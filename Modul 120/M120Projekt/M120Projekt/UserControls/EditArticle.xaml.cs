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
using MaterialDesignThemes.Wpf;

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

        public EditArticle(Article article)
        {
            InitializeComponent();
            TextBlockTitle.Text = "Artikel bearbeiten";
            FillInForm(article);
        }

        private void FillInForm(Article article)
        {
            TextBoxArticleNumber.Text = article.ArticleNumber.ToString();
            ComboBoxManufacturer.Text = article.Manufacturer;
            TextBoxArticleName.Text = article.Name;
            TextBoxArticleDescription.Text = article.Description;
            TextBoxPrice.Text = article.Price.ToString();
            CheckBoxOnStock.IsChecked = article.IsOnStock;
            DatePickerLastArrival.SelectedDate = article.LastArrival;
        }

        private void HandleSave(object sender, RoutedEventArgs e)
        {
            MainWindow.Stage.Content = new IndicateArticle();
        }

        private async void HandleCancel(object sender, RoutedEventArgs e)
        {
            DialogHostEditArticle.IsOpen = false;
            await Task.Delay(500);
            MainWindow.Stage.Content = new IndicateArticle();
        }
    }
}
