
package Accession_Classes;

public class C_BookAccession {
    private int Id;
    private int AccessionNumber;
    private String Status;
    
    public C_BookAccession(int id,int accession,String status){
        this.AccessionNumber = accession;
        this.Id = id;
        this.Status = status;
    }
    
    public int getid() {
        return Id;
    }
    public int getaccession() {
        return AccessionNumber;
    }
    
}
