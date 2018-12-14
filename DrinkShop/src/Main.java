
public class Main {

	public static void main(String[] args) {

		Drink firstCustomer = new DrinkBuilder()
				.setKind("soda")
				.setSize("medium")
				.setIce(true)
				.setSuger(true)
				.build();
		System.out.println(""+firstCustomer);
		
	}

}
