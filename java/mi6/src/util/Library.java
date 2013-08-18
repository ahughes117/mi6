package util;

import datalayer.PartnerDL;
import entities.Entity;
import entities.Partner;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sql.Connector;
import sql.DBCredentials;

/**
 * A utility class that keeps data that is static.
 *
 * @author alexhughes
 */
public class Library {

    //public static ArrayList<Connector> connectionL;
    public static ArrayList<Entity> partners;

    /**
     * Loads the combo with the agents that hold the ips
     *
     * @param aCon
     * @return
     * @throws SQLException
     */
    public static ArrayList<Entity> loadPartnerList(Connector aCon) throws SQLException, ClassNotFoundException {
        PartnerDL pdl = new PartnerDL(aCon);
        partners = pdl.fetchList("Url ASC");

        for (Entity e : partners) {
            Partner p = (Partner) e;
            Connector con = new Connector(new DBCredentials(p.getUrl(), p.getUser(), p.getPass(), p.getSchema()));
            p.con = con;
        }

        return partners;
    }

    public static Connector getConnection(int aPartnerID) {
        Connector con = null;

        for (Entity e : partners) {
            Partner p = (Partner) e;
            if (aPartnerID == p.getPartnerID()) {
                con = p.con;
                break;
            }
        }
        return con;
    }
    
    /**
     * Returns an ArrayList with all the active connections of the partners
     * 
     * @return 
     */
    public static ArrayList<Connector> getConnections() {
        ArrayList<Connector> connections = new ArrayList();
        
        for(Entity e : partners) {
            Partner p = (Partner)e;
            connections.add(p.con);
        }
        return connections;
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
}
