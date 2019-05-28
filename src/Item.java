import java.util.ArrayList;
public class Item 
{
	String name;
	double price;
	String description;
	int fakePrice;
	int whichDig;
	public Item(String n, double p, String d)
	{
		name = n;
		price = p;
		description = d;
	}
	
	//second constructor for 2 digit items:
	public Item(String n, double p, String d, int fp, int wd)
	{
		name = n;
		price = p;
		description = d;
		fakePrice = fp;
		whichDig = wd; // which one is correct, digit 1 or 2?
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	
	public String getDescription()
	{
		return description;
	}
	public String toString()
	{
		return  getName() + getDescription() ;
	}
	public int getFakePrice()
	{
		return fakePrice;
	}
	public int getWhichDig()
	{
		return whichDig;
	}
	
	public static ArrayList<Item> smallItems = new ArrayList<Item>();
	public static ArrayList<Item> twoDigitItems = new ArrayList<Item>();
	
	public static ArrayList<Item> bigItems = new ArrayList<Item>();
	public static ArrayList<Item> carItems = new ArrayList<Item>();
	public static ArrayList<Item> vacaItems = new ArrayList<Item>();
	public static ArrayList<Item> empty = new ArrayList<Item>();
	
	public static void fillSmallItems()
	{
		smallItems.add(new Item("Rose Bouquet", 14.50, "Courtesy of Stop & Shop."));
		smallItems.add(new Item("Bunch of 3 Bananas", 5.99, "From Stop & Shop."));
		smallItems.add(new Item("Teddy Bear", 8.79, "Big and fluffy!"));
		smallItems.add(new Item("Crest Mint Flavor Toothpaste 2-Pack", 5.49, "Keep your teeth minty fresh with this twin pack of blue toothpaste (12 oz. each)!"));
		smallItems.add(new Item("Baking Soda 4 Lb. Box", 2.19, "Courtesy of Arm & Hammer."));
		smallItems.add(new Item("Medline 5-Inch Black Comb", 5.99, "These classic combs come in three sizes. Firm, but flexible teeth have both wide and narrow spacing."));
		smallItems.add(new Item("Pompeian Balsamic Vinegar 16 Oz. bottle", 3.14, "Imported. Aged in oak casks. Pompeian imported Balsamic Vinegar continues a quality tradition by using only the finest grapes available.")); 
		smallItems.add(new Item("Hellmann's Real Mayonnaise 48 Fl. Oz. Jar", 5.98, "Bring out the best. Per 1 tbsp: 90 calories; 1.5 g sat fat (8% DV); 90 mg sodium (4% DV); 0 g sugars. (Rich in Omega 3 ALA. contains 650 mg ALA per serving; 40% of the 1.6 g daily value of ALA. 100% cage free eggs. Gluten free."));
		smallItems.add(new Item("Windex Glass Cleaner 32 Fl. Oz. Spray Bottle", 3.79, "Glass and multisurface cleaner contains a special glass cleaning formula with exclusive Ammonia-D that leaves glass surfaces sparkling clean with no streaking or film."));
		smallItems.add(new Item("Twin Bell Vintage Metal Alarm Clock", 19.00, "Classic alarm clock made by Crosley."));
		smallItems.add(new Item("Wintergreen Altoid Mints 1.76 Oz. Tin", 2.29, "The original celebrated curiously strong mints. Artificially flavored."));
		smallItems.add(new Item("Science World 12 Inch Diameter Globe", 26.99, "12 inch blue ocean globe with full raised relief is a great tool for grammar school, high school and college students. This lightweight, durable globe sits in a high quality, scratch resistant, smoke black semi-meridian and base."));
		smallItems.add(new Item("Nostalgic Slush Drink Maker", 59.99, "This Nostalgia Electrics Retro Style Slushee Machine will give you a refreshing drink on a hot day and provide a fun addition to your family party or group gathering."));	
	}
	
	public static void fillTwoDigitItems()
	{
		twoDigitItems.add(new Item("Microwave", 65, "You can cook up a quick meal in this 900-watt microwave oven!", 45, 2)); 
		twoDigitItems.add(new Item("2GB iPod Shuffle ", 49, "For songs on the go, just clip on this 2 gig ipod shuffle!", 29, 2)); //29
		twoDigitItems.add(new Item("Pigs in a Blanket Appliance", 25, "You can make up to 9 pigs in a blanket with this non-stick appliance!", 28, 1)); //28
		twoDigitItems.add(new Item("Portable Kettle Smoker", 80, "This portable kettle smoker features a high dome cover and smoking rack!", 60, 2));
		twoDigitItems.add(new Item("Auto on/off Citrus Juicer", 75, "It features a pressure detecting auto on/off switch!", 65, 2));//65
		twoDigitItems.add(new Item("Set of Colorful Teacups", 50, "This is a colorful set of heart-shaped cups and saucers!", 59,1)); //59
		twoDigitItems.add(new Item("4-Slice Toaster Oven", 45, "This toaster oven toasts TOAST!", 25,2)); //25
		twoDigitItems.add(new Item("1600-Watt Iron", 65, "This iron will make you WANT to iron your clothes!", 45, 2)); //45
		twoDigitItems.add(new Item("Waffle Maker", 40, "This heart-shaped waffle maker features a non-stick plate for easy cleanup!", 20, 2));//20
		twoDigitItems.add(new Item("LED Light and Tabletop Fountain", 52, "Add a gentle glow to any space with the LED light on this tabletop fountain!", 82, 2)); // 82
		twoDigitItems.add(new Item("3 qt. Fondue Pot", 30, "Have a dinner party with this 3 qt. fondue pot and 8 forks.", 70, 2)); //70
		twoDigitItems.add(new Item("Cotton Candy Machine", 50, "You can spin cotton candy in a snap with this colorful machine!", 59, 1)); // 59
	}
	
	public static void fillBigItems()
	{

		bigItems.add(new Item("Sony LED Smart HDTV (1080p)", 899.99, "1080p resolution, Motionflow XR 480, Smart TV, Web browser included, ENERGY STAR Certified"));
		bigItems.add(new Item("Alienware Desktop Computer", 3099.99, "16GB memory, 2TB hard drive, 128GB solid state drive, silver"));
		bigItems.add(new Item("Tribecca Home Uptown Modern Sofa", 428.99, "Three (3) thick seat cushion, Solid cushioned back, Materials: Solid Asian rubberwood frame, Wood finish: Espresso or cherry, Upholstery color: Grey linen"));
		bigItems.add(new Item("Nikon D3200 24.2 MP Digital SLR Camera", 446.95, "April 2012 · Nikon D Series · DSLR · Crop Sensor · With Wi-Fi · 24.2 megapixel · CMOS · 3 x optical zoom · Built-in Flash. Featuring 24.2 effective megapixels, the D3200 employs a Nikon-developed DX-format CMOS image sensor."));
		bigItems.add(new Item("Gold Apple iPhone 6 - 64 GB with T-Mobile", 649.92, "iPhone 6 isn't just bigger, it's better in every way. A smooth metal surface seamlessly meets the new retina HD display."));
		bigItems.add(new Item("Black Sapphire Samsung Galaxy S6 - 32GB with T-Mobile", 679.92, "Experience the beautiful, reinvented Galaxy S® 6 – Samsung’s most powerful smartphone. The Next Big Thing Is Here."));
		bigItems.add(new Item("2013-Present Kawasaki Ninja 300 White/Black Design Motorcycle Fairings", 729.10, "NiceCycle brand motorcycle fairings deliver the greatest solution for replacing your motorcycle bodywork! NiceCycle has been and continues to be the industry leader in aftermarket fairings year after year!"));
		bigItems.add(new Item("2 Carat Classic Diamond Ring", 3010.00, "Diamond Ring: Milgrain detailing adds vintage elegance to the micropavé diamonds set across this engagement ring's band. Uniquely hand-cast by expert jewelers."));
	}
	
	public static void fillVacaItems()
	{
		vacaItems.add(new Item("7-Night Eastern Caribbean Cruise", 1718.00, 
				"Set sail from the ports of Miami on this 2-person, 7-night cruise!"));
		vacaItems.add(new Item("7-Days in Berlin, Germany", 5194.00, 
				"Includes flight for two people and a room reserved at the Hotel Meliá Berlin!"));
	}
	
	public static void fillCarItems()
	{
		carItems.add(new Item("Used 2001 Porsche 911", 48995.00, "Has 27,840 miles. A black coupe model. Porsche 911 is an automotive icon, a world-class standard in sports cars."));
		carItems.add(new Item("New 2015 BMW 428i xDrive", 54591.00, "NEW! A black coupe model. EPA city/highway ratings of 22/33 mpg make it the thrifty choice among AWD 4-series coupes"));
		carItems.add(new Item("New 2015 Ford Mustang", 52347.00, "NEW! A black coupe model. The 2015 Ford Mustang brings the iconic pony car into a more fuel-efficient future without sacrificing any of its trademark swagger or performance."));		
		carItems.add(new Item("New 2015 Scion tC", 21295.00, "NEW! A gray coupe model. 2 stars out of 5."));
		carItems.add(new Item("New 2015 Honda Accord", 33340.00, "NEW! A white coupe model. Roomy and high-quality interior; refined and efficient powertrains; quick acceleration; responsive handling; generous standard features; available coupe body style."));
		carItems.add(new Item("New 2014 Nissan LEAF", 35421.00, "NEW! Blue color. This electric car has built-in capabilities with your phone to tell you how much battery your car has left!"));
		carItems.add(new Item("New 2015 Kia Soul", 23549.00, "NEW! A blue electric car model. Wanna be like super-dunker Blake Griffin of the Los Angeles Clippers? With this electric car, you'll have power windows and doorlocks, Bluetooth wireless technology, and 6-speaker audio with USB input!"));
	}
	public static void fillEmpty()
	{
		//empty.add(new Item("nothing", 0.0, " because you lost."));
		empty.add(new Item( " a consolation prize of $1500", 1500.00 ,""));
		
	}
	public static void fillAll()
	{
		fillEmpty();
		fillCarItems();
		fillVacaItems();
		fillBigItems();
		fillTwoDigitItems();
		fillSmallItems();
	}
}