package github.faustofjunqueira.spmercantil.core.repository;

import github.faustofjunqueira.spmercantil.core.domain.Market;
import github.faustofjunqueira.spmercantil.core.dto.CreateMarketDto;
import github.faustofjunqueira.spmercantil.core.dto.FilterMarketDto;
import github.faustofjunqueira.spmercantil.core.dto.Page;
import github.faustofjunqueira.spmercantil.core.dto.UpdateMarketDto;
import github.faustofjunqueira.spmercantil.core.exception.RegisterAlreadyExistsException;
import github.faustofjunqueira.spmercantil.core.exception.RegisterNotFoundException;

/**
 *
 * @author Fausto Junqueira
 * @since 01/08/2022
 */
public interface MarketRepository {
    /**
     * Cria uma nova feira na base de dados
     *
     * @param createMarketDto informações da feira
     * @return Market registro criado na base de dados
     * @throws RegisterAlreadyExistsException quando é enviado um registro que já tem o mesmo código de id e/ou register
     */
    Market create(CreateMarketDto createMarketDto) throws RegisterAlreadyExistsException;

    /**
     * Remove a feira da base de dados
     *
     * @param register codigo de registro a ser removido
     * @throws RegisterNotFoundException quando o registro não é localizado na base de dados
     */
    void delete(String register) throws RegisterNotFoundException;

    /**
     * Atualiza informações de uma feira
     *
     * @param register        String codigo identificador da feira
     * @param updateMarketDto UpdateMarketDto informações a serem atualizadas
     * @return Market valores da feira após atualização
     * @throws RegisterNotFoundException quando o registro não é localizado na base de dados
     */
    Market update(String register, UpdateMarketDto updateMarketDto) throws RegisterNotFoundException;

    /**
     * Busca registros do banco de dados
     *
     * @param filterMarketDto FilterMarketDto filtra os registros da base de dados
     * @return Page<Market>
     */
    Page<Market> filter(FilterMarketDto filterMarketDto);
}
