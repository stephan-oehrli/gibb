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
            Artikel dummyArticle = CreateDummyArticle();
            MainWindow.Stage.Content = new EditArticle(dummyArticle);
        }

        private void HandleCreateArticle(object sender, RoutedEventArgs e)
        {
            MainWindow.Stage.Content = new EditArticle();
        }

        private Artikel CreateDummyArticle()
        {
            Artikel article = new Artikel();
            article.Artikelnummer = 1234567;
            article.Hersteller = "ACER";
            article.Name = "Aspire C993";
            article.Bezeichnung = "Intel Core i7 @ 3.2GHz, 16GB RAM, 500GB SSD";
            article.Preis = 999.00;
            article.AnLager = true;
            article.LetzterWareneingang = DateTime.Parse("01/01/2019");
            return article;
        }

    }
}
