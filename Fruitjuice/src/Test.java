import java.io.File;


public class Test {
	public static void main(String[] args) {
		try
		{
		Reader reader = new Reader("juice.in.txt");
		Outer out = new Outer(reader.readFromfile());
		out.listOfDiffComps("juice1.out.txt");
		out.listOfCompsInImcreasingOrder("juice2.out.txt");
		out.minNumberOfWashing("juice3.out.txt");		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


}
