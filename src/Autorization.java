import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Autorization extends JFrame {

    private JTextField login=new JTextField();
    JPasswordField password=new JPasswordField();
    private JButton singin=new JButton("Login");
    JButton reg=new JButton("Registration");
    JLabel label1=new JLabel("user name");
    JLabel label2=new JLabel("password");

    public Autorization(){
        super("Singin Singup");
        setSize(800,627);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        JPanel panel=new JPanel();
        panel.setSize(800,600);
        panel.setLayout(null);

        login.setBounds(250,100,300,30);
        password.setBounds(250,150,300,30);
        singin.setBounds(250,200,300,30);
        label1.setBounds(150,100,100,30);
        label2.setBounds(150,150,100,30);
        reg.setBounds(250,250,300,30);

        panel.add(login);
        panel.add(password);
        panel.add(singin);
        panel.add(label1);
        panel.add(label2);
        panel.add(reg);
        add(panel);
        singin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ResultSet result= Servant.statement.executeQuery("SELECT mail FROM users WHERE login=\'"+
                            login.getText()+"\' AND password=\'"+password.getText()+"\'");
                    if(result.next()){

                        //переход на главное окно

                        JOptionPane.showMessageDialog(null,"Your mail is "+result.getString("mail"));

                        dispose();
                    }else {
                        JOptionPane.showMessageDialog(null,"User not found");
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        reg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Registration();
            }
        });
    }
}
