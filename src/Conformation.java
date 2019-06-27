import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Thread.sleep;

public class Conformation extends JFrame {
    JTextField tok=new JTextField();
    JLabel label=new JLabel("Token was send to you email. Put it here");
    JButton ok=new JButton("Ok");


    public Conformation(String token){
        super("Singin Singup");
        setSize(400,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        JPanel panel=new JPanel();
        panel.setSize(400,200);
        panel.setLayout(null);

        tok.setBounds(40, 20, 300, 30);
        label.setBounds(40, 60, 300, 30);
        ok.setBounds(150, 120, 100, 30);

        panel.add(tok);
        panel.add(label);
        panel.add(ok);

        add(panel);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tok.getText().equals(token)){
                    MainWindow.log=Registration.login.getText();
                    dispose();
                    Servant.mw.setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Not correct");
                }

            }
        });
        }
}
