# syntax=docker/dockerfile:1
FROM mcr.microsoft.com/dotnet/sdk:5.0 AS build-env
    
# Copy csproj and restore as distinct layers
COPY Application /app/Application
COPY Core /app/Core
COPY Test /app/Test
COPY SpMercantil.sln /app

WORKDIR /app/Test

RUN dotnet tool install dotnet-reportgenerator-globaltool --tool-path /opt/reportgenerator

RUN dotnet restore && \
    dotnet  test --collect:"XPlat Code Coverage" && \ 
    mv TestResults/*/coverage.cobertura.xml TestResults && \
    /opt/reportgenerator/reportgenerator "-reports:TestResults/coverage.cobertura.xml" "-targetdir:coveragereport" -reporttypes:Html

WORKDIR /app/Application

# Package Restore
RUN dotnet restore
    
# Copy everything else and build
RUN dotnet publish -c Release -o ../out
    
# Build runtime image
FROM mcr.microsoft.com/dotnet/aspnet:5.0
WORKDIR /app
COPY --from=build-env /app/out .
COPY --from=build-env /app/Test/coveragereport /app/coverage
ENTRYPOINT ["dotnet", "Application.dll"]
