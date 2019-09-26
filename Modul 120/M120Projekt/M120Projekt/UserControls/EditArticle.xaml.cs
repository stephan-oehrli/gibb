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
    /// Interaction logic for EditArticle2.xaml
    /// </summary>
    public partial class EditArticle : UserControl
    {
        public EditArticle()
        {
            InitializeComponent();
        }

        public EditArticle(Artikel article)
        {
            InitializeComponent();
            fillInForm(article);
        }

        private void fillInForm(Artikel article)
        {
            TextBoxArticleNumber.Text = article.Artikelnummer.ToString();
            ComboBoxManufacturer.Text = article.Hersteller;
            TextBoxArticleName.Text = article.Name;
            TextBoxArticleDescription.Text = article.Bezeichnung;
            TextBoxPrice.Text = article.Preis.ToString();
            CheckBoxOnStock.IsChecked = article.AnLager;
            DatePickerLastArrival.SelectedDate = article.LetzterWareneingang;
        }

        private void handleSave(object sender, RoutedEventArgs e)
        {

        }

        private void handleCancel(object sender, RoutedEventArgs e)
        {
            MainWindow.Stage.Content = new IndicateArticle();
        }
    }
}
