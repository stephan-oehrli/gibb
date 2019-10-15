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

namespace M120Projekt.UserControls
{
    /// <summary>
    /// Interaction logic for NavigationPlaceholder.xaml
    /// </summary>
    public partial class NavigationPlaceholder : UserControl
    {
        public NavigationPlaceholder(String title)
        {
            InitializeComponent();
            Title.Content = title;
        }
    }
}
