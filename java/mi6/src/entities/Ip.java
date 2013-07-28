package entities;

import java.sql.Timestamp;

/**
 * The IP Entity Class
 *
 * @author alexhughes
 */
public class Ip extends Entity {

    private String ip;
    private String agent;
    private String domain;
    private String ipMask;
    private int processed = -1;
    private String hostname;
    private String city;
    private String region;
    private String country;
    private String countryCode;
    private double latitude;
    private double longitude;
    private String postCode;
    private String timezone;
    private Timestamp dateCreated;
    private Timestamp dateModified;

    public Ip(String ip, String agent, String domain, String ipMask, int processed, String hostname, String city, String region, String country, String countryCode, double latitude, double longitude, String postCode, String timezone, Timestamp dateCreated, Timestamp dateModified) {
        this.ip = ip;
        this.agent = agent;
        this.domain = domain;
        this.ipMask = ipMask;
        this.processed = processed;
        this.hostname = hostname;
        this.city = city;
        this.region = region;
        this.country = country;
        this.countryCode = countryCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.postCode = postCode;
        this.timezone = timezone;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getIpMask() {
        return ipMask;
    }

    public void setIpMask(String ipMask) {
        this.ipMask = ipMask;
    }

    public int getProcessed() {
        return processed;
    }

    public void setProcessed(int processed) {
        this.processed = processed;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
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