package co.edu.unbosque.model;

public class AsignacionTarea {

	public static String maxProfit(int[][] c) {
		int m = c.length + 1, n = c[0].length + 1;
		int[][] p = new int[m][n];
		int[][] l = new int[m][n];
		for (int i = 0; i < m; i++) {
			p[i][0] = 0;
		}
		for (int j = 0; j < n; j++) {
			p[0][j] = 0;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				int max = p[i - 1][j];
				l[i][j] = 0;
				for (int k = 1; k <= j; k++) {
					if (max < c[i - 1][k - 1] + p[i - 1][j - k]) {
						max = c[i - 1][k - 1] + p[i - 1][j - k];
						l[i][j] = k;
					}
				}
				p[i][j] = max;
			}
		}
		String resultado = "";
		for (int i = m - 1, j = n - 1; i > 0 && j > 0;) {
			if (l[i][j] == 0)
				i--;
			else {
				resultado = "\n" + "En la tarea " + i + " se asigna: " + l[i][j] + resultado;
				j -= l[i][j];
				i--;
			}
		}
		for (int a = 0; a < l.length; a++) {
			for (int b = 0; b < l[a].length; b++) {
				System.out.print(l[a][b] + " ");
			}
			System.out.print("\n");
		}
		resultado = "Beneficio máximo: " + p[m - 1][n - 1] + resultado;
		return resultado;
	}

}
