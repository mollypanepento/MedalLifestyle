package medal;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;

public class Cart {
	public static ArrayList<Item> ItemList = new ArrayList<Item>();
	Item Pencils = new Item("Pencils",new ImageIcon("Item pics/Pencils.jpg").getImage(),10,"Stationary","coming soon");
	Item EraserPens = new Item("Eraser Pens (4 Pack)", new ImageIcon("Item pics/EraserPens.jpg").getImage(),15,"Stationary","Coming soon");
	Item PencilCase = new Item("PencilCase", new ImageIcon("Item pics/PencilCase.jpg").getImage(),20,"Stationary","Coming soon");
	Item GelPens = new Item("Gel Pens (6 Pack)", new ImageIcon("Item pics/GelPens.jpg").getImage(),15,"Stationary","Coming soon");
	Item AestheticNotepads = new Item("AestheticNotepads", new ImageIcon("Item pics/AestheticNotepads.jpg").getImage(),20,"Stationary","Coming soon");
	Item WashiTape = new Item("Multi-patter Washi Tape (5 Pack)", new ImageIcon("Item pics/WashiTape.jpg").getImage(),15,"Stationary","Coming soon");
	Item DeskLamp = new Item("DeskLamp", new ImageIcon("Item pics/DeskLamp.jpg").getImage(),25,"Furniture","Coming soon");
	Item ComfyLoungeChair = new Item("Comfy Lounge Chair", new ImageIcon("Item pics/ComfyLoungeChair.jpg").getImage(),45,"Furniture","Coming soon");
	Item CleatNightstand = new Item("Cleat Nightstand", new ImageIcon("Item pics/CleatNightstand.jpg").getImage(),50,"Furniture","Coming soon");
	Item HangingPlant = new Item("HangingPLant", new ImageIcon("Item pics/HangingPlant.jpg").getImage(),20,"Furniture","Coming soon");
	Item Candles = new Item("Candles (3 pack)", new ImageIcon("Item pics/Candles.jpg").getImage(),20,"Furniture","Coming soon");
	Item MakeupMirror = new Item("Makeup Mirror", new ImageIcon("Item pics/MakeupMirror.jpg").getImage(),30,"Furniture","Coming soon");
	Item RomanNumeralClock = new Item("Roman Numer Clock (30 in.)", new ImageIcon("Item pics/RomanNumeralClock.jpg").getImage(),40,"Furniture","Coming soon");
	Item CloudThrowPillow = new Item("Cloud Throw Pillow", new ImageIcon("Item pics/CloudThrowPillow.jpg").getImage(),10,"Furniture","Coming soon");
	Item HandTuftedCarpet = new Item("Hand Tufted Carpet (8x10 ft)", new ImageIcon("Item pics/HandTuftedCarpet.jpg").getImage(),50,"Furniture","Coming soon");
	Item DrawerCabinet = new Item("6 Drawer Cabinet", new ImageIcon("Item pics/6DrawerCabinet.jpg").getImage(),50,"Furniture","Coming soon");
	Item SilverHeartNecklace = new Item("Silver Heart Necklace", new ImageIcon("Item pics/SilverHeartNecklace.jpg").getImage(),15,"Jewelry","Coming soon");
	Item AssortedRings = new Item("Assorted Rings", new ImageIcon("Item pics/AssortedRings.jpg").getImage(),20,"Jewelry","Coming soon");
	Item PearlHeartBracelet = new Item("Pearl Heart Bracelet", new ImageIcon("Item pics/PearlHeartBracelet.jpg").getImage(),10,"Jewelry","Coming soon");
	Item ButterflyEarrings = new Item("Butterfly Earrings", new ImageIcon("Item pics/ButterflyEarrings.jpg").getImage(),15,"Jewelry","Coming soon");
	Item SaturnNecklace = new Item("Saturn Necklace", new ImageIcon("Item pics/SaturnNecklace.jpg").getImage(),20,"Jewelry","Coming soon");
	Item GreenAndPinkRings = new Item("Green and Pink Rings", new ImageIcon("Item pics/GreenAndPinkRings.jpg").getImage(),15,"Jewelry","Coming soon");
	Item BlueCropTop = new Item("Blue Crop Top (Women)", new ImageIcon("Item pics/BlueCropTop.jpg").getImage(),20,"Clothes","Coming soon");
	Item NatureShirtPack = new Item("Nature Shirt Pack (Unisex)", new ImageIcon("Item pics/NatureShirtPack.jpg").getImage(),30,"Clothes","Coming soon");
	Item WhiteQuarterZip = new Item("WhiteQuarterZip (Mens)", new ImageIcon("Item pics/WhiteQuarterZip.jpg").getImage(),30,"Clothes","Coming soon");
	Item BrownCargoPants = new Item("BrownCargoPants", new ImageIcon("Item pics/BrownCargoPants.jpg").getImage(),50,"Clothes","Coming soon");
	Item GreenSweater = new Item("Green Sweater", new ImageIcon("Item pics/GreenSweater.jpg").getImage(),45,"Clothes","Coming soon");
	Item FloralMaxiSkirt = new Item("Floral Maxi Skirt", new ImageIcon("Item pics/FloralMaxiSkirt.jpg").getImage(),35,"Clothes","Coming soon");
	Item GreenCargoPants = new Item("Green Cargo Pants (Mens)", new ImageIcon("Item pics/GreenCargoPants.jpg").getImage(),20,"Clothes","Coming soon");
	Item StripedSweater = new Item("StripedSweater (Mens)", new ImageIcon("Item pics/StripedSweater.jpg").getImage(),30,"Clothes","Coming soon");
	Item BlackOversizedSweatshirt = new Item("Black Oversized Sweatshirt (Unisex)", new ImageIcon("Item pics/BlackSweatshirt.jpg").getImage(),30,"Clothes","Coming soon");
	Item LongSleevedStar = new Item("Long Sleeved Star", new ImageIcon("Item pics/LongSleevedStar.jpg").getImage(),10,"Clothes","Coming soon");
	Item Headphones = new Item("Headphones", new ImageIcon("Item pics/Headphones.PNG").getImage(),40,"Electronics","Coming soon");
	Item FloralAirpodCase = new Item("Floral Airpod Case", new ImageIcon("Item pics/FloralAirpodCase.jpg").getImage(),20,"Electronics","Coming soon");
	Item IphoneCase = new Item("iPhone Case", new ImageIcon("Item pics/IphoneCase.jpg").getImage(),15,"Electronics","Coming soon");
	Item ComputerSleeve = new Item("Computer Sleeve", new ImageIcon("Item pics/ComputerSleeve.jpg").getImage(),30,"Electronics","Coming soon");
	Item IpadCase = new Item("Ipad Case", new ImageIcon("Item pics/IpadCase.jpg").getImage(),45,"Electronics","Coming soon");
	Item RetroDigitalCamera = new Item("Retro Digital Camera", new ImageIcon("Item pics/RetroDigitalCamera.jpg").getImage(),35,"Fitness","Coming soon");
	Item ResistanceBands = new Item("Resistance Bands", new ImageIcon("Item pics/ResistanceBands.jpg").getImage(),20,"Fitness","Coming soon");
	Item ReusableWaterBottles = new Item("Reusable Water Bottles", new ImageIcon("Item pics/ReusableWaterBottles.jpg").getImage(),20,"Fitness","Coming soon");
	Item Weights = new Item("6lb Weights", new ImageIcon("Item pics/6lbWeights.jpg").getImage(),15,"Fitness","Coming soon");
	Item MotivationalWaterBottle = new Item("Motivational Water Bottle", new ImageIcon("Item pics/MotivationalWaterBottle.jpg").getImage(),30,"Fitness","Coming soon");
	Item LilacYogaMat = new Item("Lilac Yoga Mat", new ImageIcon("Item pics/LilacYogaMat.jpg").getImage(),30,"Fitness","Coming soon");
	Item MatchingActiveSet = new Item("MatchingActiveSet", new ImageIcon("Item pics/MatchingActiveSet.jpg").getImage(),55,"Fitness","Coming soon");
	Item QuartzFaceRoller = new Item("QuartzFaceRoller", new ImageIcon("Item pics/QuartzFaceRoller.jpg").getImage(),15,"Skin Care","Coming soon");
	Item MiniSkincareFridge = new Item("Mini Skincare Fridge", new ImageIcon("Item pics/MiniSkincareFridge.jpg").getImage(),30,"Skin Care","Coming soon");
	Item FaceMaskSet = new Item("Face Mask Set", new ImageIcon("Item pics/FaceMaskSet.jpg").getImage(),20,"Skin Care","Coming soon");
	Item MakeupBag = new Item("Makeup Bag", new ImageIcon("Item pics/MakeupBag.jpg").getImage(),20,"Skin Care","Coming soon");
	Item AvocadoFaceMask = new Item("Avocado Face Mask", new ImageIcon("Item pics/AvocadoFaceMask.jpg").getImage(),30,"Skin Care","Coming soon");
	Item SkinCareKit = new Item("Skin Care Kit", new ImageIcon("Item pics/SkinCareKit.jpg").getImage(),35,"Skin Care","Coming soon");
	Item HeartSauceDishes = new Item("Heart Sauce Dishes", new ImageIcon("Item pics/HeartSauceDishes.jpg").getImage(),15,"Kitchen","Coming soon");
	Item CeramicTeaSet = new Item("Ceramic Tea Set", new ImageIcon("Item pics/CeramicTeaSet.jpg").getImage(),30,"Kitchen","Coming soon");
	Item HeartRiceCooker = new Item("Heart Rice Cooker", new ImageIcon("Item pics/HeartRiceCooker.jpg").getImage(),15,"Kitchen","Coming soon");
	Item KitchenContainers = new Item("Kitchen Containers", new ImageIcon("Item pics/KitchenContainers.jpg").getImage(),20,"Kitchen","Coming soon");
	Item CasseroleDish= new Item("Casserole Dish", new ImageIcon("Item pics/CasseroleDish.jpg").getImage(),30,"Kitchen","Coming soon");
	Item ToasterOven= new Item("Toaster Oven", new ImageIcon("Item pics/ToasterOven.jpg").getImage(),50,"Kitchen","Coming soon");

