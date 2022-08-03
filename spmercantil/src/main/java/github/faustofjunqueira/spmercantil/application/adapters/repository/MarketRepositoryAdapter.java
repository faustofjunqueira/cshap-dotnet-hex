package github.faustofjunqueira.spmercantil.application.adapters.repository;

import github.faustofjunqueira.spmercantil.application.adapters.repository.converter.MarketConverter;
import github.faustofjunqueira.spmercantil.application.adapters.repository.converter.RepositoryMapper;
import github.faustofjunqueira.spmercantil.application.adapters.repository.entity.MarketEntity;
import github.faustofjunqueira.spmercantil.core.domain.Market;
import github.faustofjunqueira.spmercantil.core.dto.CreateMarketDto;
import github.faustofjunqueira.spmercantil.core.dto.FilterMarketDto;
import github.faustofjunqueira.spmercantil.core.dto.Page;
import github.faustofjunqueira.spmercantil.core.dto.UpdateMarketDto;
import github.faustofjunqueira.spmercantil.core.exception.RegisterAlreadyExistsException;
import github.faustofjunqueira.spmercantil.core.exception.RegisterNotFoundException;
import github.faustofjunqueira.spmercantil.core.repository.MarketRepository;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.UUID;

/**
 * Adaptador do repositorio de Market
 *
 * @author Fausto Junqueira
 * @since 01/08/2022
 */
@ApplicationScoped
@RequiredArgsConstructor
public class MarketRepositoryAdapter implements MarketRepository {

    private final RepositoryMapper mapper;
    private final MarketConverter marketConverter;

    @Override
    @Transactional
    public Market create(CreateMarketDto createMarketDto) throws RegisterAlreadyExistsException {
        MarketEntity marketEntity = marketConverter.fromCreateDto(createMarketDto);
        marketEntity.setPkId(UUID.randomUUID());
        marketEntity.persist();
        return mapper.toMarket(marketEntity);
    }

    @Override
    @Transactional
    public void delete(String register) throws RegisterNotFoundException {
        MarketEntity marketEntity = MarketEntity.findByRegister(register);
        marketEntity.delete();
    }

    @Override
    @Transactional
    public Market update(String register, UpdateMarketDto updateMarketDto) throws RegisterNotFoundException {
        return null;
    }

    @Override
    @Transactional
    public Page<Market> filter(FilterMarketDto filterMarketDto) {
        return null;
    }
}
