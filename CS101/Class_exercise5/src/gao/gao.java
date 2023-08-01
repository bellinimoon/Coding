package gao;

import java.util.ArrayList;

public class gao {

	public static void main(String[] args) {
		
		ArrayList<Polymer> P = new ArrayList<>();
		for(int i = 0; i < 50; i++) {
			Polymer p =new Polymer();
			P.add(p);
		}
		System.out.println(P.get(0).toString());
		System.out.println(P.get(40).getMolecules()[0].toString());
		System.out.println(P.get(43).getMolecules()[0].getAtom()[0].toString());
		System.out.println(P.get(13).getMolecules()[0].getAtom()[0].getParticles()[0].toString());
	}

}
