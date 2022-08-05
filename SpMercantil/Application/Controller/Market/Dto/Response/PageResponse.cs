using System.Collections.ObjectModel;

namespace Application.Controller.Market.Dto.Response
{
    /// <summary>
    ///     Reposta Paginada dos recursos
    /// </summary>
    /// <typeparam name="TData">Tipo do Dado a ser representado na lista</typeparam>
    public class PageResponse<TData>
    {
        /// <summary>
        ///     total de registro presentes na base de dados
        /// </summary>
        private long Total { get; set; }

        /// <summary>
        ///     lista registro da pagina
        /// </summary>
        private Collection<TData> Data { get; set; }
    }
}