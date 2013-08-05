
package util;

import java.sql.SQLException;
import javax.swing.JComboBox;
import sql.Connector;

/**
 * A utility class that keeps data that is static.
 * 
 * @author alexhughes
 */
public class Library {
    
    /**
     * Loads the combo with the agents that hold the ips
     * 
     * @param aCon
     * @return
     * @throws SQLException 
     */
    public static JComboBox loadAgentCombo(Connector aCon) throws SQLException {
        JComboBox agentCombo = new JComboBox();
        
        return agentCombo;
    }
    
    /**
     * Loads the combo that is used in order to sort the ips
     * 
     * @param aCon
     * @return
     * @throws SQLException 
     */
    public static JComboBox loadSortingCombo (Connector aCon) throws SQLException {
        JComboBox sortingCombo = new JComboBox();
        
        return sortingCombo;
    }
}
