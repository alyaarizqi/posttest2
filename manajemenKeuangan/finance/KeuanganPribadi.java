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
            System.out.println("-------------------------------");
            for (Transaksi transaksi : daftarTransaksi) {               
                System.out.println("Jumlah: Rp" + transaksi.getJumlah());
                System.out.println("Jenis: " + transaksi.getJenis());
                System.out.println("Keterangan: " + transaksi.getKeterangan());
                if (transaksi instanceof Pemasukan pemasukan) {
                    System.out.println("Sumber: " + pemasukan.getSumberPemasukan());
                } else if (transaksi instanceof Pengeluaran pengeluaran) {
                    System.out.println("Metode: " + pengeluaran.getMetodePembayaran());
                }
                System.out.println("-------------------------------");
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
                System.out.print("Masukkan nominal baru: ");
                double nominalBaru = scanner.nextDouble();
                scanner.nextLine(); 
                
                // Update saldo
                if (transaksi.getJenis().equalsIgnoreCase("Pendapatan") || transaksi.getJenis().equalsIgnoreCase("Pemasukan")) {
                    saldoSekarang -= transaksi.getJumlah();
                    saldoSekarang += nominalBaru;
                } else if (transaksi.getJenis().equalsIgnoreCase("Pengeluaran")) {
                    saldoSekarang += transaksi.getJumlah();
                    saldoSekarang -= nominalBaru;
                }
                
                transaksi.setJumlah(nominalBaru); 
                System.out.println("Transaksi berhasil diperbarui.");
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Transaksi tidak ditemukan.");
        }
    }
}
