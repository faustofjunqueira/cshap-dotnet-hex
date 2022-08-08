using AutoMapper;
using Core.Repository;

namespace Application.EntityFramework
{
    /// <summary>
    ///     Implementação do Unit of Work, para o Entity Framework
    /// </summary>
    public class EfUnitOfWork : IUnitOfWork
    {
        private readonly ApplicationContext _context;

        public EfUnitOfWork(ApplicationContext context, IMapper mapper)
        {
            _context = context;
            Market = new EfMarketRepository(context, mapper);
        }

        public IMarketRepository Market { get; }
    }
}