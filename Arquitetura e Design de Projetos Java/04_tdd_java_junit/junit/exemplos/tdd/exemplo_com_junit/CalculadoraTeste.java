package tdd.exemplo_com_junit;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class CalculadoraTeste {
	
	@Test
	public void deveriaSomarDoisNumerosPositivos() {
		Calculadora calculadora = new Calculadora();
		int soma = calculadora.somar(3, 7);
		
		// Esse método verifica se duas variáveis são iguais e recebe dois parâmetros: o que estamos esperando, quem é a variável que será verificada
		Assert.assertEquals(10, soma);
		
		// Primeira maneira de adicionar o JUnit
		// 1 - Adicionar anotação do JUnit
		// 2 - Importar a biblioteca para dentro do nosso projeto
		// 3 - Selecionar a opção Run As JUnit Test
		// 4 - O JUnit possui uma classe chamada Assert, que permite fazer a verificação do código. Ela possui vários métodos
		
		/* No eclipse, como há uma integração do JUnit com a IDE, ao rodar o JUnit irá aparecer uma aba. Caso todos os testes
		 * tenham funcionado, aparecrá uma barrinha verde. Caso contrário, ela será vermelha, indicando um possível bug.
		 */
	}
}
