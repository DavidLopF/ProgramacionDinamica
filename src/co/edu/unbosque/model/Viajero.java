package co.edu.unbosque.model;

import java.util.Random;

public class Viajero {

	private int pesos[][];
	private int caminos[][];

	public Viajero() {
		pesos = new int[5][5];
		caminos = new int[5][5];
		inicializaarMatrices();
	}

	public void inicializaarMatrices() {
		Random rnd = new Random();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i == 0) {
					pesos[i][j] = rnd.nextInt(100);
					caminos[i][j] = 1;
				} else if (i == 1 && j >= 1) {
					pesos[i][j] = rnd.nextInt(100);
					caminos[i][j] = 1;
				} else if (i == 2 && j >= 2) {
					pesos[i][j] = rnd.nextInt(100);
					caminos[i][j] = 1;
				} else if (i == 3 && j >= 3) {
					pesos[i][j] = rnd.nextInt(100);
					caminos[i][j] = 1;
				} else if (i == 4 && j >= 4) {
					pesos[i][j] = rnd.nextInt(100);
					caminos[i][j] = 1;
				}
			}

		}
	}
	
	
	
	
	public String mostrarMatriz(int[][] matriz) {
		String a = "";
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				a += matriz[i][j] + "    ";
			}
			a += "\n";
		}

		return a;
	}

	public int[][] getPesos() {
		return pesos;
	}

	public void setPesos(int[][] pesos) {
		this.pesos = pesos;
	}

	public int[][] getCaminos() {
		return caminos;
	}

	public void setCaminos(int[][] caminos) {
		this.caminos = caminos;
	}
}
