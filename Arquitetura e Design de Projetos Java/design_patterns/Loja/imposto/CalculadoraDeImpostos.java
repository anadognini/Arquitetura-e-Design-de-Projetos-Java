package imposto;

import java.math.BigDecimal;

import orcamento.Orcamento;

public class CalculadoraDeImpostos {
	public BigDecimal calcular(Orcamento orcamento, TipoImposto imposto) {
		return imposto.calcular(orcamento);
	}
}
