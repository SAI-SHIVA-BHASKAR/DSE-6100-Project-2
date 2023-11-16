public class Tree
{
	    protected int tree_id;
	    protected int quote_id;
	 	protected String size;
	    protected double height;
	    protected String location;
	    protected boolean nearHouse;
	    protected String note;
	    
	 
	    //constructors
	    public Tree() {
	    }
	 
	    
	    
	    public Tree(int tree_id, int quote_id,String size,double height, String location, boolean nearHouse, String note) 
	    {
	    	this(quote_id,size,height,location, nearHouse,note);
	    	this.tree_id = tree_id;
	    }
	 
	
	    public Tree(int quote_id,String size,double height, String location, boolean nearHouse, String note) 
	    {
	    	this.quote_id = quote_id;
	    	this.size = size;
	    	this.height = height;
	    	this.location = location;
	        this.nearHouse = nearHouse;
	        this.note = note;
	    }
	    
	   //getter and setter methods
	    public int gettree_id() {
	        return tree_id;
	    }
	    public void settree_is(int tree_id) {
	        this.tree_id = tree_id;
	    }
	    public int getquote_id() {
	        return quote_id;
	    }
	    public void setquote_id(int quote_id) {
	        this.quote_id = quote_id;
	    }
	    public String getsize() {
	        return size;
	    }
	    public void setsize(String size) {
	        this.size = size;
	    }
	    
	    public double getheight() {
	        return height;
	    }
	    public void setheight(double height) {
	        this.height = height;
	    }
	    
	    public String getlocation() {
	        return location;
	    }
	    public void setlocation(String location) {
	        this.location = location;
	    }
	    
	    public boolean getnearHouse() {
	        return nearHouse;
	    }
	    public void setnearHouse(boolean nearHouse) {
	        this.nearHouse = nearHouse;
	    }
	  
	    public String getnote() {
	        return note;
	    }
	    public void setnote(String note) {
	        this.note = note;
	    }
	  
	}
