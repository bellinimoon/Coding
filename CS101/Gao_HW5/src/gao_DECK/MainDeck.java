package gao_DECK;

public class MainDeck extends ShipDeck {

	public MainDeck() {
	}

	public MainDeck(String StarDestroyerType) {
		super("MainDeck", StarDestroyerType, 600, 50, 400, 250);
		this.setStarDestroyerType(StarDestroyerType);
		if (StarDestroyerType != "Imperial_I") {
			this.setLength(700);
			this.setHeight(56);
			this.setWidth(450);
			this.setWeight(300);
		}
	}

	
}
