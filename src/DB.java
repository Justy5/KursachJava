import java.sql.Connection;
import java.sql.DriverManager;

class  DB{
     private static Connection connection;
     static Connection getConnection() throws Exception{

        if(connection == null){
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/marmaros","root","");
        }
        if(!connection.isValid(150)){
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/marmaros","root","");
        }
        return connection;
    }
}