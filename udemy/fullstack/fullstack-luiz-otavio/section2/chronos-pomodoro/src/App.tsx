// Precisamos importar primeiro as variáveis
import './styles/theme.css'
import './styles/global.css'
import './App.css'
import { Heading } from './components/Heading'

// Para não termos que fazer o export lá embaixo, podemos exportar direto na função.
export function App() {
    console.log('Oi!')

    return (
        // Precisamos ter um único elemento pai, por isso colocamos tudo dentro de uma div. Ele pode ser qualquer tag, mas usamos o fragment.
        <>
            <Heading />
            <p>
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Quisquam, quod. Lorem ipsum dolor sit amet consectetur adipisicing elit. Quisquam, quod.
            </p>
        </>
    )
}

// Precisamos exportar para que possamos importar em outro arquivo.
// export default App;

// Podemos exportar dessa forma também:
// export { App };