#nullable enable
using System.ComponentModel.DataAnnotations;
using Microsoft.AspNetCore.Mvc;

namespace Application.Controller.Market.Dto.Request
{
    /// <summary>
    ///     Objeto de filtro de feira(market)
    /// </summary>
    public class FilterMarketRequest
    {
        /// <summary>
        ///     Nome do Distrito Municipal
        /// </summary>
        [FromQuery(Name = "district")]
        [MaxLength(18)]
        public string? District { get; set; }

        /// <summary>
        ///     Região conforme divisão do Município em 5 áreas
        /// </summary>
        [FromQuery(Name = "region5")]
        [MaxLength(6)]
        public string? Region5 { get; set; }

        /// <summary>
        ///     Denominação da feira livre atribuída pela Supervisão de Abastecimento
        /// </summary>
        [FromQuery(Name = "name")]
        [MaxLength(30)]
        public string? Name { get; set; }

        /// <summary>
        ///     Bairro de localização da feira livre
        /// </summary>
        [FromQuery(Name = "neighborhood")]
        [MaxLength(20)]
        public string? Neighborhood { get; set; }

        /// <summary>
        ///     Pagina a ser acessada. default=0
        /// </summary>
        [FromQuery(Name = "page")]
        [Range(0, 1000000)]
        public int Page { get; set; } = 0;

        /// <summary>
        ///     Quantidade de registros na pagina default=25.
        /// </summary>
        [FromQuery(Name = "size")]
        [Range(0, 25)]
        public int Size { get; set; } = 25;
    }
}