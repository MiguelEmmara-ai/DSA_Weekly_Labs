package chapter1;


/**
 * @author sehall
 */
public class RapBattle {

    public static void main(String[] args) {
        RapBattle turns = new RapBattle();
        Biggie biggie = new Biggie(turns, true);
        TuPac tupac = new TuPac(turns, false);

        Thread t1 = new Thread(biggie);
        Thread t2 = new Thread(tupac);
        t2.start();
        t1.start();
    }
}
