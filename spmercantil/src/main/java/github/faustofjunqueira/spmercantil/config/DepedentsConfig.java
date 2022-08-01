package github.faustofjunqueira.spmercantil.config;

import github.faustofjunqueira.spmercantil.core.port.MarketCrudService;
import github.faustofjunqueira.spmercantil.core.repository.MarketRepository;
import github.faustofjunqueira.spmercantil.core.service.MarketCrudServiceImpl;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;

/**
 * Configuração do CDI
 * Para a arquitetura hexagonal, não ter nenhuma dependencia, nem mesmo como o framework, entao temos esse tipo de implementação
 * Aqui teremos a declaração das dependencias dos serviços
 */
@Dependent
public class DepedentsConfig {

    @Default
    public MarketCrudService marketCrud(MarketRepository marketRepository) {
        return new MarketCrudServiceImpl(marketRepository);
    }

}
