package bagli_sirala31;
/**
 *
 * @author RANA NUR OKTAY
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Bagli_Sirala31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dosya adini girin: ");
        String dosyaAdi = scanner.nextLine();

        try {
            File file = new File(dosyaAdi);
            Scanner dosyaOkuyucu = new Scanner(file);

            int maxSize = 100; // Maksimum dizi boyutu
            Node[] orijinalDizi = new Node[maxSize]; // Orijinal dizimiz
            Node[] kopyaDizi = new Node[maxSize]; // Kopya dizimiz

            int index = 0;
            while (dosyaOkuyucu.hasNextInt() && index < maxSize) {
                int x = dosyaOkuyucu.nextInt();
                Node node = new Node(x, index);
                orijinalDizi[index] = node; // Okunan her sayıyı orijinal diziye ekleme
                kopyaDizi[index] = new Node(x, index); // Okunan her sayıyı kopya diziye ekleme
                index++;
            }

            // Kopya diziyi bubble sort ile sıralama
            for (int i = 0; i < index - 1; i++) {
                for (int j = 0; j < index - i - 1; j++) {
                    if (kopyaDizi[j].x > kopyaDizi[j + 1].x) {
                        // Swap yapımı
                        Node temp = kopyaDizi[j];
                        kopyaDizi[j] = kopyaDizi[j + 1];
                        kopyaDizi[j + 1] = temp;
                    }
                }
            }

            // Dizilerin yan yana yazdırılması
            System.out.println("X\t\tY\t\t\t\tX\t\tY");
            System.out.println("-----------------------------------------------------------------");
            for (int i = 0; i < index; i++) {
                System.out.println(orijinalDizi[i].x + "\t\t" + orijinalDizi[i].y + "\t\t|" +
                        "\t\t" + kopyaDizi[i].x + "\t\t" + kopyaDizi[i].y);
            }

            dosyaOkuyucu.close();
        } catch (FileNotFoundException e) {
            System.out.println("Dosya bulunamadi.");
            e.printStackTrace();
        }
    }
}