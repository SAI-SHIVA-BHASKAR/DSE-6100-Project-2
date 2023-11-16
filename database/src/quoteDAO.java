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
import java.sql.Date;
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
@WebServlet("/quoteDAO")
public class quoteDAO 
{
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public quoteDAO(){}
	
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
    
    public boolean delete(String email) throws SQLException {
        String sql = "DELETE FROM User WHERE email = ?";        
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, email);
         
        boolean rowDeleted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowDeleted;     
    }
     
    
    public List<Tree> listTrees() throws Exception{
    	List<Tree> listTree =new ArrayList<Tree>();
    	String sql ="SELECT * from Tree";
    	connect_func();
    	statement = (Statement) connect.createStatement();
    	ResultSet resultSet = statement.executeQuery(sql);
    	
    	
        while(resultSet.next()) {
        	int tree_id = resultSet.getInt("tree_id");
        	int quote_id = resultSet.getInt("quote_id");
        	String size = resultSet.getString("size");
        	Double height = resultSet.getDouble("height");
        	String location = resultSet.getString("location");
        	Boolean near_house = resultSet.getBoolean("near_house");
        	String note = resultSet.getString("note");

            Tree tree = new Tree(tree_id, quote_id, size, height, location, near_house, note);
            listTree.add(tree);
            	
        }
    	resultSet.close();
    	disconnect();
    	return listTree;
    	
    }
    
    
    
    private void disconnect() throws SQLException {
		if (connect != null && !connect.isClosed()) {
			connect.close();
		}
		
	}

	public boolean update(Quote quote) throws SQLException {
        String sql = "update quote_request set price= ?, start_date=?, end_date=?, note=?, status=? WHERE quote_id=?";
        connect_func();
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setDouble(1, quote.getprice());
		preparedStatement.setDate(2, quote.getstart_date());
		preparedStatement.setDate(3, quote.getend_date());
		preparedStatement.setString(4, quote.getnote());
		preparedStatement.setString(5, quote.getstatus());
		preparedStatement.setInt(6, quote.getquote_id());
         
        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowUpdated;     
    }
   
    public boolean updateStatus(int quote_id, String status) throws SQLException {
        String sql = "update quote_request set status=? where quote_id=?";
        connect_func();
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setString(1,status);
		preparedStatement.setInt(2,quote_id);
         
        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowUpdated;     
    }
    
    public boolean negotiation(int quote_id, String status, String note) throws SQLException {
        String sql = "update quote_request set status=?, note=? where quote_id=?";
        connect_func();
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setString(1,status);
		preparedStatement.setString(2,note);
		preparedStatement.setInt(3,quote_id);
         
        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowUpdated;     
    }
    
    
    
    public void insertQuote(Quote quote) throws SQLException{
    	connect_func("root","pass1234");         
		String sql = "insert into Quote_request(quote_id, client_id, propose_date,status, note, price,start_date, end_date) values (?,?,?,?,?,?,?,?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		    preparedStatement.setInt(1, quote.getquote_id());
		    preparedStatement.setInt(2, quote.getclient_id());
			preparedStatement.setDate(3, quote.getpropose_date());
			preparedStatement.setString(4, quote.getstatus());
			preparedStatement.setString(5, quote.getnote());
			preparedStatement.setDouble(6, quote.getprice());
			preparedStatement.setDate(7, quote.getstart_date());
			preparedStatement.setDate(8, quote.getend_date());

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
        	Boolean near_house = resultSet.getBoolean("near_house");
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
    	
    	String sql ="Select MAX(quote_id) as id FROM quote_request";
    		
    		
    	
    	connect_func();
    	 preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
    	 ResultSet resultSet= preparedStatement.executeQuery();
    	 
    	 if(resultSet.next()) {
    		 id= resultSet.getInt("id");
    	 }
    	 
    	 resultSet.close();
    	 return id+1;
    }
    
    public List<Quote> getQuoteViaClientID(int client_id) throws SQLException {
    	List<Quote> quotes = new ArrayList<>();
    	Quote quote=null;
        String sql = "SELECT * FROM quote_request WHERE client_id = ?";
         
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setInt(1, client_id);
         
        ResultSet resultSet = preparedStatement.executeQuery();
        
        while (resultSet.next()) {
        	int quote_id = resultSet.getInt("quote_id");
        	Date propose_date = resultSet.getDate("propose_date");
        	String status = resultSet.getString("status");
        	String note = resultSet.getString("note");
        	Double price = resultSet.getDouble("price");
        	Date start_date = resultSet.getDate("start_date");
        	Date end_date = resultSet.getDate("end_date");
        	
        	
        	quote= new Quote(quote_id, client_id, propose_date, status, note, price, start_date, end_date);
        	quotes.add(quote);

        }
        
         
        resultSet.close();
        return quotes;
    }
    
	public  boolean isValid(int quote_id) throws SQLException{
		int id =0;
	    String sql = "SELECT MAX(quote_id) as id FROM quote_request";
	    connect_func();
	    preparedStatement = (PreparedStatement) connect.prepareStatement(sql);

	    ResultSet resultSet = preparedStatement.executeQuery();
	    if (resultSet.next()) {

	            id = resultSet.getInt("id");

	        }

	      resultSet.close();
	      return id==quote_id;
	
	}
    
  
	public List<Quote> getQuotesByStatus(String status) throws SQLException {
	    List<Quote> quotes = new ArrayList<>();
	    String sql = "SELECT * from quote_request where status = ? or status = 'negotiate'";
	    
	    connect_func();
	    PreparedStatement preparedStatement = connect.prepareStatement(sql);
	        
	        preparedStatement.setString(1, status);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        while (resultSet.next()) {
	                int quote_id = resultSet.getInt("quote_id");
	                int client_id = resultSet.getInt("client_id");
	                Date propose_date = resultSet.getDate("propose_date");
	                String qstatus = resultSet.getString("status");
	                String note = resultSet.getString("note");
	                double price = resultSet.getDouble("price");
	                Date start_date = resultSet.getDate("start_date");
	                Date end_date = resultSet.getDate("end_date");
	                Quote quote = new Quote(quote_id, client_id, propose_date, qstatus, note, price, start_date, end_date);
	                quotes.add(quote);
	        }
	  
        resultSet.close();
	    return quotes;
	}

	public List<Quote> getQuotesByClientId(int clientId) throws SQLException {
	    List<Quote> quotes = new ArrayList<>();
	    String sql = "SELECT * from quote_request where client_id = ?";
	    
	     connect_func();
	     PreparedStatement preparedStatement = connect.prepareStatement(sql);
	        
	        preparedStatement.setInt(1, clientId);
	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            while (resultSet.next()) {
	            	 int quote_id = resultSet.getInt("quote_id");
		             int client_id = resultSet.getInt("client_id");
		             Date propose_date = resultSet.getDate("propose_date");
		             String status = resultSet.getString("status");
		             String note = resultSet.getString("note");
		             double price = resultSet.getDouble("price");
		             Date start_date = resultSet.getDate("start_date");
		             Date end_date = resultSet.getDate("end_date");
	                Quote quote = new Quote(quote_id, client_id, propose_date, status, note, price, start_date, end_date);
	                quotes.add(quote);
	            }
	       
	
        resultSet.close();
	    return quotes;
	        }
	}


	public List<Quote> listAllQuotes() throws SQLException {
		List<Quote> listQuote = new ArrayList<Quote>();        
        String sql = "SELECT * FROM quote_request";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int quote_id = resultSet.getInt("quote_id");
            int client_id = resultSet.getInt("client_id");
            Date propose_date = resultSet.getDate("propose_date");
            String status = resultSet.getString("status");
            String note = resultSet.getString("note");
            Double price = resultSet.getDouble("price");
            Date start_date = resultSet.getDate("start_date");
            Date end_date = resultSet.getDate("end_date");

             
            Quote Quotes = new Quote(quote_id, client_id, propose_date, status,note, price,start_date, end_date);
            listQuote.add(Quotes);
        }        
        resultSet.close();
        disconnect();        
        return listQuote;
    }
	public List<quoteHistory> quoteHistory() throws SQLException {
		List<quoteHistory> listQuote = new ArrayList<quoteHistory>();        
        String sql = "SELECT * FROM quote_response";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int quote_id = resultSet.getInt("quote_id");
            int client_id = resultSet.getInt("client_id");
            Date propose_date = resultSet.getDate("propose_date");
            String status = resultSet.getString("status");
            String note = resultSet.getString("note");
            Double price = resultSet.getDouble("price");
            Date start_date = resultSet.getDate("start_date");
            Date end_date = resultSet.getDate("end_date");

             
            quoteHistory Quotes = new quoteHistory(id, quote_id, client_id, propose_date, status,note, price,start_date, end_date);
            listQuote.add(Quotes);
        }        
        resultSet.close();
        disconnect();        
        return listQuote;
    }       
}
	

