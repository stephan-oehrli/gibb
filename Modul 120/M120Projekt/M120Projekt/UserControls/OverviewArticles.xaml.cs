using M120Projekt.Data;
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
    /// Interaction logic for OverviewArticles.xaml
    /// </summary>
    public partial class OverviewArticles : UserControl
    {
        private List<Product> products;

        public OverviewArticles()
        {
            InitializeComponent();
            MainWindow.NavigationIsEnabled(true);
            GetAllArticles();
            this.DataContext = products;
            SelectionList.CanUserAddRows = false;
            SelectionList.CanUserSortColumns = true;
            SelectionList.IsReadOnly = true;
            SelectionList.SelectionMode = DataGridSelectionMode.Single;
        }

        private void GetAllArticles()
        {
            Data.Global.context = new Context();
            products = Product.GetAllProducts().ToList();
            if (products.Count == 0)
            {
                for (int i = 0; i < 20; i++)
                {
                    products.Add(IndicateArticle.CreateDummyArticle());
                }
            }
        }

        private void SelectionList_MouseDoubleClick(object sender, MouseButtonEventArgs e)
        {
            Product selectedProduct = SelectionList.SelectedItem as Product;
            IndicateArticle.displayedProduct = selectedProduct;
            if (selectedProduct != null)
            {
                MainWindow.Stage.Content = new IndicateArticle();
            }
        }

        private void ButtonCreateArticle_Click(object sender, RoutedEventArgs e)
        {
            MainWindow.Stage.Content = new EditArticle(MainWindow.OVERVIEW);
        }
    }
}
