package imposto;

import java.math.BigDecimal;

import orcamento.Orcamento;

public class ICMS extends TipoImposto {
	public ICMS(TipoImposto outro) {
		super(outro);
	}

	public BigDecimal realizarCalculo(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal("0.1"));
	}
}
