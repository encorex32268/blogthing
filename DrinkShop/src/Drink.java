
public class Drink {

	
	private String size;
	private String kind;
	private boolean ice;
	private boolean suger;
	
	
	
	public Drink(String size, String kind, boolean ice, boolean suger) {
		super();
		this.size = size;
		this.kind = kind;
		this.ice = ice;
		this.suger = suger;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public boolean isIce() {
		return ice;
	}
	public void setIce(boolean ice) {
		this.ice = ice;
	}
	public boolean isSuger() {
		return suger;
	}
	public void setSuger(boolean suger) {
		this.suger = suger;
	}
	@Override
	public String toString() {
		return "Drink [size=" + size + ", kind=" + kind + ", ice=" + ice + ", suger=" + suger + "]";
	}
	
	
	
	
}
