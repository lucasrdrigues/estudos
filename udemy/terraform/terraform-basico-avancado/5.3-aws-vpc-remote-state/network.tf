# VPC
resource "aws_vpc" "vpc" {
  cidr_block = "10.0.0.0/16"
  # As tags são usadas para identificar e organizar os recursos na AWS. Não temos uma tag específica para nomear a vpc, mas a tag "Name" é comumente usada para esse propósito.
  tags = {
    Name = "vpc-terraform"
  }
}

# SUBNET
resource "aws_subnet" "subnet" {
  # Atribuindo essa subnet a uma vpc
  vpc_id            = aws_vpc.vpc.id
  cidr_block        = "10.0.1.0/24"

  tags = {
    Name = "subnet-terraform"
  }
}

# INTERNET GATEWAY
resource "aws_internet_gateway" "internet_gateway" {
  # Atribuindo o gateway a uma vpc
  vpc_id = aws_vpc.vpc.id

  tags = {
    Name = "internet-gateway-terraform"
  }
}

# ROUTE TABLE - serve para definir as rotas de tráfego dentro da vpc. No caso, estamos criando uma rota que direciona todo o tráfego de saída.
resource "aws_route_table" "route_table" {
  # Atribuindo a tabela de rotas a uma vpc
  vpc_id = aws_vpc.vpc.id

  route {
    # O destino - abrindo para a internet toda a saída da vpc.
    cidr_block = "0.0.0.0/0"
    # O gateway - direcionando o tráfego para o gateway de internet criado anteriormente.
    gateway_id = aws_internet_gateway.internet_gateway.id
  }

  tags = {
    Name = "route-table-terraform"
  }
}

# ROUTE TABLE ASSOCIATION - serve para associar a tabela de rotas a uma subnet específica, garantindo que o tráfego da subnet seja direcionado corretamente.
resource "aws_route_table_association" "route_table_association" {
  # Atribuindo a tabela de rotas a uma subnet - ou seja, a subnet criada anteriormente usará as rotas definidas na tabela de rotas criada anteriormente.
  subnet_id      = aws_subnet.subnet.id
  route_table_id = aws_route_table.route_table.id
}

# SECURITY GROUP - serve para definir regras de segurança para controlar o tráfego de entrada e saída dos recursos dentro da vpc. CUIDADO: hoje em dia, existe um recurso para configuração de entrada e saída, aqui estamos usando uma versão anterior
resource "aws_security_group" "security_group" {
  name        = "security-group-terraform"
  description = "Permitir acesso na porta 22"
  vpc_id      = aws_vpc.vpc.id
  
  # Regras de entrada
  ingress {
    description      = "SSH"
    # Aqui configuramos o intervalos de portas, caso queira uma específica coloque elas iguais
    from_port        = 22
    to_port          = 22
    protocol         = "tcp"
    # cidr da vpc criada anteriormente
    # cidr_blocks      = [aws_vpc.vpc.cidr_block]
    # Vamos abrir para qualquer endereço na internet, mas somente por motivos didáticos!
    cidr_blocks = ["0.0.0.0/0"]
    # Não estamos usando ipv6
    # ipv6_cidr_blocks = [aws_vpc.main.ipv6_cidr_block]
  }

  egress {
    from_port        = 0
    to_port          = 0
    # Protocol -1 significa "todos os protocolos", ou seja, todos os protocolos de rede e qualquer endereço(0.0.0.0/0)
    protocol         = "-1"
    cidr_blocks      = ["0.0.0.0/0"]
    # Não vamos usar ipv6
    # ipv6_cidr_blocks = ["::/0"]
  }

  tags = {
    Name = "security_group_terraform"
  }
}