package concot

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CotacaoServiceSpec extends Specification {

    CotacaoService cotacaoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Cotacao(...).save(flush: true, failOnError: true)
        //new Cotacao(...).save(flush: true, failOnError: true)
        //Cotacao cotacao = new Cotacao(...).save(flush: true, failOnError: true)
        //new Cotacao(...).save(flush: true, failOnError: true)
        //new Cotacao(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //cotacao.id
    }

    void "test get"() {
        setupData()

        expect:
        cotacaoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Cotacao> cotacaoList = cotacaoService.list(max: 2, offset: 2)

        then:
        cotacaoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        cotacaoService.count() == 5
    }

    void "test delete"() {
        Long cotacaoId = setupData()

        expect:
        cotacaoService.count() == 5

        when:
        cotacaoService.delete(cotacaoId)
        sessionFactory.currentSession.flush()

        then:
        cotacaoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Cotacao cotacao = new Cotacao()
        cotacaoService.save(cotacao)

        then:
        cotacao.id != null
    }
}
