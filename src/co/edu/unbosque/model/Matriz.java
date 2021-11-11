package co.edu.unbosque.model;

public class Matriz {

	public  int matrizChain(int[] p, int[][] m, int[][] s) {
		int n = p.length - 1;
		for (int i = 1; i <= n; i++)
			// en s� mismo es 0
			m[i][i] = 0; // Inicializa una matriz bidimensional
		for (int r = 2; r <= n; r++) {
			for (int i = 1; i <= n - r + 1; i++) {
				int j = i + r - 1;
				// Primero divide por i
				m[i][j] = m[i + 1][j] + p[i - 1] * p[i] * p[j]; // Encuentra la multiplicaci�n continua de Ai a Aj
				s[i][j] = i; // registro de posici�n de divisi�n
				for (int k = i + 1; k < j; k++) {
					// Encuentra si hay un punto de divisi�n optimizable
					int t = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j]; // f�rmula
					if (t < m[i][j]) {
						m[i][j] = t;
						s[i][j] = k;
					}
				}
			}
		}
		return m[1][n];
	}

	public  void traceback(int i, int j, int[][] s) {
		// Muestra el orden de c�lculo �ptimo de A [i: j]
		if (i == j) {
			// Salida recursiva
			System.out.print("A" + i);
			return;
		} else {
			System.out.print("(");
			// Salida recursiva a la izquierda
			traceback(i, s[i][j], s);
			// salida recursiva a la derecha
			traceback(s[i][j] + 1, j, s);
			System.out.print(")");
		}
	}
}
