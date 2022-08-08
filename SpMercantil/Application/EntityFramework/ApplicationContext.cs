using Application.EntityFramework.Entity;
using Microsoft.EntityFrameworkCore;

namespace Application.EntityFramework
{
    /// <summary>
    ///     Configuração do contexto do Entity Framework e configuração dos DbSet das entidades
    /// </summary>
    public class ApplicationContext : DbContext
    {
        public ApplicationContext(DbContextOptions<ApplicationContext> context) : base(context)
        {
        }

        public DbSet<MarketEntity> Market { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<MarketEntity>().HasQueryFilter(p => p.DeletedAt == null);
        }
    }
}