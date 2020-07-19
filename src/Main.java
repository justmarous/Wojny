import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        start();
        boolean dalej=true;

        do{
            Chlopak gracz = theArchitect.wyborGracz();
            ToolBox.time(3);
            Chlopak przeciwnik = theArchitect.wyborPrzeciwnik();
            ToolBox.time(8);

            komunikatInicjatywa(gracz,przeciwnik);

            ToolBox.time(4);
            System.out.println("\n\n\n****\n****\nWalka się rozpoczyna!\n****\n****\n");


            Walka.walka(gracz,przeciwnik);

            System.out.println("Czy chcesz walczyć dalej?\n\t0 -> tak\n\t1 -> nie");
            int dalejInt = scanner.nextInt();
            if(dalejInt==1)
                dalej=false;

        }while(dalej);

        System.out.println("Do zobaczenia zatem!");

    }

    public static void komunikatInicjatywa(Chlopak gracz,Chlopak przeciwnik)
    {
        if(gracz.getInitiativePoints()>=przeciwnik.getInitiativePoints())
        {
            System.out.println("\nZaczynasz walkę! Powodzenia.\n");
        }

        else
        {
            System.out.println("Grę zaczyna wróg: "+przeciwnik.getName());
        }
    }

    public static void start()
    {
        ToolBox.time(8);
        theArchitect.initiate();
        ToolBox.time(5);
    }
}
