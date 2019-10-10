import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PosAvg {
	
	private String stid = "";
	
	private String[] stationArray = new String[5];
	private int arrayElements = 0;
	
	private String avgFirst1;
	private String avgFirst2;
	private String avgSecond1;
	private String avgSecond2;
	
	public PosAvg(String stid)
	{
		this.stid = stid;
		try {
			read("Mesonet.txt");
		} catch (IOException e) {
			System.out.println("Unable to read file");
			e.printStackTrace();
		}
		avgStations();
	}
	
	public int indexOfStation()
	{
		int i=0;
		for (i=0; i<stationArray.length; i++)
		{
			if (stid.equalsIgnoreCase(stationArray[i])) {
				return i;
			}
		}
		return i;
	}
	
	public void read(String filename) throws IOException
	{
		BufferedReader rd = new BufferedReader(new FileReader(filename));
		String lineRead = "";
		
		// Skip 3 lines of Mesonet.txt
		lineRead = rd.readLine();
		lineRead = rd.readLine();
		lineRead = rd.readLine();
		
		int i=0;
		while(lineRead != null) 
		{
			if (stationArray.length <= arrayElements) {
				expandArray();
			}
			stationArray[i] = lineRead.substring(1,5);
			arrayElements++;
			i++;
			lineRead = rd.readLine();
		}
		rd.close();
	}
	
	public void avgStations()
	{
		int index = indexOfStation();
		
		avgFirst1 = stationArray[index-1];
		avgFirst2 = stationArray[index+1];
		avgSecond1 = stationArray[index-2];
		avgSecond2 = stationArray[index+2];
	}
	
	public void expandArray()
	{
		int newCapacity = stationArray.length*2;
		String[] temp = new String[newCapacity];
		for (int i=0; i<stationArray.length; i++)
		{
			temp[i] = stationArray[i];
		}
		stationArray = temp;
	}
	
	public String toString()
	{
		return String.format("This index is average of %s and %s, %s and %s, and so on.", avgFirst1, avgFirst2, avgSecond1, avgSecond2);
	}
}
