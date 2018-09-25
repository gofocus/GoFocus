
import java.sql.*;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by GoFoCus $on 2017/8/16.
 */
public class Test {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    private void connect(String page) throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.88:1521:ora817", "wellhope", "wellhope");
            String sql = "select * from SYS_CODE limit ?,20";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,page);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getString("NAME") + " " + resultSet.getString("CODE"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
          finally {
            if( resultSet!= null)
                resultSet.close();
            if(preparedStatement != null)
                preparedStatement.close();
            if(connection != null)
                connection.close();
        }
    }

    public static void main(String[] args) {
        try {
            new Test().connect(args[0]);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
