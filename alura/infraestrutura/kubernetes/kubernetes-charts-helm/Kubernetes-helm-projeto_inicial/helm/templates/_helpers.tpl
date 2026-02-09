{{- define "alura-foods-app.labels" }}
{{- /* 
O name abaixo deve ser o mesmo que esta no arquivo Chart.yaml!
Na instance vamos pegar o nome de uma variável que o Helm gerencia, por isso é .Release
No managed-by precisamos pegar o nome de quem esta manejando a aplicacao, no caso será "Helm"
*/ -}}
app.kubernetes.io/name: {{.Chart.Name}}
app.kubernetes.io/instance: {{.Release.Name}}
app.kubernetes.io/version:{{.Chart.AppVersion}}
app.kubernetes.io/managed-by:{{.Release.Service}}
{{- end}}