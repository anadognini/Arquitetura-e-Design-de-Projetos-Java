package loja;

import java.math.BigDecimal;

import desconto.CalculadoraDeDescontos;
import orcamento.ItemOrcamento;
import orcamento.Orcamento;

public class TestesDescontos {
	public static void main(String[] args) {
		CalculadoraDeDescontos calculadora = new CalculadoraDeDescontos();

		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("200")));
		System.out.println(calculadora.calcular(orcamento));

		Orcamento orcamento2 = new Orcamento();
		orcamento2.adicionarItem(new ItemOrcamento(new BigDecimal("1000")));
		System.out.println(calculadora.calcular(orcamento2));
		
		Orcamento orcamento3 = new Orcamento();
		orcamento3.adicionarItem(new ItemOrcamento(new BigDecimal("500")));
		System.out.println(calculadora.calcular(orcamento3));
	}
}

