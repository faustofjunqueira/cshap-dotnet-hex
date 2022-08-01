package github.faustofjunqueira.spmercantil.application.adapters.controller;

import github.faustofjunqueira.spmercantil.application.adapters.controller.mapper.CreateMarketRequestMapper;
import github.faustofjunqueira.spmercantil.core.port.MarketCrudService;
import lombok.RequiredArgsConstructor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Controller do Recursos de Feira (market)
 *
 * @author Fausto Juqnueira
 * @since 01/08/2022
 */
@Path("/market")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class MarketController {

    // TODO Validação
    // TODO Model Mapper
    // TODO Swagger
    // TODO OpenApi - Documentação
    // TODO Java Doc
    // TODO Teste Unitário
    // TODO Logs

    private final CreateMarketRequestMapper createMarketRequestMapper;
    private final MarketCrudService crudService;
}
