package github.faustofjunqueira.spmercantil.application.adapters.repository.converter;

import github.faustofjunqueira.spmercantil.application.adapters.repository.entity.MarketEntity;
import github.faustofjunqueira.spmercantil.core.domain.Market;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Mapper de todos as entity em domain
 */
@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface RepositoryMapper {

    /**
     * Converte de MarketEntity para Market
     * @param entity MarketEntity entidade carregada da base de dados
     * @return Market Market convertido
     */
    Market toMarket(MarketEntity entity);

}
