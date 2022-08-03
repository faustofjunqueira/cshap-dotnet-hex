package github.faustofjunqueira.spmercantil.application.adapters.controller.response;

import github.faustofjunqueira.spmercantil.application.adapters.controller.mapper.PageMapper;
import github.faustofjunqueira.spmercantil.core.domain.Market;
import lombok.Data;

/**
 * Representa as informações de uma Feira(Market)
 * @since 31/07/2022
 */
@Data
public class MarketResponse {

    /**
     * Número de identificação do estabelecimento georreferenciado por SMDU/Deinfo
     */
    private String id;

    /**
     * Longitude da localização do estabelecimento no território do Município, conforme MDC
     */
    private Double longitude;

    /**
     * Latitude da localização do estabelecimento no território do Município, conforme MDC
     */
    private Double latitude;

    /**
     * Setor censitário conforme IBGE
     */
    private String setcens;

    /**
     * Área de ponderação (agrupamento de setores censitários) conforme IBGE 2010
     */
    private String areap;

    /**
     * Código do Distrito Municipal conforme IBGE
     */
    private String coddist;

    /**
     * Nome do Distrito Municipal
     */
    private String district;

    /**
     * Código de cada uma das 31 Subprefeituras (2003 a 2012
     */
    private String codsubpref;

    /**
     * Nome da Subprefeitura (31 de 2003 até 2012
     */
    private String subpref;

    /**
     * Região conforme divisão do Município em 5 áreas
     */
    private String region5;

    /**
     * Região conforme divisão do Município em 8 áreas
     */
    private String region8;

    /**
     * Denominação da feira livre atribuída pela Supervisão de Abastecimento
     */
    private String name;

    /**
     * Número do registro da feira livre na PMSP
     */
    private String register;

    /**
     * Nome do logradouro onde se localiza a feira livre
     */
    private String street;

    /**
     * Um número do logradouro onde se localiza a feira livre
     */
    private String addrNumber;

    /**
     * Bairro de localização da feira livre
     */
    private String neighborhood;

    /**
     * Ponto de referência da localização da feira livre
     */
    private String reference;


}
