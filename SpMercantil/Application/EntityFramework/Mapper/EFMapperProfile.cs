using Application.EntityFramework.Entity;
using AutoMapper;
using Core.Domain.Model;

namespace Application.EntityFramework.Mapper
{
    public class EfMapperProfile : Profile
    {
        public EfMapperProfile()
        {
            CreateMap<MarketEntity, Market>();
        }
    }
}