package gao;

public class Polymer {
	private int size;
	private int weight;
	private Molecule[] molecules = new Molecule[3];
	
	

	public Polymer() {
		super();
		Molecule M1 = new Molecule();
		Molecule M2 = new Molecule();
		Molecule M3 = new Molecule();
		
		this.molecules[0] = M1;
		this.molecules[1] = M2;
		this.molecules[2] = M3;
		this.size = M1.getSize() + M2.getSize() + M3.getSize();
		this.weight = M1.getWeight() + M2.getWeight() + M3.getWeight();
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



	public Molecule[] getMolecules() {
		return molecules;
	}



	public void setMolecules(Molecule[] molecules) {
		this.molecules = molecules;
	}
	public String toString() {
		String st = "The size is " + this.size + " and the weight is " + this.weight;
		return st;
	}
	

}
