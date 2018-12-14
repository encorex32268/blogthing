import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) {

		Date nowDate = new Date();
		System.out.println(""+nowDate.getTime());
		System.out.println(nowDate);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatTime = simpleDateFormat.format(nowDate);
		System.out.println(""+formatTime);
		

		
	}

}
