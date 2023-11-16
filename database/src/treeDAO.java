import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * Servlet implementation class Connect
 */
@WebServlet("/treeDAO")
public class treeDAO 
{
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public treeDAO(){}
	
	/** 
	 * @see HttpServlet#HttpServlet()
     */
    protected void connect_func() throws SQLException {
    	//uses default connection to the database
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false&user=john&password=pass1234");
            System.out.println(connect);
        }
    }
    
    public boolean database_login(String userName, String password) throws SQLException{
    	try {
    		connect_func("root","pass1234");
    		String sql = "select * from user where user_name = ?";
    		preparedStatement = connect.prepareStatement(sql);
    		preparedStatement.setString(1, userName);
    		ResultSet rs = preparedStatement.executeQuery();
    		return rs.next();
    	}
    	catch(SQLException e) {
    		System.out.println("failed login");
    		return false;
    	}
    }
	//connect to the database 
    public void connect_func(String username, String password) throws SQLException {
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager
  			      .getConnection("jdbc:mysql://127.0.0.1:3306/testdb?"
  			          + "useSSL=false&user=" + username + "&password=" + password);
            System.out.println(connect);
        }
    }
    
    
   
    
    public void insertTree(Tree tree) throws SQLException{
    	connect_func("root","pass1234");         
		String sql = "insert into tree(tree_id,quote_id, size, height, location, nearHouse, note) values (?,?,?,?,?,?,?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		    preparedStatement.setInt(1, tree.gettree_id());
		    preparedStatement.setInt(2, tree.getquote_id());
			preparedStatement.setString(3, tree.getsize());
			preparedStatement.setDouble(4, tree.getheight());
			preparedStatement.setString(5, tree.getlocation());
			preparedStatement.setBoolean(6, tree.getnearHouse());
			preparedStatement.setString(7, tree.getnote());

		preparedStatement.executeUpdate();
        preparedStatement.close();
    	
    }
         
    
    
    
    
    public List<Tree> getTreeID(int quote_id) throws SQLException {
    	Tree tree= null;
    	List<Tree> treeList = new ArrayList<Tree>();
        String sql = "SELECT * FROM tree WHERE quote_id = ?";
         
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setInt(1, quote_id);
         
        ResultSet resultSet = preparedStatement.executeQuery();
        
        while (resultSet.next()) {
        	int tree_id = resultSet.getInt("tree_id");
        	String size = resultSet.getString("size");
        	Double height = resultSet.getDouble("height");
        	String location = resultSet.getString("location");
        	boolean near_house = resultSet.getBoolean("nearHouse");
        	String note = resultSet.getString("note");
        	
        	tree= new Tree(tree_id, quote_id, size, height, location, near_house, note);
        	treeList.add(tree);

        }
        
         
        resultSet.close();
        statement.close();
         
        return treeList;
    }
    
    public int generateID() throws SQLException {
    	int id=0;
    	
    	String sql ="Select MAX(tree_id) as id FROM tree";
    	
    	connect_func();
    	 preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
    	 ResultSet resultSet= preparedStatement.executeQuery();
    	 
    	 if(resultSet.next()) {
    		 id= resultSet.getInt("id");
    	 }
    	 
    	 resultSet.close();
    	 return id+1;
    }

	public List<Tree> listTreesByQuote(int quote_id) throws SQLException {
		Tree tree= null;
    	List<Tree> treeList = new ArrayList<Tree>();
        String sql = "SELECT * FROM tree WHERE quote_id = ?";
         
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setInt(1, quote_id);
         
        ResultSet resultSet = preparedStatement.executeQuery();
        
        while (resultSet.next()) {
        	int tree_id = resultSet.getInt("tree_id");
        	String size = resultSet.getString("size");
        	Double height = resultSet.getDouble("height");
        	String location = resultSet.getString("location");
        	Boolean near_house = resultSet.getBoolean("nearHouse");
        	String note = resultSet.getString("note");
        	
        	tree= new Tree(tree_id, quote_id, size, height, location, near_house, note);
        	treeList.add(tree);

        }
        
         
        resultSet.close();
         
        return treeList;
		
	}


}