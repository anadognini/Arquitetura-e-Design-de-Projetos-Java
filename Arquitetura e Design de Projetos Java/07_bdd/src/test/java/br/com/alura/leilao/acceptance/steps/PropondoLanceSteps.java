package br.com.alura.leilao.acceptance.steps;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class PropondoLanceSteps {

	private Lance lance;
	private Leilao leilao;
	private Lance lance10;
	private Lance lance15;
	private ArrayList<Lance> lista;

// Similar ao beforeEach do JUnit
	@Before
	public void setUp() {
		this.lista = new ArrayList<Lance>();
		leilao = new Leilao("Tablet XPTO");
	}

// Propondo um lance válido
	@Dado("um lance valido")
	public void dado_um_lance_valido() {
		Usuario usuario = new Usuario("fulano");
		lance = new Lance(usuario, BigDecimal.TEN);
		leilao = new Leilao("Tablet XPTO");
	}

	@Quando("propoe o lance")
	public void quando_propoe_o_lance() {
		leilao.propoe(lance);
	}

	@Entao("o lance e aceito")
	public void entao_o_lance_e_aceito() {
		Assert.assertEquals(1, leilao.getLances().size());
		Assert.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
	}
	
// Propondo vários lances válidos
	@Dado("um lance de {double} reais do usuario {string}")
	public void um_lance_de_reais_do_usuario(Double valor, String nomeUsuario) {
		Lance lance = new Lance(new Usuario(nomeUsuario), new BigDecimal(valor));

		lista.add(lance);
	}

	@Quando("propoe os lances")
	public void propoe_os_lances() {
		this.lista.forEach(lance -> leilao.propoe(lance));
	}

	@Entao("os lances sao aceitos")
	public void os_lances_sao_aceitos() {
		Assert.assertEquals(this.lista.size(), leilao.getLances().size());
		Assert.assertEquals(this.lista.get(0).getValor(), leilao.getLances().get(0).getValor());
		Assert.assertEquals(this.lista.get(1).getValor(), leilao.getLances().get(1).getValor());
	}

// Propondo um lance invalido
	@Dado("um lance invalido de {double} reais e do usuario {string}")
	public void um_lance_invalido_de_reais_e_do_usuario(Double valor, String nomeUsuario) {
		System.out.println(nomeUsuario);
		this.lance = new Lance(new BigDecimal(valor));
	}
	
	@Entao("o lance nao e aceito")
	public void o_lance_nao_e_aceito() {
		Assert.assertEquals(0, leilao.getLances().size());
	} 
	
// Propondo uma sequencia de lances	na qual o segundo é igual ao primeiro
	@Dado("dois lances")
	public void dois_lances(DataTable dataTable) {
	    List<Map<String, String>> valores = dataTable.asMaps();
	    
	    for (Map<String, String> mapa : valores) {
	    	String valor = mapa.get("valor");
	    	String nome = mapa.get("nomeUsuario");
	    	
	    	Lance lance = new Lance(new Usuario(nome), new BigDecimal(valor));
	    	lista.add(lance);
		}
	}
	
	@Entao("o segundo lance nao e aceito")
	public void o_segundo_lance_nao_e_aceito() {
		Assert.assertEquals(1, leilao.getLances().size());
		Assert.assertEquals(this.lista.get(0).getValor(), leilao.getLances().get(0).getValor());
	}
}

// Ctrl + D apaga uma linha inteira