import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DBC_Class {
    private final String url = "jdbc:postgresql://localhost:5432/dvdrental";
    private final String user = "postgres";
    private final String password = "123";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
    public int getActorCount() {
        String SQL = "SELECT count(*) FROM actor";
        int count = 0;

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return count;
    }

    private void displayActor(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.println(rs.getString("actor_id") + "\t"
                    + rs.getString("first_name") + "\t"
                    + rs.getString("last_name"));

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DBC_Class app = new DBC_Class();
        int actorCount = app.getActorCount();
        System.out.println(actorCount);

    }
}
