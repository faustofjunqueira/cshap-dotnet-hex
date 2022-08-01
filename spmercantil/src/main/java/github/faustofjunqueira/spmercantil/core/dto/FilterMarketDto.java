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
     * @param offset Deslocamento entre o registro inicial e o primeiro registro da pagina
     * @param size Quantidade de registro na pagina
     */
    public FilterMarketDto(String district, String region5, String name, String neighborhood, Long offset, Long size) {
        this.district = district;
        this.region5 = region5;
        this.name = name;
        this.neighborhood = neighborhood;
        this.offset = offset;
        this.size = size;
    }

    /**
     * Deslocamento entre o registro inicial e o inicio do pagina
     */
    private Long offset;

    /**
     * Tamanho da pagina
     */
    private Long size;

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
