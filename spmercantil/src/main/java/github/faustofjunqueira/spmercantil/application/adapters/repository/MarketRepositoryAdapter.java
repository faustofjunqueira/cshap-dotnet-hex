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
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Sort;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        MarketEntity marketEntity = MarketEntity.findByRegister(register);
        marketConverter.fromUpdateDto(updateMarketDto, marketEntity);
        marketEntity.persist();
        return mapper.toMarket(marketEntity);
    }

    @Override
    @Transactional
    public Page<Market> filter(FilterMarketDto filterMarketDto) {
        StringBuilder querystr = new StringBuilder();
        Map<String, Object> params = new HashMap<String, Object>();
        if(filterMarketDto.getDistrict() != null) {
            querystr.append("lower(district) like :district");
            params.put("district", "%"+filterMarketDto.getDistrict()+"%");
        }

        if(filterMarketDto.getNeighborhood() != null) {
            querystr.append("lower(neighborhood) like :neighborhood");
            params.put("neighborhood", "%"+filterMarketDto.getNeighborhood()+"%");
        }

        if( filterMarketDto.getName() != null ) {
            querystr.append("lower(name) like :name");
            params.put("name", "%"+filterMarketDto.getName()+"%");
        }

        if(filterMarketDto.getRegion5() != null) {
            querystr.append("lower(region5) like :region5");
            params.put("region5", "%"+filterMarketDto.getRegion5()+"%");
        }
        PanacheQuery<MarketEntity> query =
                MarketEntity.find(querystr.toString(), Sort.by("id"), params)
                        .page(filterMarketDto.getPage(), filterMarketDto.getSize());
        List<Market> marketList = mapper.toMarketList(query.list());
        Long total = query.count();
        return new Page<>(total, marketList);
    }
}
