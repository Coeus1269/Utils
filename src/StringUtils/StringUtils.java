package StringUtils;

import java.io.UnsupportedEncodingException ;
import java.net.URLEncoder ;
// import java.util.regex.Matcher ;
// import java.util.regex.Pattern ;

/**
 * Collection of string utilities
 * 
 * @author will givans
 * @version 1.23
 */

public class StringUtils
{
	private String Version_str = "1.230";
		
	public static void main( String...args )
		{ 	// Self Tester
			System.out.println( "encodeURIComponent: " + StringUtils.encodeURIComponent( "http://someserver.org/lost&found+Other/file with spaces and a ?" ));
			System.out.println("\"Hello\" & GoodBye <> \n   to HTML: " + StringUtils.toHTML("\"Hello\" & GoodBye <> \n"));
			System.out.println("tEsTing TiTle cASE = " + StringUtils.toTitleCase("tEsTing TiTle cASE"));
			System.out.println("Left Pad  X: " + StringUtils.leftPad(" Kisses ", 3, "X", false));
			System.out.println("Right Pad O: " + StringUtils.rightPad("Hugs ", 3, "O", false));
			System.out.println("Strip ass from assassin: " + StringUtils.stripLeading("assassin","ass"));
			System.out.println("Camel case and_Squish : " + StringUtils.camelCaseSquish("Camel Case and Squish"));
			System.out.println("");
			System.out.println("Test input for the following =  W-3!@23 this way");
			System.out.println("LettersSpacesDigitsOnly :  = " + StringUtils.LettersSpacesDigitsOnly("W-3!@23 this way"));
			System.out.println("removeNonDigits         :  = " + StringUtils.removeNonDigits("W-3!@23 this way"));
			System.out.println("removeDigits            :  = " + StringUtils.removeDigits("W-3!@23 this way"));
		}
	
//	public static String removePunctuation(final String str) 
//		{ // If you want to remove specific punctuation from a string, it will probably be best to explicitly remove exactly what you want like
//		 if (str == null || str.length() == 0) 
//		 	{ return ""; } 
//		return str.replaceAll("/[.,\/#!$%\^&\*;:{}=\-_`~()]/g","");
//		}
	
	/**
	 * Removes digits (0-9) from a string
	 * 
	 * @param value_str
	 * @return returns empty string if input is null
	 */
	public static String removeDigits(String value_str) 
		{ if (value_str == null || value_str.length() == 0) 
		 	{ return ""; } 
		return value_str.replaceAll("\\d+", ""); 
		}
	
	/**
	 * Removes everything except digits
	 * 
	 * @param value_str
	 * @return returns empty string if input is null
	 */
	public static String removeNonDigits(String value_str) 
		{ // same as enumValue.replaceAll("[^0-9]","")
		 if (value_str == null || value_str.length() == 0) 
		 	{ return ""; } 
		return value_str.replaceAll("\\D+", ""); 
		}
	
	/**
	 * removes everything in a string except characters, spaces and digits.
	 * 
	 * @param value_str
	 * @return Original string containing only characters, spaces and digits.
	 */
	public static String LettersSpacesDigitsOnly( String value_str )
		{  if ( value_str == null )
				return null;
			
			return value_str.replaceAll( "[^\\w\\d\\s]", "" ).trim();
		}
	
	/**
	 * CamelCases a string and removes spaces and underscore
	 * 
	 * @param value_str
	 * @return InputStringCamelCaseAndSquished
	 * 
	 * Example: camel case this = CamelCaseThis
	 */
	public static String camelCaseSquish( String value_str )
		{   boolean upperCase = true;
			String result = "";
			
			for( int k = 0; k < value_str.length(); k++ )
				{	char c = value_str.charAt( k );
					
					if ( c == ' ' )
						{	upperCase = true;
							continue;
						}
					
					if ( c == '_' )
						{ 	c = value_str.charAt( ++k );
							upperCase = true;
						}
					
					result += ( upperCase ? Character.toUpperCase( c ) : Character.toLowerCase( c ));
					upperCase = false;
				}
			return result;
		}
	
	
	/**
	 * @param value_str
	 * @return if value_str = null or empty returns empty string else - returns value_str trimmed
	 */
	public static String safeTrimEmpty( String value_str )
		{ 	value_str = safeTrimNull( value_str );
			return ( value_str == null ? "" : value_str );
		}
	
