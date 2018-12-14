import java.io.File;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
		ArrayList<String> txtPath = new ArrayList<>();
		String resourcePath = "C:\\Users\\lee_chen\\Desktop\\Example";
		
		txtPath = findOutFile(resourcePath);
		for (String string : txtPath) {
			System.out.println(""+string);
		}
	}

	private static ArrayList<String> findOutFile(String resourcePath) {
		File file = new File(resourcePath);
		ArrayList<String> result = new ArrayList<>();
		if (file.isDirectory()) {
			for(String string : file.list())
			{
				result.addAll(findOutFile(resourcePath+"\\"+string));
			}
			
		}else
		{
			if (resourcePath.contains(".txt")) {
				result.add(resourcePath);
			}
		}
		return result;
		
	}

}
