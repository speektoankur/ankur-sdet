package BackEndFunctional.Models;

import java.util.ArrayList;

public class Root {

    public ArrayList<Shipment> shipments;

    public Root(ArrayList<Shipment> shipments) {
        this.shipments = shipments;
    }

    public ArrayList<Shipment> getShipments() {
        return shipments;
    }

    public void setShipments(ArrayList<Shipment> shipments) {
        this.shipments = shipments;
    }
}

