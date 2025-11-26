import './App.css'
import { Banner } from './componentes/Banner'
import { CardEvento } from './componentes/CardEvento'
// Como salvamos o arquivo como index.jsx, o próprio JS irá pegar, por isso nao preciso por o caminho absoluto do arquivo abaixo
import { FormularioDeEvento } from './componentes/FormularioDeEvento'
import { Tema } from './componentes/Tema'

// Anotações importantes:
// No React, componentes são FUNÇÕES
// O HTML é inserido dentro do arquivo index.html pelo JavaScript(o JS pega código html e joga dentro de outro arquivo html)

// Principal
function App() {
  
  // Poderiamos percorrer um array com das seguintes formas:
  // Map - transforma um array em outro array modificado
  // forEach - percorre o array, mas não transforma em outro array
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

  const eventos = [
    {
      capa: 'https://raw.githubusercontent.com/viniciosneves/tecboard-assets/refs/heads/main/imagem_15.png',
      tema: temas[0],
      data: new Date(),
      titulo: 'Mulheres no front'
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
      {temas.map(function (item) {
        return (
          // Precisamos adicionar a prop key para cada elemento que for repetido em tela, se não o React reclama
          <section key={item.id}>
            {/* Item é o contador dos elementos dentro do array que queremos percorrer */}
            <Tema tema={item}/>
            <CardEvento evento={eventos[0]}/>
          </section>
        )
      })}
    </main>
  )
}

export default App
