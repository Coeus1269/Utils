package NumberUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberUtils 
{
	public static final int	DEFAULT_NUMERIC_PRECISION	= 12,
			DEFAULT_NUMERIC_SCALE = 4;
	
	public static final int	DEFAULT_CURRENCY_PRECISION	= 12,
			DEFAULT_CURRENCY_SCALE = 4;
	
	public static final int	PRESENTATION_CURRENCY_SCALE	= 2;
	
	private String Version_str = "1.23";
	
	
	public static void main(String[] args) 
		{
		// TODO 	String Formatting with locale separators - 
		//					NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
		//					String numberAsString = numberFormat.format(number);

		// 			Currency Formatting

		
		System.out.println(NumberUtils.BigToCurrencyString(new BigDecimal(2346.0123456)));
		System.out.println(NumberUtils.BigToCurrencyString(new BigDecimal(2346.01477456)));
		System.out.println(NumberUtils.BigToCurrencyString(new BigDecimal(2346.01577456)));
		
		
		double number = 1234567.123456;
	    NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.ITALIAN);
	    String numberAsString = numberFormat.format(number);
	    System.out.println("Italian Format: " + numberAsString);
	    
	    numberFormat = NumberFormat.getNumberInstance(Locale.US);
	    numberAsString = numberFormat.format(number);
	    System.out.println("US Format: " + numberAsString);
	    
	    numberAsString = String.format("%,d", 1234567);
	    System.out.println(numberAsString);
	    
	    DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
	    numberAsString = decimalFormat.format(number);
	    System.out.println(numberAsString);
	
		}
	
	
	public static BigDecimal toCurrency( int Value_int, int Scale_int )
		{ return toCurrency( new BigDecimal( Value_int), Scale_int ); 	}
	
	
	public static BigDecimal toCurrency( int Value_int)
		{ return toCurrency( new BigDecimal( Value_int) ); 	}
 
	
	public static BigDecimal toCurrency( double Value_dbl )
		{ return toCurrency( new BigDecimal( Value_dbl ) ); }
	

	public static BigDecimal toCurrency( double Value_dbl, int Scale_int )
		{ return toCurrency( new BigDecimal( Value_dbl ), Scale_int ); }

	
	public static BigDecimal toCurrency( BigDecimal Value_big )
		{ return toCurrency( Value_big, DEFAULT_CURRENCY_SCALE );	}

	
	public static BigDecimal toCurrency( BigDecimal Value_big, int Scale_int )
		{
			if ( Value_big != null )
				return Value_big.setScale( Scale_int, RoundingMode.HALF_EVEN );
	
			return null; // or should it return BigDecimal.ZERO ?
		}
	

	public static BigDecimal toDecimal( int src )
		{ return toDecimal( (double) src );	}

	public static BigDecimal toDecimal( double src )
		{ return toDecimal( new BigDecimal( src ) ); }

	public static BigDecimal toDecimal( BigDecimal src )
		{
			if ( src != null )
				return src.setScale( DEFAULT_NUMERIC_SCALE, RoundingMode.HALF_EVEN );
	
			return null; // or should it return BigDecimal.ZERO ?
		}
	
	public static BigDecimal toWholePercent( BigDecimal src )
		{
			if ( src != null )
				return src.scaleByPowerOfTen(2);
			
			return BigDecimal.ZERO;
		}
	
	public static final String toHex( long value )
		{ return Long.toHexString( value );	}
	
	public static final String toHex( long value, int digits )
		{
			String s = Long.toHexString( value );
			
			while( s.length() < digits )
				s = "0" + s;
			
			return s;
		}


	
	public static String BigToCurrencyString(BigDecimal BigInt)
		{
			DecimalFormat df = new DecimalFormat("###,###,##0.00");
			return df.format( NumberUtils.toCurrency( BigInt ));
		}

    public boolean IsNumeric( String s )
	    {
	    	String str = s.trim();
	    	for ( int i = 0; i < str.length(); i++ )
	    	{
	    		if ( str.charAt( i ) < '0' || str.charAt( i ) > '9' )
	    			return false;
	    	}
	    	return true;
	    }
    /* -------------------------------- Getters & Setters  -------------------------------- */

   public String getVersion()
   	{ return Version_str; 	}

    /* ------------------------------ End Getters & Setters  ------------------------------ */

}
