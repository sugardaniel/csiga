package csiga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Jatek
{
    public void start()
    {
        final String PIROS = "piros";
        final String ZOLD = "zöld";
        final String KEK = "kék";
        final List<String> SZINEK = Arrays.asList(PIROS, ZOLD, KEK);

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        List<Csiga> csigak = new ArrayList<>();
        Csiga pirosCsiga = new Csiga(0, SZINEK.get(0), false, 1);
        Csiga zoldCsiga = new Csiga(0, SZINEK.get(1), false, 1);
        Csiga kekCsiga = new Csiga(0, SZINEK.get(2), false, 1);
        csigak.add(pirosCsiga);
        csigak.add(zoldCsiga);
        csigak.add(kekCsiga);

        System.out.println("Melyik csigára fogad? p/z/k");
        char fogadas = sc.nextLine().charAt(0);

        for(int i=1;i<=5;++i) {
            System.out.println(i + ". kör");
            int gyorsitoRandom = random.nextInt(10) + 1; //1-10
            if(gyorsitoRandom <= 2) {
                String gyorsitottCsigaSzin = SZINEK.get(random.nextInt(3));
                System.out.println(gyorsitottCsigaSzin + " csiga gyorsítót kapott!");
                switch (gyorsitottCsigaSzin) {
                    case PIROS -> pirosCsiga.setKap(true);
                    case ZOLD -> zoldCsiga.setKap(true);
                    default -> kekCsiga.setKap(true);
                }
            }
            for(Csiga csiga : csigak) {
                String szin = csiga.getSzin();
                int lepes = random.nextInt(4); //0-3-ig kap egy random lépésszámot
                if(csiga.isKap()) { //ha Ő kapott gyorsítót, akkor duplát lép
                    lepes = lepes * 2;
                }
                System.out.println(i + ". körben " + szin + " csiga " + lepes + " egységet megy.");

                csiga.setMessze(csiga.getMessze() + lepes);
                System.out.println(szin + " csiga messzesége: " + csiga.getMessze());
                csiga.setKap(false); //visszaállítjuk, ha esetleg gyorsítót kapott, hogy a következő körben már ne kapjon dupla lépést egyből
            }

            System.out.println("--------------------");
        }

        //győztes Csiga meghatározása (ki jutott a legmesszebb)
        Csiga gyoztes = getGyoztesCsiga(csigak);
        System.out.println("A győztes csiga színe: " + gyoztes.getSzin());
        if(talalat(gyoztes, fogadas)) {
            System.out.println("Gratulálok, eltaláltad a győztest!");
        } else {
            System.out.println("Sajnos most nem sikerült eltalálnod a győztes csigát :(");
        }
    }

    private Csiga getGyoztesCsiga(List<Csiga> csigak) {
        return Collections.max(csigak, Comparator.comparing(Csiga::getMessze));
    }

    private boolean talalat(Csiga gyoztesCsiga, char fogadas) {
        return fogadas == gyoztesCsiga.getSzin().charAt(0);
    }
}
