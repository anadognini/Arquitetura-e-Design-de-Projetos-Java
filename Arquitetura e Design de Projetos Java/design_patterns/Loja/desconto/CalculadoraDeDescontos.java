package desconto;

import java.math.BigDecimal;

import orcamento.Orcamento;

public class CalculadoraDeDescontos {
	public BigDecimal calcular(Orcamento orcamento) {
		Desconto cadeiaDeDescontos = new DescontoMaisDeCinco(new DescontoQuinhentos(new SemDesconto()));

		return cadeiaDeDescontos.calcular(orcamento);
	}
}
