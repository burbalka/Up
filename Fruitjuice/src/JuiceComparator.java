import java.util.*;

public class JuiceComparator implements Comparator<Juice>{
	private Thread t;
	private Juice j;

	public int compare(Juice s1, Juice s2) {
		
		ArrayList<String> str = s1.getComponents();
		MyThread r1 = new MyThread(str);
		
		str = s2.getComponents();
		MyThread r2 = new MyThread(str);
		
		
		new Thread(r1).start();
		new Thread(r2).start();

		s1.setComponents(r1.getComponents());
		s2.setComponents(r2.getComponents());


		if(s1.numberOfComponents() != s2.numberOfComponents())
			return s1.numberOfComponents()-s2.numberOfComponents();
		else
		{
			for(int i=0; i<s1.getComponents().size(); ++i)
				if(!s1.getComponents().get(i).equals(s2.getComponents().get(i)))
					return s1.getComponents().get(i).compareTo(s2.getComponents().get(i));
		}
		return 0;
	}
}


class MyThread implements Runnable
{
	private ArrayList<String> str = new ArrayList<String>();
	
	public MyThread(ArrayList<String> str)
	{	
		this.str = str;
	}
	
	public void run()
	{
		Collections.sort(str);
	}
	
	public ArrayList<String> getComponents()
	{
		return (ArrayList<String>)str.clone();
	}
 }