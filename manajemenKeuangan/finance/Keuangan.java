package manajemenKeuangan.finance;

import manajemenKeuangan.Interfaces.TransaksiInterface;
import java.util.ArrayList;
import manajemenKeuangan.models.Transaksi;

public abstract class Keuangan implements TransaksiInterface {
    protected final String pemilik;
    protected final String mataUang;
    protected final double saldoAwal;
    protected double saldoSekarang;
    protected final ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();

    // Constructor dengan encapsulation
    public Keuangan(String pemilik, String mataUang, double saldoAwal) {
        this.pemilik = pemilik;
        this.mataUang = mataUang;
        this.saldoAwal = saldoAwal;
        this.saldoSekarang = saldoAwal; 
    }

    // Getter untuk properti pemilik
    public String getPemilik() {
        return pemilik;
    }

    // Getter untuk properti mata uang
    public String getMataUang() {
        return mataUang;
    }

    // Getter untuk saldo awal
    public double getSaldoAwal() {
        return saldoAwal;
    }
    
    // Getter untuk saldo sekarang
    public double getSaldoSekarang() {
        return saldoSekarang;
    }

    // Method abstrak untuk menampilkan informasi
    public abstract void tampilkanInfo();
}
