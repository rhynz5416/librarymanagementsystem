
package Accession_Classes;

public class C_MagazineAccession {
      private int Id;
    private int AccessionNumber;
    private String Status;
    
    public C_MagazineAccession(int id,int accession){
        this.Id = id;
        this.AccessionNumber = accession;
        
    }
    
    public int getid() {
        return Id;
    }
    public int getaccession() {
        return AccessionNumber;
    }
    
}