	/**
	 * @param value_str
	 * @return if value_str = null or empty returns - null else returns value_str trimmed
	 */
	public static String safeTrimNull( String value_str )
	   { if ( value_str == null)
			return null;
		
	   value_str = value_str.trim();
	   	
	   	if ("".equals( value_str )) 
	   		return null;
	   	
	   	return value_str;
	   }
	

	
	/**
	 * @param value_str
	 * @return if value_str = null or empty string or spaces only string - returns true
	 */
	public static boolean isEmptyString(String value_str)
		{ // if value_str = empty string or null returns true
			return ( value_str == null || value_str.trim().equals( "" ) );
			
		}

	/**
	 * @param value_str		- the string to pad
	 * @param length_int	- the length of the padding
	 * @param pad_str		- the padding string
	 * @param doTrim_bln	- boolean trim the spaces or not
	 * @return				- value_str left padded(pad_str X length_int) + value_str characters
	 * <br><br>
	 * Example: leftPad( " Hi There ", 2, "@", false) <br>
	 *   = @@ Hi There
	 */
	public static String leftPad( String value_str, int length_int, String pad_str, boolean doTrim_bln)
		{ if ( value_str != null)
			{ if (doTrim_bln) // trims src_str
					{ value_str = value_str.trim();	}

			for(int Loop_int = 0 ; Loop_int < length_int ;  Loop_int++ )
				value_str = pad_str + value_str;
			}
			return value_str;
		}
	
	/**
	 * @param value_str		- the string to pad
	 * @param length_int	- the length of the padding
	 * @param pad_str		- the padding string
	 * @param doTrim_bln	- trim the spaces or not
	 * @return				- value_str right padded(pad_str X length_int) + value_str characters
	 * <br><br>
	 * Example: rightPad( " Hi There ", 2, "@", false) <br>
	 *   = Hi There @@ 
	 */
	public static String rightPad( String value_str, int length_int, String pad_str, boolean doTrim_bln)
		{ if ( value_str != null)
			{ if (doTrim_bln) // trims src_str
					{ value_str = value_str.trim();	}

			for(int Loop_int = 0 ; Loop_int < length_int ;  Loop_int++ )
				value_str = value_str + pad_str;
			}
			return value_str;
		}
	
	/**
	 * @param StringToCheck_str
	 * @param StartsWithString_str
	 * @return boolean return if StringToCheck_str starts with StartsWithString_str
	 */
	public static boolean startsWith( String StringToCheck_str, String StartsWithString_str )
		{ return StringToCheck_str == null ? false : StringToCheck_str.startsWith( StartsWithString_str );
		}

	/**
	 * @param Value_str
	 * @return boolean returns true if String is Not Empty And is Not Null
	 */
	public static boolean StringNotEmptyAndNotNull(String Value_str)
	   { return (Value_str != null)
	   		&& (!"".equals(Value_str));
	   }
	
	/**
	 * converts certain characters to HTML safe Character entity
	 * 
	 * @param content
	 * @return string where certain characters are converted to HTML safe
	 */
	public static String toHTML( String content )
		{ if ( content == null )
				return "";
	
			StringBuffer sb = new StringBuffer( content.length() );
			
			int len = content.length();
			char c;
	
			for ( int i = 0; i < len; i++ )
				{  c = content.charAt( i );
	
					// HTML Special Chars
					if ( c == '"' )
						sb.append( "&quot;" );
					
					else 
					if ( c == '&' )
						sb.append( "&amp;" );
					
					else 
					if ( c == '<' )
						sb.append( "&lt;" );
					
					else 
					if ( c == '>' )
						sb.append( "&gt;" );
					
					else 
					if ( c == '\n' )
						sb.append( "<br>" );
					
//					else
//					if ( c == '\r' )
//						;	// do nothing
					
					else
						{ int ci = 0xffff & c;
						
						if ( ci < 160 )
							sb.append( c );
						
						else
							{ // Not 7 Bit use the unicode system
							sb.append( "&#" );
							sb.append( new Integer( ci ).toString() );
							sb.append( ';' );
							}
						}
				}
			
			return sb.toString();
		}
	
