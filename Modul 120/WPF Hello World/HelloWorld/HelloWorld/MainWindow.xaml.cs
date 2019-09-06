using System.Windows;
using System.Windows.Controls;

namespace HelloWorld
{
    /// <summary>
    /// Interaktionslogik für MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {

        public MainWindow()
        {
            InitializeComponent();
        }

        private void Label_MouseDown(object sender, System.Windows.Input.MouseButtonEventArgs e)
        {
            ((Label)sender).Content = "Hihihihi!";
        }
    }
}
