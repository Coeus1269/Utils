package PhoneUtils;

import StringUtils.StringUtils;

public class PhoneUtils
{
	
	public String Version_str = "1.230";
	
  public static void main(String[] args) 
	{
	  // Self Tester
	  //PhoneUtils PU = new PhoneUtils();
	  
	  System.out.println("NPA of 18005551212: " + PhoneUtils.getNPA("18005551212"));
	  System.out.println("NPA of  8005551212: " + PhoneUtils.getNPA("8005551212"));
	  System.out.println("NPA of     5551212: " + PhoneUtils.getNPA("5551212"));
	  
	  System.out.println("NXX of 18005551212: " + PhoneUtils.getNXX("18005551212"));
	  System.out.println("NXX of  8005551212: " + PhoneUtils.getNXX("8005551212"));
	  System.out.println("NXX of     5551212: " + PhoneUtils.getNXX("5551212"));
	  
	  System.out.println("is 18005551212 Tollfree number? " + PhoneUtils.isTollFreeNPA("18005551212"));
	  System.out.println("is  8005551212 Tollfree number? " + PhoneUtils.isTollFreeNPA("8005551212"));
	  System.out.println("is     5551212 Tollfree number? " + PhoneUtils.isTollFreeNPA("5551212"));
	  
	  System.out.println("Format 18005551212: " + PhoneUtils.FormatPhoneNumber("18005551212"));
	  System.out.println("Format  8005551212: " + PhoneUtils.FormatPhoneNumber("8005551212"));
	  System.out.println("Format     5551212: " + PhoneUtils.FormatPhoneNumber("5551212"));
	  
	  System.out.println("unFormat 1(800)555-1212: " + PhoneUtils.unFormatPhoneNumber("1(800)555-1212"));
	  System.out.println("unFormat  (800)555-1212: " + PhoneUtils.unFormatPhoneNumber("(800)555-1212"));
	  System.out.println("unFormat       555-1212: " + PhoneUtils.unFormatPhoneNumber("555-1212"));
	  
	  System.out.println("Is DA 1(800)5551212: " + PhoneUtils.isDirectoryAssist("1(800)5551212"));
	  System.out.println("Is DA 18005551212: " + PhoneUtils.isDirectoryAssist("18005551212"));
	  System.out.println("Is DA  8005551212: " + PhoneUtils.isDirectoryAssist("8005551212"));
	  System.out.println("Is DA     5551212: " + PhoneUtils.isDirectoryAssist("5551212"));
	  System.out.println("Is DA     5551212: " + PhoneUtils.isDirectoryAssist("18005561212"));
	  
	  System.out.println("Is valid NPA 18005551212: " + PhoneUtils.isValidNPA("18005551212"));
	  System.out.println("Is valid NPA  8005551212: " + PhoneUtils.isValidNPA("8005551212"));
	  System.out.println("Is valid NPA     5551212: " + PhoneUtils.isValidNPA("5551212"));
	  System.out.println("Is valid NPA  9115551212: " + PhoneUtils.isValidNPA("9115551212"));
	  
	  System.out.println("Is valid NXX 18005551212: " + PhoneUtils.isValidNXX("18005551212"));
	  System.out.println("Is valid NXX  8005551212: " + PhoneUtils.isValidNXX("8005551212"));
	  System.out.println("Is valid NXX     5551212: " + PhoneUtils.isValidNXX("5551212"));
	  System.out.println("Is valid NXX     0551212: " + PhoneUtils.isValidNXX("0551212"));
	}


   public static String stripLeadingZeros(String PhoneNumber_str)
		{
		   PhoneNumber_str = unFormatPhoneNumber(PhoneNumber_str).trim();
		   
			while( PhoneNumber_str.startsWith( "0" ))
				PhoneNumber_str = PhoneNumber_str.substring( 1 );
			
			return PhoneNumber_str;
		}
   
   
   public static boolean isValid10DigitPhoneNumber(String PN)
	   {
	   	// A valid 10 digit Phone Number:
	   	//  has 10 numeric digits, no alpha or symbols
	   	// 	area code or NPA does not contain  911, 411 ,611 or a leading zero
	   	//	the exchange or NXX does not contain  911, 411 ,611 or a leading zero

	   	if (StringUtils.StringNotEmptyAndNotNull(PN)) 
	    	{
	    	PN = unFormatPhoneNumber(PN).trim();
	    	
	    	return PN.matches("^\\d{10}$") && isValidNPA(PN) && isValidNXX(PN);
	    	}
	   	else
	   		return false;
	   }
 
   public static boolean isValid7DigitPhoneNumber(String PN)
	   {
	   	// A valid 7 digit Phone Number:
	   	//  has 7 numeric digits, no alpha or symbols
	   	//	the exchange or NXX does not contain  911, 411 ,611 or a leading zero

	   	if (StringUtils.StringNotEmptyAndNotNull(PN)) 
	    	{	    	
	    	PN = unFormatPhoneNumber(PN).trim();

	    	return PN.matches("^\\d{7}$") && isValidNXX(PN);
	    	}
	   	else
	   		return false;
	   }
 
   public static String unFormatPhoneNumber( String PN )
		{
			if ( StringUtils.StringNotEmptyAndNotNull(PN)) 				//phone != null && !"".equals(phone))
				return PN.replaceAll( "[^0-9]", "" ).trim();
			else
				return "";
		}

