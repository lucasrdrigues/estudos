import { Heading } from './components/Heading'
// Precisamos importar primeiro as variáveis
import './styles/theme.css'
import './styles/global.css'
import { TimerIcon } from 'lucide-react'

export function App() {
    return (
        <>
            <Heading>
                {/* npm install lucide-react - library com vários icones para usarmos */}
                Olá, Mundo!
                <button>
                    <TimerIcon />
                </button>
            </Heading>
            <p>
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Quisquam, quod. Lorem ipsum dolor sit amet consectetur adipisicing elit. Quisquam, quod.
            </p>
        </>
    )
}