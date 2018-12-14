import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.sound.sampled.Line;

public class Main {

	public static void main(String[] args) {

		writeFile();
		readFile();
	}

	private static void readFile() {
		String outputPath = System.getProperty("user.home");
		String fileName = "FruitList.txt";
		try {
			FileReader fileReader = new FileReader(outputPath+"\\"+fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = "";
			while ( (line = bufferedReader.readLine())!= null ) {
				System.out.println("readline => "+line);
				//TODO you other jobs
			}
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static void writeFile() {
		String outputPath = System.getProperty("user.home");
		String fileName = "FruitList.txt";
		try {
			FileWriter fileWriter = new FileWriter(outputPath+"\\"+fileName);
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append("Apple \n");
			stringBuffer.append("Banana \n" );
			stringBuffer.append("Melon \n");
			stringBuffer.append("pieApple \n");
			fileWriter.write(stringBuffer.toString());
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
