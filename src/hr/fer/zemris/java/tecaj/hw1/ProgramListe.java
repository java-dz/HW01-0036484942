package hr.fer.zemris.java.tecaj.hw1;

/**
 * Program sadrži jedan statički ugniježđen razred (strukturu čvora liste) te
 * metode za ubacivanje, prebrojavanje, ispisivanje i sortiranje elemenata.
 *
 * @author Mario Bobic
 */
public class ProgramListe {

    /**
     * Struktura jednog čvora liste koja zadrži referencu na sljedeći čvor u
     * listi te podatak čvora.
     *
     * @author Marko Čupić
     */
    static class CvorListe {
        /** Referenca na sljedeći čvor u listi */
        CvorListe sljedeci;
        /** Podatak čvora */
        String podatak;
    }

    /**
     * Metoda koja se poziva prilikom pokretanja programa. Metoda stvara
     * nekoliko čvorova liste gdje su podaci Stringovi ženskih imena. Zatim se
     * ispisuje lista uz njezin originalni poredak. Nakon toga lista se sortira
     * te ispisuje sortirana. Zadnje se ispisuje broj elemenata koji lista sadrži.
     *
     * @param args ne koristi se u ovom primjeru
     */
    public static void main(String[] args) {
        CvorListe cvor = null;

        cvor = ubaci(cvor, "Jasna");
        cvor = ubaci(cvor, "Ana");
        cvor = ubaci(cvor, "Ivana");
//        cvor = ubaci(cvor, "Zeljka");
//        cvor = ubaci(cvor, "Mirjana");
//        cvor = ubaci(cvor, "Stefica");
//        cvor = ubaci(cvor, "Karla");

        System.out.println("Ispisujem listu uz originalni poredak:");
        ispisiListu(cvor);

        cvor = sortirajListu(cvor);

        System.out.println("Ispisujem listu nakon sortiranja:");
        ispisiListu(cvor);

        int vel = velicinaListe(cvor);
        System.out.println("Lista sadrzi elemenata: " + vel);
    }

    /**
     * Vraća veličinu liste prebrojavajući sve elemente od početka do kraja.
     *
     * @param cvor čvor liste od kuda se počinje prebrojavanje
     * @return veličinu liste
     */
    private static int velicinaListe(CvorListe cvor) {
        int brojac = 0;
        for (; cvor != null; cvor = cvor.sljedeci) {
            brojac++;
        }

        return brojac;
    }

    /**
     * Stvara novi čvor u listi sa zadanim podatkom, ubacuje ga na kraj liste te
     * vraća referencu na prvi čvor u listi.
     *
     * @param prvi prvi čvor u listi
     * @param podatak podatak koji treba ubaciti
     * @return referencu na prvi čvor u listi
     */
    private static CvorListe ubaci(CvorListe prvi, String podatak) {
        CvorListe novi = new CvorListe();
        novi.podatak = podatak;
        novi.sljedeci = null;

        if (prvi == null) {
            prvi = novi;
        } else {
            CvorListe temp;
            for (temp = prvi; temp.sljedeci != null; temp = temp.sljedeci);
            temp.sljedeci = novi;
        }

        return prvi;
    }

    /**
     * Ispisuje sadržaj liste (podatke) počevši od danog čvora do kraja liste.
     *
     * @param cvor čvor liste
     */
    private static void ispisiListu(CvorListe cvor) {
        for (; cvor != null; cvor = cvor.sljedeci) {
            System.out.println(cvor.podatak);
        }
    }

    /**
     * Sortira listu uzlazno po abecedi počevši od danog čvora, tako da čvorovi
     * budu leksikografski sortirani po svojim podatcima. Vraća referencu na
     * (novi) prvi član liste. Sortiranje liste vrši se u složenosti O(n^2).
     *
     * @param cvor čvor liste od kojeg počinje sortiranje
     * @return referencu na prvi član sortirane liste
     */
    private static CvorListe sortirajListu(CvorListe cvor) {
        if (velicinaListe(cvor) < 2) return cvor;

        boolean sortirano;
        do {
            sortirano = true;
            for (CvorListe pom = cvor; pom != null; pom = pom.sljedeci) {
                CvorListe sljed = pom.sljedeci;
                if (sljed != null && pom.podatak.compareTo(sljed.podatak) > 0) {
                    String temp = pom.podatak;
                    pom.podatak = sljed.podatak;
                    sljed.podatak = temp;
                    sortirano = false;
                }
            }
        } while (!sortirano);

        return cvor;
    }

}
