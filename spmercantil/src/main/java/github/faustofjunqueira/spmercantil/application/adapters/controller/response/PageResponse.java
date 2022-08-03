package github.faustofjunqueira.spmercantil.application.adapters.controller.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Representação de registros paginado da base de dados
 *
 * @param <TData> Tipo do registro carregado
 */
@Data
public class PageResponse<TData> {

    /**
     * total de registro presentes na base de dados
     */
    private Long total;

    /**
     *  lista registro da pagina
     */
    private List<TData> data;

    /**
     * Instancia uma pagina de registros
     * @param total total de registro presentes na base de dados
     * @param data lista registro da pagina
     */
    public PageResponse(Long total, List<TData> data) {
        this.total = total;
        this.data = data;
    }
}
