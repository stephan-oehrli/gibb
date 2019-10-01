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

        public MainWindow()
        {
            InitializeComponent();
            Stage = MyContentControl;
            ButtonCloseMenu.Visibility = Visibility.Collapsed;
            // Wichtig!
            //Data.Global.context = new Data.Context();
            // Aufruf diverse APIDemo Methoden
            //APIDemo.DemoACreate();
            //APIDemo.DemoACreateKurz();
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

    }
}
