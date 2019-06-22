import javax.swing.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class MainWindow extends JFrame{
    public static String log;
    static JPanel table;
    static JPanel users;
    MainWindow(){
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(false);

        table=new Prison();
        JPanel control=new Control(log);
        users=new Chat();
        JPanel anim=new JPanel();

        anim.setBounds(20,20,200,150);
        control.setBounds(250,20,200,300);
        users.setBounds(500,20,200,300);
        table.setBounds(20,600,700,300);

        add(anim);
        add(control);
        add(users);
        add(table);
    }

    public void RefreshTable(){
        table=new Prison();
        table.setBounds(20,600,700,300);
        add(table);
    }
}
