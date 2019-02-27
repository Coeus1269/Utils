package DB_Utils;

public class SQLUtilsTester 
{
	// this class is just for testing and demonstrating the functionality of the SQLUtils class

	public static void main(String[] args) 
		{
        String[] Columns_ary = {"col1", "col2", "col3"};
        String[] Values_ary = {"one", "two", "three's", "four"};
        
        System.out.println(SQLUtils.SQLInsertMaker(Columns_ary, "SomeTable", Values_ary, true));

		}

}
