package orcamento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import situacao.EmAnalise;
import situacao.Finalizado;
import situacao.SituacaoOrcamento;

public class Orcamento implements Orcavel {
	// Atributos
	private BigDecimal valor;
	private SituacaoOrcamento situacao;
	private List<Orcavel> itens;

	// Construtor
	public Orcamento() {
		this.valor = BigDecimal.ZERO;
		this.itens = new ArrayList<>();
		this.situacao = new EmAnalise();
	}

	// Getters e setters
	public BigDecimal getValor() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			throw new RuntimeException();
		}
		
		return valor;
	}

	public int getQuantidadeItens() {
		return itens.size();
	}

	// Métodos
	public void aplicarDescontoExtra() {
		BigDecimal valorDescontoExtra = this.situacao.calcularValorDescontoExtra(this);

		this.valor = this.valor.subtract(valorDescontoExtra);
	}

	public void aprovar() {
		this.situacao.aprovar(this);
	}

	public void reprovar() {
		this.situacao.reprovar(this);
	}

	public void finalizar() {
		this.situacao.finalizar(this);
	}

	public boolean isFinalizado() {
		return situacao instanceof Finalizado;
	}

	public SituacaoOrcamento getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoOrcamento situacao) {
		this.situacao = situacao;
	}

	public void adicionarItem(Orcavel item) {
		this.valor = valor.add(item.getValor());
		this.itens.add(item);
	}
}