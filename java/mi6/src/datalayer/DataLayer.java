package datalayer;

import entities.Entity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sql.Connector;

/**
 * The Data Layer Abstract Class
 *
 * @author alexhughes
 */
public abstract class DataLayer {

    protected Connector c;
    protected Entity e;
    protected ArrayList<Entity> entities;

    public DataLayer(Connector aConnector) {
        c = aConnector;
    }

    public DataLayer(Connector aConnector, Entity anEntity) {
        c = aConnector;
        e = anEntity;
    }

    public abstract Entity fetch() throws SQLException;

    public abstract ArrayList<Entity> fetchList(String aSorting) throws SQLException;

    public abstract String prepareSearchQuery(String aSorting);

    public abstract ArrayList<Entity> search() throws SQLException;

    public abstract ResultSet search(String aSorting) throws SQLException;

    public abstract int insert() throws SQLException;

    public abstract void update() throws SQLException;

    public abstract void delete() throws SQLException;

    public abstract ArrayList<Entity> resultSetToEntity(ResultSet aR) throws SQLException;
}
