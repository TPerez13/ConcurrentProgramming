package Principal;

import java.util.Random;
import java.util.concurrent.*;

public class PoolThreads implements Runnable {
	private int fila;

	private static int tam = 40000;
	private static int[][] matriz = new int[tam][tam];

	public PoolThreads(int fila) {
		this.fila = fila;
	}

	public void run() {
		for (int i = 0; i < tam; i++) {
			matriz[fila][i] *= 10;
		}
	}

	public static void main(String[] args) {
		Random rand = new Random(System.nanoTime());

		double tiempo_ini, tiempo_fin;

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] = rand.nextInt(10);
			}
		}

		tiempo_ini = System.nanoTime();

		ExecutorService pool = Executors.newFixedThreadPool(8);
		
		for (int i = 0; i < tam; i++) {
			Runnable runnable = new PoolThreads(i);
			pool.execute(runnable);
		}

		pool.shutdown();
		while(!pool.isTerminated());
		
		tiempo_fin = System.nanoTime() - tiempo_ini;

		System.out.println((tiempo_fin / 1000000) + " milisegundos");

		/*
		 * for(int i =0;i< matriz.length;i++) { System.out.print("( "); for(int
		 * j=0;j<matriz.length;j++) { System.out.print(matriz[i][j]); if(j
		 * !=matriz.length -1) System.out.print(",");
		 * 
		 * } System.out.print(" ) \n"); }
		 */
	}
}

//}
/*
 * Try un poquito marrullero public class PoolThreads implements Runnable { //
 * varriables para el pool de threads private static int cont; private boolean
 * bandera = true;
 * 
 * // Variables para matriz y multiplicacion de la fila private int fila;
 * private static int tam = 6; private static int[][] matriz = new
 * int[tam][tam];
 * 
 * public PoolThreads(int fila) { this.fila = fila; }
 * 
 * public void run() { while (bandera) { for (int i = 0; i < tam; i++) {
 * matriz[fila][i] *= 10; } //Esto que estoy haciendo tiene el problema de que
 * alomejor en el incrementarCont tmpieza la asincr if (cont < tam) {
 * incrementarCont();// Tiene que ser synchhronizeed try { wait(); } catch
 * (InterruptedException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } } else { bandera = false; } }
 * 
 * }
 * 
 * public synchronized void incrementarCont() { cont++; notifyAll(); }
 * 
 * public static void main(String[] args) { // Random rand = new
 * Random(System.nanoTime());
 * 
 * double tiempo_ini, tiempo_fin;
 * 
 * for (int i = 0; i < matriz.length; i++) { for (int j = 0; j <
 * matriz[0].length; j++) { matriz[i][j] = rand.nextInt(10); } }
 * 
 * tiempo_ini = System.nanoTime(); //
 * 
 * Thread[] hilos = new Thread[tam];
 * 
 * for (int i = 0; i < 4; i++) { Runnable runnable = new PoolThreads(i);
 * hilos[i] = new Thread(runnable); hilos[i].start(); }
 * 
 * for (int i = 0; i < hilos.length; i++) { try { hilos[i].join(); } catch
 * (InterruptedException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } }
 * 
 * // tiempo_fin = System.nanoTime() - tiempo_ini;
 * 
 * System.out.println((tiempo_fin/1000000)+" milisegundos"); } //
 * 
 * }
 */