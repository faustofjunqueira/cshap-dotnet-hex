using Microsoft.AspNetCore.Mvc;

namespace Application.Controller.Market
{
    /// <summary>
    ///     Controlador de requisições HTTP da entidade feira(market)
    /// </summary>
    [ApiController]
    [Route("market")]
    [Produces("application/json")]
    public class MarketController : ControllerBase
    {
        [HttpGet()]
        public ActionResult<string> Get()
        {
            return "Hello world!";
        }
    }
}