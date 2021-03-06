﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace M120Projekt.Data
{
    public class Product
    {
        #region Datenbankschicht

        [Key]
        public Int64 Id { get; set; }
        [Required]
        public Int64 ArticleNumber { get; set; }
        [Required]
        public String Name { get; set; }
        [Required]
        public DateTime LastArrival { get; set; }
        [Required]
        public Boolean IsOnStock { get; set; }
        public String Description { get; set; }
        [Required]
        public Double Price { get; set; }
        [Required]
        public String Manufacturer { get; set; }

        [NotMapped]
        public String PriceAsString
        {
            get
            {
                return GetPriceString();
            }
        }

        #endregion
        #region Applikationsschicht
        public Product() { }
        [NotMapped]
        public String CalculatedAttribute
        {
            get
            {
                return "Im Getter kann Code eingefügt werden für berechnete Attribute";
            }
        }

        public String GetPriceString()
        {
            String price = this.Price.ToString();
            String[] priceArr = price.Split('.');
            if (priceArr.Length == 1) price += ".00";
            else if (priceArr[1].Length == 1) price += "0";
            return price;
        }
        public static IEnumerable<Data.Product> GetAllProducts()
        {
            return (from record in Data.Global.context.Artikel select record);
        }
        public static Data.Product GetProoductById(Int64 klasseAId)
        {
            return (from record in Data.Global.context.Artikel where record.ArticleNumber == klasseAId select record).FirstOrDefault();
        }
        public static IEnumerable<Data.Product> LesenAttributGleich(String searchString)
        {
            return (from record in Data.Global.context.Artikel where record.Name == searchString select record);
        }
        public static IEnumerable<Data.Product> LesenAttributWie(String searchString)
        {
            return (from record in Data.Global.context.Artikel where record.Name.Contains(searchString) select record);
        }
        public Int64 Create()
        {
            if (this.Name == null || this.Name == "") this.Name = "leer";
            if (this.LastArrival == null) this.LastArrival = DateTime.MinValue;
            Data.Global.context.Artikel.Add(this);
            Data.Global.context.SaveChanges();
            return this.ArticleNumber;
        }
        public Int64 Update()
        {
            Data.Global.context.Entry(this).State = System.Data.Entity.EntityState.Modified;
            Data.Global.context.SaveChanges();
            return this.ArticleNumber;
        }
        public void Delete()
        {
            Data.Global.context.Entry(this).State = System.Data.Entity.EntityState.Deleted;
            Data.Global.context.SaveChanges();
        }
        public override string ToString()
        {
            return ArticleNumber.ToString(); // Für bessere Coded UI Test Erkennung
        }
        #endregion
    }
}
