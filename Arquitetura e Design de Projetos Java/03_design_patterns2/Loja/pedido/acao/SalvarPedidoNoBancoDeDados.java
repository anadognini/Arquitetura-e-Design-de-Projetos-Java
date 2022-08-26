package pedido.acao;

import pedido.Pedido;

public class SalvarPedidoNoBancoDeDados implements AcaoAposGerarPedido {
	@Override
	public void executarAcao(Pedido pedido) {
		System.out.println("Pedido salvo no banco de dados");
	}
}
