package bagli_sirala;
/**
 *
 * @author RANA NUR OKTAY
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Bagli_Sirala {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dosya adini girin: ");
        String dosyaAdi = scanner.nextLine();

        try {
            File file = new File(dosyaAdi);
            Scanner dosyaOkuyucu = new Scanner(file);

            ArrayList<Node> orijinalListe = new ArrayList<>(); // Orijinal ArrayList
            ArrayList<Node> kopyaListe = new ArrayList<>(); // Kopya ArrayList

            int index = 0;
            while (dosyaOkuyucu.hasNextInt()) {
                int x = dosyaOkuyucu.nextInt();
                Node node = new Node(x, index);
                orijinalListe.add(node); // Okunan her sayıyı orijinal listeye ekleme
                kopyaListe.add(new Node(x, index)); // Okunan her sayıyı kopya listeye ekleme
                index++;
            }

            // Kopya listeyi bubble sort ile sıralama 
            for (int i = 0; i < kopyaListe.size() - 1; i++) {
                for (int j = 0; j < kopyaListe.size() - i - 1; j++) {
                    if (kopyaListe.get(j).x > kopyaListe.get(j + 1).x) {
                        // Swap yapımı
                        Node temp = kopyaListe.get(j);
                        kopyaListe.set(j, kopyaListe.get(j + 1));
                        kopyaListe.set(j + 1, temp);
                    }
                }
            }

            // Dizilerin yan yana yazdırılması
            System.out.println("X\t\tY\t\t\t\tX\t\tY");
            System.out.println("-----------------------------------------------------------------");
            for (int i = 0; i < orijinalListe.size(); i++) {
                System.out.println(orijinalListe.get(i).x + "\t\t" + orijinalListe.get(i).y +"\t\t|"+
                        "\t\t"+kopyaListe.get(i).x + "\t\t" + kopyaListe.get(i).y);
            }

            dosyaOkuyucu.close();
        } catch (FileNotFoundException e) {
            System.out.println("Dosya bulunamadi.");
            e.printStackTrace();
        }
    }
}
