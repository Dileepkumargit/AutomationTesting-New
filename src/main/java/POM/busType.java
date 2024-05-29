package POM;

public enum busType {
	
	AC("AC"), NonAC("Non AC"), SEATER("Seater"), SLEEPER("Sleeper");
	
	private String value;
	
	busType (String value){
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
