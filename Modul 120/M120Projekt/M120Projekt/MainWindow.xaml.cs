using M120Projekt.Data;
using M120Projekt.UserControls;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;

namespace M120Projekt
{
    /// <summary>
    /// Interaktionslogik für MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public static ContentControl Stage;
        private static ListViewItem NAV1;
        private static ListViewItem NAV2;
        private static ListViewItem NAV3;
        private static ListViewItem NAV4;

        public MainWindow()
        {
            InitializeComponent();
            Stage = MyContentControl;
            ButtonCloseMenu.Visibility = Visibility.Collapsed;
            NAV1 = Products;
            NAV2 = Customers;
            NAV3 = Bill;
            NAV4 = Revenue;
            Stage.Content = new IndicateArticle();
            // Wichtig!
            //Data.Global.context = new Data.Context();
            // Aufruf diverse APIDemo Methoden
            //APIDemo.DemoACreate();
            //APIDemo.DemoACreateKurz();
        }

        public static void NavigationIsEnabled(bool isEnabled)
        {
            NAV1.IsEnabled = isEnabled;
            NAV2.IsEnabled = isEnabled;
            NAV3.IsEnabled = isEnabled;
            NAV4.IsEnabled = isEnabled;
        }

        private void ButtonOpenMenu_Click(object sender, RoutedEventArgs e)
        {
            ButtonOpenMenu.Visibility = Visibility.Collapsed;
            ButtonCloseMenu.Visibility = Visibility.Visible;
        }

        private void ButtonCloseMenu_Click(object sender, RoutedEventArgs e)
        {
            ButtonOpenMenu.Visibility = Visibility.Visible;
            ButtonCloseMenu.Visibility = Visibility.Collapsed;
        }
        
        private void Products_MouseUp(object sender, System.Windows.Input.MouseButtonEventArgs e)
        {
            Stage.Content = new IndicateArticle();
        }

        private void Customers_MouseUp(object sender, System.Windows.Input.MouseButtonEventArgs e)
        {
            Stage.Content = new NavigationPlaceholder("Kunden");
        }

        private void Bill_MouseUp(object sender, System.Windows.Input.MouseButtonEventArgs e)
        {
            Stage.Content = new NavigationPlaceholder("Beleg erfassen");
        }

        private void Revenue_MouseUp(object sender, System.Windows.Input.MouseButtonEventArgs e)
        {
            Stage.Content = new NavigationPlaceholder("Umsatz");
        }
    }
}
