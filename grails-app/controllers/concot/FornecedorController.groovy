package concot

class FornecedorController {

    static scaffold = Fornecedor
    def comunicacao() {
        [fornecedores:Fornecedor.list(), mensagem:new EnvioEmail()]
    }

    def enviarMensagem(EnvioEmail envio) {

        withForm {


            envio.validate()
            if (envio.hasErrors()) {
// Erro encontrado
                flash.message = "Erro de validação"
                render(view: "comunicacao",
                        model: [mensagem    : envio,
                                fornecedores: Fornecedor.list()])
            } else {
// Mensagem enviada (código omitido)
                flash.message = "Mensagem enviada com sucesso"
                render(view: 'comunicacao')

            }
        }.invalidToken {

        }
    }
}
