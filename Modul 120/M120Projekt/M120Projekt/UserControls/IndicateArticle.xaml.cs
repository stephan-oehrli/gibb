using System;
using System.Windows;
using System.Windows.Controls;
using M120Projekt.Data;

namespace M120Projekt.UserControls
{
    public partial class IndicateArticle : UserControl
    {
        public IndicateArticle()
        {
            InitializeComponent();
        }

        private void HandleUpdateArticle(object sender, RoutedEventArgs e)
        {
            Article dummyArticle = CreateDummyArticle();
            MainWindow.Stage.Content = new EditArticle(dummyArticle);
        }

        private void HandleCreateArticle(object sender, RoutedEventArgs e)
        {
            MainWindow.Stage.Content = new EditArticle();
        }

        private Article CreateDummyArticle()
        {
            Article article = new Article();
            article.ArticleNumber = 1234567;
            article.Manufacturer = "ACER";
            article.Name = "Aspire C993";
            article.Description = "Intel Core i7 @ 3.2GHz, 16GB RAM, 500GB SSD";
            article.Price = 999.00;
            article.IsOnStock = true;
            article.LastArrival = DateTime.Parse("01/01/2019");
            return article;
        }
    }
}