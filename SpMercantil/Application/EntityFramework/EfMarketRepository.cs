using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Application.EntityFramework.Entity;
using AutoMapper;
using Core.Domain.Dto;
using Core.Domain.Model;
using Core.Exceptions;
using Core.Repository;
using Microsoft.EntityFrameworkCore;

namespace Application.EntityFramework
{
    /// <summary>
    ///     Camada de serviço do banco de dados mysql para Feiras(market)
    /// </summary>
    public class EfMarketRepository : IMarketRepository
    {
        private readonly ApplicationContext _context;
        private readonly IMapper _mapper;

        public EfMarketRepository(ApplicationContext context, IMapper mapper)
        {
            _context = context;
            _mapper = mapper;
        }


        public async Task<Market> CreateAsync(CreateMarketDto dto)
        {
            var entity = new MarketEntity();
            entity.PkId = Guid.NewGuid();
            entity.Id = dto.Id;
            entity.Longitude = dto.Longitude;
            entity.Latitude = dto.Latitude;
            entity.Setcens = dto.Setcens;
            entity.Areap = dto.Areap;
            entity.Coddist = dto.Coddist;
            entity.District = dto.District;
            entity.Codsubpref = dto.Codsubpref;
            entity.Subpref = dto.Subpref;
            entity.Region5 = dto.Region5;
            entity.Region8 = dto.Region8;
            entity.Name = dto.Name;
            entity.Register = dto.Register;
            entity.Street = dto.Street;
            entity.AddrNumber = dto.AddrNumber;
            entity.Neighborhood = dto.Neighborhood;
            entity.Reference = dto.Reference;
            entity.UpdatedAt = DateTime.Now;
            entity.CreatedAt = DateTime.Now;

            await _context.Market.AddAsync(entity);
            await _context.SaveChangesAsync();
            return _mapper.Map<Market>(entity);
        }

        public async Task DeleteAsync(string register)
        {
            var entity = await GetByRegisterAsync(register);
            entity.DeletedAt = DateTime.Now;
            await _context.SaveChangesAsync();
        }

        public async Task<Market> UpdateAsync(string register, UpdateMarketDto dto)
        {
            var entity = await GetByRegisterAsync(register);
            entity.Id = dto.Id;
            entity.Longitude = dto.Longitude;
            entity.Latitude = dto.Latitude;
            entity.Setcens = dto.Setcens;
            entity.Areap = dto.Areap;
            entity.Coddist = dto.Coddist;
            entity.District = dto.District;
            entity.Codsubpref = dto.Codsubpref;
            entity.Subpref = dto.Subpref;
            entity.Region5 = dto.Region5;
            entity.Region8 = dto.Region8;
            entity.Name = dto.Name;
            entity.Street = dto.Street;
            entity.AddrNumber = dto.AddrNumber;
            entity.Neighborhood = dto.Neighborhood;
            entity.Reference = dto.Reference;
            entity.UpdatedAt = DateTime.Now;
            await _context.SaveChangesAsync();
            return _mapper.Map<Market>(entity);
        }

        public async Task<Page<Market>> FilterAsync(FilterMarketDto filter)
        {
            var page = filter.Page == 0 ? 1 : filter.Page;
            var skip = (page - 1) * filter.Size;
            IQueryable<MarketEntity> query = _context.Market;
            if (!string.IsNullOrEmpty(filter.District))
            {
                query = query.Where(x => x.District.ToLower().Contains(filter.District.ToLowerInvariant()));
            }

            if (!string.IsNullOrEmpty(filter.Name))
            {
                query = query.Where(x => x.Name.ToLower().Contains(filter.Name.ToLowerInvariant()));
            }

            if (!string.IsNullOrEmpty(filter.Neighborhood))
            {
                query = query.Where(x => x.Neighborhood.ToLower().Contains(filter.Neighborhood.ToLowerInvariant()));
            }

            if (!string.IsNullOrEmpty(filter.Region5))
            {
                query = query.Where(x => x.Neighborhood.ToLower().Contains(filter.Neighborhood.ToLowerInvariant()));
            }
            
            var total = await query.CountAsync();
            var result = await query.OrderBy(x => x.Register).Skip(skip).Take(filter.Size)
                .ToListAsync();

            var paging = new Page<Market>();
            paging.Data = _mapper.Map<List<Market>>(result);
            paging.Total = total; 
            return paging;
        }

        public async Task<MarketEntity> GetByRegisterAsync(string register)
        {
            var record = await _context.Market.SingleOrDefaultAsync(r => r.Register == register);
            if (record is null)
            {
                throw new RecordNotFoundException(register, "Market");
            }

            return record;
        }
    }
}