#!/bin/bash

converte_imagem(){
	local caminho_imagem=$1 # colocamos em uma variavel somente para nao ter que ficar usando $1 varias vezes
	local imagem_sem_extensao=$(ls $caminho_imagem | awk -F. '{ print $1 }')
	convert $imagem_sem_extensao.jpg $imagem_sem_extensao.png
}

varrer_diretorio(){
	# Este $1 esta vindo da chamada desta funcao la em baixo em: varrer_diretorio $arquivo. Ele é o primeiro parâmetro recebido
	cd $1
	for arquivo in * # Varredura em todo o conteúdo dentro da pasta
	do
		local caminho_arquivo=$(find /mnt/c/Users/Heiliger-17/TI/estudos-local/shell-scripting/1-scrips-automacao-tarefa/imagens-novos-livros -name $arquivo)
		if [ -d $caminho_arquivo ]
		then
			# Chamando função dentro dela mesma(chamamos de recursão este método)
			varrer_diretorio $caminho_arquivo # $arquivo - parâmetro a ser recebido(no caso sao os arquivos que sao diretórios)
		else
			converte_imagem $caminho_arquivo  # Conversao jpg para png
		fi
	done
}

# Chamando função e passando caminho como parametro
varrer_diretorio /mnt/c/Users/Heiliger-17/TI/estudos-local/shell-scripting/1-scrips-automacao-tarefa/imagens-novos-livros

# Status
if [ $? -eq 0 ]
then
	echo "Conversão realizada com sucesso"
else
	echo "Houve um problema na conversão"
fi
