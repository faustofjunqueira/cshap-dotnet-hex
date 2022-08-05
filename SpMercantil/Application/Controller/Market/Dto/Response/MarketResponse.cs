using System.ComponentModel.DataAnnotations;

namespace Application.Controller.Market.Dto.Response
{
    /// <summary>
    ///     Informações da Feira vindas diretamento do dominio
    /// </summary>
    public class MarketResponse
    {
        /// <summary>
        ///     Número de identificação do estabelecimento georreferenciado por SMDU/Deinfo
        /// </summary>
        [Required]
        [StringLength(08)]
        private string Id { get; set; }


        /// <summary>
        ///     Longitude da localização do estabelecimento no território do Município, conforme MDC
        /// </summary>
        [Required]
        [Range(-180, 180)]
        private double Longitude { get; set; }


        /// <summary>
        ///     Latitude da localização do estabelecimento no território do Município, conforme MDC
        /// </summary>
        [Required]
        [Range(-90, 90)]
        private double Latitude { get; set; }


        /// <summary>
        ///     Setor censitário conforme IBGE
        /// </summary>
        [Required]
        [StringLength(15)]
        private string Setcens { get; set; }


        /// <summary>
        ///     Área de ponderação (agrupamento de setores censitários) conforme IBGE 2010
        /// </summary>
        [Required]
        [StringLength(13)]
        private string Areap { get; set; }


        /// <summary>
        ///     Código do Distrito Municipal conforme IBGE
        /// </summary>
        [Required]
        [StringLength(9)]
        private string Coddist { get; set; }


        /// <summary>
        ///     Nome do Distrito Municipal
        /// </summary>
        [Required]
        [StringLength(18)]
        private string District { get; set; }


        /// <summary>
        ///     Código de cada uma das 31 Subprefeituras (2003 a 2012
        /// </summary>
        [Required]
        [StringLength(2)]
        private string Codsubpref { get; set; }


        /// <summary>
        ///     Nome da Subprefeitura (31 de 2003 até 2012
        /// </summary>
        [Required]
        [StringLength(25)]
        private string Subpref { get; set; }


        /// <summary>
        ///     Região conforme divisão do Município em 5 áreas
        /// </summary>
        [Required]
        [StringLength(6)]
        private string Region5 { get; set; }


        /// <summary>
        ///     Região conforme divisão do Município em 8 áreas
        /// </summary>
        [Required]
        [StringLength(7)]
        private string Region8 { get; set; }


        /// <summary>
        ///     Denominação da feira livre atribuída pela Supervisão de Abastecimento
        /// </summary>
        [Required]
        [StringLength(30)]
        private string Name { get; set; }


        /// <summary>
        ///     Número do registro da feira livre na PMSP
        /// </summary>
        [Required]
        [StringLength(6)]
        private string Register { get; set; }


        /// <summary>
        ///     Nome do logradouro onde se localiza a feira livre
        /// </summary>
        [Required]
        [StringLength(34)]
        private string Street { get; set; }


        /// <summary>
        ///     Um número do logradouro onde se localiza a feira livre
        /// </summary>
        [Required]
        [StringLength(5)]
        private string AddrNumber { get; set; }


        /// <summary>
        ///     Bairro de localização da feira livre
        /// </summary>
        [Required]
        [StringLength(20)]
        private string Neighborhood { get; set; }


        /// <summary>
        ///     Ponto de referência da localização da feira livre
        /// </summary>
        [Required]
        [StringLength(24)]
        private string Reference { get; set; }
    }
}