package github.faustofjunqueira.spmercantil.core.dto;

import java.util.List;

/**
 * Representação de registros paginado da base de dados
 *
 * @param <TData> Tipo do registro carregado
 */
public class Page<TData> {

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
     * @param total Long total de registro presentes na base de dados
     * @param data TData lista registro da pagina
     */
    public Page(Long total, List<TData> data) {
        this.total = total;
        this.data = data;
    }
}
