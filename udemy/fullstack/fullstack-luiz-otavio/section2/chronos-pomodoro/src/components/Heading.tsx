// import "qualquer_nome" from ...
import styles from './Heading.module.css'

export function Heading() {
    // Não podemos usar class, pois ela é uma palavra reservada do JS. Por isso usamos className.
    // este .heading é o nome da classe que criamos no arquivo Heading.module.css.

    // Podemos usar o template string para concatenar classes, caso queiramos adicionar mais de uma classe.
    // const classes = `${styles.heading} ${styles.cyan}`
    // return <h1 className={classes}>Hello World!</h1> ou podemos jogar direto: return <h1 className={`${styles.heading} ${styles.cyan}`}>Hello World!</h1>

    return <h1 className={styles.cyan}>Hello World!</h1>
}