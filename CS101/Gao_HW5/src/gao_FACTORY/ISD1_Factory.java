package gao_FACTORY;

import gao_ISD.Imperial_I;
import gao_ISD.StarDestroyer;

public class ISD1_Factory extends ISDFactory {

	public ISD1_Factory() {
	}

	public ISD1_Factory(String name) {
		super(name);
		setBuildType("Imperial I");
	}

	@Override
	public boolean buildISDs(int count) {
		int ct = 83;
		int nt = 0;
		for(int i = 0; i < count; i++) {
			String s = String.format("%03d", nt);
			Imperial_I newCreate = new Imperial_I("ISD-" + ct, "SD -" + s + "_I" );
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
