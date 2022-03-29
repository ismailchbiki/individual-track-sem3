FROM node:dind

WORKDIR /code-docker-demo

ENV PORT 80

COPY package.json /code-docker-demo/package.json

RUN npm install

COPY . /code-docker-demo

CMD ["node", "src/server.js"]