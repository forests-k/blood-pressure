FROM node:13.5-alpine

WORKDIR /app/blood-pressure

RUN apk update && \
    npm install && \
    npm install -g npm && \
    npm install -g vue-cli

COPY ./package*.json ./

EXPOSE 8080
CMD ["npm", "run", "serve"]