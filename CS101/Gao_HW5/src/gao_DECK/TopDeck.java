package gao_DECK;

public class TopDeck extends ShipDeck {

	public TopDeck() {
	}

	public TopDeck(String StarDestroyerType) {
		super("TopDeck", StarDestroyerType, 300, 30, 250, 125);
		this.setStarDestroyerType(StarDestroyerType);
		if (StarDestroyerType != "Imperial_I") {
			this.setLength(350);
			this.setHeight(34);
			this.setWidth(300);
			this.setWeight(150);
		}
	}
	
	

}
