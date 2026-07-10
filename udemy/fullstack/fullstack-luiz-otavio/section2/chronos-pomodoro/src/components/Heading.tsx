import styles from './Heading.module.css'

// Fazendo tipagem TS para as props do componente
type HeadingProps = {
    // React.ReactNode é um tipo que representa qualquer coisa que pode ser renderizada pelo React, incluindo elementos JSX, strings, números, arrays e fragmentos.
    children: React.ReactNode;
}

// Desestruturando as props do componente, para não precisar usar props.children
// Antes estava export function Heading(props: HeadingProps) {}
export function Heading({ children }: HeadingProps) {
    return <h1 className={styles.heading}>{children}</h1>
}