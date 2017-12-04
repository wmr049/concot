package concot

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CotacaoController {

    CotacaoService cotacaoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond cotacaoService.list(params), model:[cotacaoCount: cotacaoService.count()]
    }

    def show(Long id) {
        respond cotacaoService.get(id)
    }

    def create() {
        respond new Cotacao(params)
    }

    def save(Cotacao cotacao) {
        if (cotacao == null) {
            notFound()
            return
        }

        try {
            cotacaoService.save(cotacao)
        } catch (ValidationException e) {
            respond cotacao.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'cotacao.label', default: 'Cotacao'), cotacao.id])
                redirect cotacao
            }
            '*' { respond cotacao, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond cotacaoService.get(id)
    }

    def update(Cotacao cotacao) {
        if (cotacao == null) {
            notFound()
            return
        }

        try {
            cotacaoService.save(cotacao)
        } catch (ValidationException e) {
            respond cotacao.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'cotacao.label', default: 'Cotacao'), cotacao.id])
                redirect cotacao
            }
            '*'{ respond cotacao, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        cotacaoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'cotacao.label', default: 'Cotacao'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'cotacao.label', default: 'Cotacao'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    def comunicacao(){
        [fornecedores:Fornecedor.list(), mensagem:new EnvioEmail()]
    }
}
