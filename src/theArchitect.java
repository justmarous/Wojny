import java.util.ArrayList;
import java.util.Scanner;

public class theArchitect {

    private static ArrayList<Chlopak> listaChlopakow = new ArrayList<Chlopak>();
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Atak> listaAtakow = new ArrayList<Atak>();

    public static void initiate()
    {
        createChlopaki();
        System.out.println("\n\n\n*****  Witamy w grze!!  ******\n\n\n");
    }

    public static Chlopak wyborGracz()
    {
        System.out.println("Wybierz swojego wojownika:");

        for(int i = 0;i<listaChlopakow.size();i++)
        {
            System.out.println("\t"+i+" -> "+listaChlopakow.get(i).getName());
        }

        int choice = scanner.nextInt();
        Chlopak gracz = new Chlopak(theArchitect.listaChlopakow.get(choice));
        System.out.println("\nWybrano postać: "+gracz.getName());

        return gracz;
    }

    public static Chlopak wyborPrzeciwnik()
    {
        System.out.println("Wybierz swojego przeciwnika:");

        for(int i = 0;i<listaChlopakow.size();i++)
        {
            System.out.println("\t"+i+" -> "+listaChlopakow.get(i).getName());
        }

        int choice = scanner.nextInt();
        Chlopak przeciwnik = new Chlopak(theArchitect.listaChlopakow.get(choice));
        System.out.println("\nWybrano przeciwnika: "+przeciwnik.getName()+"\n\n");

        return przeciwnik;

    }

    public static void createAtaki()
    {

        addAtt("Strzał",5,4,"Hubert");
        addAtt("Przycelowany strzał",10,7,"Hubert");
        addAtt("Teleportacja i strzał w plecy",5,6,"Hubert");
        addAtt("Zapadnia", 1,0,"Hubert");

        addAtt("Trzepotanie skrzydłami",4,2,"Dawid");
        addAtt("Strzał z łuku",2,1,"Dawid");
        addAtt("Wir powietrzny",7,5,"Dawid");
        addAtt("Ucieczka",-3,-2,"Dawid");

        addAtt("Kręcenie na nogach",7,8,"Marek");
        addAtt("Mocne uderzenie",7,7,"Marek");
        addAtt("Kopnięcie",3,3,"Marek");
        addAtt("Zebranie energii", 0,-3,"Marek");


    }

    public static void createChlopaki()
    {
        createAtaki();

        Chlopak hubert = new Chlopak(15,20,"Hubert");
        Chlopak marek = new Chlopak(20,20,"Marek");
        Chlopak dawid = new Chlopak(10,15,"Dawid");


        listaChlopakow.add(hubert);
        listaChlopakow.add(marek);
        listaChlopakow.add(dawid);

    }

    public static void addAtt (String nazwaAtaku,int damageDone,int initiativeCost,String chlopakID)
    {
        Atak atak = new Atak (nazwaAtaku,damageDone,initiativeCost,chlopakID);
        listaAtakow.add(atak);
    }


}
