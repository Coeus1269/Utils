package DB_Utils;

import java.sql.*; 

public class RSToOutput
{  
	// Purpose: 		Take a record set and output to the console in a various formats optionally including the header
	// Usage:
	// Issues:
	// Expectations:	The calling class retrieves the record set and passes into this class
	// Last Updated: 	11-11-2018
	// note that all the methods are named they way they are so that they all show up together when using intellisense


	public static void main(String args[])
		{  
		// testing configuration
			String DB_str = "SchemaTest";	// The database you want to connect to on localhost
			String User_str = "dbread";		// The user login name
			String PWD_str = "zxcv";		// the password
			// to connect to a remote MySQL server
			// String DBhost_str = "Your Remote Host";
			// String DBport_str = "Your Remote Host Port"; // if different than 3306
			// then connect with DBconnectMySQL MySQLDBCONN = new DBconnectMySQL(DBhost_str, DB_str, User_str, PWD_str);
			//   or DBconnectMySQL MySQLDBCONN = new DBconnectMySQL(DBhost_str, DBport_str, DB_str, User_str, PWD_str);
			
		try
			{
			DBconnectMySQL MySQLDBCONN = new DBconnectMySQL(DB_str, User_str, PWD_str);
			// Tabed output
			// ToConsoleTable(MySQLDBCONN.ExecuteQuery("select * from MeasureUnits limit 5"));	
			
			//HTML output
			ResultSet rs= MySQLDBCONN.ExecuteQuery("select * from MeasureUnits limit 5");
			System.out.println("Full Table");
			System.out.println(RSToOutput.ToHTMLTable(rs));								// full table
			System.out.println("");
			
			System.out.println("header and data areas only");
			rs.first();																	// reset the result set for testing
			System.out.println(RSToOutput.ToHTMLTable(rs, true, false));				// table with header and data areas only
			System.out.println("");
			
			System.out.println("data area only");
			rs.first();																	// reset the result set for testing
			System.out.println(RSToOutput.ToHTMLTable(rs, false, false));				// table with data area only

			MySQLDBCONN.CloseConnection();
			}
		catch(Exception e)
			{ System.out.println(e.toString());}  

		}  
	
	public  void ToConsoleCSV(ResultSet rs) 
			throws SQLException
		{
		// Purpose: Contents of a record set and output to the console formated as comma separated values
		// Usage: 	RSToConsole.ToConsoleCSV(ResultSet rs)  - output displayed to the console
		
		// under construction
		}
	
	
	public static void ToConsoleTable(ResultSet rs) 	
			throws SQLException
		{ // Header included by default
			ToConsoleTable(rs, true);
		}
	
	public static void ToConsoleTable(ResultSet rs, boolean includeHeader) 
			throws SQLException
		{
		// Purpose:	Output tab formated table including the header to the console, using tabs to make clean columns
		//			 meant to be a tool for testing or debugging query results
		// Usage: 	RSToConsole.ToConsoleTable(ResultSet rs)  - output displayed to the console
		// Issues: 	Display will not format properly if the largest contents of the row field are longer than the length of the header name
		//				Future feature mod
		// Note: 	This method will use the length of the header and determine how many tabs are necessary to line up each column of data for each row
		
		// Example output:
		// MeasureUnits_ID	CommonName_str	Symbol_str	isMetric	
		// 26				Gram			g			1		
		// 27				Kilogram		kg			1
		
		int HowManyTabs_int 	= 0;
		int SpacesPerTab_int 	= 8;		// Adjust this if your display is different
		int HeaderLength_int 	= 0;
		String Tabs_str 		= "";
		String RowValue_str 	= "";
		
		int TabsInHeader_int 	= 0;
		int TabsInRowValue_int 	= 0;
		
		ResultSetMetaData metaData = rs.getMetaData();
		
		// make header row
		if(includeHeader)
				TableHeaderToConsole(metaData);
		
		int ColumnCount_int = metaData.getColumnCount(); //number of column
		
		while(rs.next())
			{
			for (int i = 1; i <= ColumnCount_int; i++)
				{
				Tabs_str 		= "";
				RowValue_str 	= rs.getString(i);

				HeaderLength_int = metaData.getColumnLabel(i).length();
				
				// TODO: needs to be documneted
				TabsInHeader_int = (int) Math.ceil(HeaderLength_int  / SpacesPerTab_int);
				TabsInRowValue_int = (int) Math.ceil(RowValue_str.length()  / SpacesPerTab_int);
				HowManyTabs_int = 1 + TabsInHeader_int - TabsInRowValue_int; 
				
				System.out.print(RowValue_str);
				// System.out.print(RowValue_str + " " + HeaderLength_int + " " + RowValue_str.length()  + " " + HowManyTabs_int);
				
				for (int TABS_LOOP = 0; TABS_LOOP < HowManyTabs_int; TABS_LOOP++)
					{
						Tabs_str += "\t";
					}
				System.out.print(Tabs_str);
				}
			System.out.println();
			}	
		}
	
