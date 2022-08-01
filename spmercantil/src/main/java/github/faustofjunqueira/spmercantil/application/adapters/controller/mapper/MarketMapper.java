package github.faustofjunqueira.spmercantil.application.adapters.controller.mapper;

import github.faustofjunqueira.spmercantil.application.adapters.controller.request.CreateMarketRequest;
import github.faustofjunqueira.spmercantil.application.adapters.controller.request.UpdateMarketRequest;
import github.faustofjunqueira.spmercantil.application.adapters.controller.response.MarketResponse;
import github.faustofjunqueira.spmercantil.core.domain.Market;
import github.faustofjunqueira.spmercantil.core.dto.CreateMarketDto;
import github.faustofjunqueira.spmercantil.core.dto.FilterMarketDto;
import github.faustofjunqueira.spmercantil.core.dto.UpdateMarketDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Conversão da entidade Market
 */
@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MarketMapper extends PageMapper<Market, MarketResponse> {

    /**
     * Converte o objeto de dominio Market em Response
     * @param market Market carregado do dominio
     * @return MarketResponse response a ser enviado para o frontend
     */
    MarketResponse toMarketResponse(Market market);

    /**
     * Converte de CreateMarketRequest para CreateMarketDto
     * @param request Dados recebidos da requisição
     * @return Dto a ser enviado para o dominio
     */
    CreateMarketDto toCreateDto(CreateMarketRequest request);

    /**
     * Conversao de dados da requisição UpdateMarketRequest para Dto
     * @param request dados recebidos da requisição
     * @return UpdateMarketDto dados a serem enviado para o dominio
     */
    UpdateMarketDto toUpdateDto(UpdateMarketRequest request);
}
