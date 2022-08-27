package br.com.alura.leilao.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;
import br.com.alura.leilao.util.builder.LeilaoBuilder;
import br.com.alura.leilao.util.builder.UsuarioBuilder;

class LeilaoDaoTest {

	private LeilaoDao dao;
	private EntityManager em;

	@BeforeEach
	public void beforeEach() {
		this.em = JPAUtil.getEntityManager();
		this.dao = new LeilaoDao(em);

		em.getTransaction().begin();
	}

	@AfterEach
	public void afterEach() {
		em.getTransaction().rollback();
	}

	@Test
	void cadastrarLeilao() {
		Usuario usuario = new UsuarioBuilder()
				.comNome("Fulano")
				.comEmail("fulano@email.com")
				.comSenha("12345678")
				.criar();
		
		em.persist(usuario);
		
		Leilao leilao = new LeilaoBuilder()
				.comNome("Vaca Nelore")
				.comValorInicial("3180000")
				.comData(LocalDate.now())
				.comUsuario(usuario)
				.criar();

		leilao = dao.salvar(leilao);

		Leilao salvo = dao.buscarPorId(leilao.getId());

		Assert.assertNotNull(salvo);
	}

	@Test
	void atualizarLeilao() {
		Usuario usuario = new UsuarioBuilder()
				.comNome("Fulano")
				.comEmail("fulano@email.com")
				.comSenha("12345678")
				.criar();
		
		em.persist(usuario);
		
		Leilao leilao = new LeilaoBuilder()
				.comNome("Vaca Nelore")
				.comValorInicial("3180000")
				.comData(LocalDate.now())
				.comUsuario(usuario)
				.criar();

		// Fazendo update no nome e no valor
		leilao = dao.salvar(leilao);
		leilao.setNome("Boi Angus");
		leilao.setValorInicial(new BigDecimal("16000"));
		leilao = dao.salvar(leilao);

		Leilao salvo = dao.buscarPorId(leilao.getId());

		Assert.assertEquals("Boi Angus", salvo.getNome());
		Assert.assertEquals(new BigDecimal("16000"), salvo.getValorInicial());
	}
}

/*
 * O ideal é sempre utilizar outra base de dados separada, exclusiva para a
 * execução dos testes, para que a JPA possa sincronizar com o banco de dados.
 * Alguns métodos, como os que fazem insert, update e delete, vão exigir uma
 * transação ativa.
 **/
