namespace Core.Domain.Model
{
    /// <summary>
    ///     Informações da Feira
    /// </summary>
    public class Market
    {
        /// <summary>
        ///     Número de identificação do estabelecimento georreferenciado por SMDU/Deinfo
        /// </summary>
        public string Id { get; set; }


        /// <summary>
        ///     Longitude da localização do estabelecimento no território do Município, conforme MDC
        /// </summary>
        public double Longitude { get; set; }


        /// <summary>
        ///     Latitude da localização do estabelecimento no território do Município, conforme MDC
        /// </summary>
        public double Latitude { get; set; }


        /// <summary>
        ///     Setor censitário conforme IBGE
        /// </summary>
        public string Setcens { get; set; }


        /// <summary>
        ///     Área de ponderação (agrupamento de setores censitários) conforme IBGE 2010
        /// </summary>
        public string Areap { get; set; }


        /// <summary>
        ///     Código do Distrito Municipal conforme IBGE
        /// </summary>
        public string Coddist { get; set; }


        /// <summary>
        ///     Nome do Distrito Municipal
        /// </summary>
        public string District { get; set; }


        /// <summary>
        ///     Código de cada uma das 31 Subprefeituras (2003 a 2012
        /// </summary>
        public string Codsubpref { get; set; }


        /// <summary>
        ///     Nome da Subprefeitura (31 de 2003 até 2012
        /// </summary>
        public string Subpref { get; set; }


        /// <summary>
        ///     Região conforme divisão do Município em 5 áreas
        /// </summary>
        public string Region5 { get; set; }


        /// <summary>
        ///     Região conforme divisão do Município em 8 áreas
        /// </summary>
        public string Region8 { get; set; }


        /// <summary>
        ///     Denominação da feira livre atribuída pela Supervisão de Abastecimento
        /// </summary>
        public string Name { get; set; }


        /// <summary>
        ///     Número do registro da feira livre na PMSP
        /// </summary>
        public string Register { get; set; }


        /// <summary>
        ///     Nome do logradouro onde se localiza a feira livre
        /// </summary>
        public string Street { get; set; }


        /// <summary>
        ///     Um número do logradouro onde se localiza a feira livre
        /// </summary>
        public string AddrNumber { get; set; }


        /// <summary>
        ///     Bairro de localização da feira livre
        /// </summary>
        public string Neighborhood { get; set; }


        /// <summary>
        ///     Ponto de referência da localização da feira livre
        /// </summary>
        public string Reference { get; set; }
    }
}