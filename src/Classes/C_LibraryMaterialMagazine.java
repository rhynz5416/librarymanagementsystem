package Classes;

public class C_LibraryMaterialMagazine {

    private int Id;
    private String ISBNBarcode;
    private String DateAcq;
    private String MagazineTitle;
    private String Publisher;
    private int Ednum;
    private int PageVol;
    private String Place;
    private int Year;

    public C_LibraryMaterialMagazine(int id, String isbnBarcode, String dateAcq, String magazineTitle, String publisher, int ednum, int pagevol, String place, int year) {
     
        this.Id = id;
        this.ISBNBarcode = isbnBarcode;
        this.DateAcq = dateAcq;
        this.MagazineTitle = magazineTitle;
        this.Publisher = publisher;
        this.Ednum = ednum;
        this.PageVol = pagevol;
        this.Place = place;
        this.Year = year;

    }

    public int getid() {
        return Id;
    }

    public String getisbnBarcode() {
        return ISBNBarcode;
    }


    public String getdateAcq() {
        return DateAcq;
    }

    public String getmagazineTitle() {
        return MagazineTitle;
    }

    public String getpublisher() {
        return Publisher;
    }

    public int getednum() {
        return Ednum;
    }

    public int getpagevol() {
        return PageVol;
    }

    public String getplace() {
        return Place;
    }

    public int getyear() {
        return Year;
    }


}
