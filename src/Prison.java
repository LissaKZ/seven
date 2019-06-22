import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Prison extends JPanel implements Runnable {
    static JTable table_zek;
    DefaultTableModel model_zek=new DefaultTableModel();
    Prison(){
        setSize(700,300);
        setLayout(null);

        model_zek.addColumn("drove");
        model_zek.addColumn("cell");
        model_zek.addColumn("snitch");
        model_zek.addColumn("date");

        try {
            ResultSet result = Servant.statement.executeQuery("SELECT * FROM prisoners ");
            while (result.next()){
                String drove=result.getString("drove");
                String number=result.getString("cell");
                String creator=result.getString("snitch");
                String date=result.getString("date");
                model_zek.addRow(new String[]{drove, number, creator, date});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        model_zek.fireTableDataChanged();
        table_zek= new JTable(model_zek);
        table_zek.setBounds(20,350,650,200);

        add(table_zek);
    }

    @Override
    public void run() {

    }
}
