package gao;

public class Particle {
	private int size;
	private int weight;
	
	public Particle() {
		super();
		this.size = 1;
		this.weight = 2;
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
	public String toString() {
		String st = "The size is " + this.size + " and the weight is " + this.weight;
		return st;
	}
	
	

}
