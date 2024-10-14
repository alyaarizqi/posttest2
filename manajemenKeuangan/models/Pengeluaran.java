package manajemenKeuangan.models;

public class Pengeluaran extends Transaksi {
    private final String metodePembayaran;

    public Pengeluaran(double jumlah, String keterangan, String metodePembayaran) {
        super(jumlah, keterangan);
        this.metodePembayaran = metodePembayaran;
        this.jenis = "Pengeluaran";
    }

    @Override
    public void tampilkanTransaksi() {
        System.out.println("Pengeluaran: Rp" + jumlah); 
        System.out.println("Keterangan: " + keterangan); 
        System.out.println("Metode: " + metodePembayaran);
    }
}
