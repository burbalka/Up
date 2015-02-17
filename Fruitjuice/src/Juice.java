import java.util.*;


public class Juice {
	private ArrayList<String> components = new ArrayList<String>();
	private ArrayList<Juice> children = new ArrayList<Juice>();
	private boolean child = false;
	
	public Juice(String a)
	{
		StringTokenizer str = new StringTokenizer(a);
		while (str.hasMoreTokens())
		{
			this.components.add(str.nextToken());
		}
		metka = 0;
	}

	public void setChild(boolean f)
	{
		child = f;
	}	

	public boolean amIChild()
	{
		return child;
	}
	
	public ArrayList<String> getComponents()
	{
		return (ArrayList<String>) this.components.clone();
	}

	public int numberOfComponents()
	{
		return components.size();
	}

	public void setComponents(ArrayList<String> str)
	{ 
		components = (ArrayList<String>) str.clone();
	}	

	public void addToChildren(Juice j)
	{
		children.add(j);
	}
	
	public boolean isChildren(Juice j)
	{
		return children.contains(j);
	}
}
