package pedido.acao;

import pedido.Pedido;

public class EnviarEmailPedido implements AcaoAposGerarPedido  {
	@Override
	public void executarAcao(Pedido pedido) {
		System.out.println("Enviando um e-mail");
	}
}
