#!/bin/bash

cd ~/apache-log

# Caso o usuário tenha esquecido de passar o parametro
if [ -z $1 ] # -z - verifica se o conteudo do parametro esta vazio
then
	while [ -z $requisicao]
	do
		read -p "Voce esqueceu de colocar o parametro(GET, PUT, POST, DELETE)" requisicao # read - lê um dado do teclado
		 # requisicao -> variavel que ira guardar o parametro, -p -> mantém na mesma linha
		letra_maiuscula=$(echo $requisicao | awk '{ print toupper($1) }') # usamos a funcao toupper do awk
	done
else
	# Transformando o parâmetro em letra maiúscula
	letra_maiuscula=$(echo $1 | awk '{ print toupper($1) }') # usamos a funcao toupper do awk
fi

case $letra_maiuscula in
        GET)
        cat apache.log | grep GET
        ;;

        POST)
        cat apache.log | grep POST
        ;;

        PUT)
        cat apache.log | grep PUT
        ;;

        DELETE)
        cat apache.log | grep DELETE
        ;;

        *) # Caso não seja nenhum dos itens acima
        echo "O parametro passado nao e valido"
        ;;
esac # Devemos fechar com case ao contrário

# Mesma funcionalidade do código acima, mas sem validações:
#if [ $1 == "GET"] # Usamos == ou = para comparar string
#then
#	cat apache.log | grep GET
#elif [ $1 == "POST"] # poderia ser else if tambem
#then
#	cat apache.log | grep POST
#elif [$1 == "PUT"]
#then
#	cat apache.log | grep PUT
#elif [$1 == "DELETE"]
#then
#	cat apache.log | grep DELETE
#fi
