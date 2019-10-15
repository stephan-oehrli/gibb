using M120Projekt.Data;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace M120Projekt.UserControls
{
    /// <summary>
    /// Interaction logic for IndicateArticle.xaml
    /// </summary>
    public partial class IndicateArticle : UserControl
    {
        Product displayedProduct;

        public IndicateArticle()
        {
            InitializeComponent();
            DisplayArticle();
        }

        private void DisplayArticle()
        {
            Data.Global.context = new Context();
            IEnumerable<Product> products = Product.GetAllProducts();
            displayedProduct = products.First();
            ArticleNumber.Text = displayedProduct.ArticleNumber.ToString();
            Manufacturer.Text = displayedProduct.Manufacturer;
            Name.Text = displayedProduct.Name;
            Description.Text = displayedProduct.Description;
            Price.Text = displayedProduct.GetPriceString();
            IsOnStock.IsChecked = displayedProduct.IsOnStock;
            LastArrival.Text = displayedProduct.LastArrival.ToShortDateString();
        }

        private void ButtonEdit_Click(object sender, RoutedEventArgs e)
        {
            MainWindow.Stage.Content = new EditArticle();
        }
    }
}
