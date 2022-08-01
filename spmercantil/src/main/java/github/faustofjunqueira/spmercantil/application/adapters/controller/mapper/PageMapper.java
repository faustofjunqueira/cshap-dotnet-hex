package github.faustofjunqueira.spmercantil.application.adapters.controller.mapper;

import github.faustofjunqueira.spmercantil.application.adapters.controller.response.PageResponse;
import github.faustofjunqueira.spmercantil.core.dto.Page;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Mapper da entidade Page <-> PageResponse
 * @param <TData> Tipo de dado da lista dentro da pagina
 */
@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PageMapper<TData> {

    /**
     * Conversao de Page para response
     * @param page dado da pagina carregado do dominio
     * @return pagina a ser enviado no response
     */
    PageResponse<TData> toResponse(Page<TData> page);
}
