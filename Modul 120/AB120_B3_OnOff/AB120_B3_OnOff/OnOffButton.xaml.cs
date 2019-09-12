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

namespace AB120_B3_OnOff
{
    /// <summary>
    /// Interaction logic for OnOffButton.xaml
    /// </summary>
    public partial class OnOffButton : UserControl
    {
        private bool _zustand = true;
        bool Zustand
        {
            get { return _zustand; }
            set
            {
                _zustand = value;
                if (value)
                {
                    Thickness abstandKreis = Kreis.Margin;
                    abstandKreis.Left = 5;
                    Kreis.Margin = abstandKreis;
                    Kreis.Fill = (Brush)(new BrushConverter().ConvertFrom("#3393FF"));
                    Kreis.Stroke = (Brush)(new BrushConverter().ConvertFrom("#3393FF"));
                    Umrahmung.Stroke = (Brush)(new BrushConverter().ConvertFrom("#3393FF"));
                    Beschriftung.Content = "ON";
                    Beschriftung.FontWeight = FontWeights.Bold;
                    Beschriftung.Foreground = (Brush)(new BrushConverter().ConvertFrom("#3393FF"));
                    Thickness abstandBeschriftung = Beschriftung.Margin;
                    abstandBeschriftung.Left = 30;
                    Beschriftung.Margin = abstandBeschriftung;
                } else
                {
                    Thickness abstandKreis = Kreis.Margin;
                    abstandKreis.Left = 40;
                    Kreis.Margin = abstandKreis;
                    Kreis.Fill = Brushes.Black;
                    Kreis.Stroke = Brushes.Black;
                    Umrahmung.Stroke = Brushes.Black;
                    Beschriftung.Content = "OFF";
                    Beschriftung.FontWeight = FontWeights.Normal;
                    Beschriftung.Foreground = Brushes.Black;
                    Thickness abstandBeschriftung = Beschriftung.Margin;
                    abstandBeschriftung.Left = 7;
                    Beschriftung.Margin = abstandBeschriftung;
                }
            }
        }

        public OnOffButton()
        {
            InitializeComponent();
        }

        private void Grid_MouseDown(object sender, MouseButtonEventArgs e)
        {
            Zustand = !Zustand;
        }
    }
}
