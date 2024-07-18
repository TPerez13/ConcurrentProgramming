package Principal;

import java.util.Random;
//Con tal de que simplemente se pueda dar el indeterminsmo => Problemon


//Realizar la multiplicacion de todos los elementos de un vector de enteros por 10

public class SoLIndeterminismo extends Thread {
	private static int tam=8;
	private static int[] vec = new int[tam];
	
	private int ini,fin;
	
	public SoLIndeterminismo(int init_,int fin_)
	{
		this.ini = init_;
		this.fin = fin_;
	}
	
	public void run()
	{
		for(int i=ini;i<fin;i++)
		{
			vec[i]*=10;
		}
	}

	public static void main(String[] args)
	{
		Random rand = new Random(System.nanoTime());
		
		for(int i =0;i<tam;i++)
		{
			vec[i] = rand.nextInt(10);
		}
		
		SoLIndeterminismo mul_h1= new SoLIndeterminismo(0,tam/2);
		SoLIndeterminismo mul_h2= new SoLIndeterminismo(tam/2,tam);
		
		int part2 = tam/2;
		
		mul_h1.start();
		mul_h2.start();
		
		try
		{
			mul_h1.join();
			mul_h2.join();
		}catch(Exception ex) {}
		
		for(int i = 0; i< vec.length;i++)
		{
			System.out.print(vec[i]+" ");
		}	
	}
}//2 hilos 

