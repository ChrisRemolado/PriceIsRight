
public class Player1 
{
	static int p1Points;
	static String p1Name;// = "";//
	static int p1Discs = 1;
	
	static Item p1PushOverWinnings;// = new Item ("", 0, "");//
	static int p1ContestantsRowWinnings;
	
	
	static int guesses = 4;
	static Item p1Showcase;// = new Item("",0, "");//
	static int showcaseBid, showcaseReal;
	static int p1BigWheelWinnings;
	public static void setPoints(int numPts)
	{
		p1Points += numPts;
		
	}
	
	public static int getPoints()
	{
		return p1Points;
	}
	public static void setName(String n)
	{
		p1Name = n;
	}
	public static String getName()
	{
		return p1Name;
	}
	
	public static int addDisc()
	{
		p1Discs++;
		return p1Discs;
	}
	public static void removeDisc()
	{
		p1Discs--;
	}
	public static int getDisc()
	{
		return p1Discs;
	}
	public static void setContestantsRowWinnings(int w)
	{
		p1ContestantsRowWinnings = w;
	}
	public static int getContestantsRowWinnings()
	{
		return p1ContestantsRowWinnings;
	}
	public static void setPushOverWinnings(Item w)
	{
		p1PushOverWinnings = w;
	}
	public static String getPushOverWinnings()
	{
		return p1PushOverWinnings.getName();
	}
	
	public static void setShowcase(Item s)
	{
		p1Showcase = s;
	}
	
	public static Item getShowcase()
	{
		return p1Showcase;
	}
	public static void setShowcaseBidAndActual(int bid , double actual)
	{
		showcaseBid = bid;
		showcaseReal = (int) actual;
	}
	public static int getShowcaseBid()
	{
		return showcaseBid;
	}
	public static int getReal()
	{
		return showcaseReal;
	}
	public static int getGuesses()
	{
		return guesses;
	}
	public static int removeAGuess()
	{
		guesses--;
		return guesses;
	}
	public static void setBigWheelWinnings(int w)
	{
		p1BigWheelWinnings = w;
	}
	public static int getBigWheelWinnings()
	{
		return p1BigWheelWinnings;
	}
	public void clear()
	{
		p1Points = 0; p1Discs = 1; p1PushOverWinnings = null; p1ContestantsRowWinnings = 0;
		p1Name = null; p1Showcase = null; showcaseBid = 0; showcaseReal = 0;
		p1BigWheelWinnings = 0;
	}
}
