package gui;

import datalayer.IpDL;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

/**
 * The Sync SwingWorker class, responsible for maintaining the interface
 * responsive while searching. It runs separately from the Event Dispatch
 * Thread.
 *
 * @author alexhughes
 */
public class SyncWorker extends SwingWorker {

    private JLabel statusL;
    private JProgressBar progressB;
    private IpDL ipDL;

    public SyncWorker(JLabel statusL, JProgressBar progressB, IpDL ipDL) {
        this.statusL = statusL;
        this.progressB = progressB;
        this.ipDL = ipDL;
    }

    @Override
    protected Object doInBackground() throws Exception {
        //starting the procedure
        long startTime = System.nanoTime();
        progressB.setIndeterminate(true);
        statusL.setText("Syncing...");

        //syncing
        ipDL.setStatusL(statusL);
        ipDL.syncIps();

        //calculating time
        long endTime = System.nanoTime();
        double time = (double) (endTime - startTime);
        time /= 1000000000;

        //printing summary
        DecimalFormat timeF = new DecimalFormat("#.###");
        statusL.setText(statusL.getText() + "Syncing finished in " + timeF.format(time) + " seconds. ");
        progressB.setIndeterminate(false);

        return null;
    }
}
