package com.example.ProjetEncheres.bdd;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Connect {
    public static Connection getConnection() throws Exception {
        try {
            Context context = new InitialContext();

            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");

            Connection cnx = dataSource.getConnection();
            return cnx;
        } catch (NamingException | SQLException e) {
            throw e;
        }
    }

}
