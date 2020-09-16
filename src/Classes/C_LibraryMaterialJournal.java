package Classes;

public class C_LibraryMaterialJournal {

    private int Id;
    private String ISBNBarcode;
    private String DateAcq;
    private String JournalTitle;
    private String Author;
    private String Publisher;
    private int Ednumber;
    private int Pagevol;
    private String Place;
    private int Year;
    private String Source;
    

    public C_LibraryMaterialJournal(int id, String j_isbnBarcode, String dateAcq, String j_title, String j_author, String j_publisher, int ednum, int pagevol, String place, int year, String source) {
        this.Id = id;
        this.DateAcq = dateAcq;
        this.JournalTitle = j_title;
        this.Author = j_author;
        this.Publisher = j_publisher;
        this.Ednumber = ednum;
        this.Pagevol = pagevol;
        this.Place = place;
        this.Year = year;
        this.Source = source;
        this.ISBNBarcode = j_isbnBarcode;
    }

    public int getid() {
        return Id;
    }

    public String getj_isbnBarcode() {
        return ISBNBarcode;
    }


    public String getdateAcq() {
        return DateAcq;
    }

    public String getj_title() {
        return JournalTitle;
    }

    public String getj_author() {
        return Author;
    }

    public String getj_publisher() {
        return Publisher;
    }

    public int getednum() {
        return Ednumber;
    }

    public int getpagevol() {
        return Pagevol;
    }

    public String getplace() {
        return Place;
    }

    public int getyear() {
        return Year;
    }

    public String getsource() {
        return Source;
    }

   
}
