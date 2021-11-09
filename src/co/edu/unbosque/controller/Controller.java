package co.edu.unbosque.controller;

import java.util.Iterator;

import co.edu.unbosque.model.Grafo;
import co.edu.unbosque.view.View;

public class Controller {

	private View vista;
	private Grafo grafo;

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

				vista.mostrarMensaje("Mostrar resultados de algoritmo de floyd: \n" + grafo.floyd(grafo.getMatrizAdy()));
			} catch (Exception e) {
				vista.mostrarMensaje("Valide datos. ");
			}

			break;
		}

	}

}
