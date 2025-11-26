import './formulario-de-evento.estilos.css'
import { TituloFormulario } from '../TituloFormulario'
import { CampoDeFormulario } from '../CampoDeFormulario'
import { Label } from '../Label'
import { CampoDeEntrada } from '../CampoDeEntrada'
import { ListaSuspensa } from '../ListaSuspensa'
import { Botao } from '../Botao'

// Componente FormularioDeEvento
export function FormularioDeEvento () {

    return (
      <form className="form-evento">
        <TituloFormulario>
          Preencha para criar um evento:
        </TituloFormulario>
        <div className="campos">
          <CampoDeFormulario>
            {/* Para usar um parâmetro como o htmlFor, precisamos configurar no componente */}
            <Label htmlFor="nomeEvento">
              Qual o nome do evento?
            </Label>
            <CampoDeEntrada
              type="text"
              id='nomeEvento'
              placeholder='Summer dev hits'
              name='nomeEvento'
            />
          </CampoDeFormulario>
          <CampoDeFormulario>
            <Label htmlFor="dataEvento">
              Data do evento
            </Label>
            <CampoDeEntrada
              type="date"
              id='dataEvento'
              name='dataEvento'
            />
          </CampoDeFormulario>
          <CampoDeFormulario>
            <Label htmlFor="dataEvento">
              Data do evento
            </Label>
            <ListaSuspensa />
          </CampoDeFormulario>
        </div>
        <div className='acoes'>
          <Botao>
            Criar evento
          </Botao>
        </div>
      </form>
    )
}

// Como estamos exportando esta função, precisamos usar o export, se ela estivesse dentro do arquivo principal do app, não precisariamos usar o export