import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BD {
    private Connection conn;
    private Statement st;
    private ResultSet rs;
    
    public BD(String tabla)
    {
        try
        {
            conn = DriverManager.getConnection("jdbc:sqlserver://;database=corridaToros;integratedSecurity=true;");
            String query = "SELECT * FROM "+tabla+";";
            st = conn.createStatement();
            rs = st.executeQuery(query);

//      st.close();
        }
        catch (Exception e)
        {
          System.err.print("Error: ");
          System.err.println(e.getMessage());
        }
    }

    public void Agregar(String query) {
        try
        {
            //conn = DriverManager.getConnection("jdbc:mysql://localhost/cic", "root", "admin");
            st = conn.createStatement();
            boolean bandera=st.execute(query);
            System.out.println("Hecho");            
        }
        catch (Exception e)
        {
          System.err.print("Error: ");
          System.err.println(e.getMessage());
        }
    }
    public ResultSet Buscar(String query){
        try
        {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            System.out.println("Hecho");            
        }
        catch (Exception e)
        {
          System.err.print("Error: ");
          System.err.println(e.getMessage());
}
