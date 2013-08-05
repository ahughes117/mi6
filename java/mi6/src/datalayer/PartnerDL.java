package datalayer;

import entities.Entity;
import entities.Partner;
import java.sql.*;
import java.util.ArrayList;
import sql.Connector;

/**
 * The Partner Entity Data Layer Class
 *
 * @author alexhughes
 */
public class PartnerDL extends DataLayer {

    public PartnerDL(Connector aConnector) {
        super(aConnector);
    }

    public PartnerDL(Connector aConnector, Entity anEntity) {
        super(aConnector, anEntity);
    }

    @Override
    public Entity fetch() throws SQLException {
        Partner p = (Partner) e;
        checkID(p);

        String query = ""
                + "SELECT * "
                + "FROM partner "
                + "WHERE partnerID = ? ";

        PreparedStatement ps = c.prepareStatement(query);
        ps.setInt(1, p.getPartnerID());

        ResultSet partnerR = ps.executeQuery();
        e = resultSetToEntity(partnerR).get(0);

        return e;
    }

    @Override
    public ArrayList<Entity> fetchList(String aSorting) throws SQLException {
        String query = ""
                + "SELECT * "
                + "FROM partner "
                + "ORDER BY " + aSorting;

        ResultSet partnerR = c.sendQuery(query);
        entities = resultSetToEntity(partnerR);

        return entities;
    }

    @Override
    public ArrayList<Entity> search() throws SQLException {
        Partner p = (Partner) e;

        String query = ""
                + "SELECT * "
                + "FROM partner "
                + "WHERE 1=1 ";

        if (p.getUrl() != null && !p.getUrl().equals("")) {
            query += " AND Url LIKE '%" + p.getUrl() + "%' ";
        }

        if (p.getType() != null && !p.getType().equals("")) {
            query += " AND Type LIKE '%" + p.getType() + "%' ";
        }

        ResultSet partnerR = c.sendQuery(query);
        entities = resultSetToEntity(partnerR);

        return entities;
    }

    @Override
    public int insert() throws SQLException {
        int id = Entity.NIL;
        Partner p = (Partner) e;

        String query = ""
                + "INSERT INTO partner (Url, User, Pass, `Schema`, `Table`, Type, DateCreated) VALUES "
                + "(?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP) ";

        PreparedStatement ps = c.prepareStatement(query);

        ps.setString(1, p.getUrl());
        ps.setString(2, p.getUser());
        ps.setString(3, p.getPass());
        ps.setString(4, p.getSchema());
        ps.setString(5, p.getTable());
        ps.setString(6, p.getType());

        ps.executeUpdate();

        ResultSet keyR = ps.getGeneratedKeys();
        while (keyR.next()) {
            id = keyR.getInt(1);
        }

        return id;
    }

    @Override
    public void update() throws SQLException {
        Partner p = (Partner) e;
        checkID(p);

        String query = ""
                + "UPDATE partner SET "
                + "Url = ?, "
                + "`User` = ?, "
                + "Pass = ?, "
                + "`Schema` = ?, "
                + "Table = ?, "
                + "Type = ? "
                + "WHERE partnerID = ? ";

        PreparedStatement ps = c.prepareStatement(query);

        ps.setString(1, p.getUrl());
        ps.setString(2, p.getUser());
        ps.setString(3, p.getPass());
        ps.setString(4, p.getSchema());
        ps.setString(5, p.getTable());
        ps.setString(6, p.getType());
        ps.setInt(7, p.getPartnerID());

        ps.executeUpdate();
    }

    @Override
    public void delete() throws SQLException {
        Partner p = (Partner) e;
        checkID(p);

        String query = ""
                + "DELETE "
                + "FROM partner "
                + "WHERE partnerID = ? ";

        PreparedStatement ps = c.prepareStatement(query);
        ps.setInt(1, p.getPartnerID());

        ps.executeUpdate();
    }

    @Override
    public ArrayList<Entity> resultSetToEntity(ResultSet aR) throws SQLException {
        ArrayList<Entity> entityL = new ArrayList();
        Partner p;

        while (aR.next()) {
            p = new Partner(
                    aR.getInt("partnerID"),
                    aR.getString("Url"),
                    aR.getString("User"),
                    aR.getString("Pass"),
                    aR.getString("Schema"),
                    aR.getString("Table"),
                    aR.getString("Type"),
                    aR.getTimestamp("DateCreated"),
                    aR.getTimestamp("_dateModified"));
            entityL.add(p);
        }

        return entityL;
    }

    /**
     * Helper function to help me and prevent future pain
     *
     * @param anEntity
     * @throws SQLException
     */
    private void checkID(Entity anEntity) throws SQLException {
        Partner p = (Partner) e;
        if (p.getPartnerID() == Entity.NIL) {
            throw new SQLException();
        }
    }
}
