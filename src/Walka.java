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

    public static boolean walka(Chlopak gracz,Chlopak przeciwnik,int tryb)
    {


        int graczHp = gracz.getHealthPoints();
        int przeciwnikHp = przeciwnik.getHealthPoints();

        int graczInit = gracz.getInitiativePoints();
        int przeciwnikInit = przeciwnik.getInitiativePoints();

        boolean narpiej = inicjatywa(gracz,przeciwnik);
        WynikWalki uderzenie;

        switch (tryb)
        {
            case 0: // p vs e
                if (narpiej) {
                    ToolBox.timeClean(7);

                    uderzenie = ruchHuman(gracz, graczInit);
                    //  uderzenie = ruch(gracz,graczInit,tryb);
                    przeciwnikHp -= uderzenie.getHpDamage();
                    graczInit -= uderzenie.getInitCost();

                }
                while (graczHp > 0 && przeciwnikHp > 0) {
                    ToolBox.timeClean(7);


                    uderzenie = ruchAI(przeciwnik, przeciwnikInit);
                    graczHp -= uderzenie.getHpDamage();
                    przeciwnikInit -= uderzenie.getInitCost();
                    ToolBox.timeClean(7);

                    if (narpiej)
                        System.out.println("Gracz ma " + graczHp + " HP || przeciwnik ma " + przeciwnikHp + " HP");
                    ToolBox.timeClean(7);

                    if (graczHp <= 0) break;

                    uderzenie = ruchHuman(gracz, graczInit);
                    przeciwnikHp -= uderzenie.getHpDamage();
                    graczInit -= uderzenie.getInitCost();
                    ToolBox.timeClean(7);

                    if (!narpiej)
                        System.out.println("Gracz ma " + graczHp + " HP || przeciwnik ma " + przeciwnikHp + " HP");

                }
                break;
            case 1: // p vs p
                if (narpiej) {
                    ToolBox.timeClean(7);

                    uderzenie = ruchHuman(gracz, graczInit);
                    przeciwnikHp -= uderzenie.getHpDamage();
                    graczInit -= uderzenie.getInitCost();

                }
                while (graczHp > 0 && przeciwnikHp > 0) {
                    ToolBox.timeClean(7);


                    uderzenie = ruchHuman(przeciwnik, przeciwnikInit);
                    graczHp -= uderzenie.getHpDamage();
                    przeciwnikInit -= uderzenie.getInitCost();
                    ToolBox.timeClean(7);

                    if (narpiej)
                        System.out.println("Gracz ma " + graczHp + " HP || przeciwnik ma " + przeciwnikHp + " HP");
                    ToolBox.timeClean(7);

                    if (graczHp <= 0) break;

                    uderzenie = ruchHuman(gracz, graczInit);
                    przeciwnikHp -= uderzenie.getHpDamage();
                    graczInit -= uderzenie.getInitCost();
                    ToolBox.timeClean(7);

                    if (!narpiej)
                        System.out.println("Gracz ma " + graczHp + " HP || przeciwnik ma " + przeciwnikHp + " HP");

                }
                break;
            case 2 ://e vs e
                if (narpiej) {
                    ToolBox.timeClean(7);

                    uderzenie = ruchAI(gracz, graczInit);
                    przeciwnikHp -= uderzenie.getHpDamage();
                    graczInit -= uderzenie.getInitCost();

                }
                while (graczHp > 0 && przeciwnikHp > 0) {
                    ToolBox.timeClean(7);


                    uderzenie = ruchAI(przeciwnik, przeciwnikInit);
                    graczHp -= uderzenie.getHpDamage();
                    przeciwnikInit -= uderzenie.getInitCost();
                    ToolBox.timeClean(7);

                    if (narpiej)
                        System.out.println("Gracz ma " + graczHp + " HP || przeciwnik ma " + przeciwnikHp + " HP");
                    ToolBox.timeClean(7);

                    if (graczHp <= 0) break;

                    uderzenie = ruchAI(gracz, graczInit);
                    przeciwnikHp -= uderzenie.getHpDamage();
                    graczInit -= uderzenie.getInitCost();
                    ToolBox.timeClean(7);

                    if (!narpiej)
                        System.out.println("Gracz ma " + graczHp + " HP || przeciwnik ma " + przeciwnikHp + " HP");

                }
                break;
        }
            if (graczHp <= 0) {
                ToolBox.timeClean(7);

                System.out.println("Zostałeś pokonany przez " + przeciwnik.getName());
                return false;
            } else {
                ToolBox.timeClean(7);

                System.out.println("Wygrałeś z " + przeciwnik.getName());
                return true;
            }


    }

    public static WynikWalki ruchHuman(Chlopak chlopak, int init)
    {
        WynikWalki wynik;
        if(sprawdzAtaki(chlopak,init))
        {
            System.out.println("Wybierz swój atak...\n\t masz obecnie "+init+" pkt inicjatywy");
            chlopak.printAtaki();

            int choice = scanner.nextInt();

            while(chlopak.getAtaki().get(choice).getInitiativeCost()>init)
            {
                System.out.println("Nie masz siły by wykonać ten atak");
                System.out.println("Wybierz swój atak...\n\t masz obecnie "+init+" pkt inicjatywy");
                choice = scanner.nextInt();
            }

            Atak atak = chlopak.getAtaki().get(choice);

            System.out.println("Atakujesz: " + atak.getName());
            init -= atak.getInitiativeCost();
            ToolBox.timeClean(7);

            System.out.println("\tAtak odbiera " + atak.getDamageDone() + " pkt życia \n \tZostało Ci jeszcze " + init + " pkt inicjatywy\n");

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
        int random = 0;
        Atak atak;

        ToolBox.timeClean(7);

        do {

            random = (int)(4*Math.random());

            atak = chlopak.getAtaki().get(random);


        }while(init < chlopak.getAtaki().get(random).getInitiativeCost());


        System.out.println("Przeciwnik atakuje: "+atak.getName());
        ToolBox.timeClean(7);
        System.out.println("\tAtak odbiera "+atak.getDamageDone()+" pkt życia\n\t");
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

//    private static void ruch(Chlopak przeciwnik, Chlopak gracz,int tryb)
//    {
//        //tryb pve 0
//        //tryb pvp 1
//        //tryb eve 2
//
//        switch (tryb)
//        {
//            case 0:
//            {
//        }
//    }

}
