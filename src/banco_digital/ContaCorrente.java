package banco_digital;

public class ContaCorrente extends Conta {
	
	private double credito;

	public ContaCorrente(Cliente cliente, Double credito) {
		super(cliente);
		this.credito = credito;
		
	}
	
	@Override
	public void sacar(double valor) {
		realizarOperacao("saque", valor, () -> {
			if (valor > saldo) {
				credito -= valor - saldo;
			}
		});
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns();
		System.out.println(String.format("Crédito: %.2f", this.credito));
	}
	
	@Override
	protected void realizarOperacao(String tipo, double valor, Runnable operacao) {
		if (tipo.equals("saque") || tipo.equals("transferencia")) {
			double valorTotal = saldo + credito;
			if (valor > valorTotal) {
				System.out.println("Você não pode fazer essa operação porque ela excede o limite da conta");
				return;
			}
		}
        operacao.run();
        hist.adicionarTransacao(tipo, valor);
        System.out.println("Transação realizada");
    }

}
