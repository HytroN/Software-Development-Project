
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Loading all vessels!");
        RoRo b = new RoRo("DK", 10, 100, 20);

        System.out.println(b.checkCargo());

        b.loadingCargo(10, 5);
        System.out.println(b.checkLoad());

        b.loadingCargo(10, 5);
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
    }
}

class RoRo extends Vessels {
    int carLength = 8;
    int truckLength = 30;
    int amountCars, amountTrucks, fraction;

    public RoRo(String flagNation, int draft, int length, int width) {
        super.flagNation = flagNation;
        super.vesselType = RoRo.class.getName();
        super.draft = draft;
        super.length = length;
        super.width = width;
        // super(flagNation, Tankers.class.getClass(), draft, length, width);
    }

    public String checkCargo() {
        return "Flag Nation: " + flagNation + " | Vessel Type: " + vesselType + " | draft: " + draft
                + " | length: " + length + " | width: " + width;
    }

    public int checkFraction() {
        return fraction;
    }

    public String checkLoad() {
        return "Amount of cars: " + amountCars + " | Amount of trucks: " + amountTrucks;
    }

    public void loadingCargo(int amountCars, int amountTrucks) {
        this.amountCars = amountCars;
        this.amountTrucks = amountTrucks;
    }

    public int utilityLevelOfCapacity() { // En måde at udregne vores fraction af båden
        return fraction;
    }
}

class Tankers extends Vessels {
    int compartments;

    public Tankers(String flagNation, int draft, int length, int width) {
        super.flagNation = flagNation;
        super.vesselType = Tankers.class.getName();
        super.draft = draft;
        super.length = length;
        super.width = width;
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
        super.flagNation = flagNation;
        super.vesselType = Containers.class.getName();
        super.draft = draft;
        super.length = length;
        super.width = width;
    }

    void loadingCargo() {

    }

    void utilityLevelOfCapacity() {

    }
}