package Principal;
//La implementacion de un monitor tiene que tener en cada uno de sus meteodos 
//publicos la sentencia synchronized ya que tiene que garantizar la exclusion mutua a cada uno de sus metodos


public class monitor {
	public int cont =0;
	
	public synchronized void inc()
	{
		for(int i=0;i<20000;i++)
		{
			cont++;
		}
	}
	
	public synchronized int getCont()
	{
		return cont;
	}

}

