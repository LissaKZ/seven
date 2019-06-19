import javax.swing.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Servant{
    public static Statement statement;
    Servant(){
        try{
            statement= DriverManager.getConnection("jdbc:postgresql://localhost:5432/prison",
                    "postgres","password").createStatement();
        }catch (SQLException e){e.printStackTrace();
        }
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Servant();
                new Autorization();
            }
        });

    }
}
