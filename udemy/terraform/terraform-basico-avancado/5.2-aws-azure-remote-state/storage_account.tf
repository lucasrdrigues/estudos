resource "azurerm_resource_group" "resource_group" {
  name     = "rg-terraform-state"
  location = var.location

  tags = local.common_tags
}

resource "azurerm_storage_account" "storage_account" {
  name                     = "lucasterraformstate"
  resource_group_name      = azurerm_resource_group.resource_group.name
  location                 = azurerm_resource_group.resource_group.location
  account_tier             = var.account_tier
  account_replication_type = var.account_replication_type

  # Este bloco é o equivalente ao versioning do S3, ele habilita o versionamento dos blobs dentro do storage account, permitindo a recuperação de versões anteriores dos arquivos armazenados, o que é essencial para o estado do Terraform, pois permite restaurar estados anteriores em caso de erros ou mudanças indesejadas.
  # Existem configs que serão diferentes para o aws e para o azure. 
  blob_properties {
    versioning_enabled = true
  }

  tags = local.common_tags
}

resource "azurerm_storage_container" "container" {
  name                  = "remote-state"
  storage_account_name  = azurerm_storage_account.storage_account.name
  container_access_type = "private"
}