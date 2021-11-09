package co.edu.unbosque.model;

import java.util.*;

public class Grafo {

	private List<List<Nodo>> listaADY;
	private int[][] matrizAdy;
	private int[][] pesos;
	private int vertices;
	private int arcos;

	public Grafo(int vertices, int arcos) {
		this.vertices = vertices;
		this.arcos = arcos;
		matrizAdy = new int[vertices][vertices];
		pesos = new int[vertices][vertices];
	}

	public void ingresarArco() {
		Random rnd = new Random();
		for (int i = 0; i < arcos; i++) {
			int inicio = rnd.nextInt(arcos);
			int destino = rnd.nextInt(arcos);
			int peso = rnd.nextInt(100);

			while (inicio == destino) {
				destino = rnd.nextInt(arcos);
			}

			matrizAdy[inicio][destino] = 1;
			matrizAdy[destino][inicio] = 1;
			pesos[inicio][destino] = peso;
			pesos[destino][inicio] = peso;

		}

	}

	public String mostrarMatrizAdy() {
		String a = "";
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				a += matrizAdy[i][j] + "  ";
			}
			a += "\n";
		}

		return a;
	}

}
