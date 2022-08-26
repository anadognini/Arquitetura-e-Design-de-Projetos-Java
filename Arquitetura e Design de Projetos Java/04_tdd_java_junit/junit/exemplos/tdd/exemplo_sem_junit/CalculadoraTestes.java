package tdd.exemplo_sem_junit;

public class CalculadoraTestes {
	public static void main(String[] args) {
		// Maneira de escrever um teste automatizado
		Calculadora calculadora = new Calculadora();
		
		int soma = calculadora.somar(3, 7);
		System.out.println(soma);
		
		soma = calculadora.somar(0, 7);
		System.out.println(soma);
		
		soma = calculadora.somar(0, 0);
		System.out.println(soma);
		
		soma = calculadora.somar(3, -1);
		System.out.println(soma);
	}
}
