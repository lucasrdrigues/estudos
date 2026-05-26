output "bucket_id" {
  description = "ID do bucket S3 criada na AWS"
  # tipo do resource + nome do recurso específico + atributo do recurso
  value = aws_s3_bucket.bucket.id
}

output "bucket_arn" {
  description = "ARN do bucket S3 criada na AWS"
  # tipo do resource + nome do recurso específico + atributo do recurso
  value = aws_s3_bucket.bucket.arn
}