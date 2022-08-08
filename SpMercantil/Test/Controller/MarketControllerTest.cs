using System.Threading.Tasks;
using Application.Controller.Market;
using Application.Controller.Market.Dto.Request;
using Application.Controller.Market.Dto.Response;
using Application.Controller.Market.Mapper;
using AutoFixture;
using AutoFixture.AutoMoq;
using AutoMapper;
using Core.Domain.Dto;
using Core.Domain.Model;
using Core.Exceptions;
using Core.Service.Port;
using Microsoft.AspNetCore.Mvc;
using Moq;
using Xunit;

namespace Test.Controller
{
    public class MarketControllerTest
    {
        private readonly IFixture _fixture;
        private readonly IMapper _mapper;

        public MarketControllerTest()
        {
            _fixture = new Fixture().Customize(new AutoMoqCustomization());
            //auto mapper configuration
            var mockMapper = new MapperConfiguration(cfg => { cfg.AddProfile(new MarketMapperProfile()); });
            _mapper = mockMapper.CreateMapper();
        }

        [Theory]
        [InlineData("xxxx-x")]
        public async Task UpdateMarket_ReturnsMarketWithSameValues(string register)
        {
            UpdateMarketRequest updatedDto = _fixture.Build<UpdateMarketRequest>().Create();
            Market updatedMarket = _fixture.Build<Market>()
                .With(x => x.Id, updatedDto.Id)
                .With(x => x.Longitude, updatedDto.Longitude)
                .With(x => x.Latitude, updatedDto.Latitude)
                .With(x => x.Setcens, updatedDto.Setcens)
                .With(x => x.Areap, updatedDto.Areap)
                .With(x => x.Coddist, updatedDto.Coddist)
                .With(x => x.District, updatedDto.District)
                .With(x => x.Codsubpref, updatedDto.Codsubpref)
                .With(x => x.Subpref, updatedDto.Subpref)
                .With(x => x.Region5, updatedDto.Region5)
                .With(x => x.Region8, updatedDto.Region8)
                .With(x => x.Name, updatedDto.Name)
                .With(x => x.Register, register)
                .With(x => x.Street, updatedDto.Street)
                .With(x => x.AddrNumber, updatedDto.AddrNumber)
                .With(x => x.Neighborhood, updatedDto.Neighborhood)
                .With(x => x.Reference, updatedDto.Reference)
                .Create();

            Mock<IMarketCrudService> service = new Mock<IMarketCrudService>();
            service.Setup(x => x.UpdateAsync(It.IsAny<string>(), It.IsAny<UpdateMarketDto>()))
                .Returns(Task.Run(() => updatedMarket));

            var controller = new MarketController(service.Object, _mapper);

            IActionResult actionResult = await controller.UpdateAsync(register, updatedDto);

            Assert.IsType<OkObjectResult>(actionResult);
            var okResult = actionResult as OkObjectResult;
            Assert.NotNull(okResult);
            var marketResult = okResult.Value as MarketResponse;
            Assert.NotNull(marketResult);
            Assert.Equal(200, okResult.StatusCode);
            Assert.Equal(updatedDto.Areap, marketResult.Areap);
            Assert.Equal(updatedDto.Id, marketResult.Id);
            Assert.Equal(updatedDto.Longitude, marketResult.Longitude);
            Assert.Equal(updatedDto.Latitude, marketResult.Latitude);
            Assert.Equal(updatedDto.Setcens, marketResult.Setcens);
            Assert.Equal(updatedDto.Areap, marketResult.Areap);
            Assert.Equal(updatedDto.Coddist, marketResult.Coddist);
            Assert.Equal(updatedDto.District, marketResult.District);
            Assert.Equal(updatedDto.Codsubpref, marketResult.Codsubpref);
            Assert.Equal(updatedDto.Subpref, marketResult.Subpref);
            Assert.Equal(updatedDto.Region5, marketResult.Region5);
            Assert.Equal(updatedDto.Region8, marketResult.Region8);
            Assert.Equal(updatedDto.Name, marketResult.Name);
            Assert.Equal(register, marketResult.Register);
            Assert.Equal(updatedDto.Street, marketResult.Street);
            Assert.Equal(updatedDto.AddrNumber, marketResult.AddrNumber);
            Assert.Equal(updatedDto.Neighborhood, marketResult.Neighborhood);
            Assert.Equal(updatedDto.Reference, marketResult.Reference);
        }

