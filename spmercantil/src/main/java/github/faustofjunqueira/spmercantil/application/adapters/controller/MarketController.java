package github.faustofjunqueira.spmercantil.application.adapters.controller;

import github.faustofjunqueira.spmercantil.application.adapters.controller.mapper.MarketMapper;
import github.faustofjunqueira.spmercantil.application.adapters.controller.request.CreateMarketRequest;
import github.faustofjunqueira.spmercantil.application.adapters.controller.request.UpdateMarketRequest;
import github.faustofjunqueira.spmercantil.application.adapters.controller.response.MarketResponse;
import github.faustofjunqueira.spmercantil.application.adapters.controller.response.PageResponse;
import github.faustofjunqueira.spmercantil.core.domain.Market;
import github.faustofjunqueira.spmercantil.core.dto.CreateMarketDto;
import github.faustofjunqueira.spmercantil.core.dto.FilterMarketDto;
import github.faustofjunqueira.spmercantil.core.dto.Page;
import github.faustofjunqueira.spmercantil.core.dto.UpdateMarketDto;
import github.faustofjunqueira.spmercantil.core.exception.RegisterAlreadyExistsException;
import github.faustofjunqueira.spmercantil.core.exception.RegisterNotFoundException;
import github.faustofjunqueira.spmercantil.core.port.MarketCrudService;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.reactive.ResponseStatus;
import org.jboss.resteasy.reactive.RestResponse;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

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

    private final MarketMapper mapper;

    private final MarketCrudService crudService;

    private Integer SIZE_DEFAULT = 25;
    private final Integer PAGE_DEFAULT = 1;

    /**
     * Realiza a função de filtro da aplicação
     *
     * @param district     String Nome do Distrito Municipal
     * @param region5      String Região conforme divisão do Município em 5 áreas
     * @param name         String Denominação da feira livre atribuída pela Supervisão de Abastecimento
     * @param neighborhood String Bairro de localização da feira livre
     * @param page         Deslocamento entre o registro inicial e o primeiro registro da pagina
     * @param size         Quantidade de registro na pagina
     * @return Resultado paginado de feira
     */
    @GET
    @APIResponse(
            responseCode = "200",
            description = "Resultado Filtrado de feira"
    )
    public PageResponse<MarketResponse> filter(@QueryParam("district") String district,
                                               @QueryParam("region5") String region5,
                                               @QueryParam("name") String name,
                                               @QueryParam("neighborhood") String neighborhood,
                                               @QueryParam("page") Optional<Integer> page,
                                               @QueryParam("size") Optional<Integer> size
    ) {
        FilterMarketDto filter = new FilterMarketDto(district, region5, name, neighborhood, page.orElse(PAGE_DEFAULT), size.orElse(SIZE_DEFAULT));
        Page<Market> paging = crudService.filter(filter);
        return mapper.toPage(paging);
    }

    @POST
    @ResponseStatus(201)
    @APIResponse(
            responseCode = "201",
            description = "Feira criada na aplicação"
    )
    public MarketResponse create(@Valid CreateMarketRequest body) throws RegisterAlreadyExistsException {
        CreateMarketDto dto = mapper.toCreateDto(body);
        Market entity = crudService.create(dto);
        return mapper.toMarketResponse(entity);
    }

    @PUT
    @Path("{register}")
    @APIResponse(
            responseCode = "200",
            description = "Feira atualizada"
    )
    public MarketResponse update(@PathParam("register") String register, @Valid UpdateMarketRequest body) throws RegisterNotFoundException {
        UpdateMarketDto dto = mapper.toUpdateDto(body);
        Market entity = crudService.update(register, dto);
        return mapper.toMarketResponse(entity);
    }

    @DELETE
    @ResponseStatus(RestResponse.StatusCode.NO_CONTENT)
    @Path("{register}")
    @APIResponse(
            responseCode = "204",
            description = "Feira removida"
    )
    public void delete(@PathParam("register") @NotBlank @Size(max = 6) String register) throws RegisterNotFoundException {
        crudService.delete(register);
    }

}
