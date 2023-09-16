import java.util.ArrayList;
import java.util.List;

class BisnisRetail{
    String nama;
    private List<Produk> produk; //Bisnis retail memiliki Produk (has-a)
    //Bisnis retali sebagai container / penampung
    BisnisRetail(String nama, List<Produk> produk){
        this.nama = nama;
        this.produk = produk;
    }

    public List<Produk> getProduk(){
        return produk;
    }

    @Override
    public String toString() {
        return "Retail " + nama + ", Barang: " + getProduk();
    }
}

class Supermarket extends BisnisRetail{
    Supermarket(String nama, List<Produk> produk) {
        super(nama, produk);
    }

    @Override
    public String toString(){
        return "Supermarket " + nama + ", Barang: " + getProduk();
    }
}

class Supplier{

    private final List<Produk> produk_hookies = new ArrayList<Produk>();
    private final List<Produk> produk_galaxy = new ArrayList<Produk>();
    private final List<Produk> produk_omega = new ArrayList<Produk>();
    private final List<Produk> produk_walmart = new ArrayList<Produk>();

    private String supName;
    public void TambahProduk(){
        Produk p1 = new Produk(1,"Energen-izer", 2, "Hookies");
        Produk p2 = new Produk(2,"Sari roti", 115, "Hookies");
        Produk p3 = new Produk(3,"Apel", 11, "Galaxy");
        Produk p4 = new Produk(4,"Jeruk", 12, "Omega");
        Produk p5 = new Produk(5,"Batu", 120, "Walmart");

        produk_hookies.add(p1);
        produk_hookies.add(p2);
        produk_galaxy.add(p3);
        produk_omega.add(p4);
        produk_walmart.add(p5);

//        for (Produk b: produk_hookies){
//            System.out.println(b);
//        }

    }

    public void MonitorProduk(){

        BisnisRetail Hookies = new BisnisRetail("Hookies", produk_hookies);
        BisnisRetail Galaxy = new BisnisRetail("Galaxy", produk_galaxy);
        BisnisRetail Omega = new BisnisRetail("Omega", produk_omega);

        Supermarket Walmart = new Supermarket("Walmart", produk_walmart);

        List<BisnisRetail> bisnisRetails = new ArrayList<BisnisRetail>();
        List<Supermarket> supermarkets = new ArrayList<Supermarket>();

        bisnisRetails.add(Hookies);
        bisnisRetails.add(Galaxy);
        bisnisRetails.add(Omega);

        supermarkets.add(Walmart);



        for (BisnisRetail b: bisnisRetails){
            System.out.println(b);
        }

        for (Supermarket s: supermarkets){
            System.out.println(s);
        }
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

//    public String showSupName(){
//        return "Supplier: " + getSupName();
//    }

}

class Produk{
    int id;
    String nama;
    int quantitas;
    String ret;

    Produk(int id, String nama, int quantitas, String ret){  //constructor utk class produk
        this.id = id;
        this.nama = nama;
        this.quantitas = quantitas;
        this.ret = ret;
    }

    @Override
    public String toString() {
//        return "Produk [ID: " + id + ", Nama: " + nama + ", Kuantitas: " + quantitas + ", Retail: " + ret + "]";
        return nama + " (" + quantitas + ")";
    }
}

public class Main2 {
    public static void main(String[] args){
        Supplier sup = new Supplier();

        sup.setSupName("Humane Research Labs");
        sup.TambahProduk();
        sup.MonitorProduk();
        System.out.println("Supplier: " + sup.getSupName());


    }
}
