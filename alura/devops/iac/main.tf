# COMANDOS
# terraform init - rode no terminal na pasta em que está o arquivo do código. Este código instala umas dependencias para que possamos nos comunicarmos com a AWS.

# terraform plan - trás as informações sobre a instância que estamos prestes a criar

# terraform apply - cria a instância

# CUIDADO: Certifique-se de que as imagens e tipos de instâncias são gratuitas e disponiveis para uso!

# Este primeiro bloco podemos copiar do passo a passo da documentação de como criar um iac com aws
terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 5.92"
    }
  }

  required_version = ">= 1.2"
}

# Provedor
provider "aws" {
  region = "sa-east-1"
}

# Recurso que vamos criar- instância da AWS
# Este bloco descreve como a máquina vai ser, não precisa seguir uma ordem de passos
resource "aws_instance" "app_server" {
    # imagem do sistema que vamos utilizar, escolha na AWS
    # CUIDADO: Certifique-se de que a imagem que você está pegando tem na região escolhida para esta instância !
    ami = "ami-0a174b8e659123575"

    # Tipo de máquina que vamos escolher, escolha na AWS
    instance_type = "t3.micro"

    # Associando esta instância ao par de chaves iac-alura do projeto
    # Nome da chave, não precisa da extensão
    key_name = "iac-alura"

    # Nome que damos para instância
    tags = {
      Name = "Primeira instancia"
    }
}

