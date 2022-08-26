package imposto;

import java.math.BigDecimal;

import orcamento.Orcamento;

public abstract class TipoImposto {
	private TipoImposto outro;

	public TipoImposto(TipoImposto outro) {
		this.outro = outro;
	}

	protected abstract BigDecimal realizarCalculo(Orcamento orcamento);

	public BigDecimal calcular(Orcamento orcamento) {
		BigDecimal valorImposto = realizarCalculo(orcamento);
		BigDecimal valorOutroImposto = BigDecimal.ZERO;

		if (outro != null) {
			valorOutroImposto = outro.calcular(orcamento);
		}

		return valorImposto.add(valorOutroImposto);
	}
}
