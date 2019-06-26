import javax.swing.*;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class Servant{
    public static Statement statement;
    public static JFrame mw;

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
            state= DriverManager.getConnection("jdbc:postgresql://localhost:5432/prison",
                    "postgres","password").createStatement();

        }catch (SQLException e){e.printStackTrace();
        }
        return state;
    }
    public static void main(String[] args) throws UnsupportedEncodingException {
       /* SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Servant();
                try {
                    mw=new MainWindow();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                new Autorization();

            }
        });
*/
        ResourceBundle bundle=ResourceBundle.getBundle("main_window",new Locale("ru","RU"));
        String s=bundle.getString("controlLabel");
        System.out.println(s);
    }
}
