package gao_HULL;

public class Hull {
	private String IDNumber;
	private FwdHullSection SectionFWD;
	private AftHullSection SectionAFT;

	public Hull() {
	}

	public Hull(String iDNumber, String StarDestroyerType) {
		this.IDNumber = iDNumber;
		this.SectionFWD = new FwdHullSection(StarDestroyerType);
		this.SectionAFT = new AftHullSection(StarDestroyerType);
	}
	
	public String getIDNumber() {
		return IDNumber;
	}

	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}

	public FwdHullSection getSectionFWD() {
		return SectionFWD;
	}

	public void setSectionFWD(FwdHullSection sectionFWD) {
		SectionFWD = sectionFWD;
	}

	public AftHullSection getSectionAFT() {
		return SectionAFT;
	}

	public void setSectionAFT(AftHullSection sectionAFT) {
		SectionAFT = sectionAFT;
	}

	public void displayHullSpecs() {
		System.out.println("");
		System.out.println("____Hull Specifications____");
		System.out.println("HULL: " + getIDNumber());
		System.out.println("Fwd Hull: Hull Type: " + getSectionFWD().getHullType() + "   Length: " + getSectionFWD().getLength() + "   Height: " + getSectionFWD().getHeight() 
				+ "   Width: " + getSectionFWD().getWidth() + "   Weight: " + getSectionFWD().getWeight());
		System.out.println("Aft Hull: Hull Type: " + getSectionAFT().getHullType() + "   Length: " + getSectionAFT().getLength() + "   Height: " + getSectionAFT().getHeight() 
				+ "   Width: " + getSectionAFT().getWidth() + "   Weight: " + getSectionAFT().getWeight());		
		
	}
	

}
