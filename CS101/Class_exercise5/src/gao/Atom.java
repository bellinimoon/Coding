package gao;

public class Atom {
	private int size;
	private int weight;
	private Particle[] particles = new Particle[2];
	
	

	public Atom() {
		super();
		Particle P1 = new Particle();
		Particle P2 = new Particle();
		
		this.particles[0] = P1;
		this.particles[1] = P2;
		this.size = P1.getSize()+P2.getSize();
		this.weight = P1.getWeight() + P2.getWeight();
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



	public Particle[] getParticles() {
		return particles;
	}



	public void setParticles(Particle[] particles) {
		this.particles = particles;
	}
	
	public String toString() {
		String st = "The size is " + this.size + " and the weight is " + this.weight;
		return st;
	}
	

}
