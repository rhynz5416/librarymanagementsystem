package Classes;

public class C_LibraryMaterialCD {

    private int Id;
    private String Barcode;
    private String Dateacq;
    private String CDTitle;
    private int Ednumber;
    private String Place;
    private String Producer;
    private int Year;
    private String Genre;

    public C_LibraryMaterialCD(int id, String cd_barcode,String dateAcq, String cd_Title, int ednum, String place, String producer, int year, String cd_genre) {
        this.Id = id;
        this.Dateacq = dateAcq;
        this.CDTitle = cd_Title;
        this.Ednumber = ednum;
        this.Place = place;
        this.Producer = producer;
        this.Year = year;
        this.Genre = cd_genre;
        this.Barcode = cd_barcode;

    }

    public int getid() {
        return Id;
    }

    public String getcd_barcode() {
        return Barcode;
    }

    public String getdateAcq() {
        return Dateacq;
    }

    public String getcd_Title() {
        return CDTitle;
    }

    public int getednum() {
        return Ednumber;
    }


    public String getplace() {
        return Place;
    }

    public String getproducer() {
        return Producer;
    }

    public int getyear() {
        return Year;
    }

    public String getcd_genre() {
        return Genre;
    }

  
}
