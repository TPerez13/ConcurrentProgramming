package Principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CarreraCicl {

	public static void main(String[] args)
	{
		int participantes = 100;
		Runtime runtime = Runtime.getRuntime();
		int nNucleos = runtime.availableProcessors();
		
		ExecutorService pool = Executors.newFixedThreadPool(nNucleos);
		
		for(int i = 0; i<participantes;i++)
		{
			Runnable runnable = new Carrera(i,10000,20000,5000);
			pool.execute(runnable);
		}
		
		pool.shutdown();
		while(!pool.isTerminated());
		
	}
	
}
