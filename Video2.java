package Principal;

public class Video2 extends Thread {
	private int id;
	
	public Video2(int id)
	{
		this.id=id;
	}
	
	public void run()
	{
		System.out.println("Soy el hilo:"+id);
	}
	
	public static void main(String[] args)
	{
		Video2[] vec = new Video2[5];
				
				for(int i=0;i<vec.length;i++)
				{
					vec[i]= new Video2(i+1);
					vec[i].start();
				}
				
				try {
					for(int i=0;i<vec.length;i++)
					{
						vec[i].join();
					}
				}catch(Exception ex)		
				{}
				
				System.out.println("Soy el hilo principal");
	}

}
