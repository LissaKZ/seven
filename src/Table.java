import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class Table extends JFrame {

        public Table() {

            super("Тестовое окно");

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            String[] items = {
                    "Элемент списка 1",
                    "Элемент списка 2",
                    "Элемент списка 3"
            };

            Container content = getContentPane();

            content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));


            ActionListener actionListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JComboBox box = (JComboBox) e.getSource();
                    String item = (String) box.getSelectedItem();
                }
            };
            JComboBox comboBox = new JComboBox(items);
            comboBox.setAlignmentX(LEFT_ALIGNMENT);
            comboBox.addActionListener(actionListener);
            content.add(comboBox);
            setPreferredSize(new Dimension(600, 600));
            pack();
            setLocationRelativeTo(null);
            setVisible(true);
        }
        public static void main(String[] args) {
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JFrame.setDefaultLookAndFeelDecorated(true);
                    new Table();
                }
            });
        }
    /*
    private int columnCount = 4;
    private ArrayList<String[]> dataArraylist;
    public void frame() {
        dataArraylist = new ArrayList<String[]>();
        for (int i = 0; i < dataArraylist.size(); i++) {
            dataArraylist.add(new String[getColumnCount()]);
        }
    }*/

/*
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] rows = dataArraylist.get(rowIndex);
        return rows[columnIndex];
    }

    public void addData(String[] row) {
        String[] rowTable = new String[getColumnCount()];
        rowTable = row;
        dataArraylist.add(rowTable);
    }

    public void addData(Connection con) throws SQLException {
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/prison", "postgres", "password");
        Statement st = con.createStatement();
        ResultSet result = st.executeQuery("SELECT * FROM prisoners ");

        while (result.next()) {
            String[] row = {
                    result.getString("drove"),
                    result.getString("cell"),
                    result.getString("snitch"),
                    result.getString("date")
            };
            addData(row);
        }
        result.close();
    }*/
}


