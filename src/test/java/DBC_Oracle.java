import java.sql.*;
import java.util.Properties;

/**
 * This program demonstrates how to make database connection with Oracle
 * database server.
 * @author www.codejava.net
 *
 */
public class DBC_Oracle {

    private Connection connection = null;

    public Connection connect() throws ClassNotFoundException, SQLException {
        // registers Oracle JDBC driver - though this is no longer required
        // since JDBC 4.0, but added here for backward compatibility
        Class.forName("oracle.jdbc.OracleDriver");

        String url = "jdbc:oracle:thin:@//192.168.212.154:1521/XE";
        Driver driver = new oracle.jdbc.OracleDriver();
        DriverManager.registerDriver(driver);

/*
            String dbServer="XE";
            String port="1521";
            String SID="XE";
            String url = "jdbc:oracle:thin:@"+dbServer+":"+port+":"+SID;
*/

        Properties props = new Properties();
        props.put("user", "C##OT");
        props.put("password", "12345");
//        props.put("defaultRowPrefetch", "20");

        try {
            connection = DriverManager.getConnection(url, props);
            if (connection != null) {
                System.out.println("Connected to db");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }

    public int getRegionsCount() {
        String SQL = "select COUNT(region_name) from regions";
        int count = 0;

        try {
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            if (connection != null && !connection.isClosed()) {
                System.out.println("closing connection");
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return count;
    }

    public boolean getComplexDatatable() {
//        String SQL = "SELECT\n" +
//                "    orders.order_id,\n" +
//                "    orders.status,\n" +
//                "    orders.customer_id,\n" +
//                "    products.product_name,\n" +
//                "    orders.order_date,\n" +
//                "    order_items.product_id,\n" +
//                "    order_items.unit_price\n" +
//                "FROM\n" +
//                "         orders\n" +
//                "    INNER JOIN order_items ON orders.order_id = order_items.order_id\n" +
//                "    INNER JOIN products ON order_items.product_id = products.product_id\n" +
//                "WHERE\n" +
//                "        orders.status = 'Shipped'\n" +
//                "    AND ROWNUM < 20\n" +
//                "ORDER BY\n" +
//                "    orders.order_date DESC";
        String SQL = "select * from regions";

        try {
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            ResultSetMetaData metaData = rs.getMetaData();

            int rowCount = metaData.getColumnCount();

            System.out.println("Table Name : " + metaData.getTableName(2));
            System.out.println("Field \tsize\tDataType");

            for (int i = 0; i < rowCount; i++) {
                System.out.print(metaData.getColumnName(i + 1) + " \t");
                System.out.print(metaData.getColumnDisplaySize(i + 1) + "\t");
                System.out.println(metaData.getColumnTypeName(i + 1));
            }

//            rs.next();
//            count = rs.getInt(1);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            if (connection != null && !connection.isClosed()) {
                System.out.println("closing connection");
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
//        return count;
        return false;
    }

    public static void main(String[] args) {
        DBC_Oracle app = new DBC_Oracle();
        int regionsCount = app.getRegionsCount();
        System.out.println(regionsCount);
        System.out.println(app.getComplexDatatable());


    }
}