package co.edu.unbosque.model;

public class Nodo {

	private int vertice;
	private int peso;
	private Nodo suguiente;

	public Nodo(int vertice, int peso) {
		this.vertice = vertice;
		this.peso = peso;
	}

	public int getVertice() {
		return vertice;
	}

	public void setVertice(int vertice) {
		this.vertice = vertice;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public Nodo getSuguiente() {
		return suguiente;
	}

	public void setSuguiente(Nodo suguiente) {
		this.suguiente = suguiente;
	}
	
	
}
