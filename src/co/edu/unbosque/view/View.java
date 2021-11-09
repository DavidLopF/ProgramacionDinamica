package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class View {

	public void mostrarMensaje(String a) {
		JOptionPane.showMessageDialog(null, a);
	}

	public String capturarString(String titulo) {
		String a = JOptionPane.showInputDialog(titulo);
		return a;
	}

	public int capturarInt(String titulo) {
		String a = JOptionPane.showInputDialog(titulo);
		int num = 0;
		while (!esNumeroInt(a)) {

			System.out.println("ERROR.. NO ES ENTERO.");
			a = JOptionPane.showInputDialog(titulo);
			num = 0;

		}
		num = Integer.parseInt(a);
		System.out.println("DATO INGRESADO CON EXITO.");

		return num;
	}

	private boolean esNumeroInt(String mensaje) {
		try {
			Integer.parseInt(mensaje);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	public String menuPrincipal() {
		Object[] opciones = { "1. Algoritmo de floyd.", "2. Problema del viajero", "3. Multipicacion de matrices",
				"4. Problema de asignaci�n de tareas", "5. Coeficiente binomiales", "6. Salir" };
		Object opcion = JOptionPane.showInputDialog(null,
				"      ..:Bienvenido se�or usuario :..                "
						+ "\n\n\nSelecciona un operacion a realizar:    ",
				"Elegir", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		if (opcion == null) {
			mostrarMensaje("Hasta Pronto");
		}
		return opcion.toString();
	}

}
