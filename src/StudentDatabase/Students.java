package StudentDatabase;
import java.sql.*;
public class Students {
    public static void insert(String last, String first, String email, Connection connection){
        String sql = "insert into students " +
                " (first_name,last_name,email) " +
                " values (?,?,?)";
        try {
            PreparedStatement prepState = connection.prepareStatement(sql);
            prepState.setString(1,first);
            prepState.setString(2,last);
            prepState.setString(3,email);
            prepState.executeUpdate();
            System.out.println("[DATABASE] students updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        print(connection);
    }

    public static void print(Connection connection){
        try {
            Statement statement = connection.createStatement();
            String sql = "select * from students";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                System.out.println(resultSet.getString("id") + " " +
                        resultSet.getString("first_name") + " " +
                        resultSet.getString("last_name") + " " +
                        resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
