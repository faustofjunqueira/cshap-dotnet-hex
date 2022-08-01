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
    private Integer total;

    /**
     *  lista registro da pagina
     */
    private List<TData> data;

    /**
     * Instancia uma pagina de registros
     * @param total total de registro presentes na base de dados
     * @param data lista registro da pagina
     */
    public Page(Integer total, List<TData> data) {
        this.total = total;
        this.data = data;
    }
}
