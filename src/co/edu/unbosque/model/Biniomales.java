package co.edu.unbosque.model;

public class Biniomales {

	public int[][] prodbinomial(int n, int k) {
		int a, b;
		int[][] c = new int[n][k];
		for (a = 0; a < n; a++) {
			c[a][0] = 1;
		}
		for (a = 1; a < n; a++) {
			c[a][1] = a;
		}
		for (a = 2; a < k; a++) {
			c[a][a] = 1;
		}
		for (a = 3; a < n; a++) {
			for (b = 2; b <= a - 1; b++) {
				if (b <= k) {
					c[a][b] = c[a - 1][b - 1] + c[a - 1][b];
				}
			}
		}
		return c;
	}

}
