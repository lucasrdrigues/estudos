#!/bin/bash

cd ~/apache-log

# \b - word boundary é o limitador, garante que a palavra não esteja colada em letras ou números
# ([0-9]{1,3}\.){3} -  representa os três primeiros blocos de IP
regex="\b([0-9]{1,3}\.){3}[0-9]{1,3}\b"

# Quando estamos usando operadores lógicos e regex devemos usar dois pares de colchetes
if [[ $1 =~ $regex ]] # =~ -> operador comparação com expressão regular
then
	cat apache.log | grep $1
	if [ $? -ne 0] # ne - not equals
	then
		echo "O endereco IP procurado não está presente no arquivo."
	fi
else
	echo "Formato não é válido."
fi

# Para testar, use o comando: bash nome-arquivo.sh <IP-a-ser-passado>
