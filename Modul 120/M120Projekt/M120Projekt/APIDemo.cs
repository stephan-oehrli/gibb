using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace M120Projekt
{
    static class APIDemo
    {
        #region KlasseA
        // Create
        public static void DemoACreate()
        {
            Debug.Print("--- DemoACreate ---");
            // KlasseA
            Data.Artikel klasseA1 = new Data.Artikel();

            klasseA1.Name = "Artikel 1";
            klasseA1.Bezeichnung = "3GHZ CPU";
            klasseA1.Hersteller = "ACER";
            klasseA1.Preis = 1299.90;
            klasseA1.LetzterWareneingang = DateTime.Today;
            klasseA1.AnLager = true;

            Int64 klasseA1Id = klasseA1.Erstellen();
            Debug.Print("Artikel erstellt mit Id:" + klasseA1Id);
        }
        public static void DemoACreateKurz()
        {
            Data.Artikel klasseA2 = new Data.Artikel { Name = "Artikel 2", Bezeichnung = "Beschreibung Artikel 2", Hersteller = "Hersteller 2", Preis = 999.95, LetzterWareneingang = DateTime.Today, AnLager = true };
            Int64 klasseA2Id = klasseA2.Erstellen();
            Debug.Print("Artikel erstellt mit Id:" + klasseA2Id);
        }

        // Read
        public static void DemoARead()
        {
            Debug.Print("--- DemoARead ---");
            // Demo liest alle
            foreach (Data.Artikel klasseA in Data.Artikel.LesenAlle())
            {
                Debug.Print("Artikel Id:" + klasseA.Artikelnummer + " Name:" + klasseA.Name);
            }
        }
        // Update
        public static void DemoAUpdate()
        {
            Debug.Print("--- DemoAUpdate ---");
            // KlasseA ändert Attribute
            Data.Artikel klasseA1 = Data.Artikel.LesenID(1);
            klasseA1.Name = "Artikel 1 nach Update";
            klasseA1.Aktualisieren();
        }
        // Delete
        public static void DemoADelete()
        {
            Debug.Print("--- DemoADelete ---");
            Data.Artikel.LesenID(1).Loeschen();
            Debug.Print("Artikel mit Id 1 gelöscht");
        }
        #endregion
    }
}
