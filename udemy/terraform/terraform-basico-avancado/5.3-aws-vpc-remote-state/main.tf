terraform {
    required_version = ">= 1.3.0"

    required_providers {
        aws = {
            source  = "hashicorp/aws"
            version = "4.60.0"
        }
    }

    # Configuração do backend para armazenar o estado remoto no S3(AWS)
    # A bucket deve ser criado previamente na AWS e o usuário deve ter permissão para acessar o bucket
    backend "s3" {
        bucket = "meu-bucket-terraform"
        # A chave é o caminho dentro do bucket onde o arquivo de estado será armazenado
        key    = "aws-vpc/terraform.tfstate"
        region = "us-east-1"
    }
}

provider "aws" {
  region = "us-east-1"

  default_tags {
    tags = {
        owner      = "Lucas"
        managed-by = "terraform"
    }
  }
}