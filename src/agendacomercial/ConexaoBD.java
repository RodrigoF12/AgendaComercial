
package agendacomercial;

import java.sql.*;

public class ConexaoBD  
{
    
    public static Connection conexao;
    public static PreparedStatement ps;
    public static Statement st;     
    public static ResultSet rs;
    
    public static void OpenDatabase() throws SQLException
    {
        String url = "jdbc:mysql://localhost:3306/Agenda";
        String user = "root";
        String password = "";
        conexao = DriverManager.getConnection(url, user, password);
    }
}

 