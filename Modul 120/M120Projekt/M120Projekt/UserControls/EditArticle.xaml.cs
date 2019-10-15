using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Forms.VisualStyles;
using System.Windows.Input;
using M120Projekt.Controller;
using M120Projekt.Data;
using MaterialDesignThemes.Wpf;

namespace M120Projekt.UserControls
{
    public partial class EditArticle : UserControl
    {
        private Validator validator = new Validator();
        private Product touchedProduct;
        private Boolean textHasChanged;

        public EditArticle()
        {
            InitializeComponent();
            MainWindow.NavigationIsEnabled(false);
            LastArrival.DisplayDateEnd = DateTime.Now;
        }

        public EditArticle(Product product) : this()
        {
            TextBlockTitle.Text = "Artikel bearbeiten";
            touchedProduct = product;
            FillInForm(product);
            textHasChanged = false;
        }

        private void FillInForm(Product product)
        {
            ArticleNumber.Text = product.ArticleNumber.ToString();
            Manufacturer.Text = product.Manufacturer;
            ArticleName.Text = product.Name;
            ArticleDescription.Text = product.Description;
            Price.Text = product.GetPriceString();
            OnStock.IsChecked = product.IsOnStock;
            LastArrival.SelectedDate = product.LastArrival;
        }

        private void HandleSave(object sender, RoutedEventArgs e)
        {
            if (FormIsValid())
            {
                setUpProduct();
                Data.Global.context = new Data.Context();
                if (touchedProduct.Id != 0)
                {
                    touchedProduct.Update();
                }
                else
                {
                    touchedProduct.Create();
                }
                IndicateArticle.displayedProduct = touchedProduct;
                MainWindow.Stage.Content = new IndicateArticle();
            }
        }

        private void setUpProduct()
        {
            if (touchedProduct == null) touchedProduct = new Product();
            touchedProduct.ArticleNumber = Convert.ToInt32(ArticleNumber.Text);
            touchedProduct.Manufacturer = Manufacturer.Text;
            touchedProduct.Name = ArticleName.Text;
            touchedProduct.Description = ArticleDescription.Text;
            touchedProduct.Price = Convert.ToDouble(Price.Text);
            touchedProduct.IsOnStock = OnStock.IsChecked.Value;
            touchedProduct.LastArrival = LastArrival.SelectedDate.Value;
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
            textHasChanged = true;
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
            Control control = (Control)sender;
            IsFieldValid(control);
        }

        private void BtnCancel_Click(object sender, RoutedEventArgs e)
        {
            if (FormIsEmpty() || !textHasChanged)
            {
                MainWindow.Stage.Content = new IndicateArticle();
            }
            else
            {
                DialogHostEditArticle.IsOpen = true;
            }
        }

        private bool FormIsEmpty()
        {
            if (!String.IsNullOrEmpty(ArticleNumber.Text)) return false;
            if (!String.IsNullOrEmpty(Manufacturer.Text)) return false;
            if (!String.IsNullOrEmpty(ArticleName.Text)) return false;
            if (!String.IsNullOrEmpty(ArticleDescription.Text)) return false;
            if (!String.IsNullOrEmpty(Price.Text)) return false;
            if (LastArrival.SelectedDate.HasValue) return false;
            return true;
        }


    }
}