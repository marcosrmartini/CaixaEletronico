package br.com.mmartini.caixa.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CaixaService {

	private Map<String, String> cedulas = new HashMap<String, String>();

	static String[] notas = { "100", "50", "20", "10", "5" };
	static ArrayList notasUsadas = new ArrayList();
	static int valorResult;

	public void incluir(int quantidade, int cedula) {
		int qtdAtual;

		if (cedulas.get(String.valueOf(cedula)) == null) {
			qtdAtual = 0;
		} else {
			qtdAtual = Integer.parseInt(cedulas.get(String.valueOf(cedula)));
		}
		qtdAtual += quantidade;
		cedulas.put(String.valueOf(cedula), String.valueOf(qtdAtual));
	}

	public void saldo() {
		for (Map.Entry<String, String> entry : cedulas.entrySet()) {
			System.out.println("Cedula: " + entry.getKey() + " quantidade: "
					+ entry.getValue());
		}
	}

	public void sacar(int saque) throws Exception {
		valorResult = saque;
		int qtdAtual = 0;
		boolean cedulasInsuficiente = false;

		if (saque % 5 != 0) {
			throw new Exception("Valor invalido.");
		}

		if (saque >= 10) {
			while (valorResult >= 100 && verificaMod(valorResult, 100)
					&& cedulas.get("100") != null) {
				qtdAtual = Integer.parseInt(cedulas.get("100"));
				qtdAtual -= 1;
				cedulas.put("100", String.valueOf(qtdAtual));
				notasUsadas.add(notas[0]);
				valorResult -= 100;
			}
			while (valorResult >= 50 && verificaMod(valorResult, 50)
					&& cedulas.get("50") != null) {
				qtdAtual = Integer.parseInt(cedulas.get("50"));
				qtdAtual -= 1;
				cedulas.put("50", String.valueOf(qtdAtual));
				notasUsadas.add(notas[1]);
				valorResult -= 50;
			}
			while (valorResult >= 20 && verificaMod(valorResult, 20)
					&& cedulas.get("20") != null) {
				qtdAtual = Integer.parseInt(cedulas.get("20"));
				qtdAtual -= 1;
				cedulas.put("20", String.valueOf(qtdAtual));
				notasUsadas.add(notas[2]);
				valorResult -= 20;
			}
			while (valorResult >= 10 && verificaMod(valorResult, 10)
					&& cedulas.get("10") != null) {
				qtdAtual = Integer.parseInt(cedulas.get("10"));
				qtdAtual -= 1;
				cedulas.put("10", String.valueOf(qtdAtual));
				notasUsadas.add(notas[3]);
				valorResult -= 10;
			}
			while (valorResult >= 5 && verificaMod(valorResult, 5)
					&& cedulas.get("5") != null) {

				if (Integer.parseInt(cedulas.get("5")) > 0) {
					qtdAtual = Integer.parseInt(cedulas.get("5"));
					qtdAtual -= 1;
					cedulas.put("5", String.valueOf(qtdAtual));
					notasUsadas.add(notas[4]);
					valorResult -= 5;
				} else {
					cedulasInsuficiente = true;
				}

			}
			if (cedulasInsuficiente){
				System.out.println("Cedulas insuficiente para o saque!");
			}
			
			
		}
	}

	private boolean verificaMod(int resultado, int base) {
		int valor = resultado % base;
		if ((valor == 1 || valor == 3) && (resultado / 2) < (base)) {
			return false;
		} else {
			return true;
		}
	}

}
