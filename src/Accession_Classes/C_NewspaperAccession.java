
package Accession_Classes;

public class C_NewspaperAccession {
      private int Id;
    private int AccessionNumber;
    private String Status;
    
    public C_NewspaperAccession(int id,int accession,String status){
        this.Id = id;
        this.AccessionNumber = accession;
        this.Status = status;
    }
    
    public int getid() {
        return Id;
    }
    public int getaccession() {
        return AccessionNumber;
    }
    
}
