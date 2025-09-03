module "aws-dev" {
  source = "../../infra"
  instancia = "t2.micro"
  regiao_aws = "us-west-2"
  chave = "Iac-Prod"
}

# Não pode ser o mesmo nome do que está dentro do arquivo main em infra(lá usamos IP_publico)
output "IP" {
  value = module.aws-dev.IP_publico
}