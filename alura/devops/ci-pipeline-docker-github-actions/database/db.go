package database

import (
	"log"
	// Importando o OS para que possamos mexer com variáveis de ambiente
	"os"

	"github.com/guilhermeonrails/api-go-gin/models"
	"gorm.io/driver/postgres"
	"gorm.io/gorm"
)

var (
	DB  *gorm.DB
	err error
)

func ConectaComBancoDeDados() {
	// func ConectaComBancoDeDados() {
    // host := os.Getenv("HOST")
    // user := os.Getenv("USER")
    // password := os.Getenv("PASSWORD")
    // dbname := os.Getenv("DBNAME")
    // port := os.Getenv("DBPORT")
    // stringDeConexao := "host="+ host +" user=" + user + " password=" + password + " dbname=" + dbname + " port=" + port + " sslmode=disable"

	// Pegando valor de uma variável de ambiente
	stringDeConexao := "host=" + os.Getenv("HOST") + " user=" + os.Getenv("USER") + " password=" + os.Getenv("PASSWORD") + " dbname=" + os.Getenv("DBNAME") + " port=" + os.Getenv("PORT") + " sslmode=disable"
	DB, err = gorm.Open(postgres.Open(stringDeConexao))
	if err != nil {
		log.Panic("Erro ao conectar com banco de dados")
	}

	DB.AutoMigrate(&models.Aluno{})
}
