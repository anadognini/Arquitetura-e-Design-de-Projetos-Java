package pedido;

import java.time.LocalDateTime;
import orcamento.Orcamento;

public class Pedido {
	private String nomeCliente;
	private LocalDateTime data;
	private Orcamento orcamento;

	public Pedido(String nomeCliente, LocalDateTime data, Orcamento orcamento) {
		super();
		this.nomeCliente = nomeCliente;
		this.data = data;
		this.orcamento = orcamento;
	}

	public LocalDateTime getData() {
		return data;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

}
