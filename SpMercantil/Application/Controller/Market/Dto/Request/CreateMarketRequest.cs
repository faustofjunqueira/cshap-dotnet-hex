using System.ComponentModel.DataAnnotations;

namespace Application.Controller.Market.Dto.Request
{
    /// <summary>
    ///     Informações para criação de novas feiras, recebidas no request
    /// </summary>
    public class CreateMarketRequest : UpdateMarketRequest
    {
        /// <summary>
        ///     Número do registro da feira livre na PMSP
        /// </summary>
        [Required]
        [StringLength(6)]
        public string Register { get; set; }
    }
}