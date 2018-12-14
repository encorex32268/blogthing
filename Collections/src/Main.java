import java.util.ArrayList;
import java.util.Collections;

public class Main {

	static ArrayList<Integer> number = new ArrayList<Integer>();
	public static void main(String[] args) {
        for (int i = 0; i < 10; ++i) {
            number.add(i);
        }
        Collections.sort(number);
        printNumber();
        Collections.reverse(number);
        printNumber();
        Collections.shuffle(number);
        printNumber();
	}
	private static void printNumber() {
		 for (Integer integer : number) {
				System.out.print(" "+integer);
			}
		 System.out.println("");
	}

}
