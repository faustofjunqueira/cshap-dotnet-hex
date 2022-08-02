package github.faustofjunqueira.spmercantil.application.adapters.repository;

import github.faustofjunqueira.spmercantil.core.domain.Market;
import github.faustofjunqueira.spmercantil.core.dto.CreateMarketDto;
import github.faustofjunqueira.spmercantil.core.dto.FilterMarketDto;
import github.faustofjunqueira.spmercantil.core.dto.Page;
import github.faustofjunqueira.spmercantil.core.dto.UpdateMarketDto;
import github.faustofjunqueira.spmercantil.core.exception.RegisterAlreadyExistsException;
import github.faustofjunqueira.spmercantil.core.exception.RegisterNotFoundException;
import github.faustofjunqueira.spmercantil.core.repository.MarketRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MarketRepositoryImpl implements MarketRepository {
    @Override
    public Market create(CreateMarketDto createMarketDto) throws RegisterAlreadyExistsException {
        return null;
    }

    @Override
    public void delete(String register) throws RegisterNotFoundException {

    }

    @Override
    public Market update(String register, UpdateMarketDto updateMarketDto) throws RegisterNotFoundException {
        return null;
    }

    @Override
    public Page<Market> filter(FilterMarketDto filterMarketDto) {
        return null;
    }
}
