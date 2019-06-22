import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class Servant{
    public static Statement statement=null;
    public static JFrame mw;
    public static Connection connection=null;

    static DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm, dd MMM yyyy");

    Servant(){
        statement=Servant.getState();

    }
    public static String getTime(){
        ZonedDateTime time= ZonedDateTime.now(ZoneId.of("Europe/Moscow"));
        return format.format(time);

    }
    public static Statement getState(){
        Statement state=null;
        try{
            connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/prison",
                    "postgres","password");
            state= connection.createStatement();

        }catch (SQLException e){e.printStackTrace();
        }
        return state;
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Servant();
                new Autorization();
                mw=new MainWindow();
            }
        });

    }
}
