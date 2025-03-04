package interfaces_Lambda.exer1;

public record RedesSociais(String mensagem) implements EnviarMensagem {

	
	@Override
	public void enviarMensagem() {
		System.out.println("Enviando mensagem: " + mensagem + ", pelas redes sociais...");
		
	}
}