	HashMap <Item, Integer> cartItems = new HashMap <Item, Integer>();
	public Cart() {
		ItemList.add(Pencils);
		ItemList.add(EraserPens);
		ItemList.add(PencilCase);
		ItemList.add(GelPens);
		ItemList.add(AestheticNotepads);
		ItemList.add(WashiTape);
		ItemList.add(DeskLamp);
		ItemList.add(ComfyLoungeChair);
		ItemList.add(CleatNightstand);
		ItemList.add(HangingPlant);
		ItemList.add(Candles);
		ItemList.add(MakeupMirror);
		ItemList.add(RomanNumeralClock);
		ItemList.add(CloudThrowPillow);
		ItemList.add(HandTuftedCarpet);
		ItemList.add(DrawerCabinet);
		ItemList.add(SilverHeartNecklace);
		ItemList.add(AssortedRings);
		ItemList.add(PearlHeartBracelet);
		ItemList.add(ButterflyEarrings);
		ItemList.add(SaturnNecklace);
		ItemList.add(GreenAndPinkRings);
		ItemList.add(BlueCropTop);
		ItemList.add(NatureShirtPack);
		ItemList.add(WhiteQuarterZip);
		ItemList.add(BrownCargoPants);
		ItemList.add(GreenSweater);
		ItemList.add(FloralMaxiSkirt);
		ItemList.add(GreenCargoPants);
		ItemList.add(StripedSweater);
		ItemList.add(BlackOversizedSweatshirt);
		ItemList.add(LongSleevedStar);
		ItemList.add(Headphones);
		ItemList.add(FloralAirpodCase);
		ItemList.add(IphoneCase);
		ItemList.add(ComputerSleeve);
		ItemList.add(IpadCase);
		ItemList.add(RetroDigitalCamera);
		ItemList.add(ResistanceBands);
		ItemList.add(ReusableWaterBottles);
		ItemList.add(Weights);
		ItemList.add(MotivationalWaterBottle);
		ItemList.add(LilacYogaMat);
		ItemList.add(MatchingActiveSet);
		ItemList.add(QuartzFaceRoller);
		ItemList.add(MiniSkincareFridge);
		ItemList.add(FaceMaskSet);
		ItemList.add(MakeupBag);
		ItemList.add(AvocadoFaceMask);
		ItemList.add(SkinCareKit);
		ItemList.add(HeartSauceDishes);
		ItemList.add(CeramicTeaSet);
		ItemList.add(HeartRiceCooker);
		ItemList.add(KitchenContainers);
		ItemList.add(CasseroleDish);
		ItemList.add(ToasterOven);
		
		 for (Item i : ItemList){
			addItem(i,  1);
		}
		
	}
	
	
	
	public void addItem(Item item, Integer amt) {
		cartItems.put(item, amt);
	}
	
	public void setQuantity(Item item, Integer amt) { //is this the way to go
		cartItems.put(item,amt);
	}
	
	public void incQuantityBy1(Item item) {
		cartItems.put(item, cartItems.get(item)+1);
	}
	
	public void decQuantityBy1(Item item) {
		cartItems.put(item, cartItems.get(item)-1);
	}
	
	public HashMap<Item, Integer> getItemsMap() {
		return cartItems;
	}
	
	public Integer getQuantity(Item item) {
		return cartItems.get(item);
	}
	
	public int getTotalAmtOfItems() {
		int total = 0;
		for(Integer i: cartItems.values()) {
			total += i;
		}
		return total;
	}

}
