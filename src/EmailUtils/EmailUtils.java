package EmailUtils;

import java.util.regex.Pattern;

public class EmailUtils 
	{
	// Still under construction and testing
	//This pattern matches RFC 5322 and covers most email addresses used today:
	Pattern p = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);

	public static void main(String[] args)
	{
		Email email = new Email("wg@domain.com");
		System.out.println(email.toString() + " " + email.getEmailUsername() + " @ " + email.getEmailDomain());
	}
	
	public static boolean isValidEmailAddress(String email) 
		{
		   boolean result = true;
		   try {
		      InternetAddress emailAddr = new InternetAddress(email);
		      emailAddr.validate();
		   } catch (AddressException ex) 
		   		{
			   result = false;
		   		}
		   return result;
		}
	
	/* -------------------------------- Getters & Setters  -------------------------------- */
	
	public String getEmail( )
		{ return email;	}
	
	public void setEmail(String email)
		{ this.email = email; }
	
	public String getEmailDomain( )
		{ return  email.substring(email.indexOf("@") + 1);	}
	
	public String getEmailUsername( )
		{ return  email.substring(0, email.indexOf("@") );	}

	/* ------------------------------ End Getters & Setters  ------------------------------ */
	
	}
