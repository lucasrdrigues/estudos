# Criando output para mostrar o id da subnet criada. Precisamos dele para quando formos criar uma instÂncia e associar ela a essa subnet
output "subnet_id" {
  description = "ID da subnet criada"
  value = aws_subnet.subnet.id
}

output "security_group_id" {
  description = "ID da security group criada"
  value = aws_security_group.security_group.id
}