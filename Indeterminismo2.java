package Principal;

import java.util.Random;
//Multiplicar por 10 todos los elementos de una matriz de forma concurrente y medir el tiempo  

public class Indeterminismo2 extends Thread{
	private static int tam = 4000;
	private static int[][] matriz = new int[tam][tam];
	private int ini,fin;
	
	static double tiempo_ini;
	static double tiempo_fin;
	
	public Indeterminismo2(int ini, int fin)
	{
		this.ini = ini;
		this.fin = fin;
	}
			
	public void run()
	{
		for(int i =ini;i<fin;i++)
		{
			for(int j=0;j< matriz.length;j++)
			{
				matriz[i][j] *= 10;
			}
		}
	}
	
	public static void main(String[] args)
	{
		Random rand = new Random(System.nanoTime());
		
		for(int i =0;i< matriz.length;i++)
		{
			for(int j=0;j<matriz.length;j++)
			{
				matriz[i][j] = rand.nextInt(10);
			}
		}
		
		tiempo_ini = System.nanoTime();//Hora en nanosegundos
		
		Indeterminismo2 indt2 = new Indeterminismo2(0,tam/2);
		Indeterminismo2 indt3 = new Indeterminismo2(tam/2,tam);
		
		indt2.start();
		indt3.start();
		
		//corutina
		//Para que el hilo principal espere a los secundarios
		try
		{
			indt2.join();
			indt3.join();
		}catch(Exception e) {}
		
		tiempo_fin=System.nanoTime() - tiempo_ini;
		
		System.out.println((tiempo_fin/1000000)+" milisegundos");
		
		/*for(int i =0;i< matriz.length;i++)
		{
			System.out.print("( ");
			for(int j=0;j<matriz.length;j++)
			{
				System.out.print(matriz[i][j]);
				if(j !=matriz.length -1)
					System.out.print(",");

			}
			System.out.print(" ) \n");
		}*/
	}
}
