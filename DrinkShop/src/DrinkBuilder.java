
public class DrinkBuilder {

	private String size;
	private String kind;
	private boolean ice;
	private boolean suger;
	
	public DrinkBuilder setSize(String size) {
		this.size = size;
		return this;
	}
	public DrinkBuilder setKind(String kind) {
		this.kind = kind;
		return this;
	}
	public DrinkBuilder setIce(boolean ice) {
		this.ice = ice;
		return this;
	}
	public DrinkBuilder setSuger(boolean suger) {
		this.suger = suger;
		return this;
	}
	
	public Drink build() {
		return new Drink(size,kind,ice,suger);
		
	}
}
