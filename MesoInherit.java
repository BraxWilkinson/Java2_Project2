
public class MesoInherit{

	private String stid = "";
	
	public MesoInherit(MesoStation station) 
	{
		this.stid = station.getStID();
	}
	
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
		if (decimalVal<.05) {
			result[2] = result[1];
		} else {
			result[2] = result[0];
		}
		return result;
	}
	
	public char letterAverage()
	{
		char result = (char)calAverage()[2];
		return result;
	}
}