	private static void TableHeaderToConsole(ResultSetMetaData metaData) 
				throws SQLException
		{
			// Purpose: output record set header to console
			// Usage: 	executed on call of RSToConsole methods when includeHeader is true
			// Issues:
			
		int ColumnCount_int = metaData.getColumnCount(); //number of column
		String columnName[] = new String[ColumnCount_int];

		// make header row
		for (int i = 0; i < ColumnCount_int; i++)
			{
			   columnName[i] = metaData.getColumnLabel(i+1);
			   System.out.print(columnName[i] + "\t");
			   
			}
		System.out.println("");
		}

	
	private static String TableHeaderToHTML(ResultSetMetaData metaData) 
			throws SQLException
	{
		// Purpose: output record set header columns to HTML
		// Usage: 	executed on call of TableToHTML methods when includeHeader is true
		// Issues:
		
	int ColumnCount_int = metaData.getColumnCount();		//number of columns
	String columnName[] = new String[ColumnCount_int];
	String tempTabeHeadrt_str = "<tr>";

	// make header row
	for (int i = 0; i < ColumnCount_int; i++)
		{
		   columnName[i] = metaData.getColumnLabel(i+1);
		   // System.out.print(columnName[i] + "\t");
		   tempTabeHeadrt_str += " <th>" + columnName[i] + "</th>";
		   
		}
//	System.out.println("</tr>");
//	System.out.println(tempTabeHeadrt_str);
	tempTabeHeadrt_str += " </tr>\n";
	return tempTabeHeadrt_str;
	}

	
	public static String ToHTMLTable(ResultSet rs) 	
			throws SQLException
		{ // Header included by default
		return ToHTMLTable(rs, true, true);
		}
	
	public static String ToHTMLTable(ResultSet rs, boolean includeHeader, boolean includeTableDeclaration) 
			throws SQLException
		{
		// Purpose:	Output HTML formated table , all columns in the ResultSet ResultSet, header optional 
		// includeTableDeclaration - include open and close <table> and <tbody> tags, in case you want to set your table name or attributes manually
		// includeHeader - include the column names as the table header
		
		// Example output:

		String tr_str 			= "";
//		String trHeader_str 	= "";
		String RowValue_str 	= "";
		String HTMLTable_str 	= "";
				
		if(includeTableDeclaration)
			HTMLTable_str = "<table> <tbody>\n";

		ResultSetMetaData metaData = rs.getMetaData();  	// get the column names
		int ColumnCount_int = metaData.getColumnCount(); 	// number of columns
		
		// make header row
		if(includeHeader)
			HTMLTable_str += TableHeaderToHTML(metaData);
		
		while(rs.next())
			{
			tr_str = "<tr> " ;
			for (int i = 1; i <= ColumnCount_int; i++)
				{
				RowValue_str = rs.getString(i);
				
				tr_str += " <td>" + RowValue_str + "</td>";

				}
			HTMLTable_str += tr_str + "</tr>\n";
			}
			
		if(includeTableDeclaration)
			HTMLTable_str += "</tbody> </table>";
		
		return HTMLTable_str;
		}


	
	/* -------------------------------- Getters & Setters  -------------------------------- */

	
	/* -------------------------------- End Getters & Setters  -------------------------------- */
	
}  

