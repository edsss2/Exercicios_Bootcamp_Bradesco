package banco_digital;

public abstract class Conta implements IConta {

	protected double saldo;
	protected int agencia;
	protected int numero;
	protected Cliente cliente;
	protected HistoricoTransacoes hist;
	
	private static final int AGENCIA_DEFAULT = 1;
	private static int SEQUENCIAL = 1;
	
	public Conta(Cliente cliente) {
		this.cliente = cliente;
		hist = new HistoricoTransacoes();
		this.agencia = AGENCIA_DEFAULT;
		this.numero = SEQUENCIAL;
		SEQUENCIAL++;
	}

	
	@Override
	public void sacar(double valor) {
		realizarOperacao("saque", valor, () -> saldo -= valor);
	}
	
	@Override
	public void depositar(double valor) {
		realizarOperacao("deposito", valor, () -> saldo += valor);
	}
	
	@Override
	public void transferir(double valor, Conta contaDestino) {
		realizarOperacao("transferencia", valor, () -> {
			saldo-= valor;
			contaDestino.depositar(valor);
		});
	}
	
	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
	
	public void exibirHistorico() {
		hist.exibirHistorico();
	}
	
	protected void realizarOperacao(String tipo, double valor, Runnable operacao) {
		if (tipo.equals("saque") || tipo.equals("transferencia")) {
			if (valor > saldo) {
				System.out.println("Você não pode fazer essa operação porque ela excede o limite da conta");
				return;
			}
		}
        operacao.run();
        hist.adicionarTransacao(tipo, valor);
        System.out.println("Transação realizada");
    }
	
	
	
}
