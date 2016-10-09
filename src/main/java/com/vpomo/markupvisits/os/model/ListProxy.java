package com.vpomo.markupvisits.os.model;

/**
 * Created by Zver on 09.10.2016.
 */
public class ListProxy {
    private String addressPort;
    private Boolean availability;

    public ListProxy(Boolean availability, String addressPort) {
        this.availability = availability;
        this.addressPort = addressPort;
    }

    public String getAddressPort() {
        return addressPort;
    }

    public void setAddressPort(String addressPort) {
        this.addressPort = addressPort;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "ListProxy{" + "availability=" + availability + " addressPort=" + addressPort + "}";
    }

}
