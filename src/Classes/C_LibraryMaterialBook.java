package Classes;

public class C_LibraryMaterialBook {

    private int Id;
    private String ISBNBarcode;
    private String DateofAcquisition;
    private String BookTitle;
    private String Author;
    private int EditionNumber;
    private int Pagevolume;
    private String Place;
    private String Publisher;
    private int Year;
    private String Binding;
    private double Price;
    private String BookType;

    public C_LibraryMaterialBook(int id, String isbnBarcode, String dateofAcquisition, String bookTitle, String author, int editionNumber, int pageVolume, String place, String publisher, int year, String binding, double price,String bookType) {
        this.Id = id;
        this.ISBNBarcode = isbnBarcode;
        this.DateofAcquisition = dateofAcquisition;
        this.BookTitle = bookTitle;
        this.Author = author;
        this.EditionNumber = editionNumber;
        this.Pagevolume = pageVolume;
        this.Place = place;
        this.Publisher = publisher;
        this.Year = year;
        this.Binding = binding;
        this.Price = price;
       
        this.BookType = bookType;
    }

    public int getid() {
        return Id;
    }

    public String getisbnBarcode() {
        return ISBNBarcode;
    }
    
    public String getdateofAcquisition() {
        return DateofAcquisition;
    }

    public String getbookTitle() {
        return BookTitle;
    }

    public String getauthor() {
        return Author;
    }

    public int geteditionNumber() {
        return EditionNumber;
    }

    public int getpageVolume() {
        return Pagevolume;
    }

    public String getplace() {
        return Place;
    }

    public String getpublisher() {
        return Publisher;
    }

    public int getyear() {
        return Year;
    }

    public String getbinding() {
        return Binding;
    }

    public double getprice() {
        return Price;
    }


    public String getbookType() {
        return BookType;
    }

    

}
