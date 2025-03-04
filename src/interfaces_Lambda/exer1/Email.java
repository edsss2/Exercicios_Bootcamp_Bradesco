package interfaces_Lambda.exer1;

public record Email(String mensagem) implements EnviarMensagem {

	@Override
	public void enviarMensagem() {
		System.out.println("Enviando mensagem: " + mensagem + ", por email...");
		
	}

}
