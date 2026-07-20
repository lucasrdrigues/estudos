// A funcionalidade de intersection abaixo é somente do typescript
type DefaultInputProps = {
    // Como no type do input pode vir não somente texto, precisamos usar o union type para aceitar outros tipos de input, como number, password, etc.
    // type: 'text' | 'number' | 'search';

    // Com isso obrigamos a ter um id sendo uma string sendo passado como filho e ele sobrescreve os tipos feito com o intersection abaixo.
    id: string;
    labelText?: string; // Colocar um "?" diz ao typescript que a prop existe mas ela não é obrigatória. Porém se não não tiver, ele irá enviar o label para o html vazio. Para ajustarmos isso, precisamos usar condicionais dentro do jsx, como abaixo. Neste caso, como o label não é opcional no nosso projeto, poderiamos tirar ele, mas deixei por motivos didáticos.

// Podemos usar intersection type para aceitar todos os tipos de input, como text, number, search, etc.
// O & serve para juntar os tipos, ou seja, o DefaultInputProps vai aceitar todos os tipos de input, como text, number, search, etc. Desta forma não precisa ter código nenhum dentro dessa chave, pois o & já faz isso. O React.ComponentProps<'input'> é um tipo que já existe no React e que representa todas as props que um input pode ter, como type, value, onChange, etc.
} & React.ComponentProps<'input'>

// Suponha que la no App.tsx a gente a passe a propiedade "title"(podemos fazer isso por causa do React.ComponentProps... acima, que nos permite colocar qualquer propiedade no input lá no App.tsx), se ela não tiver sendo pegada no export function... ela não sera pegada, somente as que estão lá explicitas. Para que possamos pegar TODAS as propiedades, devemos usar ...nome(a convenção é usar ...props, mas poderia ser qualquer nome)

// export function DefaultInput({ ...props }: DefaultInputProps) {
// export function DefaultInput({ id, type, labelText, ...props }: DefaultInputProps) {
export function DefaultInput({ id, type, labelText }: DefaultInputProps) {
    return (
        <>
        {/* AVISO: Neste caso, como o label não é opcional no nosso projeto, não estou usando condicional abaixo. */}
            {/* Condição ? 'True':'False' -> se exister label text exibe ..., se não existir não exibe nada*/}
            {/* {labelText ? <label htmlFor={id}>{labelText}</label> : ''} */}

            {/* Caso voce precise de mais de uma linha para fazer a condicional acima, você pode usar parenteses caso T ou caso F: */}
            {/* {labelText ? (
                <span>
                    <label htmlFor={id}>{labelText}</label> 
                </span>
                ) : ( 
                    '' 
            )} */}

            {/* Como não estamos usando uma ação para caso seja falso, ou seja, só temos ação para caso seja verdadeira, podemos usar o seguinte: */}
            {/* Condição && valor */}
            {/* { labelText && <label htmlFor={id}>{labelText}</label> } */}

            {/* Código sem a condição */}
            <label htmlFor={id}>{labelText}</label>
            <input
                id={id}
                type={type}
                // {...rest} ou {...props} // Caso fossemos usar
            />
        </>
    )
}