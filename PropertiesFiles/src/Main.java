import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Main {

	public static void main(String[] args) {
		
		Properties properties = new Properties();
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream("DBInfo.properties");
			properties.load(inputStream);
			String ip = properties.getProperty("IP");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			System.out.println("ip => "+ip);
			System.out.println("username => "+username);
			System.out.println("password => "+password);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
