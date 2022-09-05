package br.com.alura.escola.infra.indicacao;

import br.com.alura.escola.aplicacao.indicacao.EnviarEmailDeIndicacao;
import br.com.alura.escola.dominio.aluno.Aluno;

public class EnviarEmailDeIndicacaoComJavaMail implements EnviarEmailDeIndicacao {

	@Override
	public void enviarPara(Aluno indicado) {
		// Lógica de envio de e-mails com a lib Java Mail
	}
}
