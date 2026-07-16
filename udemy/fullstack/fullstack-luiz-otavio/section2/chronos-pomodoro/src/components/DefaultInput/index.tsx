// A funcionalidade de intersection abaixo é somente do typescript
type DefaultInputProps = {
    // Como no type do input pode vir não somente texto, precisamos usar o union type para aceitar outros tipos de input, como number, password, etc.
    // type: 'text' | 'number' | 'search';

    // Com isso obrigamos a ter um id sendo uma string sendo passado como filho e ele sobrescreve os tipos feito com o intersection abaixo.
    id: string;

// Podemos usar intersection type para aceitar todos os tipos de input, como text, number, search, etc.
// O & serve para juntar os tipos, ou seja, o DefaultInputProps vai aceitar todos os tipos de input, como text, number, search, etc. Desta forma não precisa ter código nenhum dentro dessa chave, pois o & já faz isso. O React.ComponentProps<'input'> é um tipo que já existe no React e que representa todas as props que um input pode ter, como type, value, onChange, etc.
} & React.ComponentProps<'input'>

export function DefaultInput({ id, type }: DefaultInputProps) {
    return (
        <>
            <label htmlFor={id}>task</label>
            <input
                id={id}
                type={type}
            />
        </>
    )
}