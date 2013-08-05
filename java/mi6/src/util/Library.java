package util;

import datalayer.PartnerDL;
import entities.Entity;
import entities.Partner;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import sql.Connector;
import sql.DBCredentials;

/**
 * A utility class that keeps data that is static.
 *
 * @author alexhughes
 */
public class Library {

    public static ArrayList<Connector> connectionL;

    /**
     * Loads the combo with the agents that hold the ips
     *
     * @param aCon
     * @return
     * @throws SQLException
     */
    public static ArrayList<Entity> loadPartnerList(Connector aCon) throws SQLException, ClassNotFoundException {
        ArrayList<Entity> partners;
        
        PartnerDL pdl = new PartnerDL(aCon);
        partners = pdl.fetchList("Url ASC");
        connectionL = new ArrayList();

        for (Entity e : partners) {
            Partner p = (Partner) e;
            Connector con = new Connector(new DBCredentials(p.getUrl(), p.getUser(), p.getPass(), p.getSchema()));
            connectionL.add(con);
        }

        return partners;
    }
    
    /**
     * Checks whether the credentials of a connection are valid
     * 
     * @param cre
     * @return 
     */
    public static boolean testConnection(DBCredentials cre) {
        boolean successful;
        
        try {
            Connector.testConnection(cre);
            successful = true;
        } catch (SQLException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
            successful = false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
            successful = false;
        }
        
        return successful;
    }

    /**
     * Loads the combo that is used in order to sort the ips
     *
     * @param aCon
     * @return
     * @throws SQLException
     */
    public static JComboBox loadSortingCombo(Connector aCon) throws SQLException {
        JComboBox sortingCombo = new JComboBox();

        return sortingCombo;
    }
}
