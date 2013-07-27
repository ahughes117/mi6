package util;

import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * SQL ResultSet to JTable utility.
 *
 * @author Alex Hughes
 */
public class TableParser {

    private static final int idCol = 0;
    private static int cols;
    private static Object[] rowData;
    private static String[] colNames;

    /**
     * This function acquires a ResultSet object and a JTable object and fills
     * the table with the ResultSet contents. Special attention is being given
     * on Date Format.
     *
     * @param aResult
     * @param aTable
     * @throws SQLException
     */
    public static void fillTable(ResultSet aResult, JTable aTable) throws SQLException {
        ((DefaultTableModel) aTable.getModel()).setRowCount(0);
        ((DefaultTableModel) aTable.getModel()).setColumnCount(0);

        ResultSet results = aResult;
        ResultSetMetaData metadata = results.getMetaData();

        cols = metadata.getColumnCount();

        rowData = new Object[cols];
        colNames = new String[cols];

        for (int i = 0; i < cols; i++) {
            colNames[i] = metadata.getColumnName(i + 1);
        }
        for (int i = 0; i < cols; i++) {
            ((DefaultTableModel) aTable.getModel()).addColumn(colNames[i]);
        }

        while (results.next()) {
            for (int i = 0; i < cols; i++) {
                if (metadata.getColumnName(i + 1).equals("DateCreated")
                        || metadata.getColumnName(i + 1).equals("_dateModified")) {

                    rowData[i] = StrVal.formatTimestamp(results.getTimestamp(i + 1));
                } else {
                    rowData[i] = results.getString(i + 1);
                }
            }
            ((DefaultTableModel) aTable.getModel()).addRow(rowData);
        }
    }
}