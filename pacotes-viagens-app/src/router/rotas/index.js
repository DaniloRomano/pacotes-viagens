import login from './login-route'
import home from './home-route'
import destinoListagem from './destino/destinos-route'
import destinoNovo from './destino/destino-novo-route'
import destinoAlterar from './destino/destino-alterar-route'
import encontrePacotes from './encontre-pacote/encontre-pacotes-route'
import pacoteListagem from './pacotes/pacote-listagem-route'

export default [
    login,
    home,
    destinoListagem,
    destinoNovo,
    destinoAlterar,
    encontrePacotes,
    pacoteListagem
]