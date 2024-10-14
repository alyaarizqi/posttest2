package manajemenKeuangan.models;

public class Pemasukan extends Transaksi {
    private final String sumberPemasukan;

    public Pemasukan(double jumlah, String keterangan, String sumberPemasukan) {
        super(jumlah, keterangan);
        this.sumberPemasukan = sumberPemasukan;
        this.jenis = "Pemasukan";
    }

    @Override
     public void tampilkanTransaksi() {
        System.out.println("Pemasukan: Rp" + jumlah); 
        System.out.println("Keterangan: " + keterangan); 
        System.out.println("Sumber: " + sumberPemasukan);
    }
}
