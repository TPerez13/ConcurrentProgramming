package Principal;

public class Bloque41 implements Runnable{
	
	private static monitor mon = new monitor();
	//public static int cont=0;
	
	public void run()
	{
		mon.inc();
		
		System.out.println(mon.getCont());
	}

	public static void main(String[] args)
	{
		Runtime runtime = Runtime.getRuntime();
		
		int nNucleos = runtime.availableProcessors();
		
		Thread[] hilos =new Thread[nNucleos];
		
		for(int i = 0;i< hilos.length;i++)
		{
			Runnable runnable = new Bloque41();
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
		
		//System.out.println("Soy el hilo: Principal ");
		
		System.out.println("Final: "+mon.getCont());
				
	}

}
