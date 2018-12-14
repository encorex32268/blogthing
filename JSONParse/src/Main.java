import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main {

	 static ArrayList<Object> mEmployee ;
	
	public static void main(String[] args) {
		mEmployee = new ArrayList<>();
		File mFile = new File("generated.json");
		try {
			FileReader fileReader = new FileReader(mFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = "";
			StringBuffer stringBuffer = new StringBuffer();
			
			while (
					(line = bufferedReader.readLine())!=null 
					) {
				stringBuffer.append(line);
				
			}
			bufferedReader.close();
			
			JSONArray jsonArray = new JSONArray(stringBuffer.toString());
			for(int i = 0 ; i<jsonArray.length();i++)
			{
				JSONObject jsonObject =jsonArray.getJSONObject(i);
				String _id = jsonObject.getString("_id");
				String name = jsonObject.getString("name");
				String gender = jsonObject.getString("gender");
				String email = jsonObject.getString("email");
				String phone = jsonObject.getString("phone");
				String address = jsonObject.getString("address");
				int age = jsonObject.getInt("age");
				Employee employee = new Employee();
				employee.set_id(_id);
				employee.setName(name);
				employee.setGender(gender);
				employee.setEmail(email);
				employee.setPhone(phone);
				employee.setAddress(address);
				employee.setAge(age);
				mEmployee.add(employee);

			}
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("File Not Found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			for (Object employee : mEmployee) {
				System.out.println(""+employee.toString());
			}
		}
		
	}

}
