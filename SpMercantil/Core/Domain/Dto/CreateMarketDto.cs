namespace Core.Domain.Dto
{
    /// <summary>
    ///     Informações para criação de novas feiras, recebidas no request
    /// </summary>
    public class CreateMarketDto : UpdateMarketDto
    {
        /// <summary>
        ///     Número do registro da feira livre na PMSP
        /// </summary>
        public string Register { get; set; }
    }
}