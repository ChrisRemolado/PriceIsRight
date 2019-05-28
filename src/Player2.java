
public class Player2 
{

	static int p2Points;
	
	static String p2Name;//= "";
	static int p2Discs = 1;
	
	static int p2ContestantsRowWinnings;
	static Item p2PushOverWinnings;// = new Item("", 0, "");
	
	static int guesses = 4;
	static Item p2Showcase; //= new Item("", 0, "");
	static int showcaseBid;
	static int showcaseReal;
	static int p2BigWheelWinnings;
	public static void setPoints(int numPts)
	{
		p2Points += numPts;
		
	}
	
	public static int getPoints()
	{
		return p2Points;
	}
	public static void setName(String n)
	{
		p2Name = n;
	}
	public static String getName()
	{
		return p2Name;
	}
	
	
	public static int addDisc()
	{
		p2Discs++;
		return p2Discs;
	}
	public static void removeDisc()
	{
		p2Discs--;
	}
	public static int getDisc()
	{
		return p2Discs;
	}
	public static void setContestantsRowWinnings(int w)
	{
		p2ContestantsRowWinnings = w;
	}
	public static int getContestantsRowWinnings()
	{
		return p2ContestantsRowWinnings;
	}
	public static void setPushOverWinnings(Item w)
	{
		p2PushOverWinnings = w;
	}
	public static String getPushOverWinnings()
	{
		return p2PushOverWinnings.getName();
	}
	

	public static void setShowcase(Item s)
	{
		p2Showcase = s;
	}
	public static Item getShowcase()
	{
		return p2Showcase;
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
		p2BigWheelWinnings = w;
	}
	public static int getBigWheelWinnings()
	{
		return p2BigWheelWinnings;
	}
	public void clear()
	{
		p2Points = 0; p2Discs = 1; p2PushOverWinnings = null; p2ContestantsRowWinnings = 0;
		p2Name = null; p2Showcase = null; showcaseBid = 0; showcaseReal = 0;
		p2BigWheelWinnings = 0;
	}

}
