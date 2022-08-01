package github.faustofjunqueira.spmercantil.application.adapters.controller.mapper;

import github.faustofjunqueira.spmercantil.application.adapters.controller.request.FilterMarketRequest;
import github.faustofjunqueira.spmercantil.core.dto.FilterMarketDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Mapper da entidade FilterMarket
 */
@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FilterMarketMapper {
    /**
     * Converte de FilterMarketRequest para FilterMarketDto
     * @param request filtro recebido da requisição
     * @return FilterMarketDto registro a ser enviado para o dominio
     */
    FilterMarketDto toDto(FilterMarketRequest request);
}
