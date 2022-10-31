package com.jbc.zipcodelookup;

import com.redis.om.spring.annotations.Document;
import org.springframework.data.annotation.Id;

import java.util.List;

@Document
public class ZipCode {
    @Id
    String zipCode;
    String primaryCity;
    List<String> acceptableCities;
    String abbreviatedState;
    String county;

    public ZipCode() {}

    public ZipCode(String zipCode, String primaryCity, List<String> acceptableCities, String abbreviatedState, String county) {
        this.zipCode = zipCode;
        this.primaryCity = primaryCity;
        this.acceptableCities = acceptableCities;
        this.abbreviatedState = abbreviatedState;
        this.county = county;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPrimaryCity() {
        return primaryCity;
    }

    public void setPrimaryCity(String primaryCity) {
        this.primaryCity = primaryCity;
    }

    public List<String> getAcceptableCities() {
        return acceptableCities;
    }

    public void setAcceptableCities(List<String> acceptableCities) {
        this.acceptableCities = acceptableCities;
    }

    public String getAbbreviatedState() {
        return abbreviatedState;
    }

    public void setAbbreviatedState(String abbreviatedState) {
        this.abbreviatedState = abbreviatedState;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }
}
