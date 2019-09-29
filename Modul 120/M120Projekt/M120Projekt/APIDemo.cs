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
            Data.Article klasseA1 = new Data.Article();

            klasseA1.Name = "Article 1";
            klasseA1.Description = "3GHZ CPU";
            klasseA1.Manufacturer = "ACER";
            klasseA1.Price = 1299.90;
            klasseA1.LastArrival = DateTime.Today;
            klasseA1.IsOnStock = true;

            Int64 klasseA1Id = klasseA1.Create();
            Debug.Print("Article erstellt mit Id:" + klasseA1Id);
        }
        public static void DemoACreateKurz()
        {
            Data.Article klasseA2 = new Data.Article { Name = "Article 3", Description = "Beschreibung Article 3", Manufacturer = "Manufacturer 3", Price = 1999.95, LastArrival = DateTime.Today, IsOnStock = true };
            Int64 klasseA2Id = klasseA2.Create();
            Debug.Print("Article erstellt mit Id:" + klasseA2Id);
        }

        // Read
        public static void DemoARead()
        {
            Debug.Print("--- DemoARead ---");
            // Demo liest alle
            foreach (Data.Article klasseA in Data.Article.ReadAll())
            {
                Debug.Print("Article Id:" + klasseA.ArticleNumber + " Name:" + klasseA.Name);
            }
        }
        // Update
        public static void DemoAUpdate()
        {
            Debug.Print("--- DemoAUpdate ---");
            // KlasseA ändert Attribute
            Data.Article klasseA1 = Data.Article.ReadById(1);
            klasseA1.Name = "Article 1 nach Update";
            klasseA1.Update();
        }
        // Delete
        public static void DemoADelete()
        {
            Debug.Print("--- DemoADelete ---");
            Data.Article.ReadById(1).Delete();
            Debug.Print("Article mit Id 1 gelöscht");
        }
        #endregion
    }
}
