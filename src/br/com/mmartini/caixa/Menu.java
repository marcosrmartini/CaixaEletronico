package br.com.mmartini.caixa;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import br.com.mmartini.caixa.service.CaixaService;

public class Menu {

	private static CaixaService caixa = new CaixaService();
	private static List<String> log = new ArrayList<String>();
	
	public static void main(String[] args) throws Exception {
		menu();
		System.out.println("Programa encerrado.");

	}

	private static void menu() throws Exception { // menu principal
		int opcao = 0;
		Scanner entrada = new Scanner(System.in);
		do {
			System.out.println("\n                  =========================");
			System.out.println("                  |     1 - Incluir	      |");
			System.out.println("                  |     2 - Saldo	      |");
			System.out.println("                  |     3 - Sacar	      |");
			System.out.println("                  |     4 - Extrato	      |");
			System.out.println("                  |     0 - Sair          |");
			System.out.println("                  =========================\n");
			opcao = entrada.nextInt();
			System.out.print("\n");
			switch (opcao) {
			case 1:
				incluir();
				break;
			case 2:
				saldo();
				break;
			case 3:
				sacar();
				break;
			case 4:
				extrato();
				break;
			case 0:
				break;
			default:
				System.out.println("Opção Inválida!");
				break;
			}
		} while (opcao != 0);
	}

	
	
	private static void extrato() {
		for (String sa : log) {
			System.out.println(sa);
		}
		
	}

	private static void sacar() throws Exception {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Entre com o valor do saque: ");
		int saque = entrada.nextInt();

		caixa.sacar(saque);
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String dataFormatada = formato.format(new Date());
		
		
		log.add("Valor: " + saque + " data: " + dataFormatada);
		
	}

	private static void incluir() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Entre com o valor da nota: ");
		int cedula = entrada.nextInt();
		System.out.println("Entre com a quantidade: ");
		int quantidade = entrada.nextInt();
		
		caixa.incluir(quantidade, cedula);
		
		
	}

	private static void saldo() {
		caixa.saldo();
	}

}
