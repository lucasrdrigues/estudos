import './label.estilos.css'

// Função Label
export function Label({ children, htmlFor }) {
  return ( 
    <label htmlFor={htmlFor} className='label'>
      {children}
    </label>
  )
}
// SEGUNDO MÉTODO DE USAR PROPIEDADES
// // Função Label
// function Label(props) {
//   return ( 
//     <label htmlFor={props.htmlFor}>
//       {props.children}
//     </label>
//   )
// }