public class Client 
{ 	
	    protected int client_id;
	    protected String firstName;
	    protected String lastName;
	    protected String address;
	    protected String email;
	    protected long phone;
	    protected String credit_card_info;
	    
	    
	 
	    //constructors
	    public Client() {
	    }
	 
	    public Client(String email) 
	    {
	        this.email = email;
	    }
	    
	    public Client(String firstName, String lastName, String address, long phone, String credit_card_info) 
	    {
	    	this.client_id = client_id;
	    	this.firstName = firstName;
	    	this.lastName = lastName;
	    	this.address = address;
	    	this.phone = phone;
	    	this.credit_card_info = credit_card_info;

	    }
	    
	    public Client(int client_id, String firstName, String lastName, String address, long phone, String credit_card_info) 
	    {
	    	this(firstName,lastName,address, phone,credit_card_info);
	    	this.email = email;
	    }
	 
	
	   
	    
	   //getter and setter methods
	    public String getEmail() {
	        return email;
	    }
	    public void setEmail(String email) {
	        this.email = email;
	    }
	    public int getclient_id() {
	        return client_id;
	    }
	    public void setclient_id(int client_id) {
	        this.client_id = client_id;
	    }
	    
	    public String getFirstName() {
	        return firstName;
	    }
	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }
	    
	    public String getLastName() {
	        return lastName;
	    }
	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }
	    
	    public String getaddress() {
	        return address;
	    }
	    public void setaddress(String address) {
	        this.address = address;
	    }
	  
	    public long getphone() {
	        return phone;
	    }
	    public void setrole(long phone) {
	        this.phone = phone;
	    }
	    public String getcredit_card_info() {
	        return credit_card_info;
	    }
	    public void setcredit_card_info(String credit_card_info) {
	        this.credit_card_info = credit_card_info;
	    }
	  
	}