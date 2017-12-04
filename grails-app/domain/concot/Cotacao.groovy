package concot

class Cotacao {

	String id
    BigDecimal valor
	Date data
	static belongsTo =	[item:Item, moeda:Moeda, fornecedor:Fornecedor]
	static constraints = {
	}

	static mapping = {	
		version false
		id generator:'uuid', column:'identificador'
		sort: 'valor'
		order: 'desc' //'asc' para ordem crescente, que é padrão
	}
}
