package models;

import java.util.ArrayList;
import java.util.List;

public class AirLine {

    private String name;
    public List<Plane> fleet;

    public AirLine(String name) {
        this.name = name;
        this.fleet = new ArrayList<>();
    }

    public void addPlane(Plane plane) {
        if (plane != null) {
            this.fleet.add(plane);
        }
    }

    public Plane getPlaneByIndex(int index) {
        if (index < 0 || index >= fleet.size()) {
            return null;
        }
        return fleet.get(index);
    }

    public void printFleetShort() {
        if (fleet.isEmpty()) {
            System.out.println("Парк літаків порожній.");
            return;
        }

        for (int i = 0; i < fleet.size(); i++) {
            Plane p = fleet.get(i);
            System.out.println(
                    i + ") " + p.getModel()
                            + " | дальність: " + p.getFlightRangeKm() + " km"
                            + " | витрати: " + p.getFuelConsumption()
            );
        }
    }

    public String getName() {
        return name;
    }

    public List<Plane> getFleet() {
        return fleet;
    }

    public int getTotalPassengerPlanes() {
        int count = 0;
        for (Plane plane : fleet) {
            if (plane instanceof PassengerPlane) {
                count++;
            }
        }
        return count;
    }

    public int getTotalCargoPlanes() {
        int count = 0;
        for (Plane plane : fleet) {
            if (plane instanceof CargoPlane) {
                count++;
            }
        }
        return count;
    }

    public double getTotalCapacity() {
        double total = 0;
        for (Plane plane : fleet) {
            if (plane instanceof PassengerPlane) {
                total += plane.getCapacity();
            }
        }
        return total;
    }

    public double getTotalPayload() {
        double total = 0;
        for (Plane plane : fleet) {
            if (plane instanceof CargoPlane) {
                total += plane.getCapacity();
            }
        }
        return total;
    }
}