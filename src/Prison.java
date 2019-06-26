import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Prison extends JPanel {
    static JTable table_zek;
     static DefaultTableModel model_zek=new DefaultTableModel();
    Prison(){
        System.out.println("Prison class added");
        setSize(700,300);
        setLayout(null);

        model_zek.addColumn("drove");
        model_zek.addColumn("cell");
        model_zek.addColumn("snitch");
        model_zek.addColumn("date");
        model_zek.addColumn("date of Freedom");
        model_zek.addColumn("Years left");

        try {
            ResultSet result = Servant.statement.executeQuery("SELECT * FROM prisoners ");
            while (result.next()){
                String drove=result.getString("drove");
                String number=result.getString("cell");
                String creator=result.getString("snitch");
                String date=result.getString("date");
                String freedom_date=result.getString("date of freedom");
                String years_left=result.getString("years left");
                model_zek.addRow(new String[]{drove, number, creator, date,freedom_date,years_left});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        table_zek= new JTable(model_zek);
        JScrollPane pane=new JScrollPane(table_zek);
        table_zek.setBounds(20,20,650,200);

        add(table_zek);
        System.out.println("end of prison class");
    }
}
