# Cenário: imprimindo os 10 primeiros processos com a maior parte de memoria alocada
#!/bin/bash

# Criando diretório log caso não exista
if [ ! -d log ]
then
	mkdir log
fi

processos_memoria(){
	processos=$(ps -e -o pid --sort -size | head -n 11 | grep [0-9]) # Retorna os pids ordenados, head para os 11 primeiros e o grep
	for pid in $processos
	do
		nome_processo=$(ps -p $pid -o comm=)
		echo -n $(date +%F,%H:%M:%S, ) >> log/$nome_processo.log # -n faz com que o comando echo nao pule uma linha para o proximo comando
		tamanho_processo=$(ps -p $pid -o size | grep [0-9])
		echo "$(bc <<< "scale=2;$tamanho_processo/1024") MB" >> log/$nome_processo.log
		 # bc -> ferramenta para calculos. scale nos permite pegar casas decimais
	done
}

processos_memoria # Chamando função

# Status saída
if [ $? -eq 0]
then
	echo "Os arquivos foram salvos com sucesso."
else
	echo "Houve um problema na hora de salvar os arquivos"
fi
