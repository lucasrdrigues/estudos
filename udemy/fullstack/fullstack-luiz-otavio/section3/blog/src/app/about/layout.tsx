// Layout de rota(neste caso) NÂO recebe HTML e CSS, ele recebe apenas o componente children, que é o componente que vai envolver as páginas do nosso projeto, ou seja, ele é o componente que vai envolver as páginas que estão dentro da pasta app, caso queira criar um layout específico para uma página, basta criar uma pasta com o nome da página e dentro dela criar um arquivo layout.tsx, esse layout irá envolver apenas a página daquela pasta, mas ele será combinado com o layout raiz.
// Não precisamos criar estes layouts de cada rota
export default function RootLayout({ children }: {
    children: React.ReactNode;
}) {
  return (
    <>
    <h1>Layout de rota about.</h1>
    {/* Precisamos por o children abaixo, se não ele não carrega os componentes */}
    {children}
    </>
  );
}
