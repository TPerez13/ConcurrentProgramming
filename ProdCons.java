package Principal;

import java.util.Random;

public class ProdCons implements Runnable {
	
	private int id;
	public static Random cerrojo = new Random();
	private static int cont = 0;
	
	public ProdCons(int id)
	{
		this.id= id;
	}
	
	public void run()
	{
		synchronized(cerrojo)
		{
			while(id != cont) // Condicion de guarda
			{
				try {
					cerrojo.wait();
				}catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			System.out.println("Soy el hilo: "+id);
			cont++;
			cerrojo.notifyAll();
		}
	}
	
	public static void main(String[] args)
	{
		Runtime runtime = Runtime.getRuntime();
		
		int nNucleos = runtime.availableProcessors();
		
		Thread[] hilos =new Thread[nNucleos];
		
		for(int i = 0;i< hilos.length;i++)
		{
			Runnable runnable = new Bloque31(i);
			hilos[i] = new Thread(runnable);
			hilos[i].start();
		}
		
		for(int i =0;i<hilos.length;i++)
		{
			try
			{
				hilos[i].join();
			}catch(Exception ex) {}
		}
		
		System.out.println("Soy el hilo: Principal ");
				
	}

	
	
}
