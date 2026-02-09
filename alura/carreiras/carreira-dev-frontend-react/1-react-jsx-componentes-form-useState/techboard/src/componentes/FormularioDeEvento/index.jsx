import "./formulario-de-evento.estilos.css";
import { TituloFormulario } from "../TituloFormulario";
import { CampoDeFormulario } from "../CampoDeFormulario";
import { Label } from "../Label";
import { CampoDeEntrada } from "../CampoDeEntrada";
import { ListaSuspensa } from "../ListaSuspensa";
import { Botao } from "../Botao";

// Componente FormularioDeEvento
// Podemos receber uma função por parametro, como a ao Submeter.
export function FormularioDeEvento({ temas, aoSubmeter }) {
  function aoFormSubmetido(formData) {
    console.log("Opa, tá na hora de criar um evento!", formData);
    const evento = {
      capa: formData.get('capa'),
      tema: temas.find(function (item){
        return item.id == formData.get('tema');
      }),
      data: new Date(formData.get('dataEvento')),
      titulo: formData.get('nomeEvento'),
    };
    aoSubmeter(evento)
  }

  return (
      <form className="form-evento" action={aoFormSubmetido}>
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
            <Label htmlFor="nomeEvento">
              Qual o endereço da imagem de capa?
            </Label>
            <CampoDeEntrada
              type="text"
              id='capa'
              placeholder='http://...'
              name='capa'
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
            <Label htmlFor="tema">
              Tema do evento
            </Label>
            <ListaSuspensa id='tema' name='tema' itens={temas}/>
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
