using System;
using System.IO;
using System.Reflection;
using Application.Controller.Configuration;
using Application.EntityFramework;
using AutoMapper;
using AutoMapper.EquivalencyExpression;
using Core.Repository;
using Core.Service;
using Core.Service.Port;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Diagnostics.HealthChecks;
using Microsoft.AspNetCore.Hosting;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using Microsoft.OpenApi.Models;
using Serilog;
using Serilog.Events;

namespace Application
{
    public class Startup
    {
        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public IConfiguration Configuration { get; }

        /// <summary>
        ///     This method gets called by the runtime. Use this method to add services to the container.
        /// </summary>
        /// <param name="services"></param>
        public void ConfigureServices(IServiceCollection services)
        {
            
            services.AddControllers(
                options => { options.Filters.Add(new HttpResponseExceptionFilter()); }
            ).AddNewtonsoftJson();

            // https://docs.microsoft.com/pt-br/aspnet/core/tutorials/getting-started-with-swashbuckle?view=aspnetcore-6.0&tabs=visual-studio
            services.AddSwaggerGenNewtonsoftSupport();
            services.AddSwaggerGen(options =>
            {
                options.SwaggerDoc("v1", new OpenApiInfo
                {
                    Version = "v1",
                    Title = "Sp Mercantil",
                    Description = "Servico de gerenciamento de feiras da cidade de Sao Paulo",
                    Contact = new OpenApiContact
                    {
                        Name = "Fausto F Junqueira",
                        Url = new Uri("http://linkedin.com/in/faustofjunqueira")
                    },
                    License = new OpenApiLicense
                    {
                        Name = "MIT",
                        Url = new Uri("https://github.com/faustofjunqueira/sp-mercantil-web-api/blob/dev/LICENSE")
                    }
                });
                // using System.Reflection;
                var xmlFilename = $"{Assembly.GetExecutingAssembly().GetName().Name}.xml";
                options.IncludeXmlComments(Path.Combine(AppContext.BaseDirectory, xmlFilename));
            });

            services.AddCors(options =>
            {
                options.AddDefaultPolicy(
                    builder =>
                    {
                        builder.WithOrigins(Configuration.GetValue<string>("cors:AllowedHosts"));
                        builder.WithHeaders("*");
                        builder.WithMethods("*");
                    });
            });

            // EF
            services.AddDbContext<ApplicationContext>(options =>
            {
                var connectionString = Configuration.GetConnectionString("DefaultConnection");
                Log.Information("Connection String {@ConnectionString}", connectionString);
                options.UseMySql(connectionString, new MySqlServerVersion(new Version(8, 0, 30)));
            });
            services.AddScoped<IUnitOfWork, EfUnitOfWork>();

            // Automapper
            services.AddAutoMapper((serviceProvider, automapper) =>
            {
                automapper.AddCollectionMappers();
                automapper.UseEntityFrameworkCoreModel<ApplicationContext>(serviceProvider);
            }, AppDomain.CurrentDomain.GetAssemblies());
            
            services.AddHealthChecks();
            services.AddResponseCompression();
            
            // Services
            services.AddScoped<IMarketCrudService, MarketCrudService>();
        }

        /// <summary>
        ///     This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        /// </summary>
        /// <param name="app"></param>
        /// <param name="env"></param>
        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {
            // app.Use((context, next) =>
            // {
            //     context.Request.PathBase = Configuration.GetValue<string>("baseUrl");
            //     return next();
            // });
            app.UseSwagger();
            app.UseSwaggerUI(c => c.SwaggerEndpoint("/swagger/v1/swagger.json", "SP Mercantil"));
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }
            else
            {
                app.UseExceptionHandler("/Error");
                // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
                app.UseHsts();
            }

            app.UseHttpsRedirection();
            app.UseRouting();
            app.UseCors();
            app.UseEndpoints(endpoints =>
            {
                endpoints.MapHealthChecks("/health", new HealthCheckOptions
                {
                    AllowCachingResponses = false
                });
                endpoints.MapControllers();
            });

            app.UseSerilogRequestLogging();
        }
    }
}