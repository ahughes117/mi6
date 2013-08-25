package gui;

import datalayer.IpDL;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import javax.swing.*;
import util.TableParser;

/**
 * The Search SwingWorker class, responsible for maintaining the interface
 * responsive while searching. It runs separately from the Event Dispatch
 * Thread.
 *
 * It is experiencing some bugs with the ip JTable because Swing is not Thread
 * Safe.
 *
 * @author alexhughes
 */
public class SearchWorker extends SwingWorker {

    private String sorting;
    private JTable table;
    private JLabel statusL;
    private JProgressBar progress;
    private IpDL ipDL;

    public SearchWorker(JTable table, JLabel statusL, JProgressBar progress, IpDL ipDL, String sorting) {
        this.table = table;
        this.statusL = statusL;
        this.progress = progress;
        this.ipDL = ipDL;
        this.sorting = sorting;
    }

    @Override
    protected Object doInBackground() throws Exception {
        //starting the procedure
        long startTime = System.nanoTime();
        progress.setIndeterminate(true);
        table.setEnabled(false);
        statusL.setText("Working...");

        //sending query
        ResultSet ipR = ipDL.search(sorting);
        statusL.setText("Query Executed");

        //filling table
        TableParser.fillTable(ipR, table);
        statusL.setText("Table Population Done");

        //calculating time
        long endTime = System.nanoTime();
        double time = (double) (endTime - startTime);
        time /= 1000000000;
        
        //printing summary
        DecimalFormat timeF = new DecimalFormat("#.###");
        statusL.setText(table.getRowCount() + " entries fetched in " + timeF.format(time) + " seconds.");
        progress.setIndeterminate(false);
        table.setEnabled(true);

        return null;
    }
}
