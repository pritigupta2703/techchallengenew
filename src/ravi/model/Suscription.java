package ravi.model;

public class Suscription {
	

	    private String accountIdentifier ;
	    private String success;

	    public Suscription (String accountIdentifier, String success){
	    	 this.accountIdentifier = accountIdentifier;
		        this.success = success;
	    }

	    public  Suscription ()
	    {
	       
	    }
	    public String getAccountIdentifier() {
	        return accountIdentifier;
	    }

	    public void setAccountIdentifier(String accountIdentifier) {
	        this.accountIdentifier = accountIdentifier;
	    }

	    public String getSuccess() {
	        return success;
	    }

	    public void setSuccess (String success) {
	        this.success = success;
	    }
	}


