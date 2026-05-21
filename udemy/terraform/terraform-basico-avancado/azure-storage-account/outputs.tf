# output "nome_escolhido" {}
output "storage_account_id" {
  description = "ID da Storage Account criada na Azure"
  # Pegando o id da storage account criada no recurso no outro arquivo. Lembrando que este id é um atributo referente, ou seja, ele é gerado automaticamente
  value = azurerm_storage_account.storage_account.id
}

output "sa_primary_access_key" {
  description = "Primary access key da Storage Account criada na Azure"
  value = azurerm_storage_account.storage_account.primary_access_key
  # Dessa forma o output não é exposto no terminal, existem atributos que são obrigatórios usar isso, como em senhas e chaves
  sensitive = true
}