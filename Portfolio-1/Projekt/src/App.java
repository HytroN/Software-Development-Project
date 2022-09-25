import java.util.Vector;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Vessels k = new Vessels();

        k.Vessel("Denmark", "Roro", 10, 200, 10);
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
    int carsLength;
    int truckLength;

    void loadingCargo() {

    }

    void utilityLevelOfCapacity() {

    }
}

class Tankers extends Vessels {
    int compartments;

    public Tankers(String flagNation, int draft, int length, int width) {

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