package gao_HULL;

public abstract class HullSection {
	
	private String HullType;
	private String StarDestroyerType;
	private int Length;
	private int Height;
	private int Width;
	private int Weight;
	
	

	public HullSection(String hullType, String starDestroyerType, int length, int height, int width, int weight) {
		HullType = hullType;
		StarDestroyerType = starDestroyerType;
		Length = length;
		Height = height;
		Width = width;
		Weight = weight;
	}
	public HullSection() {
	}
	
	public String HullInfo() {
		return HullType;
		
	};
	
	
	public String getHullType() {
		return HullType;
	}
	public void setHullType(String hullType) {
		HullType = hullType;
	}
	public String getStarDestroyerType() {
		return StarDestroyerType;
	}
	public void setStarDestroyerType(String starDestroyerType) {
		StarDestroyerType = starDestroyerType;
	}
	public int getLength() {
		return Length;
	}
	public void setLength(int length) {
		Length = length;
	}
	public int getHeight() {
		return Height;
	}
	public void setHeight(int height) {
		Height = height;
	}
	public int getWidth() {
		return Width;
	}
	public void setWidth(int width) {
		Width = width;
	}
	public int getWeight() {
		return Weight;
	}
	public void setWeight(int weight) {
		Weight = weight;
	}

}