	/**
	 * encodes certain characters to URL safe entity
	 * @param String_str
	 * @return converted String
	 * 
	 * Converted URL compliant characters: [space], !, ', (, ), ~, :, /
	 */
	public static String encodeURIComponent(String String_str) 
		{ String result;
	
		    try 
		    	{ result = URLEncoder.encode(String_str, "UTF-8")
		                .replaceAll("\\+", "%20")
		                .replaceAll("\\%21", "!")
		                .replaceAll("\\%27", "'")
		                .replaceAll("\\%28", "(")
		                .replaceAll("\\%29", ")")
		                .replaceAll("\\%7E", "~")
		                .replaceAll( "\\%3A", ":" )
		                .replaceAll( "\\%2F", "/" );
		    	} 

		    catch (UnsupportedEncodingException e) 
		    	{ result = String_str;  }

		    return result;
		}
	
	/**
	 *  Converts a string to Title Case
	 * 
	 * @param String_str
	 * @return string converted to title case i.e. tiTle cASE = Title Case
	 * 
	 * credit to scottb on https://stackoverflow.com/questions/1086123/string-conversion-to-title-case
	 * will not work with specialized rules, eg. surnames such as McNamara or MacDonald.
	 * issue with street address parts like nw, se etc.
	 */
	public static String toTitleCase(String String_str) 
		{  final String ACTIONABLE_DELIMITERS = " -/"; // these cause the character following to be capitalized
	
		    StringBuilder sb = new StringBuilder();
		    boolean capNext = true;
	
		    for (char c : String_str.toCharArray()) 
		    	{ c = (capNext)
		                ? Character.toUpperCase(c)
		                : Character.toLowerCase(c);
		        sb.append(c);
		        capNext = (ACTIONABLE_DELIMITERS.indexOf((int) c) >= 0); // explicit cast not needed
		    	}
	
		    return sb.toString();
		}
	
	
	/**
	 * @param Value_str 	- the string to process
	 * @param ToStrip_str 	- string to remove
	 * @return String ToStrip_str removed from the front of Value_str
	 */
	public static String stripLeading(String Value_str, String ToStrip_str)
		{while( Value_str.startsWith( ToStrip_str ))
				Value_str = Value_str.substring( ToStrip_str.length() );

			return Value_str;
		}
	
	/**
	 * Converts a string to a float
	 * 
	 * @param percentInput_str
	 * @return string converted to a float
	 */
	public static Float stringToPercent(String percentInput_str)  // throws TransactionException
	{
		Float percent_flt = null;

		try{
			String cleaned_str = percentInput_str.replaceAll("\\D|^[\\.]","");
			
			percent_flt = ( Float.valueOf( cleaned_str ) / 100 );
			
			}
		catch(Exception e)
			{
				// throw new TransactionException("Invalid percent format");
			}
		
		return percent_flt;
	}

	/**
	 * scrubs a string and replaces any tabs or newlines with spaces, making the value safe for tab delimited output
	 * 
	 * @param String_str
	 * @return String
	 */
	public static String scrubForTabs(String String_str)
		{
		return String_str.replaceAll("\t"," ").replaceAll("\n"," ").replaceAll("\r"," ");
		}


	
    /* -------------------------------- Getters & Setters  -------------------------------- */

   public String getVersion()
   	{ return Version_str; 	}

    /* ------------------------------ End Getters & Setters  ------------------------------ */
}


