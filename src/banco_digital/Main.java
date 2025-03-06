package banco_digital;

public class Main {

	public static void main(String[] args) {
		Cliente venilton = new Cliente("Venilton", 15992845745l);
		venilton.setNome("Venilton");
		
		Conta cc = new ContaCorrente(venilton, 200.0);
		Conta poupanca = new ContaPoupanca(venilton);

		cc.depositar(100);
		cc.transferir(100, poupanca);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
		
		cc.exibirHistorico();
		poupanca.exibirHistorico();
	}

}
