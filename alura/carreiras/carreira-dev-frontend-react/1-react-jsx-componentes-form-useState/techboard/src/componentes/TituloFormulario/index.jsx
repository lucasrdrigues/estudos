import './titulo-formulario.estilos.css'

// Titulo formulário
// Vamos pegar o conteúdo quando ele for usado em outra função(principal ou outra), por isso é children
export function TituloFormulario (props) {
  return (
    <h2 className='titulo-form'>
      {props.children}
    </h2>
  )
}