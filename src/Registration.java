import org.postgresql.util.PSQLException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.SecureRandom;
import java.sql.*;
import java.util.Base64;
import java.util.Properties;


public class Registration extends JPanel{
    private JTextField login = new JTextField();
    JTextField mail = new JTextField();
    JPasswordField password =  new JPasswordField();
    JPasswordField oneMoreTime=new JPasswordField();

    private JButton signup = new JButton("Register");
    JLabel label1=new JLabel("user name");
    JLabel label4=new JLabel("mail");
    JLabel label2=new JLabel("password");
    JLabel label3=new JLabel("password again");

    public Registration() {
        setSize(800,600);
        setLayout(null);
        login.setBounds(250,100,300,30);
        mail.setBounds(250, 50, 300, 30);
        password.setBounds(250,150,300,30);
        oneMoreTime.setBounds(250,200,300,30);
        signup.setBounds(250,250,300,30);
        label1.setBounds(150,100,100,30);
        label2.setBounds(150,150,100,30);
        label3.setBounds(150 ,200,100,30);

        add(mail);
        add(login);
        add(password);
        add(oneMoreTime);
        add(signup);
        add(label4);
        add(label1);
        add(label2);
        add(label3);

        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ResultSet result = Servant.statement.executeQuery("SELECT login FROM users WHERE login=\'"+
                            login.getText()+"\'");
                    if(result.next()){
                        JOptionPane.showMessageDialog(null,"Пользователь с таким логином уже существует");
                    }
                    if(!result.next()){
                        emailSender(mail.getText());
                        Servant.statement.executeQuery("INSERT INTO users (login, mail, password) VALUES ('"+login.getText()
                                +"','"+mail.getText()+"','"+password.getText()+"')");
                    } else {
                        JOptionPane.showMessageDialog(null,"User with the same login has been registered");
                    }
                } catch (PSQLException ee){
                    ee.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (MessagingException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });
    }
    private static final SecureRandom secureRandom = new SecureRandom(); //threadsafe
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe

    public static String generateNewToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }
    public void emailSender(String address) throws IOException, MessagingException {
        Properties properties=new Properties();
        properties.load(Registration.class.getResourceAsStream("email.properties"));
        Session mailSession=Session.getDefaultInstance(properties);
        MimeMessage message=new MimeMessage(mailSession);
        message.setFrom(new InternetAddress("alekseyevalissa"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(address));
        message.setSubject("Ку");
        message.setText(generateNewToken());
        Transport tr=mailSession.getTransport();
        tr.connect("alekseyevalissa@gmail.com","passwordforproga");
        tr.sendMessage(message,message.getAllRecipients());
        tr.close();




    }


}
