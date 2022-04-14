package org.inspector.core.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.io.Serializable;
import java.util.List;

@MongoEntity(collection = "companies")
public class Company extends PanacheMongoEntity implements Serializable {

    @BsonProperty("ruc")
    private String Ruc;

    @BsonProperty("company_name")
    private String CompanyName;

    @JsonProperty("sites")
    private List<Site> Sites;

    public String getRuc() {
        return Ruc;
    }

    public void setRuc(String ruc) {
        Ruc = ruc;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public List<Site> getSites() {
        return Sites;
    }

    public void setSites(List<Site> sites) {
        Sites = sites;
    }
}