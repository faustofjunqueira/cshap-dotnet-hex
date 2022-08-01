package github.faustofjunqueira.spmercantil.application.adapters.controller;

import github.faustofjunqueira.spmercantil.application.adapters.controller.mapper.CreateMarketRequestMapper;
import github.faustofjunqueira.spmercantil.application.adapters.controller.request.CreateMarketRequest;
import github.faustofjunqueira.spmercantil.application.adapters.controller.request.FilterMarketRequest;
import github.faustofjunqueira.spmercantil.application.adapters.controller.response.MarketResponse;
import github.faustofjunqueira.spmercantil.application.adapters.controller.response.PageResponse;
import github.faustofjunqueira.spmercantil.core.domain.Market;
import github.faustofjunqueira.spmercantil.core.dto.UpdateMarketDto;
import github.faustofjunqueira.spmercantil.core.port.MarketCrudService;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.reactive.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Set;

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
    // TODO Rever os responses em json para validations e exceptions

    private final CreateMarketRequestMapper createMarketRequestMapper;
    private final MarketCrudService crudService;
    private final Validator validator;

    /**
     * Realiza a função de filtro da aplicação
     *
     * @param district String Nome do Distrito Municipal
     * @param region5 String Região conforme divisão do Município em 5 áreas
     * @param name String Denominação da feira livre atribuída pela Supervisão de Abastecimento
     * @param neighborhood String Bairro de localização da feira livre
     * @return Resultado paginado de feira
     */
    @GET
    @APIResponse(
            responseCode = "200",
            description = "Resultado Filtrado de feira"
    )
    public PageResponse<MarketResponse> filter(@QueryParam("district") @Size(max=255) String district,
                                               @QueryParam("region5") @Size(max=255) String region5,
                                               @QueryParam("name") @Size(max=255) String name,
                                               @QueryParam("neighborhood") @Size(max=255) String neighborhood) {

        return null;
    }

    @POST
    @ResponseStatus(201)
    @APIResponse(
            responseCode = "201",
            description = "Feira criada na aplicação"
    )
    public MarketResponse create(@Valid CreateMarketRequest body) {
        return null;
    }

    @PUT
    @APIResponse(
            responseCode = "200",
            description = "Feira atualizada"
    )
    public Market update(@Valid UpdateMarketDto body) {
        return null;
    }

    @DELETE
    @Path("{register}")
    @APIResponse(
            responseCode = "200",
            description = "Feira removida"
    )
    public void delete(@PathParam("register") @NotBlank @Size(max=6) String register) {

    }

}
