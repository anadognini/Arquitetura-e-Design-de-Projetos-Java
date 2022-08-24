package situacao;

import orcamento.Orcamento;

public class Reprovado extends SituacaoOrcamento {
	public void finalizar(Orcamento orcamento) {
		orcamento.setSituacao(new Finalizado());
	}
}