        [Fact]
        public async Task CreateMarket_ReturnsNewMarket()
        {
            CreateMarketRequest createdDto = _fixture.Build<CreateMarketRequest>().Create();
            Market createdMarket = _fixture.Build<Market>()
                .With(x => x.Id, createdDto.Id)
                .With(x => x.Longitude, createdDto.Longitude)
                .With(x => x.Latitude, createdDto.Latitude)
                .With(x => x.Setcens, createdDto.Setcens)
                .With(x => x.Areap, createdDto.Areap)
                .With(x => x.Coddist, createdDto.Coddist)
                .With(x => x.District, createdDto.District)
                .With(x => x.Codsubpref, createdDto.Codsubpref)
                .With(x => x.Subpref, createdDto.Subpref)
                .With(x => x.Region5, createdDto.Region5)
                .With(x => x.Region8, createdDto.Region8)
                .With(x => x.Name, createdDto.Name)
                .With(x => x.Register, createdDto.Register)
                .With(x => x.Street, createdDto.Street)
                .With(x => x.AddrNumber, createdDto.AddrNumber)
                .With(x => x.Neighborhood, createdDto.Neighborhood)
                .With(x => x.Reference, createdDto.Reference)
                .Create();

            Mock<IMarketCrudService> service = new Mock<IMarketCrudService>();
            service.Setup(x => x.CreateAsync(It.IsAny<CreateMarketDto>()))
                .Returns(Task.Run(() => createdMarket));

            var controller = new MarketController(service.Object, _mapper);

            IActionResult actionResult = await controller.CreateAsync(createdDto);

            Assert.IsType<CreatedResult>(actionResult);
            var okResult = actionResult as CreatedResult;
            Assert.NotNull(okResult);
            var marketResult = okResult.Value as MarketResponse;
            Assert.NotNull(marketResult);
            Assert.Equal(201, okResult.StatusCode);
            Assert.Equal(createdDto.Areap, marketResult.Areap);
            Assert.Equal(createdDto.Id, marketResult.Id);
            Assert.Equal(createdDto.Longitude, marketResult.Longitude);
            Assert.Equal(createdDto.Latitude, marketResult.Latitude);
            Assert.Equal(createdDto.Setcens, marketResult.Setcens);
            Assert.Equal(createdDto.Areap, marketResult.Areap);
            Assert.Equal(createdDto.Coddist, marketResult.Coddist);
            Assert.Equal(createdDto.District, marketResult.District);
            Assert.Equal(createdDto.Codsubpref, marketResult.Codsubpref);
            Assert.Equal(createdDto.Subpref, marketResult.Subpref);
            Assert.Equal(createdDto.Region5, marketResult.Region5);
            Assert.Equal(createdDto.Region8, marketResult.Region8);
            Assert.Equal(createdDto.Name, marketResult.Name);
            Assert.Equal(createdDto.Register, marketResult.Register);
            Assert.Equal(createdDto.Street, marketResult.Street);
            Assert.Equal(createdDto.AddrNumber, marketResult.AddrNumber);
            Assert.Equal(createdDto.Neighborhood, marketResult.Neighborhood);
            Assert.Equal(createdDto.Reference, marketResult.Reference);
        }

        [Theory]
        [InlineData("xxxx-x")]
        public async Task DeleteMarket_ReturnsNoContent(string register)
        {
            Mock<IMarketCrudService> service = new Mock<IMarketCrudService>();
            service.Setup(x => x.DeleteAsync(It.IsAny<string>()))
                .Returns(Task.Run(() => { }));

            var controller = new MarketController(service.Object, _mapper);

            IActionResult actionResult = await controller.DeleteAsync(register);

            Assert.IsType<NoContentResult>(actionResult);
            var okResult = actionResult as NoContentResult;
            Assert.NotNull(okResult);
            Assert.Equal(204, okResult.StatusCode);
        }

        [Theory]
        [InlineData("xxxx-x")]
        public async Task DeleteMarket_ThrowsRecordNotfound(string register)
        {
            Mock<IMarketCrudService> service = new Mock<IMarketCrudService>();
            service.Setup(x => x.DeleteAsync(It.IsAny<string>()))
                .Throws(new RecordNotFoundException(register, "Market"));

            var controller = new MarketController(service.Object, _mapper);

            await Assert.ThrowsAsync<RecordNotFoundException>(() => controller.DeleteAsync(register));
        }
    }
}