package Principal;

//Nueva forma de lanzar hilos 

//Intentar 

public class Bloque3 implements Runnable {
	private static int cont=0;
	private static Object object = new Object(); //El cerrojo tiene que ser estatico
	
	@Override
	public void run()
	{
		
		synchronized(object){//object funciona como cerrojo || Como funciona -> Activo:h1 Cola:h4 h3 h2
											//Traza-> Activo:h3 Cola:h4 h2 h1 // Condicion de concurso, no hay prioridad ni ordend
											//de entrada
		for(int i = 0; i< 20000;i++)
		{
			
				cont++; 			 
									
			}
		}
	}
	
	public static void main(String[] args)
	{
		Runtime runtime = Runtime.getRuntime();
		
		int nNucleos = runtime.availableProcessors();
		
		//System.out.println(nNucleos);
		
		Thread[] hilos = new Thread[nNucleos];
		
		for(int i= 0; i< hilos.length;i++)
		{
			Runnable runnable = new Bloque3();
			hilos[i] = new Thread(runnable);
			hilos[i].start();
		}
		
		for(int i=0;i< hilos.length;i++)
		{
			try {
				hilos[i].join();
			}catch(Exception ex) {}
		}
		
		System.out.println(cont);
	}
}
