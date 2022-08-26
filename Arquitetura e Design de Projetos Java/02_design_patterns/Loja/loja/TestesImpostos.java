package loja;
import java.math.BigDecimal;
import imposto.CalculadoraDeImpostos;
import imposto.ICMS;
//import imposto.ISS;
import orcamento.Orcamento;

public class TestesImpostos {
	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento(new BigDecimal("100"), 1);
		CalculadoraDeImpostos calculadora = new CalculadoraDeImpostos();
		
		System.out.println(calculadora.calcular(orcamento, new ICMS()));
	}
}

/* Strategy: sempre que temos um algoritmo (uma validação, cálculo ou seja lá qual for
 * a regra) e ele varia de acordo com um determinado parâmetro, de acordo com 
 * determinado tipo de informação, gerando um código cheio de if... else
 * 
 * Para solucionar isso e eliminar essas verificações, o padrão Strategy é muito útil.
 * Ao invés de essa informação ser uma Enum, uma String, pode ser uma classe separadamente,
 * ou uma interface (para que possamos utilizar as vantagens do polimorfismo), classes
 * abstratas. 
 * 
 * Assim, eliminaríamos essas verificações e cada classe teria sua implementação específica,
 * teria a sua estratégia de cálculo específica.
 * 
 * O objetivo do Strategy é deixar o código mais coeso, com cada classe tenha sua 
 * estratégia específica, sem se relacionar intimamente com a outra. A classe Calculadora
 * também não conhece intimimante nenhuma das classes, pois ela faz uso da interface,
 * que é uma abstração.
 * 
 * Este padrão pode ser utilizado quando há diversos possíveis algoritmos para uma ação 
 * (como calcular imposto, por exemplo). Nele, nós separamos cada um dos possíveis 
 * algoritmos em classes separadas.
 **/