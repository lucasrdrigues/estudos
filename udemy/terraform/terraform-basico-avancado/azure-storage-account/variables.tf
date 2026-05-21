# O nome do arquivo de variáveis é convencionalmente "variables.tf", mas pode ser nomeado de acordo com a preferência do desenvolvedor, desde que seja um arquivo .tf 
# Podemos dar o nome que quisermos para as variáveis, mas é recomendado usar nomes descritivos para facilitar a compreensão do código
variable "location" {
    # Descrição da variável
    description = "Região onde os recursos serão criados na Azure"
    type = string
    default = "West Europe"
}

variable "account_tier" {
    description = "Tier da Storage Account da Azure"
    type = string
    # Standard ou Premium - Verifique na documentação da Azure para mais detalhes sobre os tipos de Storage Account disponíveis
    default = "Standard"
}

variable "account_replication_type" {
    description = "Tipo de replicação de dados da storage account"
    type = string
    # LRS, GRS, RA-GRS, ZRS - Verifique na documentação da Azure para mais detalhes sobre os tipos de replicação disponíveis
    default = "LRS"
}