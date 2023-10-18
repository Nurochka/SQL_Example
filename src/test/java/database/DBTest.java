package database;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTest {
    DBConnection dbConnection = new DBConnection();

    @Test
    public void insertStudentTest(){
        dbConnection.connect();
        try{
            ResultSet resultSet = dbConnection.selectFrom("students");
            DBConnection.writeResultSet(resultSet);
            dbConnection.executeQuery("insert into students (name, cityId) values ('Vasia', 3)");
            resultSet = dbConnection.selectFrom("students");
            DBConnection.writeResultSet(resultSet);
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
        dbConnection.close();
    }

    @Test
    public void joinTablesTest(){
        dbConnection.connect();
        try{
            ResultSet resultSet = dbConnection.select("select * from students s inner join cities c on s.cityId = c.id where s.cityId = 1");
            DBConnection.writeResultSet(resultSet);
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
        dbConnection.close();
    }

    @Test
    public void rightJoinTablesTest(){
        dbConnection.connect();
        try{
            ResultSet resultSet = dbConnection.select("select * from students s right join cities c on s.cityId = c.id");
            DBConnection.writeResultSet(resultSet);
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
        dbConnection.close();
    }


}
