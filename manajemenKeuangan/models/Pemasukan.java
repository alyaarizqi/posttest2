package manajemenKeuangan.models;

public class Pemasukan extends Transaksi {
    private String sumberPemasukan;

    public Pemasukan(double jumlah, String keterangan, String sumberPemasukan) {
        super(jumlah, keterangan);
        setJenis("Pendapatan"); 
        this.sumberPemasukan = sumberPemasukan;
    }

    public String getSumberPemasukan() {
        return sumberPemasukan;
    }
}
