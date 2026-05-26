# Podemos passar os valores para as varáveis de várias formas:
#  1 - através da linha de comando: terraform apply -var nome_da_variavel=valor, podemos usar isso com o plan também!
#  2 - através de um arquivo de variáveis: terraform apply -var-file="terrafom.tfvars" - poderia ser qualquer nome, mas o final tem que ser .tfvars ou .tfvars.json
#  3 - através de variáveis de ambiente: export TF_VAR_location="East US" - as var env começam com TF_VAR_ seguido do nome da variável
#  4 - através de um arquivo de variáveis chamado variables.auto.tfvars ou variables.auto.tfvars.json - esses arquivos jogam as variáveis automaticamente, sem a necessidade de usar o -var-file na linha de comando. O nome do arquivo deve começar com "variables" e terminar com ".auto.tfvars" ou ".auto.tfvars.json"
#  5 - através de um arquivo com valores definidos manualmente, como este arquivo de exemplo: (RECOMENDADA)

# O nome do arquivo de variáveis é convencionalmente "variables.tf", mas pode ser nomeado de acordo com a preferência do desenvolvedor, desde que seja um arquivo .tf 
# Podemos dar o nome que quisermos para as variáveis, mas é recomendado usar nomes descritivos para facilitar a compreensão do código
variable "location" {
  # Descrição da variável
  description = "Região onde os recursos serão criados na Azure"
  type        = string
  default     = "West Europe"
}

variable "account_tier" {
  description = "Tier da Storage Account da Azure"
  type        = string
  # Standard ou Premium - Verifique na documentação da Azure para mais detalhes sobre os tipos de Storage Account disponíveis
  default = "Standard"
}

variable "account_replication_type" {
  description = "Tipo de replicação de dados da storage account"
  type        = string
  # LRS, GRS, RA-GRS, ZRS - Verifique na documentação da Azure para mais detalhes sobre os tipos de replicação disponíveis
  default = "LRS"
}

variable "resource_group_name" {
  description = "Nome para o resource Group da Azure"
  type        = string
  default     = "rg-curso-terraform"
}

variable "storage_account_name" {
  description = "Nome para a Storage Account da Azure"
  type        = string
  default     = "lucasterraform"
}

variable "container_name" {
  description = "Nome do container na Azure"
  type        = string
  default     = "container-terraform"
}