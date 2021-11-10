package co.edu.unbosque.model;

public class Viajero {

	
	private int pesos[][];
	private int caminos[][];
	
	public Viajero() {
		pesos = new int[5][5];
		caminos = new int[5][5];
	}
	
	public void inicializaarMatrices() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				pesos[i][j]= 0;
				caminos[i][j] = 0;
			}
			
		}
	}
}
