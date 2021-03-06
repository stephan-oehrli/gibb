﻿using System.Data.Entity;

namespace M120Projekt.Data
{
    public class Context : DbContext
    {
        public Context() : base("name=M120Connectionstring")
        {
            this.Configuration.LazyLoadingEnabled = true;
            Database.SetInitializer(new MigrateDatabaseToLatestVersion<Data.Context, M120Projekt.Migrations.Configuration>());
        }
        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Product>().ToTable("Artikel"); // Damit kein "s" angehängt wird an Tabelle
        }
        public DbSet<Product> Artikel { get; set; }
    }
}
