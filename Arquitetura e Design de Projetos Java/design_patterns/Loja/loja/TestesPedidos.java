package loja;

import java.math.BigDecimal;
import java.util.Arrays;

import pedido.GeraPedido;
import pedido.GeraPedidoHandler;
import pedido.acao.EnviarEmailPedido;
import pedido.acao.SalvarPedidoNoBancoDeDados;

public class TestesPedidos {
	public static void main(String[] args) {
		String cliente = "Rodrigo";
		BigDecimal valorOrcamento = new BigDecimal("300");
		int quantidadeItens = Integer.parseInt("2");

		GeraPedido gerador = new GeraPedido(cliente, valorOrcamento, quantidadeItens);
		GeraPedidoHandler handler = new GeraPedidoHandler(
				Arrays.asList(new SalvarPedidoNoBancoDeDados(), new EnviarEmailPedido()));

		handler.executar(gerador);
	}
}
