package github.faustofjunqueira.spmercantil.application.adapters.controller;

import github.faustofjunqueira.spmercantil.application.adapters.controller.mapper.CreateMarketRequestMapper;
import github.faustofjunqueira.spmercantil.application.adapters.controller.request.FilterMarketRequest;
import github.faustofjunqueira.spmercantil.application.adapters.controller.response.MarketResponse;
import github.faustofjunqueira.spmercantil.application.adapters.controller.response.PageResponse;
import github.faustofjunqueira.spmercantil.core.port.MarketCrudService;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.reactive.ResponseStatus;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
@Tag(name = "Feira", description = "Controle do recurso de Feira")
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

    @GET
    @APIResponse(
        responseCode = "200",
        description = "Resultado Filtrado de feira"
    )
    public PageResponse<MarketResponse> filter(FilterMarketRequest filter) {
        return null;
    }
}
