import './App.css'
import { Banner } from './componentes/Banner'
// Como salvamos o arquivo como index.jsx, o próprio JS irá pegar, por isso nao preciso por o caminho absoluto do arquivo abaixo
import { FormularioDeEvento } from './componentes/FormularioDeEvento'
import { Tema } from './componentes/Tema'

// Anotações importantes:
// No React, componentes são FUNÇÕES
// O HTML é inserido dentro do arquivo index.html pelo JavaScript(o JS pega código html e joga dentro de outro arquivo html)

// Principal
function App() {

  const temas = [
    {
      id: 1,
      nome: 'front-end'
    },
    {
      id: 2,
      nome: 'back-end'
    },
    {
      id: 3,
      nome: 'devops'
    },
    {
      id: 4,
      nome: 'inteligencia artificial'
    },
    {
      id: 5,
      nome: 'data science'
    },
    {
      id: 6,
      nome: 'cloud'
    },
  ]

  return (
    <main>
      <header>
        {/* As imagens ficam dentro de public */}
        <img src="/logo.png" alt="" /> 
      </header>
      <Banner />
      <FormularioDeEvento />
      <section>
        <Tema tema={temas[0]}/>
      </section>
      <section>
        <Tema tema={temas[1]}/>
      </section>
      <section>
        <Tema tema={temas[2]}/>
      </section>
      <section>
        <Tema tema={temas[3]}/>
      </section>
      <section>
        <Tema tema={temas[4]}/>
      </section>
      <section>
        <Tema tema={temas[5]}/>
      </section>
    </main>
  )
}

export default App
