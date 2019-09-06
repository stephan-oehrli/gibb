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

namespace HelloWorld.UserControls
{
    /// <summary>
    /// Interaction logic for Incrementer.xaml
    /// </summary>
    public partial class Incrementer : UserControl
    {
        private int number = 0;

        public Incrementer()
        {
            InitializeComponent();
            lblIncrement.Content = number;
        }

        private void BtnIncrement_Click(object sender, RoutedEventArgs e)
        {
            increment();
        }

        private void increment()
        {
            number++;
            lblIncrement.Content = number;
        }
    }
}
