FROM ubuntu:latest

EXPOSE 8000

# Pasta de trabalho no container
WORKDIR /app

# Variáveis de ambiente - valores padrão
# Essas variáveis de ambiente serão somente para o docker local, quando formos usar o github actions, devemos adicionar estas variáveis no arquivo do workflow
ENV HOST=localhost PORT=5432
ENV USER=root PASSWORD=root DBNAME=root

# Copiando somente o arquivo compilado(poderia ser o projeto todo também) na pasta atual ./main para a pasta no container /main
COPY ./main main

# Poderiamos usar ENTRY POINT também
CMD [ "./main" ]
# Lembre de usar o "./" para indicar que é na pasta atual(no caso a app)

# Dê o comando "go build main.go" para ele compilar o projeto e trazer um executável para gente, este executável é o que vamos usar para subir o container

# Dê o comando "docker build -t nome:tag ." para ele criar uma imagem, o ponto indica que é no repo atual que ele irá procurar o Dockerfile para buildar a imagem


