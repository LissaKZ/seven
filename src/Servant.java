import javax.swing.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Servant extends JFrame{
    public static Statement statement;
    Servant(){
        super("Singin Singup");
        setSize(800,627);
        add(new Autorization());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        try{
            statement= DriverManager.getConnection("jdbc:postgresql://localhost:5432/users","postgres","password").createStatement();

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
