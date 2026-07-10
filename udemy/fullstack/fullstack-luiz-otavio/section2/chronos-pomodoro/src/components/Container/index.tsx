import styles from './styles.module.css'

type ContainerProps = {
    children: React.ReactNode
}

export function Container({children}: ContainerProps) {
    return (
        // Como já temos um elemento em volta de tudo, não precisamos do fragment
        <div className={styles.container}>
            <div className={styles.content}>{children}</div>
        </div>
    )
}