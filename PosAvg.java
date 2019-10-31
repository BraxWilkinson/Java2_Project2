import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PosAvg {
	
	/**
	 * Station ID
	 */
	private String stid = "";
	
	/**
	 * String array containing station IDs, with an int counter tracking the number of elements 
	 * in the array
	 */
	private String[] stationArray = new String[5];
	private int arrayElements = 0;
	
	/**
	 * The stations before and after the given station in the array
	 */
	private String avgFirst1;
	private String avgFirst2;
	private String avgSecond1;
	private String avgSecond2;
	
	/**
	 * PosAvg constructor, initializes with stid and Mesonet.txt reader
	 * @param stid
	 */
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
	
	/**
	 * Find the index in stationArray of the given station ID
	 * @return i The index
	 */
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
	
	/**
	 * Reader method optimized to read Mesonet.txt
	 * @param filename
	 * @throws IOException
	 */
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
	
	/**
	 * Retrieves the Station IDs of the two stations before and after the given index
	 */
	public void avgStations()
	{
		int index = indexOfStation();
		
		avgFirst1 = stationArray[index-1];
		avgFirst2 = stationArray[index+1];
		avgSecond1 = stationArray[index-2];
		avgSecond2 = stationArray[index+2];
	}
	
	/**
	 * Expand the stationArray if the limit is reached
	 */
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
	
	/**
	 * 
	 */
	@Override
	public String toString()
	{
		return String.format("This index is average of %s and %s, %s and %s, and so on.", avgFirst1, avgFirst2, avgSecond1, avgSecond2);
	}
}
