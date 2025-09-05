package tp2.ej2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Continente america = new Continente("America");
        Pais argentina = new Pais("Argentina", america);

        argentina.setPaisLimitrofe(new Pais("Brasil", america));
        argentina.setPaisLimitrofe(new Pais("Chile", america));
        argentina.setPaisLimitrofe(new Pais("Uruguay", america));
        argentina.setPaisLimitrofe(new Pais("Paraguay", america));
        argentina.setPaisLimitrofe(new Pais("Bolivia", america));
        argentina.setPaisLimitrofe(new Pais("Brasil", america));

        Provincia buenosAires = new Provincia("Buenos Aires", argentina);
        Ciudad caba = new Ciudad("CABA", buenosAires);
        caba.setCapital();
        System.out.println(america);
        System.out.println(argentina);
        System.out.println(buenosAires);
        System.out.println(caba);
    }
}