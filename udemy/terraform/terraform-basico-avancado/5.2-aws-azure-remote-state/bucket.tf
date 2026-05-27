resource "aws_s3_bucket" "bucket" {
  bucket = "lucas-remote-state"
}

# Esta config de versioning serve para manter um histórico de versões dos arquivos armazenados no bucket, permitindo a recuperação de versões anteriores em caso de necessidade. Ou seja, se subirmos o arquivo de estado do Terraform para o bucket e, por algum motivo, precisarmos restaurar uma versão anterior do estado, o versioning nos permitirá acessar essas versões anteriores, sem ele, o arquivo é sobrescrito e não há como recuperar versões anteriores.
resource "aws_s3_bucket_versioning" "versioning" {
  bucket = aws_s3_bucket.bucket.id
  versioning_configuration {
    status = "Enabled"
  }
}