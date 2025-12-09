#!/bin/bash

resposta_http=$(curl --write-out %{http_code} --silent --output /dev/null https://www.google.com)
# write-out -> escreve o codigo http(status), --silent -> tira as estatísticas, --output /dev/null -> joga o conteudo html no /dev/null

if [ $resposta_http -ne 200 ] # Se o conteúdo NÂO for igual a 200 faça
then
	# -s: subject, adm...: email destino, <<del: delimitador da mensagem. Poderia ser a palavra que quisessemos.
	mail -s "Problema no servidor" adm.mutillidae@gmail.com<<del
Houve um problema no servidor e os usuários pararam de ter acesso ao conteúdo web.
del
# Lembre-se de fechar o delimitador(de acordo com a palavra escolhida)
	systemctl restart apache2
fi
