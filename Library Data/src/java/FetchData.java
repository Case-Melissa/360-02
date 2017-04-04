



import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author Melissa Case
 */
public class FetchData {

    private static Connection connection = null;

    /**
     *
     * @return
     */
    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                Properties prop = new Properties();
                InputStream inputStream = FetchData.class.getClassLoader().getResourceAsStream("/db.properties");
                prop.load(inputStream);
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return connection;
        }

    }
    
    /**
     *
     * @return
     */
    public static ArrayList<Books> getAllBooks() {
    	connection = FetchData.getConnection();
        ArrayList<Books> booksList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from ROOT.BOOKS");
        
            while(rs.next()) {	
            	Books books=new Books();
                books.setId(rs.getInt("id"));
            	books.setCallno(rs.getString("callno"));
            	books.setName(rs.getString("name"));
                books.setAuthor(rs.getString("author"));
                books.setPublisher(rs.getString("publisher"));
                books.setQuantity(rs.getInt("quantity"));
            	books.setIssued(rs.getInt("issued"));
            	books.setAddedDate(rs.getDate("date"));
                books.setGenre(rs.getString("genre"));
            	booksList.add(books);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return booksList;
    }
}