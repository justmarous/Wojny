public class ToolBox {

    public static void time(int czas) {
        System.out.println("Wczytywanie...");
        for (int l = 0; l < 60; l++) {
            if (l%2==0)
            {
                System.out.print("|");
            }

            for (double m = 0; m < (czas*1000000); m++) {
                m = m - 1 + 1;

            }
        }
        System.out.println();
    }

    public static void timeClean(int czas) {
        for (int l = 0; l < 60; l++) {
            if (l%2==0)
            {
                int wet=1;
            }

            for (double m = 0; m < (czas*1000000); m++) {
                m = m - 1 + 1;

            }
        }
        System.out.println();
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
