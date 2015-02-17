import java.io.*;
import java.util.*;

public class Outer {
	private ArrayList<Juice> juices = new ArrayList<Juice>();
	
	public Outer(ArrayList<Juice> alj)
	{
		this.juices = (ArrayList<Juice>)alj.clone();
	}
	
	public void listOfDiffComps(String filename) throws IOException, FileNotFoundException
	{
		LinkedHashSet<String> diffComps =
				new LinkedHashSet<String>();
		for(Juice juice: juices)
		{
			for(String component: juice.getComponents())
			{
				diffComps.add(component);
			}
		}

		FileWriter writer = new FileWriter(filename);
		for(String s: diffComps)
		{
			writer.write(s);
		}
		writer.close();	
	}
	
	public void listOfCompsInImcreasingOrder(String filename) throws IOException, FileNotFoundException
	{
		TreeSet<String> sortedComps = new TreeSet<String>();
		for(Juice juice: juices)
		{
			for(String component: juice.getComponents())
			{
				sortedComps.add(component);
			}
		}

		FileWriter writer = new FileWriter(filename);
		for(String s: sortedComps)
		{
			writer.write(s);
		}
		writer.close();	
	}
	
	public void minNumberOfWashing(String filename) throws IOException, FileNotFoundException
	{
		Collections.sort(juices, new JuiceComparator());
	
		int supermin = juices.size();
		
		for(int k=0; k < juices.size()-1; ++k)
		{
			int min = 0;
			int counter = 0;
			for(int i = 0; i< juices.size(); ++i)
			{
				Juice j1 = juices.get(i);
				if(!j1.amIChild())
				{
					++min;
					for(int j= i+1; j < juices.size(); ++j)
					{
						Juice j2 = juices.get(j);
						if(!j1.isChildren(j2) && j2.getComponents().containsAll(j1.getComponents()) && j2.numberOfComponents()>j1.numberOfComponents())
						{
							if(counter<min)
							{
								j1.addToChildren(j2);
								counter= min;
							}
							j2.setChild(true);
							j2 = j1;
						}
					}
				}
			} 
			for(Juice j: juices)
			{
				j.setChild(false);
			}
			if(supermin>min)
				supermin = min;	
			if(supermin<3)	
				break;
		}
		writeMin(supermin, filename);
	}
	
	public void writeMin(int a, String filename)throws IOException, FileNotFoundException
	{
		FileWriter writer = new FileWriter(filename);
		writer.write(a + " ");
		writer.close();	
	}
}
