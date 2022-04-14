package org.inspector.core.entity;

import org.bson.codecs.pojo.annotations.BsonProperty;

public class Site {

    @BsonProperty("id")
    private String Id;

    @BsonProperty("site_name")
    private String SiteName;

    @BsonProperty("city")
    private String City;

    @BsonProperty("address")
    private String Address;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getSiteName() {
        return SiteName;
    }

    public void setSiteName(String siteName) {
        SiteName = siteName;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
