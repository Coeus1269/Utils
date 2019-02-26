package SQL_Utils;

public class SQLUtils
    {
	// TODO: method that takes a table as input and pulls the column info for testing data type, size etc.
	
    public static String SQLSafeString(String SQL_str)
        {// replaces single quote to work in MS SQL.
        return SQL_str.replaceAll("\'","''");
        }

    public static String SQLInsertMaker(String[] Columns_ary, String Table_str, String[] Values_ary)
        {
        return SQLInsertMaker(Columns_ary, Table_str, Values_ary, false);
        }

    public static String SQLInsertMaker(String[] Columns_ary, String Table_str, String[] Values_ary, boolean ShowDeBug_bln)
        {// builds an insert statement String that has DeBug Features
        String SQLSelect_str = "Insert into " + Table_str + "(";
        String Values_str = " values(";

        for (int ColumnsLoop=0; ColumnsLoop < Columns_ary.length; ColumnsLoop++)
            {
            SQLSelect_str += " [" + Columns_ary[ColumnsLoop] + "],";
            Values_str += " '" + SQLSafeString(Values_ary[ColumnsLoop]) + "',";

            if(ShowDeBug_bln)
                System.out.println(Columns_ary[ColumnsLoop] + " = " + SQLSafeString(Values_ary[ColumnsLoop]));
            }

        SQLSelect_str = SQLSelect_str.substring(0,SQLSelect_str.length()-1) + " )";
        Values_str = Values_str.substring(0,Values_str.length()-1) + " )";

        return SQLSelect_str + Values_str;
        }
    }
