import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'

// Importando componente
// 1 Forma: 
// import App from './App'
// 2 Forma:
import { App } from './App'

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <App />
  </StrictMode>
)
