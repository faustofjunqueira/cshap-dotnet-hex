using System.Threading.Tasks;
using Core.Domain.Dto;
using Core.Domain.Model;
using Core.Repository;
using Core.Service.Port;

namespace Core.Service
{
    /// <summary>
    ///     Serviço de interfaciamento das operações de CRUD do dominio de Feira(Market)
    /// </summary>
    public class MarketCrudService : IMarketCrudService
    {
        private readonly IUnitOfWork _unitOfWork;

        /// <summary>
        ///     Instancia o MarketCrudService
        /// </summary>
        /// <param name="unitOfWork">Unidade de centralização de operações com banco de dados</param>
        public MarketCrudService(IUnitOfWork unitOfWork)
        {
            _unitOfWork = unitOfWork;
        }

        /// <summary>
        ///     Cria uma nova feira na base de dados
        /// </summary>
        /// <param name="createMarketDto">informações da feira</param>
        /// <returns>registro criado na base de dados</returns>
        public Task<Market> CreateAsync(CreateMarketDto createMarketDto)
        {
            return _unitOfWork.Market.CreateAsync(createMarketDto);
        }

        /// <summary>
        ///     Remove a feira da base de dados
        /// </summary>
        /// <param name="register">codigo de registro a ser removido</param>
        public Task DeleteAsync(string register)
        {
            return _unitOfWork.Market.DeleteAsync(register);
        }

        /// <summary>
        ///     Atualiza informações de uma feira
        /// </summary>
        /// <param name="register">codigo identificador da feira</param>
        /// <param name="updateMarketDto">informações a serem atualizadas</param>
        /// <returns>valores da feira após atualização</returns>
        public Task<Market> UpdateAsync(string register, UpdateMarketDto updateMarketDto)
        {
            return _unitOfWork.Market.UpdateAsync(register, updateMarketDto);
        }

        /// <summary>
        ///     Busca registros do banco de dados
        /// </summary>
        /// <param name="filterMarketDto"> filtra os registros da base de dados</param>
        /// <returns>Retorna a pagina carregada</returns>
        public Task<Page<Market>> FilterAsync(FilterMarketDto filterMarketDto)
        {
            return _unitOfWork.Market.FilterAsync(filterMarketDto);
        }
    }
}