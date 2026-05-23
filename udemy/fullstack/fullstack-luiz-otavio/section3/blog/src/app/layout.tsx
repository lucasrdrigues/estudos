// Este arquivo de layout é o layout raiz, ou seja, ele é o layout que vai envolver todas as páginas do nosso projeto, ele é obrigatório e deve ser criado na raiz da pasta app, ele é responsável por definir a estrutura básica do nosso projeto, como o html, head e body, além de definir o metadata da nossa aplicação.
import type { Metadata } from "next";
import "./globals.css";

export const metadata: Metadata = {
  title: "The Blog -  Este é um blog com NextJS",
  description: "Essa seria a descrição dessa página em si.",
};

// Esses códigos abaixo foi modificado
type RootLayoutProps = {
  children: React.ReactNode;
};

// Este layout raiz precisa do HTML
export default function RootLayout({ children }: Readonly<RootLayoutProps>) {
  return (
    <html lang="en">
      <body>
        {/* Se colocarmos componentes aqui dentro(dentro da tag de return), ele irá para todas as páginas do nosso projeto, ou seja, ele é um layout global, caso queira criar um layout específico para uma página, basta criar uma pasta com o nome da página e dentro dela criar um arquivo layout.tsx, esse layout irá envolver apenas a página daquela pasta. */}
        <header><h1>Header</h1></header>
        {children}
        <footer><h1>Footer</h1></footer>
      </body>
    </html>
  );
}
