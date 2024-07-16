package Principal;

//Para lanzar hilos se hace desde objetos que heredan de ThreaD

public class principal extends Thread{

	private int id;
	
	public principal(int id)
	{
		this.id=id;
	}
	
	public void run()
	{
		System.out.println("Soy el hilo: "+id);
	}
	
	public static void main(String[] args)
	{
		principal h1= new principal(1);
		principal h2= new principal(2);
		principal h3= new principal(3);
		
		h1.start();//Se crea un nuevo hilo
		h2.start();//Se crea un nuevo hilo
		h3.start();//Se crea un nuevo hilo
		
		System.out.println("Soy el hilo principal");
	}
}
