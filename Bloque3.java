package Principal;

public class Bloque3 implements Runnable {
	
	@Override
	public void run()
	{
	System.out.println("Hola");
	}
	
	public static void main(String[] args)
	{
		Runnable runnable = new Bloque3();
		runnable.run();
	}
}
