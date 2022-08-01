package github.faustofjunqueira.spmercantil.application.adapters.controller.mapper;

import github.faustofjunqueira.spmercantil.application.adapters.controller.request.UpdateMarketRequest;
import github.faustofjunqueira.spmercantil.core.dto.UpdateMarketDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Conversao de dados do UpdateMarket
 */
@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UpdateMarketMapper {

    /**
     * Conversao de dados da requisição UpdateMarketRequest para Dto
     * @param request dados recebidos da requisição
     * @return UpdateMarketDto dados a serem enviado para o dominio
     */
    UpdateMarketDto toDto(UpdateMarketRequest request);

}
