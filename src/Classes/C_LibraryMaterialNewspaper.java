package Classes;

public class C_LibraryMaterialNewspaper {

    private int Id;
    private String ISBNBarcode;
    private String N_Type;
    private String Heading;
    private int Volume;
    private String DateReceive;

    public C_LibraryMaterialNewspaper(int id, String barcode,String ntype, String heading, int volume, String dateReceive) {
        this.Id = id;
        this.ISBNBarcode = barcode;
        this.N_Type = ntype;
        this.Heading = heading;
        this.Volume = volume;
        this.DateReceive = dateReceive;
    }

    public int getid() {
        return Id;
    }

    public String getbarcode() {
        return ISBNBarcode;
    }
    
    public String getn_type() {
        return N_Type;
    }

    public String getheading() {
        return Heading;
    }

    public int getvolume() {
        return Volume;
    }

    public String getdateReceive() {
        return DateReceive;
    }

}
