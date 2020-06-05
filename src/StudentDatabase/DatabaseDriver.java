package StudentDatabase;

import java.sql.*;

public class DatabaseDriver {
    private static String url,user,password;
    private static void createDriver(String url, String user, String password) throws SQLException {
        Connection connection = DriverManager.getConnection(url,user,password);
        Students.print(connection);
        Students.insert("Nguyen","Stephen","stephen.nguyen@gmail.com",connection);

    }
    public static void main(String [] args) throws SQLException {
       if(args.length != 3){
           System.err.print("Invalid number of inputs\n" +
                   "1. url" +
                   "2. MySQL user" +
                   "3. MySQL password");
       }
       url = args[0];
       user = args[1];
       password = args[2];
       createDriver(url,user,password);
    }

}
