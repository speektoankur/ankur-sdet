package BackEndFunctional.Models;

public class Address {
    public String key;
    public Object latitude;
    public Object longitude;
    public String name;
    public String order;

    public Address(String key, Object latitude, Object longitude, String name, String order) {
        this.key = key;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.order = order;
    }

    public Address() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getLatitude() {
        return latitude;
    }

    public void setLatitude(Object latitude) {
        this.latitude = latitude;
    }

    public Object getLongitude() {
        return longitude;
    }

    public void setLongitude(Object longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
