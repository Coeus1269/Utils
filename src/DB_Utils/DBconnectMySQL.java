package DB_Utils;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.sql.PooledConnection;
import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;


public class DBconnectMySQL
{
	// Purpose: Class to handle database connectivity to a MySQL DB using pooled connections
	// Usage: Typical class usage
	// Issues: 
	// Created:  11-11-2018
	// Expectations: The default values are for a typical localhost setup using MySQL 5.5.45 and java 1.7.

    private String host_str = "localhost"; 		// MySQL Host Name
    private int port_int = 3306; 				// Host port
    private String username_str; 				// The user login name
    private String pwd_str; 
    private String database_str; 				// The database you want to connect to
    private boolean requireSSL_bln = false;		// Documented below
    private boolean useSSL_bln = false;			// Documented below
    String DB_Default_str = "SchemaTest";		// The default database you want to connect to. this is optional depending on your security concerns and how many 
    											// DBs you might need to connect to in one application
   
	// private Connection conn = null;
    private PooledConnection pooledConnection = null;
    private MysqlConnectionPoolDataSource poolDataSource = null;
    private Connection connToMySQL = null;
    
	
	// Connection Properties:
	// https://dev.mysql.com/doc/connector-j/5.1/en/connector-j-reference-configuration-properties.html
	// username_str 				- The user to connect as
	// pwd_str						- The password to use when connecting
	// useSSL_bln					- Use SSL (Secure Socket Layer) when communicating with the server (true/false), 
	//									default needs to be 'true' when connecting to MySQL 5.5.45+, 5.6.26+ or 5.7.6+, otherwise default is 'false' 
	// requireSSL_bln				- if useSSL_bln=true Require server support of SSL connection (defaults to 'false'). 
    //									assuming that if useSSL_bln=true and requireSSL_bln=false, the connection will switch to not use SSL if the server does not support SSL? 
   
    // Other options not implemented in this class currently
	// connectTimeout				- Timeout for socket connect (in milliseconds), with 0 being no timeout. Only works on JDK-1.4 or newer. 
	//									Defaults to '0'.
	// disconnectOnExpiredPasswords	- If "disconnectOnExpiredPasswords" is set to "false" and password is expired then server enters "sandbox" mode and 
    //									sends ERR(08001, ER_MUST_CHANGE_PASSWORD) for all commands that are not needed to set a new password until a new password is set.
	// useCompression				- Use zlib compression when communicating with the server (true/false)? Defaults to 'false'. 
	// allowMultiQueries			- Allow the use of ';' to delimit multiple queries during one statement (true/false), defaults to 'false', and does not affect the 
    //									addBatch() and executeBatch() methods, which instead rely on rewriteBatchStatements.
    // verifyServerCertificate 		- If "useSSL" is set to "true", should the driver verify the server's certificate? When using this feature, the keystore parameters should 
    //									be specified by the "clientCertificateKeyStore*" properties, rather than system properties. Default is 'false' when connecting to 
    //									MySQL 5.5.45+, 5.6.26+ or 5.7.6+ and "useSSL" was not explicitly set to "true". Otherwise default is 'true' Default: true
	// autoGenerateTestcaseScript 	- Should the driver dump the SQL it is executing, including server-side prepared statements to STDERR? Default: false
	// autoReconnect				- Should the driver try to re-establish stale and/or dead connections? 
	//									If enabled the driver will throw an exception for queries issued on a stale or dead connection, 
	//									which belong to the current transaction, but will attempt reconnect before the next query issued on 
	//									the connection in a new transaction. The use of this feature is not recommended, because it has side effects 
	//									related to session state and data consistency when applications don't handle SQLExceptions properly, and is only 
	//									designed to be used when you are unable to configure your application to handle SQLExceptions resulting from 
	//									dead and stale connections properly. Alternatively, as a last option, investigate setting the MySQL server 
	//									variable "wait_timeout" to a high value, rather than the default of 8 hours. Default: false
	// initialTimeout				- If autoReconnect is enabled, the initial time to wait between re-connect attempts (in seconds, defaults to '2'). 
	// roundRobinLoadBalance	 	- When autoReconnect is enabled, and failoverReadonly is false, should we pick hosts to connect to on a round-robin basis? 
	// maxReconnects				- Maximum number of reconnects to attempt if autoReconnect is true, default is '3'. 
   
  
    public DBconnectMySQL()
		{
			try
				{
					connectPooled();
				}
			catch (ClassNotFoundException e)
				{ e.printStackTrace(); }
			catch (SQLException e)
				{ e.printStackTrace(); }
		}
	
