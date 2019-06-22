import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class Table extends AbstractTableModel {

    private int columnCount = 4;
    private ArrayList<String[]> dataArraylist;
    public void frame() {
        dataArraylist = new ArrayList<String[]>();
        for (int i = 0; i < dataArraylist.size(); i++) {
            dataArraylist.add(new String[getColumnCount()]);
        }
    }
    @Override
    public int getRowCount() {
        return dataArraylist.size();
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "drove";
            case 1:
                return "cell";
            case 2:
                return "snitch";
            case 3:
                return "date";
        }
        return "";
    }

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
    }
}


