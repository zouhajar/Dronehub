package test;

import java.sql.Connection;

public class AbstractDAO {
    protected Connection connection = SingleConnexion.getConnection();
    
}