	public DBconnectMySQL(String host, int Port, String database, String username, String password, boolean requireSSL, boolean useSSL)
		{
			this(host, Port, database,  username,  password);
			requireSSL_bln = requireSSL;
			useSSL_bln = useSSL;
		}
	
	public DBconnectMySQL(String host, int Port, String database, String username, String password)
		{
			this(host, database,  username,  password);
			port_int = Port;
		}
	
	public DBconnectMySQL(String host, String database, String username, String password)
		{
			this(database,  username,  password);
			host_str = host;
		}
	
	public DBconnectMySQL( int Port, String database, String username, String password)
		{
			this(database,  username,  password);
			port_int = Port;
		}
	
	public DBconnectMySQL(String database, String username, String password)
		{
			username_str = username;
			pwd_str = password;
			database_str = database;
			try
				{
					connectPooled();
				}
			catch (ClassNotFoundException e)
				{ e.printStackTrace(); }
			catch (SQLException e)
				{ e.printStackTrace(); }
		}
	


	public static void main(String[] args)
	{

	}
	
	public synchronized Connection connectPooled() 
			throws ClassNotFoundException, SQLException 
	{
  
		  createPooledDataSource();
		  if (poolDataSource!= null)
			  {
			  pooledConnection = poolDataSource.getPooledConnection();
			  connToMySQL = pooledConnection.getConnection();
			  return connToMySQL;
			  }
		  else
			  {// TODO output error to log or console
			  System.out.println("OOps Error");
			  return null;
			  }

	}
	
	  private MysqlConnectionPoolDataSource createPooledDataSource() 
			  throws SQLException 
	  {
		  poolDataSource = new MysqlConnectionPoolDataSource();
		  
		  if(database_str != null && !"".equals(database_str))
		  	{
			  poolDataSource.setDatabaseName(database_str);
		  	}
		  else
			  {
			  System.out.println("Database not set, Using Default");
			  if(DB_Default_str != null && !"".equals(DB_Default_str))
			  	{
				  poolDataSource.setDatabaseName(DB_Default_str);
			  	}
			  else
			  	{
				  System.out.println("Database not set, no Default set");
				  throw new SQLException("Database not set, no Default set");
			  	}
			  }
		  
		  
		  if(username_str != null && !"".equals(username_str))
		  	{
			  poolDataSource.setUser(username_str);
			  if(pwd_str != null && !"".equals(pwd_str))
			  	{
				  poolDataSource.setPassword(pwd_str);				  
				  poolDataSource.setPortNumber(port_int);
				  poolDataSource.setLocalSocketAddress(host_str);
				  poolDataSource.setRequireSSL(requireSSL_bln);
				  poolDataSource.setUseSSL(useSSL_bln);  
			  	}
			  else
				  System.out.println("PWD not set");
		  	}
		  else
			  System.out.println("Username not set");

		  		  	
		  return poolDataSource;
	  }
	  	  
	  public void CloseConnection() 
			  throws SQLException
		  {
			  connToMySQL.close();
			  pooledConnection.close();
		  }
	  
	  public boolean isConnected() 
			  throws SQLException
		  {
			  return !connToMySQL.isClosed();
		  }
	  
	  public ResultSet ExecuteQuery(String Query_str)
	  {
		  Statement stmt;
		try
			{
				if (Query_str.length() > 5 && isConnected())
					{
						stmt = connToMySQL.createStatement();
						return stmt.executeQuery(Query_str);
					}
				else
					{// TODO output error to log or console
					  System.out.println("OOps Error");
					}
				
			}
		catch (SQLException e)
			{
				e.printStackTrace();
			}
			return null;
	  }
	
	  /* -------------------------------- Getters & Setters  -------------------------------- */
	  
	   public String getHost()
			{ return host_str; }

		public void setHost(String value)
			{ host_str = value; }

		public int getPort()
			{ return port_int; }

		public void setPort(int value)
			{ port_int = value;	}

		public String getUsername()
			{ return username_str; }

		public void setUsername(String value)
			{ username_str = value;	}

		public String getPassword()
			{ return pwd_str; }

		public void setPassword(String value)
			{ pwd_str = value; }

		public String getDatabase()
			{ return database_str; }

		public void setDatabase(String value)
			{ database_str = value;	}

		public Connection getConnToMySQL()
			{ return connToMySQL; }

//		public void setConnToMySQL(Connection connToMySQL)
//			{ this.connToMySQL = connToMySQL; }

		public boolean isRequireSSL()
			{ return requireSSL_bln; }

		public void setRequireSSL(boolean requireSSL)
			{ requireSSL_bln = requireSSL;	}
		
	/* -------------------------------- END Getters & Setters  -------------------------------- */

}
