
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		ChatBotDao chatBotDao= new ChatBotDao();
		List<User>allUsersList = chatBotDao.getAllUsersList();
		User user = chatBotDao.getUsersbyName("Codrin");
		System.out.println(chatBotDao.updateUserOccupation("Costel","Cioban"));
	}

	

}
