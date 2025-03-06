package banco_digital;

import java.util.HashMap;
import java.util.Map;

public class HistoricoTransacoes {

	private Map<String, Double> transacoes;
	
	public HistoricoTransacoes() {
		transacoes = new HashMap<>();
	}
	
	public void adicionarTransacao (String tipo, double valor) {
		if (!transacoes.containsKey(tipo)) {
			transacoes.put(tipo, valor);
		} else {
			transacoes.put(tipo, transacoes.get(tipo) + valor);
		}
	}
	
	public void exibirHistorico() {
		System.out.println("=== Historico de Transações ===");
		transacoes.entrySet()
		.stream()
		.forEach(entry -> System.out.println(entry.getKey() + ": R$ " + entry.getValue()));
	}
}
