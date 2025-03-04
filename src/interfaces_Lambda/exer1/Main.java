package interfaces_Lambda.exer1;

import java.util.Scanner;

public class Main {

	static String mensagem;
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean isPermanecer = true;
		System.out.println("Digite a mensagem: ");
		
		do {
			System.out.println("");
			mensagem = scn.nextLine();
			
			opcoes();
			
			System.out.println();
			System.out.println("Por qual meio de comunicação quer enviar a mensagem? ");
			int opcao = scn.nextInt();
			
			switch (opcao) {
				case 1 -> enviarSms();
				case 2 -> enviarEmail();
				case 3 -> enviarWhatsApp();
				case 4 -> enviarRedesSociais();
				case 5 -> isPermanecer = false;
				default -> System.out.println("Opção invalida");
			}
			
			
		} while (isPermanecer);
		
		scn.close();
	}
	
	private static void opcoes() {
		System.out.println("1- Enviar mensagem por SMS");
		System.out.println("2- Enviar mensagem por E-mail");
		System.out.println("3- Enviar mensagem por WhatsApp");
		System.out.println("4- Enviar mensagem por Redes sociais");
		System.out.println("5- Sair");
	}
	
	private static void enviarSms() {
		EnviarMensagem enviarMsg =  new Sms(mensagem);
		enviarMsg.enviarMensagem();
	}
	private static void enviarEmail() {
		EnviarMensagem enviarMsg =  new Email(mensagem);
		enviarMsg.enviarMensagem();
	}
	private static void enviarWhatsApp() {
		EnviarMensagem enviarMsg =  new WhatsApp(mensagem);
		enviarMsg.enviarMensagem();
	}
	private static void enviarRedesSociais() {
		EnviarMensagem enviarMsg =  new RedesSociais(mensagem);
		enviarMsg.enviarMensagem();
	}
}
