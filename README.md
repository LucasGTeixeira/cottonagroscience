# cottonagroscience

# Setup para rodar o Projeto

## Subindo o Banco de Dados

### Instalando Docker

Caso não tenha docker na sua máquina, instale por aqui a versão mais recente: [Docker](https://www.docker.com/products/docker-desktop/)

### Criando um container docker usando o arquivo docker compose

Partindo da raiz do projeto, rode os seguintes comandos:

```
cd docker
docker-compose up --build --remove-orphans -d

```
