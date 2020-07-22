public class Atak {

    private String name;
    private int damageDone;
    private int initiativeCost;
    private String chlopakID;

    public String getName() {
        return name;
    }

    public int getDamageDone() {
        return damageDone;
    }

    public int getInitiativeCost() {
        return initiativeCost;
    }

    public Atak(String name, int damageDone, int initiativeCost, String chlopakID) {
        this.name = name;
        this.damageDone = damageDone;
        this.initiativeCost = initiativeCost;
        this.chlopakID = chlopakID;
    }

    public String getChlopakID() {
        return chlopakID;
    }
}
