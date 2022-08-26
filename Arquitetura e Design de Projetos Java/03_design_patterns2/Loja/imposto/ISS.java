package imposto;

import java.math.BigDecimal;

import orcamento.Orcamento;

public class ISS extends TipoImposto {
	public ISS(TipoImposto outro) {
		super(outro);
	}

	public BigDecimal realizarCalculo(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal("0.06"));
	}
}
