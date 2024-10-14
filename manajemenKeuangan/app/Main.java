package manajemenKeuangan.app;

import java.util.Scanner;
import manajemenKeuangan.finance.KeuanganPribadi;

public class Main {
    public static void main(String[] args) {
        KeuanganPribadi.tampilkanDeskripsiAplikasi();
        
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Masukkan nama pemilik akun: ");
            String pemilik = scanner.nextLine();
            System.out.print("Masukkan jenis mata uang: ");
            String mataUang = scanner.nextLine();
            double saldoAwal = 200000; 
            
            // Membuat objek KeuanganPribadi
            KeuanganPribadi keuanganPribadi = new KeuanganPribadi(pemilik, mataUang, saldoAwal);
            
            int pilihan;
            do {
                System.out.println("\n=== Aplikasi Keuangan Pribadi ===");
                System.out.println("1. Tambah Transaksi");
                System.out.println("2. Lihat Transaksi");
                System.out.println("3. Hapus Transaksi");
                System.out.println("4. Update Transaksi");
                System.out.println("5. Tampilkan Info Pemilik");
                System.out.println("6. Keluar");
                System.out.print("Pilih menu: ");
                pilihan = scanner.nextInt();
                
                switch (pilihan) {
                    case 1 -> {
                        System.out.print("Masukkan nominal uang: ");
                        double nominal = scanner.nextDouble();
                        System.out.print("Masukkan jenis (Pendapatan/Pengeluaran): ");
                        scanner.nextLine(); 
                        String jenis = scanner.nextLine();
                        System.out.print("Masukkan keterangan: ");
                        String keterangan = scanner.nextLine();
                        keuanganPribadi.tambahTransaksi(nominal, jenis, keterangan);
                    }
                    case 2 -> keuanganPribadi.lihatTransaksi();
                    case 3 -> {
                        keuanganPribadi.lihatTransaksi();
                        System.out.print("Masukkan keterangan transaksi yang ingin dihapus: ");
                        scanner.nextLine(); 
                        String keteranganHapus = scanner.nextLine();
                        keuanganPribadi.hapusTransaksi(keteranganHapus);
                    }
                    case 4 -> {
                        keuanganPribadi.lihatTransaksi();
                        System.out.print("Masukkan keterangan transaksi yang ingin diupdate: ");
                        scanner.nextLine(); 
                        String keteranganUpdate = scanner.nextLine();
                        keuanganPribadi.updateTransaksi(keteranganUpdate);
                    }
                    case 5 -> keuanganPribadi.tampilkanInfo();
                    case 6 -> System.out.println("Terima kasih!");
                    default -> System.out.println("Pilihan tidak valid.");
                }
            } while (pilihan != 6);
        }
    }
}
