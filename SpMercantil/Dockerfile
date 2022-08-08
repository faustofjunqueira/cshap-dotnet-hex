# syntax=docker/dockerfile:1
FROM mcr.microsoft.com/dotnet/sdk:5.0 AS build-env
    
# Copy csproj and restore as distinct layers
COPY Application /app/Application
COPY Application.Test /app/Application.Test
COPY Core /app/Core
COPY Core.Test /app/Core.Test
COPY SpMercantil.sln /app


WORKDIR /app/Application

# Package Restore
RUN dotnet restore
    
# Copy everything else and build
RUN dotnet publish -c Release -o ../out
    
# Build runtime image
FROM mcr.microsoft.com/dotnet/aspnet:5.0
WORKDIR /app
COPY --from=build-env /app/out .
ENTRYPOINT ["dotnet", "Application.dll"]