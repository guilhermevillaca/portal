# Etapa de build
FROM node:18 as builder
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build -- --prod

# Production stage
FROM nginx:alpine
COPY --from=builder /app/dist/portal_front /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
