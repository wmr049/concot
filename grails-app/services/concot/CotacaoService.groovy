package concot

import grails.gorm.services.Service

@Service(Cotacao)
interface CotacaoService {

    Cotacao get(Serializable id)

    List<Cotacao> list(Map args)

    Long count()

    void delete(Serializable id)

    Cotacao save(Cotacao cotacao)

}