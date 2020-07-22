
import java.util.ArrayList;

public class Chlopak {

    private ArrayList<Atak> ataki;
    private int healthPoints;
    private int initiativePoints;
    private String name;

    public Chlopak(Chlopak chlopak)
    {
        this.ataki = chlopak.ataki;
        this.healthPoints = chlopak.healthPoints;
        this.initiativePoints = chlopak.healthPoints;
        this.name = chlopak.name;
    }

    public Chlopak(int healthPoints, int initiativePoints, String name) {
        this.healthPoints = healthPoints;
        this.initiativePoints = initiativePoints;
        this.name = name;
        this.ataki = znajdzAtaki();
    }

    public ArrayList<Atak> getAtaki() {
        return ataki;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getInitiativePoints() {
        return initiativePoints;
    }

    public String getName() {
        return name;
    }

    public void printAtaki()
    {
        znajdzAtaki();

        System.out.println("Twoje dostępne ataki: ");
        for (int i = 0;i<ataki.size();i++)
        {
            System.out.println(i+ ": "+ataki.get(i).getName()+" - "+ataki.get(i).getDamageDone()+" DMG | koszt "+ataki.get(i).getInitiativeCost()+" INIT");
        }
    }

    private ArrayList<Atak> znajdzAtaki()
    {
        ArrayList <Atak> atakiChlopaka = new ArrayList<Atak>();

        for(int i = 0;i<theArchitect.listaAtakow.size();i++)
        {
            if(this.name.equals(theArchitect.listaAtakow.get(i).getChlopakID()))
            {
                atakiChlopaka.add(theArchitect.listaAtakow.get(i));
                System.out.println("Przydzielono dla: "+this.name.toUpperCase()+" atak --- "+theArchitect.listaAtakow.get(i).getName());
            }
        }

        return atakiChlopaka;
    }


}
