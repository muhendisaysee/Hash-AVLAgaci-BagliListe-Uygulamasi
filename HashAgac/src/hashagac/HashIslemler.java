package hashagac;

public class HashIslemler {

    BagliListe[] ulke;
    int N;
    
    HashIslemler(int N) {
        this.N = N;
        ulke = new BagliListe[N];
        
        for (int i = 0; i < ulke.length; i++) {
            ulke[i] = new BagliListe();
        }
    }

    public int SayiIndex(int UlkeNo) {
        /*
        Mod kullanılmaması gerektiğini duyduğumdan basit bir matematiksel denklem oluşturdum.
        Şöyle;
        Diyelimki UlkeNo : 34 , hash eleman sayısı 10;
        Bu durumda 4.indise yerleşmesi gerekiyor;
        UlkeNo/N dersem bölümü elde etmiş olurum;
        Bölüm*Bölünen +kalan UlkeNo ya eşit olduğundan 
        UlkeNo-bolum*N dersem kalani elde ederim.
        */
        int bolum=UlkeNo/N;
        int indis1=UlkeNo-bolum*N;             
        System.out.println("kalan : " + indis1);
        return indis1;
    }

    public void HashElemanEkle(String isim, int UlkeNo, boolean Kiyi) {
        int index = SayiIndex(UlkeNo);
        ulke[index].elemanEkle(isim, UlkeNo, Kiyi);
    }

    public void sil(int ulkeNo) {
        int index = SayiIndex(ulkeNo);
        ulke[index].elemanSil(ulkeNo);
    }

    public void HashAra(int ulkeNo) {
        int index = SayiIndex(ulkeNo);
        ulke[index].elemanAra(ulkeNo);
    }

    public void HashGuncelle(int guncellenecekUlkeNo, String yeniIsim, int yeniUlkeNo, boolean yeniKontrol) {
        int index = SayiIndex(guncellenecekUlkeNo);
        ulke[index].elemanGuncelle(guncellenecekUlkeNo, yeniIsim, yeniUlkeNo, yeniKontrol);
    }

    public void yazdir() {
        for (int i = 0; i < N; i++) {
            ulke[i].elemanlariListele();
        }        
    }
}
