terraform {

  required_version = ">= 1.0.0"

  required_providers {
    azurerm = {
      source  = "hashicorp/azurerm"
      version = "=3.0.0"
    }
  }
}

# Configure the Microsoft Azure Provider
# Sempre veja a documentação para verificar como configurar o provider
provider "azurerm" {
  features {
    # Exmplo do que vai dentro de features, mas na aula não utilizamos
    # resource_group {
    #   prevent_deletion_if_contains_resources = true
    # }
  }
}
