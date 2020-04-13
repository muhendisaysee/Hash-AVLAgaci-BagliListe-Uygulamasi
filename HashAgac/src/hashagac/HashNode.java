package hashagac;

public class HashNode {

    String isim;
    int ulkeNo;
    boolean Kontrol;
    HashNode ileri;

    HashNode(String isim, int numara, boolean Kontrol) {
        this.isim = isim;
        this.ulkeNo = numara;
        this.Kontrol = Kontrol;

    }
}
