package Principal;

public class EjJavaThreads1 implements Runnable {

	Thread timer;
	private int cont = 0;

	public void run() {
		System.out.print("Estoy en el hilo" + Thread.currentThread().getName());
		// Thread.sleep(1000);
	}

	public void empezar() {
		if (timer == null) {
			cont++;
			EjJavaThreads1 ejt1 = new EjJavaThreads1();
			String aux = "Thread " + cont;
			timer = new Thread(ejt1, aux);
		}
		timer.start();
	}

	public static void main(String[] args) {

		System.out.println("Hola");

		EjJavaThreads1 ejJavaThreads1 = new EjJavaThreads1();
		ejJavaThreads1.empezar();
		
		try {
			Thread.currentThread().sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ejJavaThreads1.empezar();

		/*
		 * EjJavaThreads1 ejJavaThreads1 = new EjJavaThreads1();
		 * 
		 * int cont=0;
		 * 
		 * ejJavaThreads1.timer = new Thread(ejJavaThreads1);
		 * 
		 * ejJavaThreads1.timer.start();
		 * 
		 * 
		 * System.out.println("Estamos antes del main");
		 * 
		 * try { while(ejJavaThreads1.timer.isAlive()) { cont++;
		 * 
		 * } System.out.println("El hilo esta activo se ha repetido "+cont);
		 * 
		 * } catch (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * System.out.println("El hilo NO esta activo");
		 */

	}
}
