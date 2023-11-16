import java.sql.Date;

public class quoteHistory
{
        protected int id;
	    protected int quote_id;
	    protected int client_id;
	 	protected Date propose_date;
	    protected String status;
	    protected String note;
	    protected double price;
	    protected Date start_date;
	    protected Date end_date;
	    
	 
	    //constructors
	    public quoteHistory() {
	    }
	 
	   
	    
	    public quoteHistory(int id,int quote_id,int client_id,Date propose_date,String status, String note, double price, Date start_date, Date end_date) 
	    {
	    	this(quote_id, client_id,propose_date, status, note, price,start_date, end_date);
	    	this.id = id;
	    	
	    
	    }
	    
	    public quoteHistory(int quote_id,int client_id, Date propose_date,String status, String note, double price, Date start_date, Date end_date) 
	    {
	    	this.quote_id = quote_id;
	    	this.client_id = client_id;
	    	this.propose_date = propose_date;
	    	this.status = status;
	    	this.note = note;
	        this.price = price;
	        this.start_date = start_date;
	        this.end_date = end_date;
	    }
	 
	
	    
	    
	   //getter and setter methods
	    public int getid() {
	        return id;
	    }
	    public void setid(int id) {
	        this.id = id;
	    }
	    public int getquote_id() {
	        return quote_id;
	    }
	    public void setquote_id(int quote_id) {
	        this.quote_id = quote_id;
	    }
	    public int getclient_id() {
	        return client_id;
	    }
	    public void setclient_id(int client_id) {
	        this.client_id = client_id;
	    }
	    public Date getpropose_date() {
	        return propose_date;
	    }
	    public void setpropose_date(Date propose_date) {
	        this.propose_date = propose_date;
	    }
	    
	    public String getstatus() {
	        return status;
	    }
	    public void setstatus(String status) {
	        this.status = status;
	    }
	    
	    public String getnote() {
	        return note;
	    }
	    public void setnote(String note) {
	        this.note = note;
	    }
	    
	    public double getprice() {
	        return price;
	    }
	    public void setprice(double price) {
	        this.price = price;
	    }
	  
	    public Date getstart_date() {
	        return start_date;
	    }
	    public void setstart_date(Date start_date) {
	        this.start_date = start_date;
	    }
	    public Date getend_date() {
	        return end_date;
	    }
	    public void setend_date(Date end_date) {
	        this.end_date = end_date;
	    }
	}

