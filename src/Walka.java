import java.util.Scanner;

public class Walka {

    private static Scanner scanner = new Scanner(System.in);

    public static boolean inicjatywa(Chlopak gracz, Chlopak przeciwnik)
    {
        if(gracz.getInitiativePoints()>=przeciwnik.getInitiativePoints())
        {
            return true;
        }

       else
        {
            return false;
        }
    }

    public static void wybierzAtak(Chlopak gracz)
    {
        System.out.println("Twoje dostępne ataki: "+gracz.getAtaki());
    }

    public static void walka(Chlopak gracz,Chlopak przeciwnik)
    {
        int graczHp = gracz.getHealthPoints();
        int przeciwnikHp = przeciwnik.getHealthPoints();

        int graczInit = gracz.getInitiativePoints();
        int przeciwnikInit = przeciwnik.getInitiativePoints();

        boolean narpiej = inicjatywa(gracz,przeciwnik);
        WynikWalki uderzenie;

        if(narpiej) {
            ToolBox.timeClean(7);

            uderzenie = ruch(gracz,graczInit);
            przeciwnikHp -= uderzenie.getHpDamage();
            graczInit -= uderzenie.getInitCost();
        }


        while(graczHp>0&&przeciwnikHp>0)
        {ToolBox.timeClean(7);


            uderzenie = ruchAI(przeciwnik,przeciwnikInit);
            graczHp-=uderzenie.getHpDamage();
            przeciwnikInit-=uderzenie.getInitCost();
            ToolBox.timeClean(7);

            if(narpiej)System.out.println("Gracz ma "+graczHp+" HP || przeciwnik ma "+przeciwnikHp+" HP");
            ToolBox.timeClean(7);

            uderzenie = ruch(gracz, graczInit);
            przeciwnikHp -= uderzenie.getHpDamage();
            graczInit -= uderzenie.getInitCost();
            ToolBox.timeClean(7);

            if(!narpiej)System.out.println("Gracz ma "+graczHp+" HP || przeciwnik ma "+przeciwnikHp+" HP");

        }
        if(graczHp <=0 )
        {
            ToolBox.timeClean(7);

            System.out.println("Zostałeś pokonany przez "+przeciwnik.getName());
        }
        else
        {
            ToolBox.timeClean(7);

            System.out.println("Wygrałeś z "+przeciwnik.getName());
        }
    }

    public static WynikWalki ruch(Chlopak chlopak,int init)
    {
        WynikWalki wynik;
        if(sprawdzAtaki(chlopak,init))
        {
            System.out.println("Wybierz swój atak...\n\t masz obecnie "+init+" punktów inicjatywy");
            chlopak.printAtaki();

            int choice = scanner.nextInt();

            if(chlopak.getAtaki().get(choice).getInitiativeCost()>init)
            {
                System.out.println("Nie masz siły by wykonać ten atak");
                choice = 0;
            }

            Atak atak = chlopak.getAtaki().get(choice);

            System.out.println("Atakujesz: " + atak.getName());
            init -= atak.getInitiativeCost();
            ToolBox.timeClean(7);

            System.out.println("\tAtak odbiera " + atak.getDamageDone() + " punktów życia \n \tZostało Ci jeszcze " + init + " punktów inicjatywy\n");

            wynik = new WynikWalki(atak.getDamageDone(), atak.getInitiativeCost());

        }

        else
        {
            System.out.println("Jesteś zbyt zmęczony by zrobić cokolwiek.");
            wynik = new WynikWalki(0,0);
        }

        return wynik;

    }

    public static WynikWalki ruchAI(Chlopak chlopak,int init)
    {
        ToolBox.timeClean(7);

        Atak atak = chlopak.getAtaki().get(0);
        System.out.println("Przeciwnik atakuje: "+atak.getName());

        ToolBox.timeClean(7);

        System.out.println("\tAtak odbiera Ci "+atak.getDamageDone()+" punktów życia\n\t");

        WynikWalki wynik = new WynikWalki(atak.getDamageDone(),atak.getInitiativeCost());

        return wynik;
    }

    public static boolean sprawdzAtaki(Chlopak chlopak, int init)
    {
        for(int i =0;i<chlopak.getAtaki().size();i++)
        {
            if(init>chlopak.getAtaki().get(i).getInitiativeCost()) return true;
        }
        return false;
    }

}
