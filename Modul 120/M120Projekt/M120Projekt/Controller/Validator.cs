using System;
using System.Text.RegularExpressions;
using System.Windows;
using System.Windows.Controls;

namespace M120Projekt.Controller
{
    public class Validator
    {
        private Control control;
        private TextBlock errorTextBlock;
        private String userInput;
        private bool inputIsValid;

        public bool ArticleNumberIsValid(Control control, TextBlock errorTextBlock)
        {
            initParam(control, errorTextBlock);
            Regex regex = new Regex(@"^[1-9]\d{6}$");
            Match match = regex.Match(userInput);
            inputIsValid = match.Success;
            if (!inputIsValid || control.Tag != null) HandleErrorTextVisibility();
            return inputIsValid;
        }

        public bool ManufacturerIsValid(Control control, TextBlock errorTextBlock)
        {
            initParam(control, errorTextBlock);
            inputIsValid = !String.IsNullOrWhiteSpace(userInput);
            if (!inputIsValid || control.Tag != null) HandleErrorTextVisibility();
            return inputIsValid;
        }

        public bool ArticleNameIsValid(Control control, TextBlock errorTextBlock)
        {
            initParam(control, errorTextBlock);
            inputIsValid = !String.IsNullOrWhiteSpace(userInput) && userInput.Length <= 50;
            errorTextBlock.Text = userInput.Length > 50
                ? "Der Name des Artikels darf maximal 50 Zeichen lang sein."
                : "Bitte geben Sie den Namen des Artikels ein.";
            if (!inputIsValid || control.Tag != null) HandleErrorTextVisibility();
            return inputIsValid;
        }

        public bool ArticleDescriptionIsValid(Control control, TextBlock errorTextBlock)
        {
            initParam(control, errorTextBlock);
            inputIsValid = userInput.Length <= 100;
            if (!inputIsValid || control.Tag != null) HandleErrorTextVisibility();
            return inputIsValid;
        }

        public bool PriceIsValid(Control control, TextBlock errorTextBlock)
        {
            initParam(control, errorTextBlock);
            Regex regex = new Regex(@"^([1-9]|0(?=\.([1-9]|0(?=5))))\d{0,5}\.?\d?[05]?$");
            Match match = regex.Match(userInput);
            inputIsValid = match.Success;
            if (!inputIsValid || control.Tag != null) HandleErrorTextVisibility();
            return inputIsValid;
        }

        private void initParam(Control control, TextBlock errorTextBlock)
        {
            this.control = control;
            this.errorTextBlock = errorTextBlock;
            userInput = control.GetType() == typeof(TextBox) ? ((TextBox) control).Text : ((ComboBox) control).Text;
        }

        private void HandleErrorTextVisibility()
        {
            Style materialFloatTextBox = Application.Current.FindResource("MaterialDesignFloatingHintTextBox") as Style;
            bool isFloatingHintTextBox =
                control.Style.BasedOn == materialFloatTextBox || control.Style == materialFloatTextBox;
            if (inputIsValid)
            {
                errorTextBlock.Visibility = Visibility.Hidden;
                if (control.GetType() == typeof(ComboBox))
                    control.Style = Application.Current.FindResource("ValidComboBox") as Style;
                if (control.GetType() == typeof(TextBox) && !isFloatingHintTextBox)
                    control.Style = Application.Current.FindResource("ValidTextBox") as Style;
                if (isFloatingHintTextBox)
                    control.Style = Application.Current.FindResource("ValidFloatingHintTextBox") as Style;
            }
            else
            {
                errorTextBlock.Visibility = Visibility.Visible;
                if (control.GetType() == typeof(ComboBox))
                    control.Style = Application.Current.FindResource("InvalidComboBox") as Style;
                if (control.GetType() == typeof(TextBox) && !isFloatingHintTextBox)
                    control.Style = Application.Current.FindResource("InvalidTextBox") as Style;
                if (isFloatingHintTextBox)
                    control.Style = Application.Current.FindResource("InvalidFloatingHintTextBox") as Style;
            }
        }
    }
}