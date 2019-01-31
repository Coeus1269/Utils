package DateUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// import java.util.HashMap;

// import lombok.Data;
// import lombok.Getter;
// import lombok.Setter;

// Java 1.8 packages
// import java.time.LocalDate;
// import java.time.format.DateTimeFormatter;
// import java.time.ZoneId;

public class DateUtils 
{
	public String Version_str = "1.230";
	
	private static DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd"); 
	private static Calendar cal = Calendar.getInstance();
	// public static final String	DEFAULT_DATETIME_FORMAT	= "yyyy-MM-dd hh:mm",
	// 								DEFAULT_DATE_FORMAT 	= "yyyy-MM-dd";
	// private static HashMap<String,String> calendarFormats = new HashMap<String,String>();	
		
	public static void main(String[] args) 
		{ // SELF TESTER
			
		System.out.println(cal.getTime());
		System.out.println("2 Years Ago " + DateUtils.nYearsAgo(2).getTime());
		System.out.println("2 Months Ago " + DateUtils.nMonthsAgo(2).getTime());
		System.out.println("First Day of this year " + DateUtils.FirstDayOfThisYear().getTime());
		
	
		}
	
	public static Calendar FirstDayOfThisYear()
		{   Date myDate = new Date();
			cal.setTime(myDate);
			
			cal.set(Calendar.MONTH, 0);
			cal.set(Calendar.DAY_OF_MONTH, 1);
	        
	        return cal;
		}	
	
	public static Calendar nYearsAgo( int YearsAgo_int)
		{ return nYearsAgo(cal,YearsAgo_int);	}
	
	public static Calendar nYearsAgo(Calendar myCal, int YearsAgo_int)
		{ Calendar Tempcal = (Calendar) myCal.clone();
		Tempcal.add(Calendar.YEAR, (-1*YearsAgo_int));
          return Tempcal;
		}
	
	
	public static Calendar nMonthsAgo( int MonthsAgo_int)
		{ return nMonthsAgo(cal,MonthsAgo_int); }
	
	public static Calendar nMonthsAgo(Calendar myCal, int MonthsAgo_int)
		{ Calendar Tempcal = (Calendar) myCal.clone();
		Tempcal.add(Calendar.MONTH, (-1*MonthsAgo_int));
          return Tempcal;
		}
	

	/************************************ To Calendar ********************************************************/
	
	public static Calendar toCalendar( int year, int month, int day )
		{
			Calendar calendar = null ;
			
			calendar = Calendar.getInstance();
			calendar.setTimeInMillis( 0 );
			
			calendar.set( Calendar.YEAR, year );
			calendar.set( Calendar.MONTH, month );
			calendar.set( Calendar.DATE, day );
			
			return calendar ;
		}
	
	
	/************************************** Under Construction ******************************************************/
	public interface DateFormats
		{
			static final String SQL = "SQL";
		}
	
