terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 3.27"
    }
  }

  required_version = ">= 0.14.9"
}

provider "aws" {
  profile = "default"
  region  = "us-west-2"
}

# app_server é o nome
resource "aws_instance" "app_server" {
  ami           = "ami-03d5c68bab01f3496"
  instance_type = var.instancia # Usando as variáveis definidas
  key_name = var.chave
  tags = {
    Name = "Terraform Ansible Python"
  }
}

# Podemos criar chaves ssh via console AWS e via comando terminal "ssh-keygen". Quando criamos no terminal, devemos vinculá-la à instância da AWS:
resource "aws_key_pair" "chaveSSH" {
  key_name = var.chave
  public_key = file("${var.chave}.pub")
}

output "IP_publico" {
  # value = aws_instance.app_server. -> mostra as infs que podemos retirar do nosso host como: host_id, dns, region, tags
  value = aws_instance.app_server.public_ip
}
