package gao_FACTORY;

import gao_ISD.Imperial_II;
import gao_ISD.StarDestroyer;

public class ISD2_Factory extends ISDFactory {

	public ISD2_Factory() {
	}

	public ISD2_Factory(String name) {
		super(name);
		setBuildType("Imperial II");
	}

	@Override
	public boolean buildISDs(int count) {
		int ct = 901;
		int nt = 0;
		for(int i = 0; i < count; i++) {
			String s = String.format("%03d", nt);
			Imperial_II newCreate = new Imperial_II("ISD-" + ct, "SD -" + s + "_II" );
			setDryDock(newCreate);
			ct ++;
			nt ++;
			}
		return true;
	}

	
	@Override
	public void displayISDs() {
		for(StarDestroyer st: getDryDock()) {
			st.displayInfo();

		}
	}

}
