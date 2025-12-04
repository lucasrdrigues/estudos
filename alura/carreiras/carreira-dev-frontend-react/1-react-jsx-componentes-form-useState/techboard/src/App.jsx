import { useState } from 'react'
import './App.css'
import { Banner } from './componentes/Banner'
import { CardEvento } from './componentes/CardEvento'
// Como salvamos o arquivo como index.jsx, o próprio JS irá pegar, por isso nao preciso por o caminho absoluto do arquivo abaixo
import { FormularioDeEvento } from './componentes/FormularioDeEvento'
import { Tema } from './componentes/Tema'

// Anotações importantes:
// No React, componentes são FUNÇÕES
// Se quisermos que ela seja executada novamente(renderizada), precisamos dizer para o react usando States
// O HTML é inserido dentro do arquivo index.html pelo JavaScript(o JS pega código html e joga dentro de outro arquivo html)

// Principal
function App() {
  
  // Poderiamos percorrer um array com das seguintes formas:
  // Map - transforma um array em outro array modificado. Ele permite que você transforme cada elemento de uma lista em um componente React, garantindo que cada elemento tenha uma chave única, o que ajuda o React a identificar quais itens mudaram, foram adicionados ou removidos.
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

  // eventos: dado a ser modificado(strings, arrays, entre outros), setEventos: função que modifica o dado
  const [eventos, setEventos] = useState([
    {
      capa: 'https://raw.githubusercontent.com/viniciosneves/tecboard-assets/refs/heads/main/imagem_15.png',
      tema: temas[0],
      data: new Date(),
      titulo: 'Mulheres no front'
    }
  ])

  function adicionarEvento(evento){
    // Passando o novo array(atualizado com o novo evento) para o evento(dado no State)
    setEventos([...eventos, evento])
    console.log('eventos => ', eventos)
  }

  return (
    <main>
      <header>
        {/* As imagens ficam dentro de public */}
        <img src="/logo.png" alt="" /> 
      </header>
      <Banner />
      <FormularioDeEvento 
        temas={temas} 
        aoSubmeter={adicionarEvento} 
      />
      {temas.map(function (item) {
        return (
          // Precisamos adicionar a prop key para cada elemento que for repetido em tela, se não o React reclama
          <section key={item.id}>
            {/* Item é o contador dos elementos dentro do array que queremos percorrer */}
            <Tema tema={item}/>
            {eventos.map(function(item, index){
              return <CardEvento evento={item} key={index}/>
            })}
          </section>
        )
      })}
    </main>
  )
}

export default App
