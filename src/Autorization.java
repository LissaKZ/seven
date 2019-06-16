import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Autorization extends JPanel {

    private JTextField login=new JTextField();
    JPasswordField password=new JPasswordField();
    private JButton singin=new JButton("Login");
    JLabel label1=new JLabel("user name");
    JLabel label2=new JLabel("password");

    public Autorization(){
        setSize(800,600);
        setLayout(null);

        login.setBounds(250,100,300,30);
        password.setBounds(250,150,300,30);
        singin.setBounds(250,200,300,30);
        label1.setBounds(150,100,100,30);
        label2.setBounds(150,150,100,30);

        add(login);
        add(password);
        add(singin);
        add(label1);
        add(label2);

        singin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ResultSet result= Servant.statement.executeQuery("SELECT id FROM studs WHERE login=\'"+
                            login.getText()+"\' AND password=\'"+password.getText()+"\'");
                    if(result.next()){
                        JOptionPane.showMessageDialog(null,"Your id is "+result.getInt("id"));
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
