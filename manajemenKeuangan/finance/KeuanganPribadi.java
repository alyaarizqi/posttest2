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

    @Override
    public void tampilkanInfo() {
        System.out.println("=== Informasi Pemilik ===");
        System.out.println("Pemilik: " + getPemilik());
        System.out.println("Mata Uang: " + getMataUang());
        System.out.println("Saldo Awal: Rp" + getSaldoAwal());
        System.out.println("Saldo Sekarang: Rp" + getSaldoSekarang());
    }

    @Override
    public void tambahTransaksi(double nominal, String jenis, String keterangan) {
        Scanner scanner = new Scanner(System.in);
        Transaksi transaksiBaru;

        if (jenis.equalsIgnoreCase("Pendapatan") || jenis.equalsIgnoreCase("Pemasukan")) {
            System.out.print("Masukkan sumber pemasukan: ");
            String sumberPemasukan = scanner.nextLine();
            transaksiBaru = new Pemasukan(nominal, keterangan, sumberPemasukan);
            saldoSekarang += nominal;
        } else if (jenis.equalsIgnoreCase("Pengeluaran")) {
            System.out.print("Masukkan metode pembayaran: ");
            String metodePembayaran = scanner.nextLine();
            transaksiBaru = new Pengeluaran(nominal, keterangan, metodePembayaran);
            saldoSekarang -= nominal;
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
        Scanner scanner = new Scanner(System.in);
        boolean ditemukan = false;

        for (Transaksi transaksi : daftarTransaksi) {
            if (transaksi.getKeterangan().equalsIgnoreCase(keterangan)) {
                ditemukan = true;

                // Menampilkan informasi transaksi yang akan diupdate
                transaksi.tampilkanTransaksi();

                System.out.print("Masukkan jenis transaksi baru (Pendapatan/Pengeluaran): ");
                String jenisBaru = scanner.nextLine();
                double nominalBaru;

                do {
                    System.out.print("Masukkan nominal baru: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Masukkan nominal yang valid.");
                        scanner.next(); 
                    }
                    nominalBaru = scanner.nextDouble();
                    scanner.nextLine(); 
                } while (nominalBaru <= 0); 

                // Mengupdate transaksi dan saldo
                if (jenisBaru.equalsIgnoreCase("Pendapatan") || jenisBaru.equalsIgnoreCase("Pemasukan")) {
                    if (transaksi.getJenis().equalsIgnoreCase("Pengeluaran")) {
                        saldoSekarang += transaksi.getJumlah(); // Mengurangi saldo dari pengeluaran
                    }
                    saldoSekarang += nominalBaru; // Menambahkan nominal baru
                    transaksi.setJumlah(nominalBaru);
                    transaksi.setJenis(jenisBaru);
                } else if (jenisBaru.equalsIgnoreCase("Pengeluaran")) {
                    if (transaksi.getJenis().equalsIgnoreCase("Pendapatan")) {
                        saldoSekarang -= transaksi.getJumlah(); // Mengurangi saldo dari pendapatan
                    }
                    saldoSekarang -= nominalBaru; // Mengurangi nominal baru
                    transaksi.setJumlah(nominalBaru);
                    transaksi.setJenis(jenisBaru);
                } else {
                    System.out.println("Jenis transaksi tidak valid. Harap masukkan 'Pendapatan' atau 'Pengeluaran'.");
                    return;
                }

                System.out.println("Transaksi berhasil diupdate.");
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Transaksi tidak ditemukan.");
        }
    }
}
