import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ToolBox.start();
        boolean dalej=true;
        theArchitect.instrukcja();

        do{
            int tryb = theArchitect.trybGry();
            if(tryb==3) {
                theArchitect.turniej();
                System.out.println("Zaczynamy turniej! Walczysz z każdym chłopakiem po kolei.");
            }

            if(tryb!=3) {
                Chlopak gracz = theArchitect.wyborGracz();
                ToolBox.time(3);
                Chlopak przeciwnik = theArchitect.wyborPrzeciwnik();
                ToolBox.time(8);

                ToolBox.komunikatInicjatywa(gracz, przeciwnik);

                ToolBox.time(4);
                System.out.println("\n\n\n****\n****\nWalka się rozpoczyna!\n****\n****\n");

                Walka.walka(gracz, przeciwnik, tryb);

                System.out.println("Czy chcesz walczyć dalej?\n\t0 -> tak\n\t1 -> nie");
                int dalejInt = scanner.nextInt();
                if (dalejInt == 1)
                    dalej = false;
            }
        }while(dalej);

        System.out.println("Do zobaczenia zatem!");

    }


}