	/**
	 * Pre-defined date formats:
	 *  format name      format
	 *  -----------    -------------------------
	 *   SQL	       yyyy-MM-dd HH:mm:ss.SSS
	 *
	 */
//	public DateUtils()
//	    {  	calendarFormats.clear();
//	    	calendarFormats.put( DateFormats.SQL, "yyyy-MM-dd HH:mm:ss.SSS" );    	
//	    }

		
//		public static Calendar StringToCalendar(String StringDate)
//		{
//			// Make sure to set the class dateFormat to the format the is in use for the string date
//			Calendar cal = Calendar.getInstance();
//			StringDate = StringDate.trim();
//
//			try 
//				{
//				LocalDate LD = getCleanDate(StringDate);
//					if (LD != null )
//						{
//						//System.out.println("DateUtils.StringToCalendar parse " + dateFormat.parse(StringDate));
//						// dateFormat = new SimpleDateFormat("MM/dd/yy");
//						// System.out.println("DateUtils.StringToCalendar parse MM/dd/YY " + dateFormat.parse(StringDate));
//						
//						cal.setTime(Date.from(LD.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
//						return cal;
//						}
////					else
////						debug("DateUtils.StringToCalendar - error converting string to date:");
//				} 
//			catch (Exception e) 
//				{
//					System.out.println("DateUtils.StringToCalendar - error converting string to date: ");
//					//e.getStackTrace());
//				}
//			return null;
//		}
		
		
		
//		private static LocalDate getCleanDate(String date)
//		{
//			DateTimeFormatter a = DateTimeFormatter.ofPattern("MM/dd/yyyy h;mm"), //06/20/2018 1;00
//							  b = DateTimeFormatter.ofPattern("MM/dd/yyyy hh;mm"), //06/20/2018 10;00
//							  c = DateTimeFormatter.ofPattern("MM/dd/yyyy"), //06/20/2018 10;00
//						      d = DateTimeFormatter.ofPattern("MM/dd/yyyy"),
//						      e = DateTimeFormatter.ofPattern("MM/dd/yy"),
//						      f = DateTimeFormatter.ofPattern("M/dd/yy"),
//						      g = DateTimeFormatter.ofPattern("M/d/yy");
//			
//			LocalDate cleanDate = LocalDate.parse("01/01/2100 12;00", a);
//			
//			if( date != null && date.isEmpty() == false )
//			{
//				try
//				{
//					date = date.replace(" @ ", "");
//					cleanDate = LocalDate.parse(date, a);
//				}
//				catch( Exception ex )
//				{
//					try
//					{
//						cleanDate = LocalDate.parse(date,  b);
//					}
//					catch( Exception ex2 )
//					{	
//						try
//						{
//							cleanDate = LocalDate.parse(date,  c);
//						}
//						catch( Exception ex3 )
//						{
//							try
//							{
//								cleanDate = LocalDate.parse(date,  d);
//							}
//							catch( Exception ex4 )
//							{	
//								try
//								{
//									cleanDate = LocalDate.parse(date,  e);
//								}
//								catch( Exception ex5 )
//								{	
//									try
//									{
//										cleanDate = LocalDate.parse(date,  f);
//									}
//									catch( Exception ex6 )
//									{			
//										try
//										{
//											cleanDate = LocalDate.parse(date,  g);
//										}
//										catch( Exception ex7 )
//										{	
//											return null;
//										}
//									}
//								}
//							}
//						}
//					}
//				}
//			}
//			
//			return cleanDate;
//		}
		
		
		public static DateFormat setDateFormat(String dtFormat)
		{
			dateFormat = new SimpleDateFormat(dtFormat);
			return dateFormat;
		}
		
		public static DateFormat getDateFormat()
		{
			return dateFormat;
		}
		
//		public static Calendar toCalendar( XMLGregorianCalendar c )
//		{
//			return ( c == null ? null : c.toGregorianCalendar() );
//		}


//		public static String toString( XMLGregorianCalendar c )
//		{
//			return ( c == null ? null : toString( c.toGregorianCalendar() ));
//		}
//
//		public static String toString( XMLGregorianCalendar c, String format )
//		{
//			return ( c == null ? null : toString( c.toGregorianCalendar(), format ));
//		}
		
//		public static String toString( Calendar calendar )
//		{
//			return toString( calendar, DEFAULT_DATETIME_FORMAT );
//		}	

		public static String toString( Calendar calendar, String format )
		{
			if ( calendar == null )
				return null;

			SimpleDateFormat f = new SimpleDateFormat( format );
			return f.format( calendar.getTime() );
		}

//		public static Calendar fromString( String source )
//		{
//			return ( source == null ? null : fromString( source, ( source.indexOf( ':' ) == -1 ? DEFAULT_DATE_FORMAT : DEFAULT_DATETIME_FORMAT ) ) );
//		}
	
	public static String dateToString(java.sql.Timestamp Date_dtm)
		{
		java.util.Date date = new Date( Date_dtm.getTime() );
		return dateToString(date);
		}
		
	public static String dateToString(java.util.Date Date_dtm)
		{
		if( Date_dtm == null )
			{ return ""; }
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(Date_dtm);
		}
	




	public static Calendar fromString( String source, String format )
		{
			try
			{
				return fromStringEx( source, format );
			}

			catch ( Exception ignored )
			{
			}

			return null;
		}
		
		public static Calendar fromStringEx( String source, String format ) 
			throws ParseException
		{
			if ( "".equals( source ))
				source = null;
			
			if ( source != null )
			{
				SimpleDateFormat f = new SimpleDateFormat( format );
				f.setLenient( true );

				Date d = f.parse( source.trim() );
				Calendar calendar = Calendar.getInstance();
				calendar.setTime( d );
				return calendar;
			}
			
			return null;
		}
}
