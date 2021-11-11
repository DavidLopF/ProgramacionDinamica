package co.edu.unbosque.controller;

import java.util.Iterator;

import java.util.*;
import co.edu.unbosque.model.AsignacionTarea;
import co.edu.unbosque.model.Biniomales;
import co.edu.unbosque.model.Grafo;
import co.edu.unbosque.model.Matriz;
import co.edu.unbosque.model.Viajero;
import co.edu.unbosque.view.View;

public class Controller {

	private View vista;
	private Grafo grafo;
	private Viajero viajero;
	private Matriz matriz;
	private Biniomales bino;
	private AsignacionTarea asignacionTarea;

	public Controller() {
		vista = new View();

		funcionar();
	}

	private void funcionar() {
		String opcion = vista.menuPrincipal();

		switch (opcion) {
		case "1. Algoritmo de floyd.":
			int arcos = vista.capturarInt("Ingrese cantidad de vertices que va a tener el grafo:  ");
			int nodos = vista.capturarInt("Ingrese cantidad de nodos para crear aleatoriamente: ");

			try {
				grafo = new Grafo(arcos, nodos);
				grafo.ingresarArco();
				vista.mostrarMensaje("¡¡¡ Grafo creado con exito !!!\n" + "Matriz de adyacencia:\n"
						+ grafo.mostrarMatriz(grafo.getMatrizAdy()) + "\n matriz de pesos:\n"
						+ grafo.mostrarMatriz(grafo.getPesos()));

				vista.mostrarMensaje("Resultados de algoritmo de floyd: \n" + grafo.floyd(grafo.getMatrizAdy()));
			} catch (Exception e) {
				vista.mostrarMensaje("Valide datos. ");
			}
			funcionar();
			break;

		case "2. Problema del viajero":
			viajero = new Viajero();
			vista.mostrarMensaje("Matriz de adyacencia:\n" + viajero.mostrarMatriz(viajero.getCaminos())
					+ "\nmatriz de pesos:\n" + viajero.mostrarMatriz(viajero.getPesos()));
			funcionar();
			break;
		case "3. Multipicacion de matrices":
			matriz = new Matriz();
			int tam = vista.capturarInt("Ingrese tamaño: ");
			int[] a = new int[tam];
			for (int b = 0; b < tam; b++) {
				a[b] = vista.capturarInt("Posici�n " + (b + 1));
			}
			int[][] c = new int[a.length][a.length];
			int[][] d = new int[a.length][a.length];
			vista.mostrarMensaje("Resultado: " + matriz.matrizChain(a, c, d));
			matriz.traceback(1, a.length - 1, d);
			funcionar();
			break;

		case "4. Problema de asignación de tareas":
			asignacionTarea = new AsignacionTarea();
			int tareas = vista.capturarInt("ingrese numero de tareas: ");
			int emp = vista.capturarInt("ingrese numero de empleados: ");
			int[][] c1 = new int[emp][tareas];

			for (int i = 0; i < c1.length; i++) {
				c1[i][0] = (int) (Math.random() * 10);
				for (int j = 1; j < c1[i].length; j++) {
					c1[i][j] = c1[i][j - 1] + (int) (Math.random() * 5);
				}
			}

			String sol = "";
			for (int i = 0; i < c1.length; i++) {
				sol += Arrays.toString(c1[i]) + "\n";
				sol += asignacionTarea.maxProfit(c1) + "\n";
			}
			
			vista.mostrarMensaje("resultado\n " + sol);
	

			funcionar();
			break;

		case "5. Coeficiente binomiales":
			bino = new Biniomales();
			String res = "";
			int n = vista.capturarInt("ingrese el valor de N");
			int[][] result = bino.prodbinomial(n, n);
			for (int i = 0; i < result.length; i++) {
				for (int b = 0; b < result[i].length; b++) {
					res += result[i][b] + " ";
				}
			}

			vista.mostrarMensaje("Resultado: " + res);
			funcionar();
			break;

		}
	}

}
