package gao.FACTORY;

import gao.INTERFACES.Displayable;


import gao.DROID.AstromechDroid;
import gao.DROID.R3;

public class R3Factory extends DroidFactory implements Displayable {

	public R3Factory() {
	}

	public R3Factory(String factoryID) {
		super(factoryID);

	}

	@Override
	public void displayAllDroids() {
		for(AstromechDroid a:getDroidStorage()) {
				a.displayDroid();
		}
	}

	@Override
	public boolean buildDroids(int count) {
		int ct = 0;
		for(int i = 0; i < count; i++) {
			String s = String.format("%03d", ct);
			R3 newCreate = new R3("R3-" + s);
			setDroidStorage(newCreate);
			ct ++;
			}
		return true;
	}
}
