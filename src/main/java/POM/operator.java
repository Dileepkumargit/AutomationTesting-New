package POM;

public enum operator {
	
	Bus("bus"), Train("train"), Flight("flights");
	
	private String value;
	
	operator(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return value;
	}

}
