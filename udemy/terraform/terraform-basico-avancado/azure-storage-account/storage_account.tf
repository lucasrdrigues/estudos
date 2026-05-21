# Criando resource group
resource "azurerm_resource_group" "resource_group" {
  # Existem attribute referentes que eles nós não definimos, mas que são gerados automaticamente pela Azure, como o id do resource group(Veja a documentação do azure no terraform para saber mais). Esses atributos podem ser referenciados em outros recursos também e rexpostos usando blocos de outputs
  # Os arguments referentes são argumentos que eu posso definir, como os abaixo:

  name     = ""
  # Para usarmos a variável usamos var.nome_da_variavel
  location = var.location

  # Usando os valores do local. Aqui o nome é no singular, mas na definição do bloco é no plural
  tags = local.common_tags
}

resource "azurerm_storage_account" "storage_account" {
  name                     = ""
  # Podemos referenciar o atributo de outro recurso em um recurso. Fazemos isso colocando o recurso seguido do nome do recurso e do atributo que queremos referenciar
  resource_group_name      = azurerm_resource_group.resource_group.name
  location                 = var.location
  account_tier             = var.account_tier
  account_replication_type = var.account_replication_type

  tags = local.common_tags
}

resource "azurerm_storage_container" "container" {
  name                  = ""
  # Referenciando ao nome do recurso acima
  storage_account_name  = azurerm_storage_account.storage_account.name
}