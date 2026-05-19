terraform {
  # Especifica a versão mínima do Terraform necessária para este projeto
  # required_version = ">= 1.0.0, < 1.3.0" # Versão mínima e máxima permitida: 1.0.0 até 1.2.x. Tem como fazer outros tipos de intervalos
  required_version = ">= 1.3.0" # Versão mínima: 1.3.0 e superior, sem limite máximo

  #  Especifica os provedores necessários para este projeto
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "4.58.0"
    }
  }
}

# Configurando AWS Provider
# Cuidado: Nem todos os providers tem as mesmas configs no terraform
provider "aws" {
  region = "us-east-1"

  # Configuração de tags padrão para todos os recursos criados com este provider
  default_tags {
    tags = {
      # tag é formada por chave = valor
      owner      = "lucasnrdrigues"
      managed-by = "terrafom"
    }
  }


}



