#!/bin/bash

CAMINHO_HOME=/home/rafael

cd $CAMINHO_HOME

# Se não existir o diretório backup crie um
if [ ! -d backup ]
then
	mkdir backup
fi

# O mysqldump é utilizado para realizarmos um backup de um determinado banco presente no MySQL
# $1 -> banco que queremos fazer o backup das informações será passado via parâmetro
mysqldump -u root $1 > $CAMINHO_HOME/backup/$1.sql

# Status
if [ $? -eq 0 ]
then
	echo "Backup foi realizado com sucesso."
else
	echo "Houve um problema no backup!"
fi

# Para reestabelecer o banco de dados use o comando:
# sudo mysql -u root nomeBanco < caminho/arquivo/backup/arquivo.sql
