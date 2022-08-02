package github.faustofjunqueira.spmercantil.application.adapters.repository.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name="market")
public class MarketEntity {

    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "pkId", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID pkId;

    /**
     * Número de identificação do estabelecimento georreferenciado por SMDU/Deinfo
     */
    @Column(name = "id", unique = true)
    private String id;

    /**
     * Longitude da localização do estabelecimento no território do Município, conforme MDC
     */
    @Column(name="longitude")
    private Double longitude;

    /**
     * Latitude da localização do estabelecimento no território do Município, conforme MDC
     */
    @Column(name="latitude")
    private Double latitude;

    /**
     * Setor censitário conforme IBGE
     */
    @Column(name="setcens")
    private String setcens;

    /**
     * Área de ponderação (agrupamento de setores censitários) conforme IBGE 2010
     */
    @Column(name="areap")
    private String areap;

    /**
     * Código do Distrito Municipal conforme IBGE
     */
    @Column(name="coddist")
    private String coddist;

    /**
     * Nome do Distrito Municipal
     */
    @Column(name="district")
    private String district;

    /**
     * Código de cada uma das 31 Subprefeituras (2003 a 2012
     */
    @Column(name="codsubpref")
    private String codsubpref;

    /**
     * Nome da Subprefeitura (31 de 2003 até 2012
     */
    @Column(name="subpref")
    private String subpref;

    /**
     * Região conforme divisão do Município em 5 áreas
     */
    @Column(name="region5")
    private String region5;

    /**
     * Região conforme divisão do Município em 8 áreas
     */
    @Column(name="region8")
    private String region8;

    /**
     * Denominação da feira livre atribuída pela Supervisão de Abastecimento
     */
    @Column(name="name")
    private String name;

    /**
     * Número do registro da feira livre na PMSP
     */
    @Column(name="register", unique = true)
    private String register;

    /**
     * Nome do logradouro onde se localiza a feira livre
     */
    @Column(name="street")
    private String street;

    /**
     * Um número do logradouro onde se localiza a feira livre
     */
    @Column(name="addrNumber")
    private String addrNumber;

    /**
     * Bairro de localização da feira livre
     */
    @Column(name="neighborhood")
    private String neighborhood;

    /**
     * Ponto de referência da localização da feira livre
     */
    @Column(name="reference")
    private String reference;

}
