package github.faustofjunqueira.spmercantil.core.dto;

import lombok.Data;

/**
 * Informações a serem filtradas sobre as feiras
 */
@Data
public class FilterMarketDto {

    /**
     * Nome do Distrito Municipal
     */
    private String district;

    /**
     * Região conforme divisão do Município em 5 áreas
     */
    private String region5;

    /**
     * Denominação da feira livre atribuída pela Supervisão de Abastecimento
     */
    private String name;

    /**
     * Bairro de localização da feira livre
     */
    private String neighborhood;

}
