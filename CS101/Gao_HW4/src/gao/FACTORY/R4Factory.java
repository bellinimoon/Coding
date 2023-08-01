package gao.FACTORY;

import gao.DROID.AstromechDroid;
import gao.DROID.R4;
import gao.INTERFACES.Displayable;

public class R4Factory extends DroidFactory implements Displayable {

	public R4Factory() {
		// TODO Auto-generated constructor stub
	}

	public R4Factory(String factoryID) {
		super(factoryID);
		// TODO Auto-generated constructor stub
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
			R4 newCreate = new R4("R4-" + s);
			setDroidStorage(newCreate);
			ct ++;
			}
		return true;
	}


}
