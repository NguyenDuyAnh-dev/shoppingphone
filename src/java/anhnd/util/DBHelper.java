/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anhnd.util;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author PHUCHAU
 */
public class DBHelper {
    public static Connection getConnection() throws SQLException, NamingException{
        //1. get current context
        Context context = new InitialContext();
        Context tomcatContext = (Context)context.lookup("java:comp/env");
        //2. look up database
        DataSource ds = (DataSource) tomcatContext.lookup("DV007");
        //3. open connection
        Connection con = ds.getConnection();
        //4. return connection
        return con;
    }
}