   public static String FormatPhoneNumber( String PhoneNumber_str )
	{
	   // when given 19188675309 results in 1 (918) 867-5309
		
		if ( StringUtils.StringNotEmptyAndNotNull(PhoneNumber_str))
		{
			int nxxPos = 0;
			int StartPos=0;
		   
			StringBuffer s = new StringBuffer();

			PhoneNumber_str = unFormatPhoneNumber(PhoneNumber_str).trim();

			if( PhoneNumber_str.length() == 11 )
				{
				StartPos = 1;
				s.append( PhoneNumber_str.substring( 0, 1 ) + " ");
				}
			
			if( PhoneNumber_str.length() > 9 )
				{
				nxxPos = StartPos + 3;
				s.append( "(" + PhoneNumber_str.substring( StartPos, nxxPos ) + ") ");
				}
			
			s.append( PhoneNumber_str.substring( nxxPos, nxxPos + 3 ))
				.append( "-" )
				.append( PhoneNumber_str.substring( nxxPos + 3 ));
			
			return s.toString();
		}

		return "";
	}

   
   public static int length(String PhoneNumber_str)
   	{
       return PhoneNumber_str == null ? 0 : PhoneNumber_str.length();
   	}

   
 /* -------------------------------- Getters & Setters  -------------------------------- */

   public static boolean isTollFreeNPA(String PhoneNumber_str)
	   { 
	   String NPA_str = getNPA(unFormatPhoneNumber(PhoneNumber_str));
	
	   return "800".equals( NPA_str )
	   || "888".equals( NPA_str )
	   || "877".equals( NPA_str )
	   || "866".equals( NPA_str )
	   || "855".equals( NPA_str )
	   || "844".equals( NPA_str )
	   || "833".equals( NPA_str )
	   || "822".equals( NPA_str ); 
	   }
   
   public static String getNPA(String PhoneNumber_str)
	   {   
	   	String PN_str = unFormatPhoneNumber(PhoneNumber_str).trim();
	   	
	   	if (PN_str.length()==11)	
	   		return ( PhoneNumber_str + "   " ).substring( 1, 4 );
	   	
	   	if (PN_str.length()==10)	// area code + 7 digit number
	   		return ( PhoneNumber_str + "   " ).substring( 0, 3 );
	   	else
	   		return "";
	   }

	public static String getNXX(String PhoneNumber_str)
	   { 
	   	String PN_str = unFormatPhoneNumber(PhoneNumber_str).trim();
	   	
	   	if (PN_str.length()==11)	
	   		return ( PhoneNumber_str + "   " ).substring( 4, 7 );
	   	
	   	if (PN_str.length()==10)	// area code + 7 digit number
	   		return ( PhoneNumber_str + "   " ).substring( 3, 6 );
	   	
	   	if (PN_str.length()==7)		//  7 digit number
	   		return ( PhoneNumber_str + "   " ).substring( 0, 3 );
	   	else
	   		return "";
	   }
	
	
	public static boolean is700Number(String PhoneNumber_str)
		{ 
		 return "700".equals( getNPA(unFormatPhoneNumber(PhoneNumber_str)) );
		}
	
	public static boolean is800Number(String PhoneNumber_str)
		{
		return "800".equals( getNPA(unFormatPhoneNumber(PhoneNumber_str)) );
		}
	
	public static boolean is900Number(String PhoneNumber_str)
		{ 
		return "900".equals( getNPA(unFormatPhoneNumber(PhoneNumber_str)) );
		}
	
	
	public static boolean isDirectoryAssist(String PhoneNumber_str)
		{
		    if ( StringUtils.StringNotEmptyAndNotNull(PhoneNumber_str))
		    	{
		    	PhoneNumber_str = unFormatPhoneNumber(PhoneNumber_str);
		    	
		 	   	if (PhoneNumber_str.length()==11)
		 		   return ( PhoneNumber_str.indexOf( "555121" ) == 4 || PhoneNumber_str.indexOf( "411" ) == 4); // 1800555121
		 	   	if (PhoneNumber_str.length()==10)
		 		   return ( PhoneNumber_str.indexOf( "555121" ) == 3 || PhoneNumber_str.indexOf( "411" ) == 3); // 9164115656
		 	   	else
		 		   return ( PhoneNumber_str.indexOf( "555121" ) == 0 || PhoneNumber_str.indexOf( "411") == 0 ); // 411
		    	}
		    
		    return false;
		}
	
	
	public static boolean isValidNXX(String PN_str)
		{
		   String nxx = PhoneUtils.getNXX(PN_str).trim();
		   
		   if(nxx.length() < 3)
			   return false;
		   
		   if ( nxx.indexOf("0") == 0 || nxx.indexOf("1") == 0)					// NPXs do not permit the digits 0 and 1 as the leading digit
			   return false; 											
		   
		   if (nxx.equals("911")  || nxx.equals("411") || nxx.equals("611"))	// Reserved services numbers
			   return false;		
	
		   return true;	   
		}
	
	
	public static boolean isValidNPA(String PN_str)
		{
		   String npa = PhoneUtils.getNPA(PN_str).trim();
		   
		   if(npa.length() < 3)
			   return false;
			   
		   if ( npa.indexOf("0") == 0 || npa.indexOf("1") == 0)					// NPAs do not permit the digits 0 and 1 as the leading digit of an area code
			   return false; 			
		   
		   if (npa.equals("911") || npa.equals("411") || npa.equals("611"))		// Reserved services numbers
			   return false;			
		   
		   return true;
		}
	
	
	public String getNpaNxx(String PhoneNumber_str)
		{
			String NPA_str = getNPA(PhoneNumber_str),
				   NXX_str = getNXX(PhoneNumber_str);
	
//			if ( StringUtils.isEmptyString(NPA_str))
//				NPA_str = "   ";
//	
//			if ( StringUtils.isEmptyString(NXX_str))
//				NXX_str = "   ";
	
			return NPA_str + NXX_str;
		}

   /* ------------------------------ End Getters & Setters  ------------------------------ */
}

