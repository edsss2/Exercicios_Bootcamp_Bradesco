package interfaces_Lambda.exer1;

public record WhatsApp(String mensagem) implements EnviarMensagem {

	
	@Override
	public void enviarMensagem() {
		System.out.println("Enviando mensagem: " + mensagem + ", por WhatsApp...");
		
	}
}
