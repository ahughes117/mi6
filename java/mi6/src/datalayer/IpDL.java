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
        Ip ip = (Ip) e;

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
        String query = ""
                + "SELECT * "
                + "FROM ip "
                + "ORDER BY " + aSorting;

        ResultSet ipR = c.sendQuery(query);
        entities = resultSetToEntity(ipR);

        return entities;
    }

    @Override
    public ArrayList<Entity> search() throws SQLException {
        Ip ip = (Ip) e;

        String query = ""
                + "SELECT * "
                + "FROM ip "
                + "WHERE 1=1 ";

        if (ip.getIp() != null && !ip.getIp().equals("")) {
            query += " AND ip LIKE '%" + ip.getIp() + "%' ";
        }

        if (ip.getAgent() != null && !ip.getAgent().equals("")) {
            query += " AND agent LIKE '%" + ip.getAgent() + "%' ";
        }

        if (ip.getDomain() != null && !ip.getDomain().equals("")) {
            query += " AND domain LIKE '%" + ip.getDomain() + "%' ";
        }

        if (ip.getProcessed() != Entity.NIL) {
            query += " AND Processed = " + ip.getProcessed();
        }

        int floor = ip.getHits() - 100;
        int ceiling = ip.getHits() + 100;
        if (ip.getHits() != Entity.NIL) {
            query += " AND Hits BETWEEN " + floor + " AND " + ceiling;
        }
        
        



        return entities;
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
