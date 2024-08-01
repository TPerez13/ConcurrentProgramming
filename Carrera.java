package Principal;

public class Carrera implements Runnable {
	private int id_participante;
	private double[] tiempo_etapas = new double[3];
	private int[] tareas = new int[3];
	private int etapa_actual = 0;
	private int var;

	public void run() {
		if (etapa_actual < 3) {
			double tiempo_ini, tiempo_fin;

			tiempo_ini = System.nanoTime();

			for (int i = 0; i < tareas[etapa_actual]; i++) {
				var += 1;
			}

			tiempo_fin = System.nanoTime() - tiempo_ini;

			tiempo_etapas[etapa_actual] = tiempo_fin;
			etapa_actual++;
		}
	}

	Carrera(int id_participante, int tarea_1, int tarea_2, int tarea_3) {
		this.id_participante = id_participante;
		this.tareas[1] = tarea_1;
		this.tareas[1] = tarea_2;
		this.tareas[1] = tarea_3;
	}
}
