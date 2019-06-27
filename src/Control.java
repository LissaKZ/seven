import net.proteanit.sql.DbUtils;
import sun.applet.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Control extends JPanel {
    String selected=null;
    JLabel text=new JLabel(new String(MainWindow.bundle.getString("controlLabel").getBytes("ISO-8859-1"), "UTF-8"));
    JTextField prisoner=new JTextField();
    JButton adding=new JButton(new String(MainWindow.bundle.getString("controlButton1").getBytes("ISO-8859-1"),"UTF-8"));
    JButton removing=new JButton(new String(MainWindow.bundle.getString("controlButton2").getBytes("ISO-8859-1"),"UTF-8"));
    String cellNumber;
    int ind;
    Control() throws UnsupportedEncodingException {
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
                String login=MainWindow.log;
                try {
                    ResultSet result= Servant.statement.executeQuery("SELECT drove FROM prisoners WHERE drove=\'"+
                            prisoner.getText()+"\'");
                    if(result.next()){
                        JOptionPane.showMessageDialog(null,new String(MainWindow.bundle.getString("addingError").getBytes("ISO-8859-1"),"UTF-8"));
                    }else {
                        cellNumber=String.valueOf((int)(Math.random()*6));
                       ZonedDateTime toTime=Servant.getTime();
                       double between= (double) (Math.random()*50);
                        ZonedDateTime fromTime=toTime.plusYears((long)between);
                        Servant.statement.executeQuery("INSERT INTO prisoners (drove, cell, snitch, date,freedom,tern) VALUES ('" +
                                prisoner.getText() + "','" + cellNumber + "','" + login + "','"+ Servant.format.format(toTime)+ "','"+Servant.format.format(fromTime)+ "','"+String.valueOf(between)+"')");
                        Prison.model_zek.addRow(new String[]{prisoner.getText(),cellNumber,login,Servant.format.format(toTime),Servant.format.format(fromTime), String.valueOf(between)});
                        Prison.model_zek.fireTableDataChanged();
                        update();
                    }
                }catch (SQLException | UnsupportedEncodingException e1) {
                    System.out.println("Попытка добавление заключенного");
                }
            }
        });
        removing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Servant.statement.executeQuery("DELETE FROM prisoners WHERE drove=\'"+
                            Prison.table_zek.getSelectedRow()+"\'");
                    ind=Prison.table_zek.getSelectedRow();
                    Prison.model_zek.removeRow(ind);
                    Prison.model_zek.fireTableDataChanged();
                    update();
                } catch (SQLException e1){

                    e1.printStackTrace();
                }
            }
        });
    }
    public static void update(){
        try {
            ResultSet result= Servant.statement.executeQuery("SELECT * FROM prisoners ");
            Prison.table_zek.setModel(DbUtils.resultSetToTableModel(result));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
