using System.Threading.Tasks;
using Core.Domain.Dto;
using Core.Domain.Model;

namespace Core.Repository
{
    /// <summary>
    ///     Interface para acesso da feira com o banco de dados
    /// </summary>
    public interface IMarketRepository
    {
        /// <summary>
        ///     Cria uma nova feira na base de dados
        /// </summary>
        /// <param name="createMarketDto">informações da feira</param>
        /// <returns>registro criado na base de dados</returns>
        Task<Market> CreateAsync(CreateMarketDto createMarketDto);

        /// <summary>
        ///     Remove a feira da base de dados
        /// </summary>
        /// <param name="register">codigo de registro a ser removido</param>
        Task DeleteAsync(string register);

        /// <summary>
        ///     Atualiza informações de uma feira
        /// </summary>
        /// <param name="register">codigo identificador da feira</param>
        /// <param name="updateMarketDto">informações a serem atualizadas</param>
        /// <returns>valores da feira após atualização</returns>
        Task<Market> UpdateAsync(string register, UpdateMarketDto updateMarketDto);

        /// <summary>
        ///     Busca registros do banco de dados
        /// </summary>
        /// <param name="filterMarketDto"> filtra os registros da base de dados</param>
        /// <returns>Retorna a pagina carregada</returns>
        Task<Page<Market>> FilterAsync(FilterMarketDto filterMarketDto);
    }
}