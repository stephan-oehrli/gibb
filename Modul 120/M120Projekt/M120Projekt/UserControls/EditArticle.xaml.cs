using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using M120Projekt.Controller;
using M120Projekt.Data;

namespace M120Projekt.UserControls
{
    public partial class EditArticle : UserControl
    {
        private Validator validator = new Validator();

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
            ArticleNumber.Text = article.ArticleNumber.ToString();
            Manufacturer.Text = article.Manufacturer;
            ArticleName.Text = article.Name;
            ArticleDescription.Text = article.Description;
            Price.Text = article.Price.ToString();
            OnStock.IsChecked = article.IsOnStock;
            LastArrival.SelectedDate = article.LastArrival;
        }

        private void HandleSave(object sender, RoutedEventArgs e)
        {
            if (FormIsValid())
            {
                MainWindow.Stage.Content = new IndicateArticle();
            }
        }

        private bool FormIsValid()
        {
            IList<Control> form = new List<Control>
                {ArticleNumber, Manufacturer, ArticleName, ArticleDescription, Price};
            bool formIsValid = true;
            foreach (var control in form)
            {
                if (!IsFieldValid(control)) formIsValid = false;
            }

            return formIsValid;
        }

        private async void HandleCancel(object sender, RoutedEventArgs e)
        {
            DialogHostEditArticle.IsOpen = false;
            await Task.Delay(500);
            MainWindow.Stage.Content = new IndicateArticle();
        }

        private bool IsFieldValid(Control control)
        {
            bool fieldIsValid = true;
            TextBlock validationErrorText = this.FindName("ValidationText" + control.Name) as TextBlock;
            switch (control.Name)
            {
                case "ArticleNumber":
                    fieldIsValid = validator.ArticleNumberIsValid(control, validationErrorText);
                    break;
                case "Manufacturer":
                    fieldIsValid = validator.ManufacturerIsValid(control, validationErrorText);
                    break;
                case "ArticleName":
                    fieldIsValid = validator.ArticleNameIsValid(control, validationErrorText);
                    break;
                case "ArticleDescription":
                    fieldIsValid = validator.ArticleDescriptionIsValid(control, validationErrorText);
                    break;
                case "Price":
                    fieldIsValid = validator.PriceIsValid(control, validationErrorText);
                    break;
            }

            if (!fieldIsValid) control.Tag = "touched";
            return fieldIsValid;
        }

        private void UserInput_OnLostFocus(object sender, RoutedEventArgs e)
        {
            Control control = sender as Control;
            IsFieldValid(control);
        }

        private void UserInput_OnTextChanged(object sender, TextChangedEventArgs e)
        {
            Control control = sender as Control;
            if (control.Tag != null && control.Tag.ToString() == "touched")
            {
                UserInput_OnLostFocus(sender, e);
            }
        }

        private void Numeric_OnPreviewTextInput(object sender, TextCompositionEventArgs e)
        {
            foreach (var character in e.Text)
            {
                if (!(Char.IsDigit(character) || character.Equals('.')))
                {
                    e.Handled = true;
                    break;
                }
            }
        }

        private void Manufacturer_OnDropDownClosed(object sender, EventArgs e)
        {
            Control control = (Control) sender;
            IsFieldValid(control);
        }
    }
}