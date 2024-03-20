package gramer;

/**
 *
 * @author RANA NUR OKTAY
 */
import java.util.Scanner;

public class Gramer {
    //İç içe üç if-else yapısı yerine bir fonksiyon yazmak daha okunaklılık sağladı.Ayrıca öge sayısı arttıkça şartlı ifadeler de artacaktı.Bu sayede kod uzunluğu hayli azalmış oldu. 
    public static boolean Kontrol(String[] dizi, String oge) {
        for (String parca : dizi) {
            if (parca.equals(oge)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lutfen 'Turkce cumle yapisini' kontrol etmek istediginiz cumleyi giriniz:");
        String cumle = scanner.nextLine();

        String[] Ozne = {"Ben", "Sen", "Hasan", "Nurşah", "Elif", "Abdulrezzak", "Şehribanu", "Zeynelabidin", "Naki","ben", "sen", "hasan", "nurşah", "elif", "abdulrezzak", "şehribanu", "zeynelabidin", "naki"};
        String[] Nesne = {"Bahçe", "Okul", "Park", "Sınıf", "Yarın", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi", "Pazar", "Merkez", "Ev", "Kitap", "Defter", "Güneş", "Beydağı","bahçe", "okul", "park", "sınıf", "yarın", "pazartesi", "salı", "çarşamba", "perşembe", "cuma", "cumartesi", "pazar", "merkez", "ev", "kitap", "defter", "güneş", "beydağı"};
        String[] Yuklem = {"Gitmek", "Gelmek", "Okumak", "Yazmak", "Yürümek", "Görmek","gitmek", "gelmek", "okumak", "yazmak", "yürümek", "görmek"};

        cumle = cumle.trim();// Alınan cümlenin başı ve sonundaki boşluklar kalkar.
        // trim fonksiyonun görevi cümle başı ve sonundaki tüm boşlukları kaldırmaktır. Okuma kolaylığı sağlar. Bknz ilk dönem ödevleri. 

        String[] CumleninOgeleri = cumle.split("\\s+"); // Cümleden boşlukları çekmeye yarar.
        //Split kelimesinin sözlük anlamı parçalanmış demektir.Bu fonksiyonu herhangi bir noktalama işaretini bile çekmek için kullanabiliriz. Bknz ilk dönem ödevleri.

        if (CumleninOgeleri.length != 3) {
            System.out.println("HAYIR");
            return;
        }

        String ozneOgesi = CumleninOgeleri[0];
        String nesneOgesi = CumleninOgeleri[1];
        String yuklemOgesi = CumleninOgeleri[2];

        if (!Kontrol(Ozne, ozneOgesi) || !Kontrol(Nesne, nesneOgesi) || !Kontrol(Yuklem, yuklemOgesi)) {
            System.out.println("HAYIR");
            return;
        }
        System.out.println("EVET");
    }
}