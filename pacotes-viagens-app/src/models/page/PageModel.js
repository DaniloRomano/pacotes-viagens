class PageModel{
    conteudo
    totalPaginas=0
    totalElementos=0

    parse(retorno){
        if (retorno.data){
            this.conteudo=retorno.data.content
            this.totalPaginas=retorno.data.totalPages
            this.totalElementos=retorno.data.totalElements
        }
    }
}

export default new PageModel()