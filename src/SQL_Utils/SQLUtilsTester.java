package SQL_Utils;

public class SQLUtilsTester 
{

	public static void main(String[] args) 
		{
        String[] Columns_ary = {"col1", "col2", "col3"};
        String[] Values_ary = {"one", "two", "three's", "four"};
        
        System.out.println(SQLUtils.SQLInsertMaker(Columns_ary, "SomeTable", Values_ary, true));

		}

}
