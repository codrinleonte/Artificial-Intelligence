import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class DatabaseConnection {
		private static Connection connection;
		private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
		private static final String USERNAME = "ORACLE";
		private static final String PASSWORD = "ORACLEDBA";

		public DatabaseConnection() {
		}

		public static Connection getConnection() {

			if (connection == null) {
				try {
					//System.out.println("LOADING DRIVER...");

					Class.forName("oracle.jdbc.driver.OracleDriver");
					//System.out.println("DRIVER LOADED...");

					//System.out.println("INITIALIZING CONNECTION...");

					connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
					//System.out.println("CONNECTION INITIALIZED!");
				} catch (ClassNotFoundException e) {
					throw new IllegalStateException("Cannot find the driver in the classpath!", e);
				} catch (SQLException e) {
					throw new IllegalStateException("Cannot connect the database!", e);
				}
			}

			return connection;
		}
	}

