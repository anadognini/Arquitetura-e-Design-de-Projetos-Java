package imposto;

import java.math.BigDecimal;

import orcamento.Orcamento;

public interface TipoImposto {
	BigDecimal calcular(Orcamento orcamento);
}
