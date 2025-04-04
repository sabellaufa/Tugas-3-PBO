import java.util.ArrayList;
import java.util.Scanner;

class Mahasiswa {
    String nim;
    String nama;
    int nilai;
    char grade;

    public Mahasiswa(String nim, String nama, int nilai) {
        this.nim = nim;
        this.nama = nama;
        this.nilai = nilai;
        this.grade = hitungGrade(nilai);

    }

    private char hitungGrade (int nilai) {
        if (nilai >= 80 && nilai <= 100) {
            return 'A';
        } else if (nilai >= 70 && nilai <= 79) {
            return 'B';
        } else if (nilai >= 60 && nilai <= 69) {
            return 'C';
        } else if (nilai >= 50 && nilai <= 59) {
            return 'D';
        } else if (nilai >= 0 && nilai < 50) {
            return 'E';
        } else {
            return 'X'; //indikasi nilai salah
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Mahasiswa> mahasiswaList = new ArrayList<>();
        int jumlahLulus = 0, jumlahTidakLulus = 0, totalNilai =0;

        System.out.println("Mahasiswa jumlah mahasiswa: ");
        int jumlahMahasiswa = scanner.nextInt();
        scanner.nextLine(); //membersihkan buffer

        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("\nMahasiswa ke-" + (i + 1));
            System.out.println("Masukan NIM: ");
            String nim = scanner.nextLine();
            System.out.println("Masukan nama: ");
            String nama = scanner.nextLine();
            System.out.println("Masukan Nilai: ");
            int nilai = scanner.nextInt();
            scanner.nextLine(); // membersihkan buffer

            if(nilai < 0 || nilai > 100) {
                System.out.println("Input nilai anda salah");
                i--; // mengulang input untuk mahasiswa ini
                continue;
            }

            Mahasiswa mhs = new Mahasiswa(nim, nama, nilai);
            mahasiswaList.add(mhs);

            totalNilai += nilai;
            if (mhs.grade == 'A' || mhs.grade == 'B' || mhs.grade == 'C') {
                jumlahLulus++;
            } else {
                jumlahTidakLulus++;
            }
        }

        // output data mahasiswa
        System.out.println("\n==========================================");
        for ( Mahasiswa mhs : mahasiswaList) {
            System.out.println("NIM    : " + mhs.nim);
            System.out.println("Nama   : " + mhs.nama);
            System.out.println("Nilai  : " + mhs.nilai);
            System.out.println("Grade  : " + mhs.grade);
            System.out.println("==========================================");   
        }

        // menampilkan statistik
        System.out.println("Jumlah Mahasiswa  : " + jumlahMahasiswa);
        System.out.println("Jumlah mahasiswa yang Lulus : " + jumlahLulus);
        System.out.println("Nama mahasiswa yang Lulus : ");
        for (Mahasiswa mhs : mahasiswaList) {
            if (mhs.grade == 'A' || mhs.grade == 'B' || mhs.grade == 'C') {
                System.out.println(mhs.nama + ",");
            }
        }
        System.out.println();

        System.out.println("Jumlah Mahasiswa yang tidak Lulus : " + jumlahTidakLulus);
        System.out.println("Nama Mahasiswa yang tidak Lulus : ");
        for(Mahasiswa mhs : mahasiswaList) {
            if (mhs.grade == 'D' || mhs.grade == 'E') {
                System.out.println(mhs.nama + ",");
            }
        }
        System.out.println();

        double rataRata = (double) totalNilai / jumlahMahasiswa;
        System.out.printf("Rata-rata Nilai Mahasiswa: %.2f\n", rataRata);

        scanner.close();
    }
}

