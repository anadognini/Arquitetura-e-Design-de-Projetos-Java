package loja;
import java.math.BigDecimal;
import imposto.CalculadoraDeImpostos;
import imposto.ICMS;
import imposto.ISS;
import orcamento.ItemOrcamento;
//import imposto.ISS;
import orcamento.Orcamento;

public class TestesImpostos {
	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("20")));
		
		CalculadoraDeImpostos calculadora = new CalculadoraDeImpostos();
		
		System.out.println(calculadora.calcular(orcamento, new ISS(new ICMS(null))));
	}
}
