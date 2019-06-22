import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Chat extends JPanel {
    JTable table;
    DefaultTableModel model=new DefaultTableModel();
    Chat(){
        setSize(200,300);
        setLayout(null);

        model.addColumn("Username");

        try {
            ResultSet result = Servant.statement.executeQuery("SELECT login FROM users ");
            while (result.next()){
                String data=result.getString("login");
                model.addRow(new String[]{data});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        table= new JTable(model);
        table.setBounds(20,20,150,300);

        add(table);
    }
}
