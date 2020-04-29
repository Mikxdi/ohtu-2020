
package ohtu.intjoukkosovellus;

public class IntJoukko {


    private int kasvatuskoko;
    private int[] joukko;      // Joukon luvut säilytetään taulukon alkupäässä.
    private int taulukonKoko;    // Tyhjässä joukossa alkioiden_määrä on nolla.

    public IntJoukko() {
            this(5, 5);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, 5);

    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
            this.joukko = new int[kapasiteetti];
            this.kasvatuskoko = kasvatuskoko;
            this.taulukonKoko=0;
    }

    public boolean lisaa(int luku) {

        if (!kuuluu(luku)) {
            if (joukko.length == taulukonKoko) {
                joukko = kastavataJaKopioi();
            }
            joukko[taulukonKoko]=luku;
            taulukonKoko++;
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < taulukonKoko; i++) {
            if (luku == joukko[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        for(int i = 0; i < taulukonKoko; i++){
            if(luku == joukko[i]){
                taulukonKoko--;
                joukko[i] = joukko[taulukonKoko-1];
                return true;
            }
        }


        return false;
    }

    private int[] kastavataJaKopioi(int[] vanha) {
        int[] uusi = new int[taulukonKoko + kasvatuskoko];
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
        return uusi;

    }

    public int mahtavuus() {
        return taulukonKoko;
    }


    @Override
    public String toString() {
        String tuloste = "{";
        for (int i = 0; i < taulukonKoko; i++) {
            tuloste += joukko[i];
            if (i < taulukonKoko - 1) {
                tuloste += ", ";
            }
        }
        tuloste += "}";
        return tuloste;
    }

    public int[] toIntArray() {
        int[] taulu = new int[taulukonKoko];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = joukko[i];
        }
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaa(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkaus = new IntJoukko();
        for (Integer luku : a.toIntArray()) {
            if (b.kuuluu(luku)) {
                leikkaus.lisaa(luku);
            }
        }
        return leikkaus;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko erotus = new IntJoukko();
        for (Integer luku : a.toIntArray()) {
            if (!b.kuuluu(luku)) {
                erotus.lisaa(luku);
            }
        }
        return erotus;
    }
        
}
