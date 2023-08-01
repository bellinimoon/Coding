package gao_HULL;

public class FwdHullSection extends HullSection {
	
	public FwdHullSection() {
	}

	public FwdHullSection( String starDestroyerType) {
		super("Fwd", starDestroyerType, 900, 100, 75, 350);
		if (starDestroyerType != "Imperial_I") {
			setLength(900);
			setHeight(100);
			setWidth(200);
			setWeight(400);
		}
		
		
	}


}
