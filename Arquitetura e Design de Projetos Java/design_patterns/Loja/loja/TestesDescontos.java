package loja;

import java.math.BigDecimal;

import desconto.CalculadoraDeDescontos;
import orcamento.Orcamento;

public class TestesDescontos {
	public static void main(String[] args) {
		CalculadoraDeDescontos calculadora = new CalculadoraDeDescontos();

		Orcamento orcamento = new Orcamento(new BigDecimal("200"), 6);
		System.out.println(calculadora.calcular(orcamento));

		Orcamento orcamento2 = new Orcamento(new BigDecimal("1000"), 1);
		System.out.println(calculadora.calcular(orcamento2));
	}
}

