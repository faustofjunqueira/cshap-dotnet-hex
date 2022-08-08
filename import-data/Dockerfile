## 
# Imagem de build da aplicação

FROM node:18-alpine3.15

RUN mkdir /import

COPY ./* /import

WORKDIR /import

RUN npm install

CMD ["node", "index.js"]