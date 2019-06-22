import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Control extends JPanel {

    String selected="zeekless";


    JLabel text=new JLabel("Prisoner's name");
    JTextField prisoner=new JTextField();
    JButton adding=new JButton("Add");
    JButton removing=new JButton("Remove");
    Control(String login){
        setSize(200,300);
        setLayout(null);

        text.setBounds(20,20,100,30);
        prisoner.setBounds(20,100,100,30);
        adding.setBounds(20,150,100,30);
        removing.setBounds(20,200,100,30);

        add(text);
        add(prisoner);
        add(adding);
        add(removing);

        adding.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ResultSet result= Servant.statement.executeQuery("SELECT drove FROM prisoners WHERE drove=\'"+
                            prisoner.getText()+"\'");
                    if(result.next()){
                        JOptionPane.showMessageDialog(null,"Prisoner with the same drove is already exist");
                    }else {
                        Servant.statement.executeQuery("INSERT INTO prisoners (drove, cell, snitch, date) VALUES ('" + prisoner.getText()
                                + "','" + String.valueOf((int)(Math.random()*6)) + "','" + MainWindow.log + "','"+ Servant.getTime()+ "')");
                        Prison.table_zek.repaint();
                    }
                }catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }

        });
        removing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Servant.statement.executeQuery("DELETE FROM prisoners WHERE drove=\'"+
                            selected+"\'");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
