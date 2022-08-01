package github.faustofjunqueira.spmercantil.application.adapters.controller.mapper;

import github.faustofjunqueira.spmercantil.application.adapters.controller.response.PageResponse;
import github.faustofjunqueira.spmercantil.core.dto.Page;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Mapper da entidade Page - PageResponse
 * @param <TModel> Tipo de dado da entidade do dominio
 * @param <TResponse> tipo de dado da entidade do response
 */
public interface PageMapper<TModel, TResponse> {

    /**
     * Conversao de Page para response
     * @param page dado da pagina carregado do dominio
     * @return pagina a ser enviado no response
     */
    PageResponse<TResponse> toResponse(Page<TModel> page);
}
