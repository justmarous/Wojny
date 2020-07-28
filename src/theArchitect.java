import java.sql.SQLOutput;
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
        addAtt("Przycelowany strzał",7,7,"Hubert");
        addAtt("Teleportacja i strzał w plecy",5,6,"Hubert");
        addAtt("Zapadnia", 1,0,"Hubert");

        addAtt("Trzepotanie skrzydłami",4,2,"Dawid");
        addAtt("Strzał z łuku",2,1,"Dawid");
        addAtt("Wir powietrzny",7,5,"Dawid");
        addAtt("Ucieczka", 0,-3,"Dawid");

        addAtt("Kręcenie się na głowie z wykopami",10,13,"Marek");
        addAtt("Mocne uderzenie",7,7,"Marek");
        addAtt("Kopnięcie w żebra",3,3,"Marek");
        addAtt("Zebranie energii", 0,-3,"Marek");

        addAtt("Szarża",5,5,"Mikołaj");
        addAtt("Nadzianie mieczem",3,3,"Mikołaj");
        addAtt("Szturchnij",1,0,"Mikołaj");
        addAtt("Wielkie Machnięcie",10,13,"Mikołaj");

        addAtt("Powolna macka",3,2,"Tadeusz");
        addAtt("Podejrzane łypnięcie",1,-2,"Tadeusz");
        addAtt("Pastwienie się",2,-1,"Tadeusz");
        addAtt("Wielka macka", 4,5,"Tadeusz");

        addAtt("Błotny atak",4,5,"Konrad");
        addAtt("Zawistny skrzek",2,-2,"Konrad");
        addAtt("Kula ziemi",10,15,"Konrad");
        addAtt("Rzut kamieniem",3,4,"Konrad");

        addAtt("Uderzenie tarczą",2,-2,"Tomasz");
        addAtt("Uderzenie mieczem",5,5,"Tomasz");
        addAtt("Sprint rycerza",4,4,"Tomasz");
        addAtt("Wojenny zaśpiew",-1,-5,"Tomasz");

        addAtt("Czytanie ruchu przeciwnika",0,-10,"Dynia");
        addAtt("Ból głowy",3,3,"Dynia");
        addAtt("Rozszarpanie materii",6,7,"Dynia");
        addAtt("Miażdż mózg",10,10,"Dynia");
    }

    public static void createChlopaki()
    {
        createAtaki();

        addChl("Hubert",15,15);
        addChl("Marek",13,12);
        addChl("Dawid",11,13);
        addChl("Mikołaj",12,13);
        addChl("Tadeusz",17,5);
        addChl("Konrad",10,17);
        addChl("Tomasz",12,9);
        addChl("Dynia",11,11);

    }

    private static void addAtt (String nazwaAtaku,int damageDone,int initiativeCost,String chlopakID)
    {
        Atak atak = new Atak (nazwaAtaku,damageDone,initiativeCost,chlopakID);
        listaAtakow.add(atak);
    }

    private static void addChl (String imie,int healthPoints, int initativePoints)
    {
        Chlopak chlopak = new Chlopak(healthPoints,initativePoints,imie);
        listaChlopakow.add(chlopak);
    }

    public static int trybGry()
    {
        System.out.println("Jaki tryb gry Cię interesuje?\n\t0 -> Gracz VS Komputer\n\t1 -> Gracz VS Gracz\n\t2 -> Komputer VS Komputer\n\t3 -> TURNIEJ (Gracz VS Komputer)");

        return scanner.nextInt();
    }

    public static void instrukcja()
    {
            System.out.println("*** INSTRUKCJA ***\nChodzi o to zeby pokonac swojego przeciwnika w walce 1 na 1\n" +
                    "Kazdy bohater ma inna liczbe pkt ZYCIA \n\toraz inna liczbe pkt INICJATYWY.\n"+
                    "Zaczyna gracz, ktory ma wiecej INICJATYWY na poczatku gry\n"+
                    "Aby pokonac przeciwnika, musisz odebrac mu pkt ZYCIA \n\t- przegrywasz gdy Twoje spadna do zera.\n"+
                    "Atak wybierasz w kazdej rundzie walki \n\t- placisz za nie uzywajac pkt INICJATYWY\n"+
                    "Przy kazdym ataku widzisz ile OBRAZEN zadaje atak, \n\ta takze ile kosztuje INICJATYWY\n"+
                    "Niektore ataki maja wartosc UJEMNA OBRAZEN lub INICJATYWY\n"+
                    "Oznacza to ze atak powoduje \n\tREGENRACJE PUNKTOW ZYCIA przeciwnika \n\tlub Twoich PUNKTOW INICJATYWY\n"+
                    "Wszystkie akcje wykonujesz wpisujac dana cyfre \n\ti zatwierdzajac wybor klawiszem ENTER\n"+
                    "To wszystko! Jestes gotowy do walki.\n\n"+
                    "Naciśnij ENTER dwa razy, żeby kontynuowac...");
            String readString = scanner.nextLine();
            scanner.nextLine();
            while(readString!=null) {
                if (readString.isEmpty()) {
                    break;
                }
                if (scanner.hasNextLine()) {
                    readString = scanner.nextLine();
                } else {
                    readString = null;
                }
            }
    }

    public static void turniej()
    {
        Chlopak gracz = wyborGracz();
        boolean wygrana = true;
        int counter=0;

        while(wygrana&&counter!=8)
        {
            Chlopak przeciwnik = new Chlopak(theArchitect.listaChlopakow.get((int)(8*Math.random())));
            System.out.println("\nWalczysz z : "+przeciwnik.getName().toUpperCase()+"!!! \n\n");
            counter++;
            wygrana=Walka.walka(gracz,przeciwnik,0);
        }
        if(wygrana) System.out.println("Gratuluję!!! Rozwaleni w mak");
        else System.out.println("No nic, następnym razem.");
    }



}
