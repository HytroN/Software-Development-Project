public class App {
    public static void main(String[] args) throws Exception {
        RoRo b = new RoRo("DK", 10, 400, 20);
        System.out.println(b.checkCargo());
        b.loadingCargo(10, 5);
        System.out.println(b.checkLoad());
        System.out.println(b.utilityLevelOfCapacity());

        // Containers k = new Containers("DE", 10, 200, 30, 10);
        // System.err.println(k.checkCargo());
        // System.out.println(k.amountOfContainers);
        // k.loadingCargo(10);
        // System.out.println(k.amountOfContainers);
        // System.out.println(k.utilityLevelOfCapacity());
        // System.out.println(k.checkLoad());

        // Tankers c = new Tankers("DE", 10, 200, 30, 10, 5);
        // System.out.println(c.checkCargo());
    }
}

class Vessels {
    String vesselType, flagNation;
    int draft, length, width, cargo;

    public void Vessel(String flagNation, String vesselType, int draft, int length, int width, int cargo) {
        this.flagNation = flagNation;
        this.vesselType = vesselType;
        this.draft = draft;
        this.length = length;
        this.width = width;
        this.cargo = cargo;
    }
}

class RoRo extends Vessels {
    int carLength = 8;
    int truckLength = 30;
    int totalCarsLength, totalTruckLength;
    double fraction;

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

    public String checkLoad() {
        return "Amount of cars: " + totalCarsLength + " | Amount of trucks: " + totalTruckLength;
    }

    public void loadingCargo(int totalCarsLength, int totalTruckLength) {
        if (length > ((totalCarsLength * carLength) + (totalTruckLength * truckLength))) {
            this.totalCarsLength = totalCarsLength * carLength;
            this.totalTruckLength = totalTruckLength * truckLength;
        } else {
            System.out.println("There is not space for that!");
        }
    }

    public String utilityLevelOfCapacity() { // En måde at udregne vores fraction af båden
        float length2 = length;
        this.fraction = ((this.totalCarsLength + this.totalTruckLength) / length2) * 100.0;
        return "Amount of space that are filled: " + fraction;
    }
}

class Tankers extends Vessels {
    int compartments;
    double fraction;

    public Tankers(String flagNation, int draft, int length, int width, int cargo, int compartments) {
        super.flagNation = flagNation;
        super.vesselType = Tankers.class.getName();
        super.draft = draft;
        super.length = length;
        super.width = width;
        super.cargo = cargo;
        this.compartments = compartments;
    }

    public String checkCargo() {
        return "Flag Nation: " + flagNation + " | Vessel Type: " + vesselType + " | draft: " + draft
                + " | length: " + length + " | width: " + width + " | Cargo: " + cargo + " | Amount of compartments: "
                + compartments;
    }

    void loadingCargo() {
        if (fraction < 100.0) {

        } else {
            System.out.println("There is not space for that!");
        }
    }

    public double utilityLevelOfCapacity() {
        // this.fraction =
        return fraction;
    }
}

class Containers extends Vessels {
    int amountOfContainers;
    double fraction;

    public Containers(String flagNation, int draft, int length, int width, int cargo) {
        super.flagNation = flagNation;
        super.vesselType = Containers.class.getName();
        super.draft = draft;
        super.length = length;
        super.width = width;
        super.cargo = cargo;
    }

    public int checkLoad() {
        return amountOfContainers;
    }

    public String checkCargo() {
        return "Flag Nation: " + flagNation + " | Vessel Type: " + vesselType + " | draft: " + draft
                + " | length: " + length + " | width: " + width + " | Cargo: " + cargo;
    }

    void loadingCargo(int amountOfContainers) {
        if (cargo >= amountOfContainers) {
            this.amountOfContainers = amountOfContainers;
        } else {
            System.out.println("There is no more space!");
        }
    }

    String utilityLevelOfCapacity() {
        float amountOfContainers = this.amountOfContainers;
        this.fraction = (amountOfContainers / cargo) * 100.0;
        return "Amount of space that are filled: " + fraction;
    }
}