package gao;

public class Molecule {
	private int size;
	private int weight;
	private Atom[] atom = new Atom[4];
	
	

	public Molecule() {
		super();
		Atom A1 = new Atom();
		Atom A2 = new Atom();
		Atom A3 = new Atom();
		Atom A4 = new Atom();
		
		this.atom[0] = A1;
		this.atom[1] = A2;
		this.atom[2] = A3;
		this.atom[3] = A4;
		this.size = A1.getSize() + A2.getSize() + A3.getSize() + A4.getSize();
		this.weight = A1.getWeight() + A2.getWeight() + A3.getWeight() + A4.getWeight();
	}



	public int getSize() {
		return size;
	}



	public void setSize(int size) {
		this.size = size;
	}



	public int getWeight() {
		return weight;
	}



	public void setWeight(int weight) {
		this.weight = weight;
	}



	public Atom[] getAtom() {
		return atom;
	}



	public void setAtom(Atom[] atom) {
		this.atom = atom;
	}
	public String toString() {
		String st = "The size is " + this.size + " and the weight is " + this.weight;
		return st;
	}
	

}
