using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Microsoft.EntityFrameworkCore;

namespace Application.EntityFramework.Entity
{
    /// <summary>
    ///     Entidade ORM da feira (Market)
    /// </summary>
    [Table("market")]
    public class MarketEntity
    {
        [Key]
        [Column("pkId", TypeName = "VARCHAR(36)")]
        public Guid PkId { get; set; }

        /// <summary>
        ///     Número de identificação do estabelecimento georreferenciado por SMDU/Deinfo
        ///     </sumarry>
        [Column("id")]
        public string Id { get; set; }

        /// <summary>
        ///     Longitude da localização do estabelecimento no território do Município, conforme MDC
        ///     </sumarry>
        [Column("longitude")]
        public double Longitude { get; set; }

        /// <summary>
        ///     Latitude da localização do estabelecimento no território do Município, conforme MDC
        ///     </sumarry>
        [Column("latitude")]
        public double Latitude { get; set; }

        /// <summary>
        ///     Setor censitário conforme IBGE
        ///     </sumarry>
        [Column("setcens")]
        public string Setcens { get; set; }

        /// <summary>
        ///     Área de ponderação (agrupamento de setores censitários) conforme IBGE 2010
        ///     </sumarry>
        [Column("areap")]
        public string Areap { get; set; }

        /// <summary>
        ///     Código do Distrito Municipal conforme IBGE
        ///     </sumarry>
        [Column("coddist")]
        public string Coddist { get; set; }

        /// <summary>
        ///     Nome do Distrito Municipal
        ///     </sumarry>
        [Column("district")]
        public string District { get; set; }

        /// <summary>
        ///     Código de cada uma das 31 Subprefeituras (2003 a 2012
        ///     </sumarry>
        [Column("codsubpref")]
        public string Codsubpref { get; set; }

        /// <summary>
        ///     Nome da Subprefeitura (31 de 2003 até 2012
        ///     </sumarry>
        [Column("subpref")]
        public string Subpref { get; set; }

        /// <summary>
        ///     Região conforme divisão do Município em 5 áreas
        ///     </sumarry>
        [Column("region5")]
        public string Region5 { get; set; }

        /// <summary>
        ///     Região conforme divisão do Município em 8 áreas
        ///     </sumarry>
        [Column("region8")]
        public string Region8 { get; set; }

        /// <summary>
        ///     Denominação da feira livre atribuída pela Supervisão de Abastecimento
        ///     </sumarry>
        [Column("name")]
        public string Name { get; set; }

        /// <summary>
        ///     Número do registro da feira livre na PMSP
        ///     </sumarry>
        [Column("register")]
        public string Register { get; set; }

        /// <summary>
        ///     Nome do logradouro onde se localiza a feira livre
        ///     </sumarry>
        [Column("street")]
        public string Street { get; set; }

        /// <summary>
        ///     Um número do logradouro onde se localiza a feira livre
        ///     </sumarry>
        [Column("addrNumber")]
        public string AddrNumber { get; set; }

        /// <summary>
        ///     Bairro de localização da feira livre
        ///     </sumarry>
        [Column("neighborhood")]
        public string Neighborhood { get; set; }

        /// <summary>
        ///     Ponto de referência da localização da feira livre
        ///     </sumarry>
        [Column("reference")]
        public string Reference { get; set; }

        /// <summary>
        ///     Campo de auditoria, marca quando houve a ultima atualização
        /// </summary>
        [Column("updatedAt")]
        public DateTime UpdatedAt { get; set; }

        /// <summary>
        ///     Campo de auditoria, marca quando o registro foi criado
        /// </summary>
        [Column("createdAt")]
        public DateTime CreatedAt { get; set; }

        /// <summary>
        ///     Campo de auditoria, marca quando o registro foi deletado, caso o campo seja null, então o registro não esta
        ///     deletado.
        /// </summary>
        [Column("deletedAt")]
        public DateTime? DeletedAt { get; set; }
    }
}