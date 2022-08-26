package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	// Quando temos que testar um valor numérico, devemos testar com um valor maior,
	// um valor menor e um valor exatamente igual ao cenário esperado

	@Test
	void verificarBonusZeroParaSalarioAlto() {
		// Método que retorna uma mensagem em caso de falha no teste:
		// fail("Not yet implemented");

		BonusService service = new BonusService();
		
		// 3a abordagem do JUnit: simulando se tem uma exceção sendo passada
		
		// Método que verifica exceções, argumentos: tipodeexcecao.class, lambda com o método a ser chamado
		// assertThrows(IllegalArgumentException.class,
		// () -> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000"))));

		try {
			service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
			fail("Se chegar aqui é porque a exception não passou.");
		} catch (Exception e) {
			assertEquals("Funcionário com salário acima de 10000 reais não pode receber bônus!", e.getMessage());
		}

	}

	@Test
	void verificarBonus10000Reais() {
		BonusService service = new BonusService();
		// 1a abordagem do JUnit: chamar um método (calcularBonus) que devolve um valor (BigDecimal bonus) e fazer o assert em cima dessa variáve
		BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("2500")));

		assertEquals(new BigDecimal("250.00"), bonus);
	}

	@Test
	void verificarSalarioIgualAMil() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));

		assertEquals(new BigDecimal("1000.00"), bonus);
	}
}

// 3 abordagens do JUnit (em geral) para escrever testes:
// 1 - Testar um valor que é devolvido por um método
// 2 - Testar um objeto que é modificado por um método
// 3 - Testar uma exception