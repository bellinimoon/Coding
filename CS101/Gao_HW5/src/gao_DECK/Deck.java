package gao_DECK;

public class Deck {
	private String IDNumber;
	private Bridge Deck_Bridge;
	private TopDeck Deck_Top;
	private MainDeck Deck_Main;
	
	public Deck(String iDNumber, String StarDestroyerType) {
		this.IDNumber = iDNumber;
	
		this.Deck_Bridge = new Bridge( StarDestroyerType);
		this.Deck_Top = new TopDeck( StarDestroyerType);
		this.Deck_Main = new MainDeck( StarDestroyerType);
	}

	public String getIDNumber() {
		return IDNumber;
	}

	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}



	public Bridge getDeck_Bridge() {
		return Deck_Bridge;
	}



	public void setDeck_Bridge(Bridge deck_Bridge) {
		Deck_Bridge = deck_Bridge;
	}



	public TopDeck getDeck_Top() {
		return Deck_Top;
	}



	public void setDeck_Top(TopDeck deck_Top) {
		Deck_Top = deck_Top;
	}



	public MainDeck getDeck_Main() {
		return Deck_Main;
	}



	public void setDeck_Main(MainDeck deck_Main) {
		Deck_Main = deck_Main;
	}
	
	public void displayDeckSpecs() {
		System.out.println("");
		System.out.println("____Deck Specifications____");
		System.out.println("DECK: " + getIDNumber());
		System.out.println("Bridge: Deck Type: " +  getDeck_Bridge().getDeckType()+ "   Star Destroyer Type: " +  getDeck_Bridge().getStarDestroyerType()+ "   Length: " +  getDeck_Bridge().getLength() + "   Height: " +  getDeck_Bridge().getHeight() 
				+ "   Width: " +   getDeck_Bridge().getWidth() + "   Weight: " +   getDeck_Bridge().getWeight());
		System.out.println("Top Deck: Deck Type: " + getDeck_Top().getDeckType()+ "   Star Destroyer Type: " + getDeck_Top().getStarDestroyerType()+ "   Length: " +getDeck_Top().getLength() + "   Height: " + getDeck_Top().getHeight() 
				+ "   Width: " +  getDeck_Top().getWidth() + "   Weight: " +  getDeck_Top().getWeight());
		System.out.println("Main Deck: Deck Type: " + getDeck_Main().getDeckType()+ "   Star Destroyer Type: " + getDeck_Main().getStarDestroyerType()+ "   Length: " + getDeck_Main().getLength() + "   Height: " + getDeck_Main().getHeight() 
				+ "   Width: " +  getDeck_Main().getWidth() + "   Weight: " +  getDeck_Main().getWeight());

		
	}


}
