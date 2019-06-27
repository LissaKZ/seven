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
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class MainWindow {
    public static String log;
    static JFrame mainWindow;
    static JPanel table;
    static JPanel users;
    static JPanel lang;
    static JPanel anim;
    static JPanel control;
    static ResourceBundle bundle;
    MainWindow() throws UnsupportedEncodingException, MalformedURLException {
        mainWindow=new JFrame();
        bundle=ResourceBundle.getBundle("main_window",new Locale("ru","RU"));
        mainWindow.setSize(800,600);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainWindow.setVisible(false);

        table=new Prison();
        control=new Control();
        users=new Chat();
        anim=new Animation();
        lang=new Languadge();

        anim.setBounds(20,20,200,200);
        control.setBounds(250,20,200,300);
        users.setBounds(600,20,200,250);
        table.setBounds(20,300,700,300);
        lang.setBounds(500,20,200,300);

        mainWindow.add(anim);
        mainWindow.add(control);
        mainWindow.add(users);
        mainWindow.add(table);
        mainWindow.add(lang);
    }
    public static void update(){
        control.removeAll();
        mainWindow.revalidate();
        mainWindow.repaint();
        control.revalidate();
        control.repaint();
        //mainWindow.pack();
        //mainWindow.setLocationRelativeTo(null);
    }
}
