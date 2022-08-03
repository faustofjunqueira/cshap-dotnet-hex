package github.faustofjunqueira.spmercantil.core.dto;

import lombok.Data;

/**
 * Informações a serem filtradas sobre as feiras
 */
@Data
public class FilterMarketDto {

    /**
     * Instacia o filtro FilterMarketDto
     *
     * @param district String Nome do Distrito Municipal
     * @param region5 String Região conforme divisão do Município em 5 áreas
     * @param name String Denominação da feira livre atribuída pela Supervisão de Abastecimento
     * @param neighborhood String Bairro de localização da feira livre
     * @param page Integer numero da pagina
     * @param size Integer Quantidade de registro na pagina
     */
    public FilterMarketDto(String district, String region5, String name, String neighborhood, Integer page, Integer size) {
        this.district = district;
        this.region5 = region5;
        this.name = name;
        this.neighborhood = neighborhood;
        this.page = page;
        this.size = size;
    }

    /**
     * Numero da pagina
     */
    private Integer page;

    /**
     * Tamanho da pagina
     */
    private Integer size;

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
