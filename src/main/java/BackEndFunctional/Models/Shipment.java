package BackEndFunctional.Models;

import java.util.ArrayList;

public class Shipment {

    public ArrayList<Address> addresses;
    public String commodity;
    public String key;
    public Object numberOfBids;
    public Object price;
    public String vehicleType;

    public Shipment(ArrayList<Address> addresses, String commodity, String key, Object numberOfBids, Object price, String vehicleType) {
        this.addresses = addresses;
        this.commodity = commodity;
        this.key = key;
        this.numberOfBids = numberOfBids;
        this.price = price;
        this.vehicleType = vehicleType;
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(ArrayList<Address> addresses) {
        this.addresses = addresses;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getNumberOfBids() {
        return numberOfBids;
    }

    public void setNumberOfBids(Object numberOfBids) {
        this.numberOfBids = numberOfBids;
    }

    public Object getPrice() {
        return price;
    }

    public void setPrice(Object price) {
        this.price = price;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
