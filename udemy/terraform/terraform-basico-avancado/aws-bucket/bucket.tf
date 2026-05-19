# É uma boa prática dividir os recursos em arquivos separados, para melhor organização e manutenção do código. Neste exemplo, estamos criando um bucket S3 da AWS.
# resource "nome-do-recurso" "nome-da-instancia" {}
resource "aws_s3_bucket" "bucket" { # O nome do recurso não pode se repetir no mesmo recurso
  bucket = "lucas-curso-terraform"

  # Tag a mais para o nosso bucket, além das tags padrão do provider
  tags = {
    Name        = "My bucket"
    Environment = "Dev"
  }
}