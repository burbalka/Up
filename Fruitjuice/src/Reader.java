import java.util.*;
import java.io.*;

public class Reader {
	private String filename;

	public Reader(String f)
	{
		filename = f;
	}
		
	public ArrayList<Juice> readFromfile() throws IOException, FileNotFoundException
	{	
		ArrayList<Juice> juices = new ArrayList<Juice>();
		BufferedReader reader = new BufferedReader(
						new FileReader(
							new File("juice.in.txt")
						)
					);
		String line = null;
		while((line = reader.readLine()) != null)
		{
			juices.add(new Juice(line));
		}
		reader.close();
		return juices;
	}
	
}
