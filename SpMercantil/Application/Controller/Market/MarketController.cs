using Application.Controller.Market.Dto.Request;
using Application.Controller.Market.Dto.Response;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace Application.Controller.Market
{
    /// <summary>
    ///     Controlador de requisições HTTP da entidade feira(market)
    /// </summary>
    [ApiController]
    [Route("market")]
    [Produces("application/json")]
    [Consumes("application/json")]
    public class MarketController : ControllerBase
    {
        /// <summary>
        ///     Realiza a função de filtro da aplicação
        /// </summary>
        /// <param name="filterMarketRequest">Objeto de filtro de feira</param>
        /// <returns>Feiras filtras, ordenadas por ID e paginadas</returns>
        /// <remarks>
        ///     Sample request
        ///     GET /market?page=2&#38;size=10&#38;district=tes
        /// </remarks>
        /// <response code="200">Resultado filtrado com sucesso</response>
        /// <response code="400">Quebra de validação dos valores passados no filtro</response>
        /// <response code="500">Erro interno da aplicação</response>
        [HttpGet]
        [ProducesResponseType(StatusCodes.Status200OK)]
        [ProducesResponseType(StatusCodes.Status400BadRequest)]
        [ProducesResponseType(StatusCodes.Status500InternalServerError)]
        public IActionResult Filter([FromQuery] FilterMarketRequest filterMarketRequest)
        {
            return Ok(new PageResponse<MarketResponse>());
        }

        /// <summary>
        /// Cria uma feira na aplicação
        /// </summary>
        /// <param name="body">Informações de feira</param>
        /// <returns>Feira criada</returns>
        /// <remarks>
        /// POST /market
        /// {
        ///     "Id": "1",
        ///     "Longitude": -46.550164,
        ///     "Latitude": -23.558733,
        ///     "Setcens": "355030885000091",
        ///     "Areap": "3550308005040",
        ///     "Coddist": "87",
        ///     "District": "VILA FORMOSA",
        ///     "Codsubpref": "26",
        ///     "Subpref": "ARICANDUVA-FORMOSA-CARRAO",
        ///     "Region5": "Leste",
        ///     "Region8": "Leste 1",
        ///     "Name": "VILA FORMOSA",
        ///     "Register": "4041-0",
        ///     "Street": "RUA MARAGOJIPE",
        ///     "AddrNumber": "S/N",
        ///     "Neighborhood": "VL FORMOSA",
        ///     "Reference": "TV RUA PRETORIA"
        /// }
        /// </remarks>
        /// <response code="201">Feira criada com sucesso</response>
        /// <response code="400">Quebra de validação dos valores passados no filtro</response>
        /// <response code="500">Erro interno da aplicação</response>
        [HttpPost]
        [ProducesResponseType(StatusCodes.Status201Created)]
        [ProducesResponseType(StatusCodes.Status400BadRequest)]
        [ProducesResponseType(StatusCodes.Status500InternalServerError)]
        public IActionResult Create([FromBody] CreateMarketRequest body)
        {
            return Created("/new",new MarketResponse());
        }

        /// <summary>
        /// Atualiza uma feira na aplicação
        /// </summary>
        /// <param name="register">Registro da feira</param>
        /// <param name="body">Informações de feira</param>
        /// <returns>Feira Atualizada</returns>
        /// <remarks>
        /// PUT /market/4041-0
        /// {
        ///     "Id": "1",
        ///     "Longitude": -46.550164,
        ///     "Latitude": -23.558733,
        ///     "Setcens": "355030885000091",
        ///     "Areap": "3550308005040",
        ///     "Coddist": "87",
        ///     "District": "VILA FORMOSA",
        ///     "Codsubpref": "26",
        ///     "Subpref": "ARICANDUVA-FORMOSA-CARRAO",
        ///     "Region5": "Leste",
        ///     "Region8": "Leste 1",
        ///     "Name": "VILA FORMOSA",
        ///     "Register": "4041-0",
        ///     "Street": "RUA MARAGOJIPE",
        ///     "AddrNumber": "S/N",
        ///     "Neighborhood": "VL FORMOSA",
        ///     "Reference": "TV RUA PRETORIA"
        /// }
        /// </remarks>
        /// <response code="200">Feira atualizada com sucesso</response>
        /// <response code="400">Quebra de validação dos valores passados no filtro</response>
        /// <response code="500">Erro interno da aplicação</response>
        [HttpPut("{register}")]
        [ProducesResponseType(StatusCodes.Status200OK)]
        [ProducesResponseType(StatusCodes.Status400BadRequest)]
        [ProducesResponseType(StatusCodes.Status500InternalServerError)]
        public IActionResult Update([FromRoute] string register, [FromBody] UpdateMarketRequest body)
        {
            return Ok(body);
        }

        /// <summary>
        /// Remove uma feira na aplicação
        /// </summary>
        /// <param name="register">Registro da feira</param>
        /// <remarks>
        /// DELETE /market/4041-0
        /// </remarks>
        /// <response code="204">Feira removida com sucesso</response>
        /// <response code="500">Erro interno da aplicação</response>
        [HttpDelete("{register}")]
        [ProducesResponseType(StatusCodes.Status204NoContent)]
        [ProducesResponseType(StatusCodes.Status500InternalServerError)]
        public IActionResult Delete([FromRoute] string register)
        {
            return NoContent();
        }
    }
}
