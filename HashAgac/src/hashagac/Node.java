package hashagac;

public class Node {

    int yukseklik;
    String isim;
    int ulkeNo;
    boolean Kontrol;
    Node sol;
    Node sag;

    Node(String isim, int numara, boolean Kontrol) {
        this.isim = isim;
        this.ulkeNo = numara;
        this.Kontrol = Kontrol;
        sol = null;
        sag = null;
    }
}
