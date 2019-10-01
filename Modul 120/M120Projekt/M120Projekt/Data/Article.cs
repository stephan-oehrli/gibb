using System;
using System.Collections.Generic;
using System.Linq;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace M120Projekt.Data
{
    public class Article
    {
        #region Datenbankschicht
        [Key]
        public Int64 ArticleNumber { get; set; }
        [Required]
        public String Name { get; set; }
        [Required]
        public DateTime LastArrival { get; set; }
        [Required]
        public Boolean IsOnStock { get; set; }
        [Required]
        public String Description { get; set; }
        [Required]
        public Double Price { get; set; }
        [Required]
        public String Manufacturer { get; set; }

        #endregion
        #region Applikationsschicht
        public Article() { }
        [NotMapped]
        public String CalculatedAttribut
        {
            get
            {
                return "Im Getter kann Code eingefügt werden für berechnete Attribute";
            }
        }
        public static IEnumerable<Data.Article> ReadAll()
        {
            return (from record in Data.Global.context.Artikel select record);
        }
        public static Data.Article ReadById(Int64 articleId)
        {
            return (from record in Data.Global.context.Artikel where record.ArticleNumber == articleId select record).FirstOrDefault();
        }
        public static IEnumerable<Data.Article> ReadArticleEquals(String searchString)
        {
            return (from record in Data.Global.context.Artikel where record.Name == searchString select record);
        }
        public static IEnumerable<Data.Article> ReadArticleContains(String searchString)
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
