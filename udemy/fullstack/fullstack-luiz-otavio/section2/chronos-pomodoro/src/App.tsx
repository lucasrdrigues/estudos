// Precisamos importar primeiro as variáveis
import './styles/theme.css'
import './styles/global.css'

import { Container } from './components/Container'
import { Heading } from './components/Heading'
import { Logo } from './components/Logo';
import { Menu } from './components/Menu';
import { CountDown } from './components/CountDown';
import { DefaultInput } from './components/DefaultInput';
import { Cycles } from './components/Cycles';

export function App() {
    return (
        <>
            <Container>
                <Logo />
            </Container>

            <Container>
                <Menu />
            </Container>

            <Container>
                <CountDown />
            </Container>

            <Container>
                <form className="form" action="">
                    <div className="formRow">
                        <DefaultInput labelText='task' id='meuInput' type='text' placeholder='Digite Algo' title='Exemplo para o ...props ou ...rest'/>
                    </div>

                    <div className="formRow">
                        <p>Lorem ipsum dolor sit.</p>
                    </div>

                    <div className="formRow">
                        <Cycles />
                    </div>

                    <div className="formRow">
                        <button type="submit">Enviar</button>
                    </div>
                </form>
            </Container>

            <Container>
                <Heading>FOOTER </Heading>
            </Container>
        </>
    );
}