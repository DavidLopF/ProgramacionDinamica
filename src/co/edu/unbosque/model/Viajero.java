package co.edu.unbosque.model;

import java.util.*;

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
					caminos[i][j] = rnd.nextInt(2);
				} else if (i == 1 && j >= 1) {
					pesos[i][j] = rnd.nextInt(100);
					caminos[i][j] = rnd.nextInt(2);
				} else if (i == 2 && j >= 2) {
					pesos[i][j] = rnd.nextInt(100);
					caminos[i][j] = rnd.nextInt(2);
				} else if (i == 3 && j >= 3) {
					pesos[i][j] = rnd.nextInt(100);
					caminos[i][j] = rnd.nextInt(2);
				} else if (i == 4 && j >= 4) {
					pesos[i][j] = rnd.nextInt(100);
					caminos[i][j] = rnd.nextInt(2);
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

	public int travellingProblem(int graph[][], int s) {
		ArrayList<Integer> vertex = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++)
			if (i != s)
				vertex.add(i);
		int min_path = Integer.MAX_VALUE;
		do {
			int current_pathweight = 0;
			int k = s;
			for (int i = 0; i < vertex.size(); i++) {
				current_pathweight += graph[k][vertex.get(i)];
				k = vertex.get(i);
			}
			current_pathweight += graph[k][s];
			min_path = Math.min(min_path, current_pathweight);

		} while (findNextPermutation(vertex));
		return min_path;
	}

	public ArrayList<Integer> swap(ArrayList<Integer> data, int left, int right) {
		int temp = data.get(left);
		data.set(left, data.get(right));
		data.set(right, temp);
		return data;
	}

	public ArrayList<Integer> reverse(ArrayList<Integer> data, int left, int right) {
		while (left < right) {
			int temp = data.get(left);
			data.set(left++, data.get(right));
			data.set(right--, temp);
		}
		return data;
	}

	public boolean findNextPermutation(ArrayList<Integer> data) {
		if (data.size() <= 1)
			return false;
		int last = data.size() - 2;
		while (last >= 0) {
			if (data.get(last) < data.get(last + 1)) {
				break;
			}
			last--;
		}
		if (last < 0)
			return false;
		int nextGreater = data.size() - 1;
		for (int i = data.size() - 1; i > last; i--) {
			if (data.get(i) > data.get(last)) {
				nextGreater = i;
				break;
			}
		}
		data = swap(data, nextGreater, last);
		data = reverse(data, last + 1, data.size() - 1);
		return true;
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
