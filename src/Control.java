import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Control extends JPanel {
    String selected=null;
    JLabel text=new JLabel(new String(MainWindow.bundle.getString("controlLabel").getBytes("ISO-8859-1"),"UTF-8"));
    JTextField prisoner=new JTextField();
    JButton adding=new JButton(new String(MainWindow.bundle.getString("controlButton1").getBytes("ISO-8859-1"),"UTF-8"));
    JButton removing=new JButton(new String(MainWindow.bundle.getString("controlButton2").getBytes("ISO-8859-1"),"UTF-8"));
    String cellNumber;
    int ind;
    Control(String login) throws UnsupportedEncodingException {
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
                System.out.println("нажатие на кнопку адд");
                try {
                    ResultSet result= Servant.statement.executeQuery("SELECT drove FROM prisoners WHERE drove=\'"+
                            prisoner.getText()+"\'");
                    if(result.next()){
                        JOptionPane.showMessageDialog(null,"Prisoner with the same drove is already exist");
                    }else {
                        cellNumber=String.valueOf((int)(Math.random()*6));
                        Servant.statement.executeQuery("INSERT INTO prisoners (drove, cell, snitch, date) VALUES ('" + prisoner.getText()
                                + "','" + cellNumber + "','" + login + "','"+ Servant.getTime()+ "')");
                        Prison.model_zek.addRow(new String[]{prisoner.getText(),cellNumber,login,Servant.getTime()});
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
                    ind=Prison.table_zek.getSelectedRow();
                    Prison.model_zek.removeRow(ind);
                } catch (SQLException e1){

                    e1.printStackTrace();
                }
            }
        });
    }
}
