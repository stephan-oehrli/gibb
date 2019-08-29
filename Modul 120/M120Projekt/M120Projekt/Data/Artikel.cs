using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity;

namespace M120Projekt.Data
{
    public class Artikel
    {
        #region Datenbankschicht
        [Key]
        public Int64 Artikelnummer { get; set; }
        [Required]
        public String Name { get; set; }
        [Required]
        public DateTime LetzterWareneingang { get; set; }
        [Required]
        public Boolean AnLager { get; set; }
        [Required]
        public String Bezeichnung { get; set; }
        [Required]
        public Double Preis { get; set; }
        [Required]
        public String Hersteller { get; set; }

        #endregion
        #region Applikationsschicht
        public Artikel() { }
        [NotMapped]
        public String BerechnetesAttribut
        {
            get
            {
                return "Im Getter kann Code eingefügt werden für berechnete Attribute";
            }
        }
        public static IEnumerable<Data.Artikel> LesenAlle()
        {
            return (from record in Data.Global.context.Artikel select record);
        }
        public static Data.Artikel LesenID(Int64 klasseAId)
        {
            return (from record in Data.Global.context.Artikel where record.Artikelnummer == klasseAId select record).FirstOrDefault();
        }
        public static IEnumerable<Data.Artikel> LesenAttributGleich(String suchbegriff)
        {
            return (from record in Data.Global.context.Artikel where record.Name == suchbegriff select record);
        }
        public static IEnumerable<Data.Artikel> LesenAttributWie(String suchbegriff)
        {
            return (from record in Data.Global.context.Artikel where record.Name.Contains(suchbegriff) select record);
        }
        public Int64 Erstellen()
        {
            if (this.Name == null || this.Name == "") this.Name = "leer";
            if (this.LetzterWareneingang == null) this.LetzterWareneingang = DateTime.MinValue;
            Data.Global.context.Artikel.Add(this);
            Data.Global.context.SaveChanges();
            return this.Artikelnummer;
        }
        public Int64 Aktualisieren()
        {
            Data.Global.context.Entry(this).State = System.Data.Entity.EntityState.Modified;
            Data.Global.context.SaveChanges();
            return this.Artikelnummer;
        }
        public void Loeschen()
        {
            Data.Global.context.Entry(this).State = System.Data.Entity.EntityState.Deleted;
            Data.Global.context.SaveChanges();
        }
        public override string ToString()
        {
            return Artikelnummer.ToString(); // Für bessere Coded UI Test Erkennung
        }
        #endregion
    }
}
