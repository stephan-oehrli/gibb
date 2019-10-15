using System;
using System.Diagnostics;

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
            Data.Product product = new Data.Product();

            product.ArticleNumber = 1234567;
            product.Name = "Aspire C993";
            product.Description = "3GHZ CPU";
            product.Manufacturer = "ACER";
            product.Price = 1299.90;
            product.LastArrival = DateTime.Today;
            product.IsOnStock = true;

            Int64 productId = product.Create();
            Debug.Print("Artikel erstellt mit Id:" + productId);
        }

        public static void DemoACreateKurz()
        {
            Data.Product product = new Data.Product { Name = "Artikel 3", Description = "Beschreibung Artikel 3", Manufacturer = "Hersteller 3", Price = 1999.95, LastArrival = DateTime.Today, IsOnStock = true };
            Int64 productId = product.Create();
            Debug.Print("Artikel erstellt mit Id:" + productId);
        }

        // Read
        public static void DemoARead()
        {
            Debug.Print("--- DemoARead ---");
            // Demo liest alle
            foreach (Data.Product product in Data.Product.GetAllProducts())
            {
                Debug.Print("Artikel Id:" + product.ArticleNumber + " Name:" + product.Name);
            }
        }
        // Update
        public static void DemoAUpdate()
        {
            Debug.Print("--- DemoAUpdate ---");
            // KlasseA ändert Attribute
            Data.Product klasseA1 = Data.Product.GetProoductById(1);
            klasseA1.Name = "Artikel 1 nach Update";
            klasseA1.Update();
        }
        // Delete
        public static void DemoADelete()
        {
            Debug.Print("--- DemoADelete ---");
            Data.Product.GetProoductById(1).Delete();
            Debug.Print("Artikel mit Id 1 gelöscht");
        }
        #endregion
    }
}
