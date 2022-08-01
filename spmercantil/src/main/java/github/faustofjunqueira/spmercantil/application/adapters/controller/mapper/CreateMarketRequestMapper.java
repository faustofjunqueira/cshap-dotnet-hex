package github.faustofjunqueira.spmercantil.application.adapters.controller.mapper;

import github.faustofjunqueira.spmercantil.application.adapters.controller.request.CreateMarketRequest;
import github.faustofjunqueira.spmercantil.core.dto.CreateMarketDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Mapper para CreateMarketDto
 */
@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CreateMarketRequestMapper {

    /**
     * Converte de CreateMarketRequest para CreateMarketDto
     * @param request Dados recebidos da requisição
     * @return Dto a ser enviado para o dominio
     */
    CreateMarketDto toDTO(CreateMarketRequest request);
}
