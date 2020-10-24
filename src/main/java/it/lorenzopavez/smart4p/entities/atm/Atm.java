
package it.lorenzopavez.smart4p.entities.atm;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Atm {

    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("distance")
    @Expose
    private Integer distance;
    @SerializedName("type")
    @Expose
    private String type;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
