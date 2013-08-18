package entities;

import java.sql.Timestamp;
import sql.Connector;

/**
 * The Partner Entity Class
 *
 * @author alexhughes
 */
public class Partner extends Entity {

    private int partnerID = NIL;
    private String url;
    private String user;
    private String pass;
    private String schema;
    private String table;
    private String type;
    private Timestamp dateCreated;
    private Timestamp dateModified;
    public Connector con;

    /**
     * Constructor for fetching partners
     *
     * @param partnerID
     * @param url
     * @param user
     * @param pass
     * @param schema
     * @param table
     * @param type
     * @param dateCreated
     * @param dateModified
     */
    public Partner(int partnerID, String url, String user, String pass, String schema, String table, String type, Timestamp dateCreated, Timestamp dateModified) {
        this.partnerID = partnerID;
        this.url = url;
        this.user = user;
        this.pass = pass;
        this.schema = schema;
        this.table = table;
        this.type = type;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
    }

    /**
     * Constructor for creating new partners
     *
     * @param url
     * @param user
     * @param pass
     * @param schema
     * @param table
     * @param type
     */
    public Partner(int id, String url, String user, String pass, String schema, String table, String type) {
        this.partnerID = id;
        this.url = url;
        this.user = user;
        this.pass = pass;
        this.schema = schema;
        this.table = table;
        this.type = type;
    }

    public Partner() {
    }

    public int getPartnerID() {
        return partnerID;
    }

    public void setPartnerID(int partnerID) {
        this.partnerID = partnerID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Timestamp getDateModified() {
        return dateModified;
    }

    public void setDateModified(Timestamp dateModified) {
        this.dateModified = dateModified;
    }
}
