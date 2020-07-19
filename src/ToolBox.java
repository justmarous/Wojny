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
}
