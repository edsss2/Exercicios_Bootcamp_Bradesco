package interfaces_Lambda.exer1;

public record Sms(String mensagem) implements EnviarMensagem {

	@Override
	public void enviarMensagem() {
		System.out.println("Enviando mensagem: " + mensagem + ", por SMS...");
		
	}

}
