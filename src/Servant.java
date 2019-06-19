import javax.swing.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Servant extends JFrame{
    public static Statement statement;
    Servant(){
        super("Singin Singup");
        setSize(800,627);
        //add(new Autorization());
        //add(new Registration());
        new Conformation("12345");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(false);
        try{
            statement= DriverManager.getConnection("jdbc:postgresql://localhost:5432/prison","postgres","password").createStatement();


        }catch (SQLException e){e.printStackTrace();

        }

    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Servant();
            }
        });

    }
}
