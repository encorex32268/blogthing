import java.sql.*;


public class Main {

	private static final String DRIVER="com.mysql.jdbc.Driver";
    private static final String USER="test_root";
    private static final String PASSWORD="root";
    private static final String URL ="jdbc:mysql://localhost:3306/test";
    private static final String SQL = "select * from user";
	public static void main(String[] args) {
		toGet();
	}
	
	 private static void toGet() {

	        try {
	            Class.forName(DRIVER).newInstance();
	            Connection connection = null;
	            connection  = DriverManager.getConnection(URL,USER,PASSWORD);
	            PreparedStatement statement = connection.prepareStatement(SQL);
	            ResultSet  resultSet = statement.executeQuery();
	            while (resultSet.next())
	            {
	                System.out.println(""+resultSet.getString("name"));
	            }

	        } catch (InstantiationException e) {
	            e.printStackTrace();
	        } catch (IllegalAccessException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }


	    }
}
