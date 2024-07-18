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
	//El indeterminismo se evita con la exclusion mutua (solamente puede acceder a la variable)
	//Seccion critica: Aquella parte del codigo donde se va a producir indeterminismo
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
		
		for(int i = 0;i<=1000000;i++)
		{
			if (i == 1000000)
				System.out.println(cont);
				
		}
	
	}
	
	

}
