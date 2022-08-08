namespace Core.Domain.Dto
{
    /// <summary>
    ///     Objeto de filtro de feira(market)
    /// </summary>
    public class FilterMarketDto
    {
        /// <summary>
        ///     Nome do Distrito Municipal
        /// </summary>
        public string? District { get; set; }

        /// <summary>
        ///     Região conforme divisão do Município em 5 áreas
        /// </summary>
        public string? Region5 { get; set; }

        /// <summary>
        ///     Denominação da feira livre atribuída pela Supervisão de Abastecimento
        /// </summary>
        public string? Name { get; set; }

        /// <summary>
        ///     Bairro de localização da feira livre
        /// </summary>
        public string? Neighborhood { get; set; }

        /// <summary>
        ///     Pagina a ser acessada. default=0
        /// </summary>
        public int Page { get; set; } = 0;

        /// <summary>
        ///     Quantidade de registros na pagina default=25.
        /// </summary>
        public int Size { get; set; } = 25;
    }
}