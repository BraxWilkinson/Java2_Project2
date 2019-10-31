
public class MesoInherit extends MesoAbstract{

	/**
	 * Station ID
	 */
	private String stid = "";
	
	/**
	 * MesoInherit constructor, initializes an object with stid 
	 * @param station
	 */
	public MesoInherit(MesoStation station)
	{
		this.stid = station.getStID();
	}
	
	/**
	 * Calculates the Ascii average of the given station ID.
	 * @return result An array of ints containing the floor, ceiling and rounded Ascii average.
	 */
	public int[] calAverage()
	{
		int[] result = new int[3];
		
		int char1 = stid.charAt(0);
		int char2 = stid.charAt(1);
		int char3 = stid.charAt(2);
		int char4 = stid.charAt(3);
		
		double charAvg = (char1 + char2 + char3 + char4)/4.0;
		result[0] = (int)Math.ceil(charAvg);
		result[1] = (int)Math.floor(charAvg);
		
		double decimalVal = charAvg - (int)charAvg;
		if (decimalVal<.5) {
			result[2] = result[1];
		} else {
			result[2] = result[0];
		}
		return result;
	}
	
	/**
	 * Finds the character associated with the rounded Ascii average from calAverage().
	 * @return result The character associated with the calAverage rounded result.
	 */
	public char letterAverage()
	{
		char result = (char)calAverage()[2];
		return result;
	}
}
