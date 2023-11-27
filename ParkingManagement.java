import java.util.ArrayList;
import java.util.List;

class Vehicle {
    private String licenseNumber;
    private String VehicleType; 
    public Vehicle(String licenseNumber, String VehicleType) {
        this.licenseNumber = licenseNumber;
        this.VehicleType = VehicleType;
    }
    public String getLicenseNumber() {
        return licenseNumber;
    }
    public String getType() {
        return VehicleType;
    }
}
class ParkingSpace {
    private int spaceNumber;
    private boolean IsOccupied;
    private Vehicle ParkedVehicle;
    private long parkStartTime; 
    private static final double COST_PER_HOUR= 3.0;

    public ParkingSpace(int spaceNumber) {
        this.spaceNumber = spaceNumber;
        this.IsOccupied = false;
        this.ParkedVehicle = null;
        this.parkStartTime = System.currentTimeMillis(); 
    }
    public int getSpaceNumber() {
        return spaceNumber;
    }
    public boolean isOccupied() {
        return IsOccupied;
    }
    public Vehicle getParkedVehicle() {
        return ParkedVehicle;
    }
    public void parkVehicle(Vehicle vehicle) {
        if (!IsOccupied) {
            this.ParkedVehicle = vehicle;
            this.IsOccupied = true;
            System.out.println(vehicle.getType() + "  is parked space in  " + spaceNumber);
        } else {
            System.out.println("Parking space " + spaceNumber + " is already occupied.");
        }
    }
    public void unParkVehicle() {
        if (IsOccupied) {
            long parkEndTime = System.currentTimeMillis();
            double parkingDuration = (parkEndTime - parkStartTime) /(1000.0 * 60.0 * 60.0);
            double parkingFee = parkingDuration * COST_PER_HOUR;
            
            System.out.println(ParkedVehicle.getType() + " removed from space " + spaceNumber);
            System.out.println("Parking duration: " + parkingDuration + " hours");
            System.out.println("Parking fee: " + parkingFee + "  ruppes");

            this.ParkedVehicle = null;
            this.IsOccupied = false;
        } else {
            System.out.println("Parking space " + spaceNumber + " is already vacant.");
        }
    }
}

class Attendant {
    private String name;
    public Attendant(String name) {
        this.name = name;
    }
    public String getname() {
        return name;
    }

    public void parkVehicle(ParkingSpace parkingSpace, Vehicle vehicle) {
        if (!parkingSpace.isOccupied()) {
            parkingSpace.parkVehicle(vehicle);
        } else {
            System.out.println("Parking space " + parkingSpace.getSpaceNumber() + " is occupied.");
        }
    }
    public void vacantParkingSpace(ParkingSpace parkingSpace) {
        parkingSpace.unParkVehicle();
    }
}
class ParkingLot {
    private List<ParkingSpace> parkingSpaces;

    public ParkingLot(int NoOfspaces) {
        parkingSpaces = new ArrayList<>();
        for (int i = 1; i <= NoOfspaces; i++) {
            parkingSpaces.add(new ParkingSpace(i));
        }
    }

    public List<ParkingSpace> getParkingSpaces() {
        return parkingSpaces;
    }
}

public class ParkingManagement {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(50);
        Vehicle car = new Vehicle("BIH345", "Car");
        Vehicle bike = new Vehicle("PUB897", "Bike");
        Vehicle van = new Vehicle("BIH786", "Van");
        Vehicle bus = new Vehicle("PUB987", "Bus");
        Attendant attendant = new Attendant("Kriti");
        Attendant attendant1 = new Attendant("Jaiswal");
        Attendant attendant2 = new Attendant("Raushni");
        Attendant attendant3 = new Attendant("Vaibhav");
        ParkingSpace parkingSpace = parkingLot.getParkingSpaces().get(0);
        ParkingSpace parkingSpace1 = parkingLot.getParkingSpaces().get(1);
        ParkingSpace parkingSpace2 = parkingLot.getParkingSpaces().get(2);
        ParkingSpace parkingSpace3 = parkingLot.getParkingSpaces().get(3);
        // attendant managing the parking space if it is occupied or not .
        attendant.parkVehicle(parkingSpace, car);
        attendant1.parkVehicle(parkingSpace1, bike);
        attendant2.parkVehicle(parkingSpace2, van);
        attendant3.parkVehicle(parkingSpace3, bus);
        //attendant unparking the vehichle
        attendant.vacantParkingSpace(parkingSpace);
        attendant1.vacantParkingSpace(parkingSpace1);
        attendant.vacantParkingSpace(parkingSpace2);
        attendant1.vacantParkingSpace(parkingSpace3);

    }
}
