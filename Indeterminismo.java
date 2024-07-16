package Principal;

public class Indeterminismo extends Thread {
	private static int cont=0;
	
	public void run()
	{
		for(int i=0;i<1000;i++)
		{
			cont++;
		}
	}
	
	public static void main(String[] args)
	{
		Indeterminismo[] vec = new Indeterminismo[1000];
		
		for(int i =0;i<vec.length;i++)
		{
			vec[i]= new Indeterminismo();
			vec[i].start();
		}
		
		try
		{
			for(int i =0;i<vec.length;i++)
			{
				vec[i].join();
			}
		}catch(Exception ex) {}
		System.out.println(cont);
	}

}
