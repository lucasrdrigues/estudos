variable "location" {
  description = "Azure location to deploy resources"
  type        = string
  default     = "East US"
}

variable "region" {
  description = "AWS region to deploy resources"
  type        = string
  default     = "us-east-1"
}

variable "account_tier" {
  description = "Azure Storage Account tier"
  type        = string
  default     = "Standard"
}

variable "account_replication_type" {
  description = "Azure Storage Account replication type"
  type        = string
  default     = "LRS"
}
