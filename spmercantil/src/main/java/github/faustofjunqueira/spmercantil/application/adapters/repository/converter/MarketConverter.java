package github.faustofjunqueira.spmercantil.application.adapters.repository.converter;

import github.faustofjunqueira.spmercantil.application.adapters.repository.entity.MarketEntity;
import github.faustofjunqueira.spmercantil.core.dto.CreateMarketDto;
import github.faustofjunqueira.spmercantil.core.dto.UpdateMarketDto;

import javax.enterprise.context.ApplicationScoped;

/**
 * Converte as Entities e DTOs, do dominio feira
 */
@ApplicationScoped
public class MarketConverter {

    /**
     * Converte o dto de criação e instancia um novo market
     * @param dto CreateMarketDto informações de criação do marketEntity
     * @return Instancia do market
     */
    public MarketEntity fromCreateDto(CreateMarketDto dto) {
        MarketEntity entity = new MarketEntity();
        applyMarketValues(entity, dto);
        return entity;
    }

    /**
     * Atualização do objeto marketentity a partir do DTO de atualização
     * @param updateMarketDto UpdateMarketDto informações para atualizar o marketEntity
     * @param marketEntity MarketEntity entidade market carregada da base de dados
     */
    public void fromUpdateDto(UpdateMarketDto updateMarketDto, MarketEntity marketEntity) {
        applyMarketValues(marketEntity, updateMarketDto);
    }

    /**
     * Aplica os valores do DTO na entidade do market
     * @param marketEntity MarketEntity entidade carregada da base de dados
     * @param dto CreateMarketDto informações a serem aplicadas na entidade
     */
    private void applyMarketValues(MarketEntity marketEntity, UpdateMarketDto dto) {
        marketEntity.setId(dto.getId());
        marketEntity.setLongitude(dto.getLongitude());
        marketEntity.setLatitude(dto.getLatitude());
        marketEntity.setSetcens(dto.getSetcens());
        marketEntity.setAreap(dto.getAreap());
        marketEntity.setCoddist(dto.getCoddist());
        marketEntity.setDistrict(dto.getDistrict());
        marketEntity.setCodsubpref(dto.getCodsubpref());
        marketEntity.setSubpref(dto.getSubpref());
        marketEntity.setRegion5(dto.getRegion5());
        marketEntity.setRegion8(dto.getRegion8());
        marketEntity.setName(dto.getName());
        marketEntity.setRegister(dto.getRegister());
        marketEntity.setStreet(dto.getStreet());
        marketEntity.setAddrNumber(dto.getAddrNumber());
        marketEntity.setNeighborhood(dto.getNeighborhood());
        marketEntity.setReference(dto.getReference());
    }


}
