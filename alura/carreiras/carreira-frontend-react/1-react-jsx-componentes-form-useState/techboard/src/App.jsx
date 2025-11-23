import './App.css'
// Como salvamos o arquivo como index.jsx, o próprio JS irá pegar, por isso nao preciso por o caminho absoluto do arquivo abaixo
import { FormularioDeEvento } from './componentes/FormularioDeEvento'

// Anotações importantes:
// No React, componentes são FUNÇÕES
// O HTML é inserido dentro do arquivo index.html pelo JavaScript(o JS pega código html e joga dentro de outro arquivo html)

// Principal
function App() {

  return (
    <main>
      <header>
        {/* As imagens ficam dentro de public */}
        <img src="/logo.png" alt="" /> 
      </header>
      <section>
        <img src="/banner.png" alt="" />
      </section>
      <FormularioDeEvento />
    </main>
  )
}

export default App
