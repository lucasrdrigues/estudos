#!/bin/bash

# free: memória usada, grep -i mem: trás somente dados da memória sem se importar com a letra caixa alta(-i), awk...:imprime col 2 mem
memoria_total=$(free | grep -i mem | awk '{ print $2 }')

# $3: coluna da memória consumida
memoria_consumida=$(free | grep -i mem | awk '{ print $3 }')

# faz o calculo, multiplicamos por 100 para pegar o valor inteiro(pois o IF so aceita assim) e o awk para tirar as casas decimais
relacao_memoria_atual_total=$(bc <<< "scale=2;$memoria_consumida/$memoria_total *100" | awk -F. '{ print $1}')

if [ $relacao_memoria_atual_total -gt 50 ] # Se a relacao_memoria... for maior que(greather than) 50, faça:
then
mail -s "Consumo de memória acima do limite!" adm.mutillidae@gmail.com<<del
O consumo de memória está acima do limite que foi especificado. Atualmente o consumo é de $(free -h | grep -i mem | awk '{ print $3 }')
del
fi
