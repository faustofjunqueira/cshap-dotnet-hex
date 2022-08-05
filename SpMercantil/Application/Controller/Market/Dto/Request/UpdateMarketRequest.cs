using System.ComponentModel.DataAnnotations;

namespace Application.Controller.Market.Dto.Request
{
    /// <summary>
    ///     Atualização das informações da feira, recebida no request da requisição
    /// </summary>
    public class UpdateMarketRequest
    {
        /// <summary>
        ///     Número de identificação do estabelecimento georreferenciado por SMDU/Deinfo
        /// </summary>
        [Required]
        [StringLength(08)]
        public string Id { get; set; }


        /// <summary>
        ///     Longitude da localização do estabelecimento no território do Município, conforme MDC
        /// </summary>
        [Required]
        [Range(-180, 180)]
        public double Longitude { get; set; }


        /// <summary>
        ///     Latitude da localização do estabelecimento no território do Município, conforme MDC
        /// </summary>
        [Required]
        [Range(-90, 90)]
        public double Latitude { get; set; }


        /// <summary>
        ///     Setor censitário conforme IBGE
        /// </summary>
        [Required]
        [StringLength(15)]
        public string Setcens { get; set; }


        /// <summary>
        ///     Área de ponderação (agrupamento de setores censitários) conforme IBGE 2010
        /// </summary>
        [Required]
        [StringLength(13)]
        public string Areap { get; set; }


        /// <summary>
        ///     Código do Distrito Municipal conforme IBGE
        /// </summary>
        [Required]
        [StringLength(9)]
        public string Coddist { get; set; }


        /// <summary>
        ///     Nome do Distrito Municipal
        /// </summary>
        [Required]
        [StringLength(18)]
        public string District { get; set; }


        /// <summary>
        ///     Código de cada uma das 31 Subprefeituras (2003 a 2012
        /// </summary>
        [Required]
        [StringLength(2)]
        public string Codsubpref { get; set; }


        /// <summary>
        ///     Nome da Subprefeitura (31 de 2003 até 2012
        /// </summary>
        [Required]
        [StringLength(25)]
        public string Subpref { get; set; }


        /// <summary>
        ///     Região conforme divisão do Município em 5 áreas
        /// </summary>
        [Required]
        [StringLength(6)]
        public string Region5 { get; set; }


        /// <summary>
        ///     Região conforme divisão do Município em 8 áreas
        /// </summary>
        [Required]
        [StringLength(7)]
        public string Region8 { get; set; }


        /// <summary>
        ///     Denominação da feira livre atribuída pela Supervisão de Abastecimento
        /// </summary>
        [Required]
        [StringLength(30)]
        public string Name { get; set; }


        /// <summary>
        ///     Nome do logradouro onde se localiza a feira livre
        /// </summary>
        [Required]
        [StringLength(34)]
        public string Street { get; set; }


        /// <summary>
        ///     Um número do logradouro onde se localiza a feira livre
        /// </summary>
        [StringLength(5)]
        public string AddrNumber { get; set; }


        /// <summary>
        ///     Bairro de localização da feira livre
        /// </summary>
        [Required]
        [StringLength(20)]
        public string Neighborhood { get; set; }


        /// <summary>
        ///     Ponto de referência da localização da feira livre
        /// </summary>
        [Required]
        [StringLength(24)]
        public string Reference { get; set; }
    }
}