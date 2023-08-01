package gao_DECK;

public class Bridge extends ShipDeck {
	

	public Bridge(String StarDestroyerType) {
		super( "Bridge", StarDestroyerType,150, 20, 100, 75);
		this.setStarDestroyerType(StarDestroyerType);
		
		if (StarDestroyerType != "Imperial_I") {
			this.setLength(200);
			this.setHeight(22);
			this.setWidth(150);
			this.setWeight(100);
		}
	}

}
