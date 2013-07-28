
package datalayer;

import entities.Entity;
import entities.Ip;
import java.sql.*;
import java.util.ArrayList;
import sql.Connector;

/**
 * The Ip Entity Data Layer Class
 * 
 * @author alexhughes
 */
public class IpDL extends DataLayer {
    
    public IpDL(Connector aConnector) {
        super(aConnector);
    }
    
    public IpDL(Connector aConnector, Entity anEntity) {
        super(aConnector, anEntity);
    }

    @Override
    public Entity fetch() throws SQLException {
        Ip ip = (Ip)e;
        
        String query = ""
                + "SELECT * "
                + "FROM ip "
                + "WHERE ip = ? AND agent = ? AND domain = ? ";
        
        PreparedStatement ps = c.prepareStatement(query);
        
        ps.setString(1, ip.getIp());
        ps.setString(2, ip.getAgent());
        ps.setString(3, ip.getDomain());
        
        ResultSet ipR = ps.executeQuery();
        e = resultSetToEntity(ipR).get(0);
        
        return e;
    }

    @Override
    public ArrayList<Entity> fetchList(String aSorting) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Entity> search() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insert() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Entity> resultSetToEntity(ResultSet aR) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
