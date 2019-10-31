import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LetterAvg {
	
	/**
	 * String array initialized with a length of 10
	 */
	String[] sameStations = new String[10];
	
	/**
	 * A letter to be used in LetterAvg
	 */
	char letter;
	
	/**
	 * The count
	 */
	int count;
	
	/**
	 * LetterAvg constructor, initializes with letter and numberOfStationWithLetterAvg reader method.
	 * @param letter
	 */
	public LetterAvg(char letter)
	{
		this.letter = letter;
		try {
			numberOfStationWithLetterAvg();
		} catch (IOException e) {
			System.out.println("Unable to read file");
			e.printStackTrace();
		}
	}
	
	/**
	 * Read Mesonet.txt and compare the first letter of the Station IDs to the given letter. 
	 * If the letters are the same, add to the count and put the Station ID in the sameStation array.
	 * @return count The number of stations that start with the given letter.
	 * @throws IOException
	 */
	public int numberOfStationWithLetterAvg() throws IOException
	{
		BufferedReader rd = new BufferedReader(new FileReader("Mesonet.txt"));
		String lineRead = "";
		
		// Skip 3 lines of Mesonet.txt
		lineRead = rd.readLine();
		lineRead = rd.readLine();
		lineRead = rd.readLine();
		
		count=0;
		while(lineRead != null) 
		{
			if (lineRead.charAt(1) == letter) {
				sameStations[count] = lineRead.substring(1,5);
				count++;
			}
			lineRead = rd.readLine();
		}
		rd.close();
		return count;
	}
	
	/**
	 * Overrides the default toString. Prints the stations in the sameStations array.
	 */
	@Override
	public String toString()
	{
		String result = "\nThey are:";
		for (int i=0; i<count; i++)
		{
			result += String.format("\n%s", sameStations[i]);
		}
		return result;
	}
}
