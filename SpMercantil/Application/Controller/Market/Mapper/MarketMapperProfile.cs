using Application.Controller.Market.Dto.Request;
using Application.Controller.Market.Dto.Response;
using AutoMapper;
using Core.Domain.Dto;

namespace Application.Controller.Market.Mapper
{
    public class MarketMapperProfile : Profile
    {
        public MarketMapperProfile()
        {
            CreateMap<CreateMarketRequest, CreateMarketDto>();
            CreateMap<UpdateMarketRequest, UpdateMarketDto>();
            CreateMap<FilterMarketRequest, FilterMarketDto>();
            CreateMap<Core.Domain.Model.Market, MarketResponse>();
            CreateMap(typeof(Page<>), typeof(PageResponse<>));
        }
    }
}