package br.com.mmartini.caixa.model;

public class Cedula {

	private int nota;
	private int quantidade;
	private double valor;

	public Cedula(int nota, int quantidade, double valor) {
		this.nota = nota;
		this.quantidade = quantidade;
		this.valor = valor;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Cedula [quantidade=" + quantidade + ", valor=" + valor + "]";
	}

}
