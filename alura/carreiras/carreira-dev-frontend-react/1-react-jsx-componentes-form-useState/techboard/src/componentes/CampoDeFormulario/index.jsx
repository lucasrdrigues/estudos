import './campo-formulario.estilos.css'

//Campo de Formulário
// Ao invés de ficar escrevendo props.children, podemos passar o 'children' como parametro. Isso é do JS em si, e não exclusivo do React
export function CampoDeFormulario({ children }) {
    return (
      <fieldset className='campo-form'>
        {children}
      </fieldset>
    )
}