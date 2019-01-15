package EmailUtils;

import java.util.regex.Pattern;

public class EmailUtils 
	{
	// Still under construction and testing
	//This pattern matches RFC 5322 and covers most email addresses used today:
	Pattern p = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
	private String eMail_str = "wg@domain.com";
	
	// TODO check for more that one @
	// test domain type i.e. .com .org etc
	
	public static void main(String[] args)
	{
		// Email email = new Email("wg@domain.com");
		EmailUtils eMail = new EmailUtils();
		System.out.println(eMail.getEmail());
		System.out.println(eMail.getEmailUsername() + " @ " + eMail.getEmailDomain());
	}
	
//	public static boolean isValidEmailAddress(String email) 
//		{
//		   boolean result = true;
//		   try {
//		      InternetAddress emailAddr = new InternetAddress(email);
//		      emailAddr.validate();
//		   } catch (AddressException ex) 
//		   		{
//			   result = false;
//		   		}
//		   return result;
//		}
	
	/* -------------------------------- Getters & Setters  -------------------------------- */
	
	public String getEmail( )
		{ return eMail_str;	}
	
	public void setEmail(String email)
		{ eMail_str = email; }
	
	public String getEmailDomain( )
		{ return  eMail_str.substring(eMail_str.indexOf("@") + 1);	}
	
	public String getEmailUsername( )
		{ return  eMail_str.substring(0, eMail_str.indexOf("@") );	}

	/* ------------------------------ End Getters & Setters  ------------------------------ */
	
	}
