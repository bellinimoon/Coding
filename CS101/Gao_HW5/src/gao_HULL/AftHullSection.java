package gao_HULL;

public class AftHullSection extends HullSection {
	public AftHullSection() {
	}

	public AftHullSection( String starDestroyerType) {
		super("Aft", starDestroyerType, 700, 200, 325, 550);
		
		if (starDestroyerType != "Imperial_I") {
			setLength(900);
			setHeight(275);
			setWidth(300);
			setWeight(700);
		}
	}



}
