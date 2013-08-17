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
    
    public static Connector getConnection(String aUrl) {
        Connector con = null;
        
        for(Connector c : connectionL) {
            if(c.getCredentials().getURL().equalsIgnoreCase(aUrl)) {
                con = c;
                break;
            }
        }
        
        return con;
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
