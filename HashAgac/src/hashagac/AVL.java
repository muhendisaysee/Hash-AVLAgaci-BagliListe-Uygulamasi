package hashagac;

public class AVL {

    Node kok;
    int yukseklik;

    AVL() {
        kok = null;
    }

    /*-------------------------*/
    int yukseklik(Node dugum) {
        if (dugum == null) {
            return 0;
        }
        return dugum.yukseklik;
    }

    /*------------------------*/
    int karsilastir(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    /*------------------------*/
    Node sagaDondur(Node dugum) {
        Node n = dugum.sol;
        Node temp = n.sag;
        n.sag = dugum;
        dugum.sol = temp;

        dugum.yukseklik = karsilastir(yukseklik(dugum.sol), yukseklik(dugum.sag)) + 1;
        n.yukseklik = karsilastir(yukseklik(n.sol), yukseklik(n.sag)) + 1;

        return n;
    }

    /*---------------------------*/
    Node solaDondur(Node dugum) {
        Node n = dugum.sag;
        Node temp = n.sol;

        n.sol = dugum;
        dugum.sag = temp;
        n.yukseklik = karsilastir(yukseklik(n.sol), yukseklik(n.sag)) + 1;
        dugum.yukseklik = karsilastir(yukseklik(dugum.sol), yukseklik(dugum.sag)) + 1;
        return n;
    }

    /*--------------------------*/
    int balanceCheck(Node dugum) {
        if (dugum == null) {
            return 0;
        } else {
            return yukseklik(dugum.sol) - yukseklik(dugum.sag);
        }
    }

    /*----------------------------------------------------------------------*/
    Node EkleRecursive(int numara, String isim, boolean kiyi, Node kok) {
        Node eklenecek = new Node(isim, numara, kiyi);

        if (kok == null) {
            kok = eklenecek;

        }
        if (numara > kok.ulkeNo) {
            kok.sag = EkleRecursive(numara, isim, kiyi, kok.sag);
        } else if (numara < kok.ulkeNo) {
            kok.sol = EkleRecursive(numara, isim, kiyi, kok.sol);
        } //else {
//            return kok;
//        }
        kok.yukseklik = karsilastir(yukseklik(kok.sol), yukseklik(kok.sag)) + 1;
        int balance = balanceCheck(kok);
        if (balance > 1 && numara < kok.sol.ulkeNo) {
            return sagaDondur(kok);
        }
        if (balance < -1 && numara > kok.sag.ulkeNo) {
            return solaDondur(kok);
        }
        if (balance > 1 && numara > kok.sol.ulkeNo) {
            kok.sol = solaDondur(kok.sol);
            return sagaDondur(kok);
        }
        if (balance < -1 && numara < kok.sag.ulkeNo) {
            kok.sag = sagaDondur(kok.sag);
            return solaDondur(kok);
        }
        return kok;
    }

    /*------------------------------------------------------------------------------------------------------------*/
    public Node EnBuyukUlkeNo(Node kok) {
        if (kok.sag == null) {
            return kok;
        } else {
            return EnBuyukUlkeNo(kok.sag);
        }
    }
    public Node EnKucukUlkeNo(Node kok){
        if(kok.sol==null)
            return null;
        else 
            return EnKucukUlkeNo(kok.sol);
    }
    /*------------------------------------------------------------------------------------------------------------*/
    Node SilmeDengele(Node kok){
        if(kok==null)
            return null;
        kok.yukseklik=karsilastir(yukseklik(kok.sol),yukseklik(kok.sag))+1;
        int balance=balanceCheck(kok);
        if(balance > 1 && balanceCheck(kok.sol) >= 0 ){
            return sagaDondur(kok);
        }
        else if(balance > 1 && balanceCheck(kok.sol) < 0){
            kok.sol=solaDondur(kok.sol);
            return sagaDondur(kok);
        }
        else if(balance < -1 && balanceCheck(kok.sag) <= 0 ){
            return solaDondur(kok);
        }
        else if(balance < -1 && balanceCheck(kok.sag) > 0 ){
            kok.sag=sagaDondur(kok);
        }
        return kok;
    }
    /*-------------------------------------------------------------------------------------------------------------*/
    Node UlkeSil(Node kok, int silinecekUlkeNo) {
        
        if(kok==null){
            return null;
        }
        if(kok.sag==null && kok.sol==null && yukseklik(kok.sol)==1 && yukseklik(kok.sag)==1){
            return null;
        }
        if(silinecekUlkeNo < kok.ulkeNo){
            kok.sol=UlkeSil(kok.sol,silinecekUlkeNo);
        }
        else if(silinecekUlkeNo > kok.ulkeNo){
            kok.sag=UlkeSil(kok.sag,silinecekUlkeNo);
        }
        else {
            if(kok.sol!=null && kok.sag!=null){
                Node enBuyuk=EnBuyukUlkeNo(kok.sol);
                kok.isim=enBuyuk.isim;
                kok.Kontrol=enBuyuk.Kontrol;
                kok.ulkeNo=enBuyuk.ulkeNo;
                kok.sol=UlkeSil(kok.sol,kok.ulkeNo);
            }
            else if(kok.sol!=null)
                kok=kok.sol;
            else 
                kok=kok.sag;
        }
        
       
        return kok;
    }
    /*------------------------------------------------------------------------------------------------------------*/
    Node AraRecursive(Node kok, int aranan) {
        if (kok == null) {
            return null;
        }
        if (kok.ulkeNo == aranan) {
            return kok;
        } else {
            if (kok.ulkeNo < aranan) {
                return AraRecursive(kok.sag, aranan);
            } else {
                return AraRecursive(kok.sol, aranan);
            }
        }
    }

    /*------------------------------------------------------------------------------------------------------------*/
    public Node AgactaElemanGuncelleme(Node kok, int guncellenecek, int ulkeNo, String isim, boolean kontrol) {
        if (kok.ulkeNo == guncellenecek) {
            kok.isim = isim;
            kok.ulkeNo = ulkeNo;
            kok.Kontrol = kontrol;
            return kok;
        }
        if (kok == null) {
            System.out.println("Boyle bir sayi yok!!");
            return null;
        } else {
            if (guncellenecek < kok.ulkeNo) {
                return AgactaElemanGuncelleme(kok.sol, guncellenecek, ulkeNo, isim, kontrol);
            } else {
                return AgactaElemanGuncelleme(kok.sag, guncellenecek, ulkeNo, isim, kontrol);
            }
        }

    }

    /*------------------------------------------------------------------------------------------------------------*/
    void inOrder(Node kok) {
        if (kok == null) {
            System.out.println("Bütün elemanlar listelendi");
        }
        if (kok != null) {
            System.out.println("------------------------------------");
            inOrder(kok.sol);
            System.out.println("Ulkenin ismi : " + kok.isim);
            System.out.println("Ulkenin numarasi : " + kok.ulkeNo);
            System.out.println("Ulkenin denize kiyisi var mi ? : " + kok.Kontrol);
            System.out.println("------------------------------------");
            inOrder(kok.sag);

        }
    }
    /*------------------------------------------------------------------------------------------------------------*/
}