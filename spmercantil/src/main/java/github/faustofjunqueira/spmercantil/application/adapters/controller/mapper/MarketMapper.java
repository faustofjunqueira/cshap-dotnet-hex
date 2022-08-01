package github.faustofjunqueira.spmercantil.application.adapters.controller.mapper;

import github.faustofjunqueira.spmercantil.application.adapters.controller.response.MarketResponse;
import github.faustofjunqueira.spmercantil.core.domain.Market;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Conversão da entidade Market
 */
@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MarketMapper {

    /**
     * Converte o objeto de dominio Market em Response
     * @param market Market carregado do dominio
     * @return MarketResponse response a ser enviado para o frontend
     */
    MarketResponse toResponse(Market market);
}
