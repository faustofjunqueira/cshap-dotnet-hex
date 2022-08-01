package github.faustofjunqueira.spmercantil.application.adapters.controller.request;

import io.vertx.core.cli.annotations.Description;
import lombok.Data;

import javax.validation.constraints.Size;

/**
 * Informações a serem filtradas sobre as feiras
 */
@Data
public class FilterMarketRequest {

    /**
     * Nome do Distrito Municipal
     */
    @Size(min=0, max=255)
    private String district;

    /**
     * Região conforme divisão do Município em 5 áreas
     */
    @Size(min=0, max=255)
    private String region5;

    /**
     * Denominação da feira livre atribuída pela Supervisão de Abastecimento
     */
    @Size(min=0, max=255)
    private String name;

    /**
     * Bairro de localização da feira livre
     */
    @Size(min=0, max=255)
    private String neighborhood;

}
