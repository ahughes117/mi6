
package sql;


import util.Credentials;
import java.io.*;

/**
 * The DB credential entity class
 * @author Alex Hughes
 */
public class DBCredentials extends Credentials implements Serializable {

    private String driver = "jdbc:mysql://";
    private String URL;
    private String username;
    private String password;
    private String port = ":3306/";
    private String schema;

    public DBCredentials(String aURL, String aUsername, String aPassword,
            String aSchema) {
        URL = aURL;
        username = aUsername;
        password = aPassword;
        schema = aSchema;
    }

    public String getDriver() {
        return driver;
    }

    public String getURL() {
        return URL;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPort() {
        return port;
    }

    public String getSchema() {
        return schema;
    }

    public void setURL(String aURL) {
        URL = aURL;
    }

    public void setUsername(String aUsername) {
        username = aUsername;
    }

    public void setPassword(String aPassword) {
        password = aPassword;
    }
    
    public void setSchema(String aSchema) {
        schema = aSchema;
    }

    public void clear() {
        URL = null;
        username = null;
        password = null;
        schema = null;
    }
}
