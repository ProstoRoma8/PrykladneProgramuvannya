package models;

public abstract class Plane {

    protected  String model;
    protected  int fuelConsumption;    // Витрати пального (наприклад, кг/год)
    protected int flightRangeKm;      // Дальність польоту (кілометри)
    protected  double cruiseSpeedKmh;  // Крейсерська швидкість (км/год)

    protected  double capacity; // К-сть пасажирів АБО вантажопідйомність (в тоннах)

    public Plane(String model, int fuelConsumption, int flightRangeKm,
                 double cruiseSpeedKmh, double capacity) {
        this.model = model;
        this.fuelConsumption = fuelConsumption;
        this.flightRangeKm = flightRangeKm;
        this.cruiseSpeedKmh = cruiseSpeedKmh;
        this.capacity = capacity;
    }

    public String getModel() {
        return model;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public int getFlightRangeKm() {
        return flightRangeKm;
    }

    public double getCruiseSpeedKmh() {
        return cruiseSpeedKmh;
    }

    public double getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "model='" + model + '\'' +
                ", fuelConsumption=" + fuelConsumption + " kg/h" +
                ", flightRange=" + flightRangeKm + " km" +
                ", cruiseSpeed=" + cruiseSpeedKmh + " km/h" +
                ", capacity=" + capacity +
                '}';
    }
}
