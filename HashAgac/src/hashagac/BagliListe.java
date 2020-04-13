package hashagac;

public class BagliListe {

    HashNode bas;
    HashNode son;

    BagliListe() {
        bas = null;
        son = null;

    }

    public void elemanEkle(String isim, int ulkeNo, boolean kiyi) {
        HashNode yeniEleman = new HashNode(isim, ulkeNo, kiyi);
        if (bas == null) {
            bas = yeniEleman;
            son = yeniEleman;
        } else {
            son.ileri = yeniEleman;
            yeniEleman = son;
        }
    }

    public void elemanlariListele() {
        HashNode isaretci = bas;
        while (isaretci != null) {
            System.out.println("------------------------------------------------------");
            System.out.println("ulke ismi : " + isaretci.isim);
            System.out.println("ulke no : " + isaretci.ulkeNo);
            System.out.println("ulkenin denize kiyisi var mi ? : " + isaretci.Kontrol);
            isaretci = isaretci.ileri;
        }
    }

    public void elemanAra(int ulkeNo) {
        HashNode isaretci = bas;
        int sayac = 0;
        while (isaretci != null) {
            if (isaretci.ulkeNo == ulkeNo) {
                System.out.println("Aranan ulke bulundu : ");
                System.out.println("Bulunan ulke ismi  : " + isaretci.isim);
                System.out.println("Bulunan ulke numarasi :   " + isaretci.ulkeNo);
                System.out.println("Bulunan ulkenin denize kiyisi var mi : " + isaretci.Kontrol);

                sayac++;
            }
            isaretci = isaretci.ileri;
        }

        if (sayac == 0) {
            System.out.println("Aranan eleman bulunamadi!!");
        }

    }

    public void elemanSil(int ulkeNo) {
        if (ulkeNo == bas.ulkeNo) {
            bas = bas.ileri;
        } else if (ulkeNo == son.ulkeNo) {
            HashNode isaretci = bas;
            while (isaretci != null) {
                if (isaretci.ileri == son) {
                    isaretci.ileri = null;
                    son = isaretci;
                }
                isaretci = isaretci.ileri;
            }
        } else {
            HashNode isaretci = bas;
            while (isaretci != null) {
                if (isaretci.ileri.ulkeNo == ulkeNo) {
                    isaretci.ileri = isaretci.ileri.ileri;
                }
                isaretci = isaretci.ileri;
            }
        }
    }

    public void elemanGuncelle(int guncellenecekUlkeNo, String yeniIsim, int yeniUlkeNo, boolean yeniKontrol) {
        HashNode isaretci = bas;
        int sayac = 0;
        while (isaretci != null) {
            if (isaretci.ulkeNo == guncellenecekUlkeNo) {
                isaretci.isim = yeniIsim;
                isaretci.ulkeNo = yeniUlkeNo;
                isaretci.Kontrol = yeniKontrol;
                sayac++;
            }
            isaretci = isaretci.ileri;
        }
        if (sayac == 0) {
            System.out.println("Guncellenecek eleman bulunamadi!!");
        }
    }
}
