package github.faustofjunqueira.spmercantil.application.adapters.controller.data;

import github.faustofjunqueira.spmercantil.application.adapters.controller.response.MarketResponse;
import github.faustofjunqueira.spmercantil.core.domain.Market;
import github.faustofjunqueira.spmercantil.core.dto.CreateMarketDto;

public class MarketMockData {

    public static CreateMarketDto generateSuccessCreateMarketDto() {
        var register = new CreateMarketDto();
        register.setId("1");
        register.setLongitude(-46.550164D);
        register.setLatitude(-23.558733D);
        register.setSetcens("355030885000091");
        register.setAreap("3550308005040");
        register.setCoddist("87");
        register.setDistrict("VILA FORMOSA");
        register.setCodsubpref("26");
        register.setSubpref("ARICANDUVA-FORMOSA-CARRAO");
        register.setRegion5("Leste");
        register.setRegion8("Leste 1");
        register.setName("VILA FORMOSA");
        register.setRegister("4041-0");
        register.setStreet("RUA MARAGOJIPE");
        register.setAddrNumber("S/N");
        register.setNeighborhood("VL FORMOSA");
        register.setReference("TV RUA PRETORIA");
        return register;
    }

    public static CreateMarketDto generateValidationErrorCreateMarketDto() {
        var register = generateSuccessCreateMarketDto();
        register.setAddrNumber("fajshdfkasjdhfkasjdhfaksdhfkasjdhfkasjdhfaksjhdfaksdhfkajshfkasjdhf");
        return register;
    }

    public static Market generateSuccessedMarket() {
        var register = new Market();
        register.setId("1");
        register.setLongitude(-46.550164D);
        register.setLatitude(-23.558733D);
        register.setSetcens("355030885000091");
        register.setAreap("3550308005040");
        register.setCoddist("87");
        register.setDistrict("VILA FORMOSA");
        register.setCodsubpref("26");
        register.setSubpref("ARICANDUVA-FORMOSA-CARRAO");
        register.setRegion5("Leste");
        register.setRegion8("Leste 1");
        register.setName("VILA FORMOSA");
        register.setRegister("4041-0");
        register.setStreet("RUA MARAGOJIPE");
        register.setAddrNumber("S/N");
        register.setNeighborhood("VL FORMOSA");
        register.setReference("TV RUA PRETORIA");
        return register;
    }

    public static MarketResponse generateSuccessedMarketResponse() {
        var register = new MarketResponse();
        register.setId("1");
        register.setLongitude(-46.550164D);
        register.setLatitude(-23.558733D);
        register.setSetcens("355030885000091");
        register.setAreap("3550308005040");
        register.setCoddist("87");
        register.setDistrict("VILA FORMOSA");
        register.setCodsubpref("26");
        register.setSubpref("ARICANDUVA-FORMOSA-CARRAO");
        register.setRegion5("Leste");
        register.setRegion8("Leste 1");
        register.setName("VILA FORMOSA");
        register.setRegister("4041-0");
        register.setStreet("RUA MARAGOJIPE");
        register.setAddrNumber("S/N");
        register.setNeighborhood("VL FORMOSA");
        register.setReference("TV RUA PRETORIA");
        return register;
    }
}
