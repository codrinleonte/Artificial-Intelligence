import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.*;

public class ChatBotDao {

    private Connection con ;

    public ChatBotDao(){
        con = DatabaseConnection.getConnection();
    }

    public List<User> getAllUsersList() throws SQLException {

        List<User> allUsersList=new ArrayList<User>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select*from users");
        while(rs.next()){
            User currentUser = new User();  // create Uses object
            currentUser.setId(rs.getInt(1));            /*exctract user data */
            currentUser.setName(rs.getString(2));
            currentUser.setAge(rs.getInt(3));
            currentUser.setOccupation(rs.getString(4));
            allUsersList.add(currentUser);                                   // add user to List
            currentUser = null;                                         // delete user instance
        }
        return allUsersList;
    }

    public User getUsersbyName(String name) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("select*from users where name = ?");
        stmt.setString(1,name);
        ResultSet rs = stmt.executeQuery();
        User currentUser = new User();  // create Uses object
        if(rs.next()){
            currentUser.setId(rs.getInt(1));            /*exctract user data */
            currentUser.setName(rs.getString(2));
            currentUser.setAge(rs.getInt(3));
            currentUser.setOccupation(rs.getString(4));
        }
        else
            return null;


        return currentUser;

    }


    public int addUser(String name) throws SQLException{

        PreparedStatement stmt = con.prepareStatement("insert into users(name) values(?)");
        stmt.setString(1,name);
        ResultSet rs = stmt.executeQuery();

        return 0;
    }


    public int updateUserAge(String name, int age) throws SQLException{

        PreparedStatement stmt = con.prepareStatement("update users set age = ? where name = ?");
        stmt.setInt(1,age);
        stmt.setString(2,name);
        ResultSet rs = stmt.executeQuery();

        return 0;


    }

    public int updateUserOccupation(String name, String occupation) throws SQLException{

        PreparedStatement stmt = con.prepareStatement("update users set occupation = ? where name = ?");
        stmt.setString(1,occupation);
        stmt.setString(2,name);
        ResultSet rs = stmt.executeQuery();

        return 0;

    }






}
