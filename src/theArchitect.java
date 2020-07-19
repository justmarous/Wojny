import java.util.ArrayList;
import java.util.Scanner;

public class theArchitect {

    private static ArrayList<Chlopak> listaChlopakow = new ArrayList<Chlopak>();
    public static Scanner scanner = new Scanner(System.in);

    public static void initiate()
    {
        Atak shoot = new Atak("Strzał",5,5);
        Atak kick = new Atak("Kopnięcie",3,3);
        Atak aim = new Atak("Przycelowany strzał",10,10);
        Atak punch = new Atak("Mocne uderzenie",7,7);

        ArrayList<Atak> jedenAtaki = new ArrayList<Atak>();
        jedenAtaki.add(shoot);
        jedenAtaki.add(aim);

        ArrayList<Atak> dwaAtaki = new ArrayList<Atak>();
        dwaAtaki.add(kick);
        dwaAtaki.add(punch);

        Chlopak jeden = new Chlopak(jedenAtaki,15,20,"Strzelec");
        Chlopak dwa = new Chlopak(dwaAtaki,20,20,"Wojownik");

        listaChlopakow.add(jeden);
        listaChlopakow.add(dwa);
//
//        for(int i =0;i<listaChlopakow.size();i++)
//        {
//            System.out.println("Chlopak "+ listaChlopakow.get(i).getName()+" został stworzony. Ma ataki: "+listaChlopakow.get(i).getAtaki().get(0).getName()+" oraz "+ listaChlopakow.get(i).getAtaki().get(1).getName());
//        }

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


}
