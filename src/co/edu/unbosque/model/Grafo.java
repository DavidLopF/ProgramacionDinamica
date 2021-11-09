package co.edu.unbosque.model;

import java.util.*;

public class Grafo {

	private int[][] matrizAdy;
	private int[][] pesos;
	private int[][] d;
	private int vertices;
	private int arcos;

	public Grafo(int vertices, int arcos) {
		this.vertices = vertices;
		this.arcos = arcos;
		matrizAdy = new int[vertices][vertices];
		pesos = new int[vertices][vertices];
		d = new int[vertices][vertices];
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

	public String mostrarMatriz(int[][] matriz) {
		String a = "";
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				a += matriz[i][j] + "    ";
			}
			a += "\n";
		}

		return a;
	}

	public String floyd(int[][] adyacencia) {
		int n = adyacencia.length;
		int D[][] = adyacencia;

		String enlaces[][] = new String[n][n];
		String[][] aux_enlaces = new String[adyacencia.length][adyacencia.length];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				enlaces[i][j] = "";
				aux_enlaces[i][j] = "";
			}
		}
		String enl_rec = "";
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					float aux = D[i][j];
					float aux2 = D[i][k];
					float aux3 = D[k][j];
					float aux4 = aux2 + aux3;
					float res = Math.min(aux, aux4);
					if (aux != aux4) {
						if (res == aux4) {
							enl_rec = "";
							aux_enlaces[i][j] = k + "";
							enlaces[i][j] = enlaces(i, k, aux_enlaces, enl_rec) + (k + 1);
						}
					}
					D[i][j] = (int) res;
				}
			}
		}

		String enlacesres = "";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j) {
					if (enlaces[i][j].equals("") == true) {
						enlacesres += " De ( " + (i + 1) + " a " + (j + 1) + " ) = " + "( " + (i + 1) + " , " + (j + 1)
								+ " )" + "\n";
					} else
						enlacesres += " De ( " + (i + 1) + " a " + (j + 1) + " ) = ( " + (i + 1) + " , " + enlaces[i][j]
								+ " , " + (j + 1) + ")\n";
				}
			}
		}

		return "\nlos caminos minimos entre nodo son:\n" + enlacesres;
	}

	public String enlaces(int i, int k, String[][] aux_enlaces, String enl_rec) {
		if (aux_enlaces[i][k].equals("") == true) {
			return "";
		} else {
			enl_rec += enlaces(i, Integer.parseInt(aux_enlaces[i][k].toString()), aux_enlaces, enl_rec)
					+ (Integer.parseInt(aux_enlaces[i][k].toString()) + 1) + " , ";
			return enl_rec;
		}
	}

	public int[][] getMatrizAdy() {
		return matrizAdy;
	}

	public void setMatrizAdy(int[][] matrizAdy) {
		this.matrizAdy = matrizAdy;
	}

	public int[][] getPesos() {
		return pesos;
	}

	public void setPesos(int[][] pesos) {
		this.pesos = pesos;
	}

}
