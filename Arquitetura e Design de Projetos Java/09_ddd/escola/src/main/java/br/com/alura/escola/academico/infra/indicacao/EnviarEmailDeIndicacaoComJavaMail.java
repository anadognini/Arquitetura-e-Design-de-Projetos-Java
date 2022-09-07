package br.com.alura.escola.academico.infra.indicacao;

import br.com.alura.escola.academico.aplicacao.indicacao.EnviarEmailDeIndicacao;
import br.com.alura.escola.academico.dominio.aluno.Aluno;

public class EnviarEmailDeIndicacaoComJavaMail implements EnviarEmailDeIndicacao {

	@Override
	public void enviarPara(Aluno indicado) {
		// Lógica de envio de e-mails com a lib Java Mail
	}
}
