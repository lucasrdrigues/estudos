import './campo-entrada.estilos.css'

// Campo de entrada
// Botão de input - <input type="text" id='nome' placeholder='Summer dev hits' />
// Ao invés de passarmos várias propiedades como parâmetro(type, id, placeholder, entre outras) poderiamos fazer da seguinte maneira abaixo(também é uma funionalidade do JS)
export function CampoDeEntrada(props){
  return (
    <input {...props} className='campo-entrada-form' />
  )
}

// Como estamos exportando esta função, precisamos usar o export, se ela estivesse dentro do arquivo principal do app, não precisariamos usar o export