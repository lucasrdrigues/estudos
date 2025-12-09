#!/bin/bash

# Função
converte_imagem(){
# Entrando no diretório das imagens
cd /mnt/c/Users/Heiliger-17/TI/estudos-local/shell-scripting/1-scrips-automacao-tarefa/imagens-livros

# CONDICIONAL - Se não existir o diretório png, então crie
if [ ! -d png ]
then
	mkdir png
fi

# imagem - variável na qual escolhemos o nome
# Atenção: já estamos pegando a extensão do arquivo com *.jpg
for imagem in *.jpg
do
	# local - faz com que a variável se torne somente local(somente dentro desta função)
	local imagem_sem_extensao=$(ls $imagem | awk -F. '{ print $1 }') # Apenas para manipular o texto
	convert $imagem_sem_extensao.jpg png/$imagem_sem_extensao.png # Conversão
done

# EXPLICAÇÃO
# ls + nome do arquivo - retorna o próprio arquivo
# awk(manipula textos) -F. - corta o nome e o campo(F) delimitador é o ponto, ou seja, vamos cortar o nome a partir dos pontos
# '{ print $1 }' - imprime somente o primeiro pedaco cortado
#  imagem_sem_extensao=$( comando a ser executado para pegar o resultado )

# Fim da função
}

# Chamada da função
converte_imagem 2>erros_conversao.txt # caso tenha erro(sinalizado pelo 2), o log será enviado para o arquivo erros_.... Se não tivesse este codigo, o erro seria mostrado na tela.

# $? - tras o status do último comando, no caso status da função. 0 -> sucesso
if [ $? -eq 0 ]
then
	echo "Conversão realizada com sucesso."
else 
	echo "Houve uma falha no processo."
fi

# Status da execução de comandos
# 0 - sucesso, 1 - erro geral, nao sendo identificado o erro, 2 - uso indeviso de comando/argumento, indica a raiz do erro
