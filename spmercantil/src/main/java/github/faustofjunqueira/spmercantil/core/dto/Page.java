package github.faustofjunqueira.spmercantil.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * Representação de registros paginado da base de dados
 *
 * @param <TData> Tipo do registro carregado
 */
@Data
@AllArgsConstructor
public class Page<TData> {

    /**
     * total de registro presentes na base de dados
     */
    private Long total;

    /**
     *  lista registro da pagina
     */
    private List<TData> data;

}
