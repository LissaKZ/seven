import javax.swing.*;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.ResourceBundle;

import static java.util.ResourceBundle.getBundle;

public class MainWindow extends JFrame {
    public static String log;
    static JPanel table;
    static JPanel users;
    JPanel lang;
    static ResourceBundle bundle;
    MainWindow() throws UnsupportedEncodingException, MalformedURLException {
        bundle=ResourceBundle.getBundle("main_window",new Locale("ru","RU"));
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(false);

        table=new Prison();
        JPanel control=new Control();
        users=new Chat();
        JPanel anim=new Animation();
        lang=new Languadge();

        anim.setBounds(20,20,200,200);
        control.setBounds(250,20,200,300);
        users.setBounds(500,20,200,250);
        table.setBounds(20,300,700,300);
        lang.setBounds(500,20,200,300);

        add(anim);
        add(control);
        add(users);
        add(table);
        add(lang);
    }
}
