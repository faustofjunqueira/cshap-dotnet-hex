package github.faustofjunqueira.spmercantil.application.adapters.controller;

import github.faustofjunqueira.spmercantil.application.adapters.controller.data.MarketMockData;
import github.faustofjunqueira.spmercantil.core.domain.Market;
import github.faustofjunqueira.spmercantil.core.dto.CreateMarketDto;
import github.faustofjunqueira.spmercantil.core.exception.RegisterAlreadyExistsException;
import github.faustofjunqueira.spmercantil.core.port.MarketCrudService;
import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

@QuarkusTest
public class MarketControllerTest {

    @Test
    public void whenSendRightCreateDto_shouldBeReturn201StatusCodeWithSameRegisterCode() throws RegisterAlreadyExistsException {
        CreateMarketDto createDto = MarketMockData.generateSuccessCreateMarketDto();
        Market market = MarketMockData.generateSuccessedMarket();

        MarketCrudService mock = Mockito.mock(MarketCrudService.class);
        Mockito.when(mock.create(createDto)).thenReturn(market);
        QuarkusMock.installMockForType(mock, MarketCrudService.class);

        given()
                .body(createDto)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .when().post("/market")
                .then()
                .statusCode(201)
                .body("id", is("1"))
                .body("setcens", is("355030885000091"))
                .body("areap", is("3550308005040"))
                .body("coddist", is("87"))
                .body("district", is("VILA FORMOSA"))
                .body("codsubpref", is("26"))
                .body("subpref", is("ARICANDUVA-FORMOSA-CARRAO"))
                .body("region5", is("Leste"))
                .body("region8", is("Leste 1"))
                .body("name", is("VILA FORMOSA"))
                .body("register", is("4041-0"))
                .body("street", is("RUA MARAGOJIPE"))
                .body("addrNumber", is("S/N"))
                .body("neighborhood", is("VL FORMOSA"))
                .body("reference", is("TV RUA PRETORIA"));
    }

    @Test
    public void whenSendValidationErrorCreateDto_shouldBeReturn400StatusCode() throws RegisterAlreadyExistsException {
        CreateMarketDto createDto = MarketMockData.generateValidationErrorCreateMarketDto();

        given()
                .body(createDto)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .when().post("/market")
                .then()
                .statusCode(400);
    }



}
