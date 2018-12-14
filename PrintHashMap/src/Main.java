import java.util.HashMap;
import java.util.Map.Entry;

public class Main {
	
	public static void main(String[] args) {

		HashMap<String, Integer> fruits = new HashMap<>();
		fruits.put("Apple", 20);
		fruits.put("Lemon", 10);
		fruits.put("Banana", 30);
		fruits.put("Melon", 55);
		
		for(Entry<String, Integer> tEntry : fruits.entrySet())
		{
			System.out.println("fruit :"+tEntry.getKey() +" Price :"+tEntry.getValue());
		}

		
		
	}

}
