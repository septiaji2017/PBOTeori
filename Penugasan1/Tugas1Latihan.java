import java.util.Scanner;
public class Tugas1Latihan {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        double nilaiAkhir;

        System.out.print("Masukkan Nilai Tugas: ");
        double nilaiTugas = sc.nextDouble();

        System.out.print("Masukkan Nilai UTS: ");
        double nilaiUTS = sc.nextDouble();

        System.out.print("Masukkan Nilai UAS: ");
        double nilaiUAS = sc.nextDouble();

        nilaiAkhir = ((20.0/100.0) * nilaiTugas) +
                ((35.0/100.0) * nilaiUTS) + ((45.0/100.0) * nilaiUAS);

        System.out.print("Nilai Akhir: ");
        System.out.println(nilaiAkhir);

        System.out.print("Grade: ");
        if (nilaiAkhir >= 85.0){
            System.out.println("A");
        } else if (nilaiAkhir >= 75.0) {
            System.out.println("B");
        } else if (nilaiAkhir >= 65.0) {
            System.out.println("C");
        } else if (nilaiAkhir >= 49.0) {
            System.out.println("D");
        } else{
            System.out.println("E");
        }
    }
}
