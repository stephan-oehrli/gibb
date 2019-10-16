using M120Projekt.Data;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;

namespace M120Projekt.UserControls
{
    public partial class IndicateArticle : UserControl
    {
        public static Product displayedProduct;

        public IndicateArticle()
        {
            InitializeComponent();
            MainWindow.NavigationIsEnabled(true);
            DisplayArticle();
        }

        private void DisplayArticle()
        {
            if (displayedProduct == null)
            {
                Data.Global.context = new Context();
                IEnumerable<Product> products = Product.GetAllProducts();
                displayedProduct = products.FirstOrDefault();
                if (displayedProduct == null)
                {
                    displayedProduct = CreateDummyArticle();
                }
            }
            WindowTitle.Text = displayedProduct.Name;
            ArticleNumber.Text = displayedProduct.ArticleNumber.ToString();
            Manufacturer.Text = displayedProduct.Manufacturer;
            Name.Text = displayedProduct.Name;
            Description.Text = displayedProduct.Description;
            Price.Text = displayedProduct.GetPriceString();
            IsOnStock.IsChecked = displayedProduct.IsOnStock;
            LastArrival.Text = displayedProduct.LastArrival.ToShortDateString();
        }

        private void HandleUpdateArticle(object sender, RoutedEventArgs e)
        {
            Product dummyArticle = CreateDummyArticle();
            MainWindow.Stage.Content = new EditArticle(displayedProduct);
        }

        private void HandleCreateArticle(object sender, RoutedEventArgs e)
        {
            MainWindow.Stage.Content = new EditArticle();
        }

        public static Product CreateDummyArticle()
        {
            Product article = new Product();
            article.ArticleNumber = 1234567;
            article.Manufacturer = "ACER";
            article.Name = "Aspire C993";
            article.Description = "Intel Core i7 @ 3.2GHz, 16GB RAM, 500GB SSD";
            article.Price = 999.00;
            article.IsOnStock = true;
            article.LastArrival = DateTime.Parse("01/01/2019");
            return article;
        }

        private void HandleDelete(object sender, RoutedEventArgs e)
        {
            Data.Global.context = new Context();
            displayedProduct.Delete();
            displayedProduct = null;
            DisplayArticle();
        }

        private void ButtonBack_Click(object sender, RoutedEventArgs e)
        {
            MainWindow.Stage.Content = new OverviewArticles();
        }
    }
}