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

			if (arcos < nodos) {
				vista.mostrarMensaje("Los vertices no pueden ser mayores que los nodos. ");
				funcionar();
			}
			
			grafo = new Grafo(arcos, nodos);
			grafo.ingresarArco();
			vista.mostrarMensaje(grafo.mostrarMatrizAdy());
			
			
			break;
		}

	}

}
