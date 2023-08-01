package gao_ENUMS;

public enum TieFighter {
	TieFighter_S("Standard Fighter",15,5,Status.NOT_READY),
	TieFighter_H("Heavy Fighter",20,7,Status.NOT_READY),
	TieFighter_I("Stealth Fighter",10,6,Status.NOT_READY);
	private String TF_type;
	private double TF_length;
	private double TF_width;
	private Status TF_status;
	

	private TieFighter(String tF_type, double tF_length, double tF_width, Status tF_status) {
		TF_type = tF_type;
		TF_length = tF_length;
		TF_width = tF_width;
		TF_status = tF_status;
	}
	public String getTF_type() {
		return TF_type;
	}
	public void setTF_type(String tF_type) {
		TF_type = tF_type;
	}
	public double getTF_length() {
		return TF_length;
	}
	public void setTF_length(double tF_length) {
		TF_length = tF_length;
	}
	public double getTF_width() {
		return TF_width;
	}
	public void setTF_width(double tF_width) {
		TF_width = tF_width;
	}
	public Status getTF_status() {
		return TF_status;
	}
	public void setTF_status(Status tF_status) {
		TF_status = tF_status;
	}

	
	public void ready() {
		setTF_status(Status.READY);
	}
	public void display() {
		System.out.println("Tie Fighter");
		System.out.println("Fighter Type: " + getTF_type());
		System.out.println("Length: " + getTF_length());
		System.out.println("Width: " + getTF_width());
		System.out.println("Status: " + getTF_status());
	}

}
