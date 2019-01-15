package EmailUtils;

import java.util.regex.Pattern;

public class EmailUtils 
	{
	//This site suggests that the following pattern matches RFC 5322 and covers most email addresses used today:
	Pattern p = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);

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
	
	}
