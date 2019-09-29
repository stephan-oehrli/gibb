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
using M120Projekt.Data;

namespace M120Projekt.UserControls
{
    /// <summary>
    /// Interaction logic for IndicateArticle.xaml
    /// </summary>
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
