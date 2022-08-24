package situacao;

import java.math.BigDecimal;

import loja.DomainException;
import orcamento.Orcamento;

public abstract class SituacaoOrcamento {
	public BigDecimal calcularValorDescontoExtra(Orcamento orcamento) {
		return BigDecimal.ZERO;
	}

	public void aprovar(Orcamento orcamento) {
		throw new DomainException("Orçamento não pode ser aprovado, pois já está aprovado!");
	}

	public void reprovar(Orcamento orcamento) {
		throw new DomainException("Orçamento não pode ser reprovado, pois já está reprovado!");
	}

	public void finalizar(Orcamento orcamento) {
		throw new DomainException("Orçamento não pode ser finalizado, pois já está finalizado!");
	}
}
