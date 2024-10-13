package manajemenKeuangan.finance;

import manajemenKeuangan.models.Transaksi;
import manajemenKeuangan.models.Pemasukan;
import manajemenKeuangan.models.Pengeluaran;
import java.util.Iterator;
import java.util.Scanner;


public final class KeuanganPribadi extends Keuangan {
    
    public KeuanganPribadi(String pemilik, String mataUang, double saldoAwal) {
        super(pemilik, mataUang, saldoAwal);
    }
    
    public static void tampilkanDeskripsiAplikasi() {
        System.out.println("Aplikasi Keuangan Pribadi");
    }
    
    // Implementasi method tampilkanInfo
    @Override
    public void tampilkanInfo() {
        System.out.println("=== Informasi Pemilik ===");
        System.out.println("Pemilik: " + getPemilik());
        System.out.println("Mata Uang: " + getMataUang());
        System.out.println("Saldo Awal: Rp" + getSaldoAwal());
        System.out.println("Saldo Sekarang: Rp" + getSaldoSekarang());
    }

    // Implementasi method CRUD dari interface
    @Override
    public void tambahTransaksi(double nominal, String jenis, String keterangan) {
        Transaksi transaksiBaru;
        if (jenis.equalsIgnoreCase("Pendapatan") || jenis.equalsIgnoreCase("Pemasukan")) {
            transaksiBaru = new Pemasukan(nominal, keterangan);
            saldoSekarang += nominal; // Update saldo sekarang
        } else if (jenis.equalsIgnoreCase("Pengeluaran")) {
            transaksiBaru = new Pengeluaran(nominal, keterangan);
            saldoSekarang -= nominal; // Update saldo sekarang
        } else {
            System.out.println("Jenis transaksi tidak valid. Harap masukkan 'Pendapatan' atau 'Pengeluaran'.");
            return;
        }
        daftarTransaksi.add(transaksiBaru);
        System.out.println("Transaksi berhasil ditambahkan.");
    }

    @Override
    public void lihatTransaksi() {
        if (daftarTransaksi.isEmpty()) {
            System.out.println("Tidak ada transaksi.");
        } else {
            System.out.println("=== Daftar Transaksi ===");
            for (Transaksi transaksi : daftarTransaksi) {
                transaksi.tampilkanTransaksi();
            }
            System.out.println("Saldo Sekarang: Rp" + saldoSekarang);
        }
    }

    @Override
    public void hapusTransaksi(String keterangan) {
        boolean ditemukan = false;
        Iterator<Transaksi> iterator = daftarTransaksi.iterator();
        while (iterator.hasNext()) {
            Transaksi transaksi = iterator.next();
            if (transaksi.getKeterangan().equalsIgnoreCase(keterangan)) {
                // Mengembalikan saldo berdasarkan jenis transaksi yang dihapus
                if (transaksi.getJenis().equalsIgnoreCase("Pendapatan") || transaksi.getJenis().equalsIgnoreCase("Pemasukan")) {
                    saldoSekarang -= transaksi.getJumlah();
                } else if (transaksi.getJenis().equalsIgnoreCase("Pengeluaran")) {
                    saldoSekarang += transaksi.getJumlah();
                }
                iterator.remove();
                System.out.println("Transaksi berhasil dihapus.");
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Transaksi tidak ditemukan.");
        }
    }

    @Override
    public void updateTransaksi(String keterangan) {
        boolean ditemukan = false;
        for (Transaksi transaksi : daftarTransaksi) {
            if (transaksi.getKeterangan().equalsIgnoreCase(keterangan)) {
                Scanner scanner = new Scanner(System.in);
    
                System.out.print("Masukkan nominal uang baru: ");
                double nominalBaru = scanner.nextDouble();
                System.out.print("Masukkan jenis baru (Pendapatan/Pengeluaran): ");
                scanner.nextLine(); // Membersihkan buffer
                String jenisBaru = scanner.nextLine();
                System.out.print("Masukkan keterangan baru: ");
                String keteranganBaru = scanner.nextLine();
    
                // Mengembalikan saldo sebelumnya
                if (transaksi.getJenis().equalsIgnoreCase("Pendapatan") || transaksi.getJenis().equalsIgnoreCase("Pemasukan")) {
                    saldoSekarang -= transaksi.getJumlah();
                } else if (transaksi.getJenis().equalsIgnoreCase("Pengeluaran")) {
                    saldoSekarang += transaksi.getJumlah();
                }
    
                // Meng-update nilai transaksi
                transaksi.setJumlah(nominalBaru);
                transaksi.setJenis(jenisBaru);
                transaksi.setKeterangan(keteranganBaru);
    
                // Meng-update saldo berdasarkan jenis transaksi baru
                if (jenisBaru.equalsIgnoreCase("Pendapatan") || jenisBaru.equalsIgnoreCase("Pemasukan")) {
                    saldoSekarang += nominalBaru;
                } else if (jenisBaru.equalsIgnoreCase("Pengeluaran")) {
                    saldoSekarang -= nominalBaru;
                }
    
                System.out.println("Transaksi berhasil diupdate.");
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Transaksi tidak ditemukan.");
        }
    }
}