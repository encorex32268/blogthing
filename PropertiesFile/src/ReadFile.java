import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadFile {
	
	public static final String TAG = ReadFile.class.getSimpleName();
	
	public ReadFile(String fileName)
	{
		Properties properties = new Properties();
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(fileName);
			properties.load(inputStream);
			String ip = properties.getProperty("IP");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			System.out.println(TAG+ " ip => "+ip);
			System.out.println(TAG+" username => "+username);
			System.out.println(TAG+" password => "+password);
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
