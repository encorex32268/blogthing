import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class WrtieFile {

	
	
	
	public WrtieFile(String fileName)
	{
		Properties properties = new Properties();
		OutputStream outputStream = null;
		
		try {
			outputStream = new FileOutputStream(fileName);
			properties.setProperty("IP", "168.0.0.1");
			properties.setProperty("username", "myData");
			properties.setProperty("password", "p@sswr0d");
			properties.store(outputStream, "my comments");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (outputStream!=null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
}
