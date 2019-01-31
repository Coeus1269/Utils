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
	String Version_str = "1.230";
	
	private StringUtils()
		{
		}
	
	public static void main( String...args )
		{ 	// Self Tester
			System.out.println( "encodeURIComponent: " +encodeURIComponent( "http://someserver.org/lost+found/file with spaces and a ?" ));
			System.out.println("to HTML: " + toHTML("\"Hello\" & GoodBye <> \n"));
			System.out.println(toTitleCase("tEsTing TiTle cASE"));
			System.out.println("Left Pad X: " + leftPad(" Kisses ", 3, "X", false));
			System.out.println("Right Pad O: " + rightPad(" Hugs ", 3, "O", false));
			System.out.println("Strip ass from assassin: " + stripLeading("assassin","ass"));
			System.out.println("Camel case and_Squish : " + camelCaseSquish("Camel Case and Squish"));
			System.out.println("                          W-3!@23 this way");
			System.out.println("LettersSpacesDigitsOnly :  = " + LettersSpacesDigitsOnly("W-3!@23 this way"));
			System.out.println("removeNonDigits         :  = " + removeNonDigits("W-3!@23 this way"));
			System.out.println("removeDigits            :  = " + removeDigits("W-3!@23 this way"));
		}
	
//	public static String removePunctuation(final String str) 
//		{ // If you want to remove specific punctuation from a string, it will probably be best to explicitly remove exactly what you want like
//		 if (str == null || str.length() == 0) 
//		 	{ return ""; } 
//		return str.replaceAll("/[.,\/#!$%\^&\*;:{}=\-_`~()]/g","");
//		}
	
	public static String removeDigits(final String str) 
		{ if (str == null || str.length() == 0) 
		 	{ return ""; } 
		return str.replaceAll("\\d+", ""); 
		}
	
	public static String removeNonDigits(final String str) 
		{ // same as enumValue.replaceAll("[^0-9]","")
		 if (str == null || str.length() == 0) 
		 	{ return ""; } 
		return str.replaceAll("\\D+", ""); 
		}
	
	
	public static String LettersSpacesDigitsOnly( String src_str )
		{  // removes everything except words, spaces and digits.
			
			if ( src_str == null )
				return null;
			
			return src_str.replaceAll( "[^\\w\\d\\s]", "" ).trim();
		}
	
	public static String camelCaseSquish( String src_str )
		{   // CamelCases a string and removes spaces
			// camel case this = CamelCaseThis
			// removes spaces and underscore
			
			boolean upperCase = true;
			String result = "";
			
			for( int k = 0; k < src_str.length(); k++ )
				{	char c = src_str.charAt( k );
					
					if ( c == ' ' )
						{	upperCase = true;
							continue;
						}
					
					if ( c == '_' )
						{ 	c = src_str.charAt( ++k );
							upperCase = true;
						}
					
					result += ( upperCase ? Character.toUpperCase( c ) : Character.toLowerCase( c ));
					upperCase = false;
				}
			return result;
		}
	
	/**
	 * 
	 * @param src
	 * @return if scr = null or empty returns null else returns src trimmed
	 */
	public static String safeSet( String src )
	   { if ( "null".equals( src ))
			return null;
		
   		src = src.trim();
	   	
	   	if ("".equals( src )) 
	   		return null;
	   	
	   	return src;
	   }
	
	/**
	 * 
	 * @param src
	 * @return if scr = null or empty returns empty string else returns src trimmed
	 */
	public static String safeNull( String src )
		{ 	src = safeSet( src );
			return ( src == null ? "" : src );
		}
	
	public static boolean isEmptyString(String value_str)
		{ // if value_str = empty string or null returns true
			return ( value_str == null || value_str.trim().equals( "" ) );
			
		}

	/**
	 * 
	 * @param src_str 		- the string to pad
	 * @param length_int	- the length of the padding
	 * @param pad_str		- the padding string
	 * @param doTrim_b		- trim the blank spaces or not
	 * @return				- src_str left padded(length_int x pad_str) + src_str characters
	 */
	public static String leftPad( String src_str, int length_int, String pad_str, boolean doTrim_b)
		{ if ( src_str != null)
			{ if (doTrim_b) // trims src_str
					{ src_str = src_str.trim();	}
				
					// while ( src_str.length() < length_int )
					for(int Loop_int = 0 ; Loop_int < length_int ;  Loop_int++ )
						src_str = pad_str + src_str;
			}
			return src_str;
		}
	
	/**
	 * 
	 * @param src_str 		- the string to pad
	 * @param length_int	- the length of the padding
	 * @param pad_str		- the padding string
	 * @param doTrim_b		- trim the blank spaces or not
	 * @return				- src_str right padded(length_int x pad_str) + src_str characters
	 */
	public static String rightPad( String src_str, int length_int, String pad_str, boolean doTrim_b )
		{ // right pads src_str to  src_str + (length_int x pad_str) characters
		// doTrim_b =  trim src_str or not
		
		if ( src_str != null)
			{ if (doTrim_b) // trims src_str
				{ src_str = src_str.trim(); }
			
				for(int Loop_int = 0 ; Loop_int < length_int ;  Loop_int++ )
					src_str = src_str + pad_str;
			}
			return src_str;
		}
	
	/**
	 * 
	 * @param StringToCheck
	 * @param StartsWithString
	 * @return boolean return if StringToCheck starts with StartsWithString
	 */
	public static boolean startsWith( String StringToCheck_str, String StartsWithString_str )
		{ return StringToCheck_str == null ? false : StringToCheck_str.startsWith( StartsWithString_str );
		}

	/**
	 * 
	 * @param Value_str
	 * @return boolean if String is Not Empty And is Not Null
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
	 * @param s
	 * @return
	 */
	public static String encodeURIComponent(String s) 
		{ String result;
	
		    try 
		    	{ result = URLEncoder.encode(s, "UTF-8")
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
		    	{ result = s;  }

		    return result;
		}
	
	/**
	 * credit to scottb on https://stackoverflow.com/questions/1086123/string-conversion-to-title-case
	 * will not work with specialized rules, eg. surnames such as McNamara or MacDonald.
	 * TODO: issue with street address parts like nw, se etc.
	 * 
	 * @param String_str
	 * @return string converted to title case i.e. tiTle cASE = Title Case
	 */
	public static String toTitleCase(String String_str) 
		{  final String ACTIONABLE_DELIMITERS = " -/"; // these cause the character following
		                                                 // to be capitalized
	
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
	 * Strip ToStrip_str from the front of Value_str
	 * 
	 * @param Value_str - the string to process
	 * @param ToStrip_str - string to remove
	 * @return ToStrip_str from the front of Value_str
	 */
	public static String stripLeading(String Value_str, String ToStrip_str)
		{while( Value_str.startsWith( ToStrip_str ))
				Value_str = Value_str.substring( ToStrip_str.length() );

			return Value_str;
		}
	
	
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

	
	// scrubs a string and replaces any tabs or newlines with spaces, making the value safe for tab delimited output
	public static String scrubForTabs(String String_str)
		{
		return String_str.replaceAll("\t"," ").replaceAll("\n"," ").replaceAll("\r"," ");
		}


	
	/* -------------------------------- Getters & Setters  -------------------------------- */



	/* ------------------------------ End Getters & Setters  ------------------------------ */
}


