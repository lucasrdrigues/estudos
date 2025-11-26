import './tema.estilos.css'

// Queremos pegar a prop "tema" que foi passado como propiedade la no App.jsx, por isso usamos o Tema({ tema })
export function Tema({ tema }){
    return <h3 className='titulo-tema'>{tema.nome}</h3>
}