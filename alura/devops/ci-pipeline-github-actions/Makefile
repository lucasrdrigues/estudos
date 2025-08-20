# EXEMPLO DE UMA ESTEIRA com makefile
# Este é um arquivo somente para mostrar a lógica por trás da esteira. O CURDIR é uma variável de ambiente que jogamos nela o "pwd", pois neste arquivo não conseguimos rodar comandos usados no terminal.

# make lint - roda somente o lint
# make test - roda somente o test
# make ci - roda o start, o lint e caso tenha sucesso, roda o test
lint:
	docker run --rm -itv $(CURDIR):/app -w /app golangci/golangci-lint golangci-lint run controllers/ database/ models/ routes/
test:
	docker compose exec app go test main_test.go
start:
	docker compose up -d
ci: start lint test
