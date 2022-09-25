
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Loading all vessels!");
        Vessels k = new Vessels();
        RoRo b = new RoRo();

        b.loadingCargo(10, 5);

        k.Vessel("Denmark", Tankers.class.getName(), 10, 200, 10);
    }
}

class Vessels {
    String vesselType, flagNation;
    int draft, length, width;

    public void Vessel(String flagNation, String vesselType, int draft, int length, int width) {
        this.flagNation = flagNation;
        this.vesselType = vesselType;
        this.draft = draft;
        this.length = length;
        this.width = width;

        System.out.println("Flagnation: " + flagNation + " | Vessel Type: " + vesselType + " | draft: " + draft
                + " | length: " + length + " | width: " + width);
    }
}

class RoRo extends Vessels {
    int carLength = 8;
    int truckLength = 30;
    int amountCars, amountTrucks, fraction;

    public boolean checkCargo() {
        return carLength + truckLength <= length;
    }

    public boolean checkFraction() {
        return true;
    }

    public int loadingCargo(int amountCars, int amountTrucks) {
        this.amountCars = amountCars * carLength;
        this.amountTrucks = amountTrucks * truckLength;

        System.out.println(
                "The length of all cars: " + this.amountCars + " | The length of all trucks: " + this.amountTrucks);

        return amountCars;
    }

    public int utilityLevelOfCapacity() { // En måde at udregne vores fraction af båden
        return fraction;
    }
}

class Tankers extends Vessels {
    int compartments;

    public Tankers(String flagNation, String vesselType, int draft, int length, int width) {
        // super(flagNation, Tankers.class.getClass(), draft, length, width);
    }

    void loadingCargo() {

    }

    void utilityLevelOfCapacity() {

    }
}

class Containers extends Vessels {
    int amountOfContainers;

    public Containers(String flagNation, int draft, int length, int width) {

    }

    void loadingCargo() {

    }

    void utilityLevelOfCapacity() {

    }
}