package github.faustofjunqueira.spmercantil.application.adapters.controller.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

/**
 * Informações para criação de um market
 *
 * @author Fausto Junqueira
 * @since 01/08/2022
 */
@Data
public class CreateMarketRequest {

    /**
     * Número de identificação do estabelecimento georreferenciado por SMDU/Deinfo
     */
    @NotBlank(message = "id is mandatory")
    @Size(min=1, max=8)
    private String id;

    /**
     * Longitude da localização do estabelecimento no território do Município, conforme MDC
     */
    @NotNull(message = "longitude is mandatory")
    @Min(-180)
    @Max(180)
    private Double longitude;

    /**
     * Latitude da localização do estabelecimento no território do Município, conforme MDC
     */
    @NotNull(message = "latitude is mandatory")
    @Min(-90)
    @Max(90)
    private Double latitude;

    /**
     * Setor censitário conforme IBGE
     */
    @NotBlank(message = "id is setcens")
    @Size(min=1, max=15)
    private String setcens;

    /**
     * Área de ponderação (agrupamento de setores censitários) conforme IBGE 2010
     */
    @NotBlank(message = "areap is mandatory")
    @Size(min=1, max=13)
    private String areap;

    /**
     * Código do Distrito Municipal conforme IBGE
     */
    @NotBlank(message = "coddist is mandatory")
    @Size(min=1, max=9)
    private String coddist;

    /**
     * Nome do Distrito Municipal
     */
    @NotBlank(message = "district is mandatory")
    @Size(min=1, max=18)
    private String district;

    /**
     * Código de cada uma das 31 Subprefeituras (2003 a 2012
     */
    @NotBlank(message = "codsubpref is mandatory")
    @Size(min=1, max=2)
    private String codsubpref;

    /**
     * Nome da Subprefeitura (31 de 2003 até 2012
     */
    @NotBlank(message = "subpref is mandatory")
    @Size(min=1, max=25)
    private String subpref;

    /**
     * Região conforme divisão do Município em 5 áreas
     */
    @NotBlank(message = "region5 is mandatory")
    @Size(min=1, max=6)
    private String region5;

    /**
     * Região conforme divisão do Município em 8 áreas
     */
    @NotBlank(message = "region8 is mandatory")
    @Size(min=1, max=7)
    private String region8;

    /**
     * Denominação da feira livre atribuída pela Supervisão de Abastecimento
     */
    @NotBlank(message = "name is mandatory")
    @Size(min=1, max=30)
    private String name;

    /**
     * Número do registro da feira livre na PMSP
     */
    @NotBlank(message = "register is mandatory")
    @Size(min=1, max=6)
    private String register;

    /**
     * Nome do logradouro onde se localiza a feira livre
     */
    @NotBlank(message = "street is mandatory")
    @Size(min=1, max=34)
    private String street;

    /**
     * Um número do logradouro onde se localiza a feira livre
     */
    @NotBlank(message = "addrNumber is mandatory")
    @Size(min=1, max=5)
    private String addrNumber;

    /**
     * Bairro de localização da feira livre
     */
    @NotBlank(message = "neighborhood is mandatory")
    @Size(min=1, max=20)
    private String neighborhood;

    /**
     * Ponto de referência da localização da feira livre
     */
    @NotBlank(message = "reference is mandatory")
    @Size(min=1, max=24)
    private String reference;
}
