using System.Collections.Generic;

namespace Core.Domain.Dto
{
    /// <summary>
    ///     Representação de registros paginado da base de dados
    /// </summary>
    /// <typeparam name="TData">Tipo do registro carregado</typeparam>
    public class Page<TData>
    {
        /// <summary>
        ///     total de registro presentes na base de dados
        /// </summary>
        public long Total { get; set; }

        /// <summary>
        ///     lista registro da pagina
        /// </summary>
        public List<TData> Data { get; set; } = new List<TData>();
    }
}