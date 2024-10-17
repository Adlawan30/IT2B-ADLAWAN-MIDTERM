
package adlawan.it2b;
import java.util.Scanner;

public class AdlawanIt2b {
    config conf = new config();
    
    public static void main(String[] args) {
    int choice;
        Scanner sc = new Scanner(System.in);
        
        do{
            
            System.out.println(" 1. ADD");
            System.out.println(" 2. VIEW");
            System.out.println(" 3. UPDATE");
            System.out.println(" 4. DELETE");
            System.out.println(" 5. Exit");
        
            System.out.print("Enter choice: ");
            choice= sc.nextInt();   
            sc.nextLine();
            
            switch(choice){
                case 1:
                add(sc);
                break;
                
                case 2:
                   view();
                   break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                case 5: 
                    System.out.println("Exit!!");
                    break;
                default:
                    System.out.println("Invalid Choice, PLease Try Again");
            
                    
                    
                    
            } 
        }while(choice != 5);
    
        
    }

 
        

    
      public static void add(Scanner sc) {
        System.out.println("Patient ID");
        int id = sc.nextInt();
        System.out.println("Name");
        String name = sc.next();
        System.out.println("Visit Date");
        String date = sc.next();
        System.out.print("Diagnos: ");
        String Diagnos = sc.next();
        System.out.print("Treatment Plan: ");
        String Treatment = sc.next();       
        config conf = new config();
        String sql = "INSERT INTO tbl_medicalrecord ( p_id ,p_name, p_date ,p_diagnos, p_treatment) VALUES (?, ?, ?, ? , ?)";
        conf.add(sql, id ,name,date ,Diagnos, Treatment);
    }

    public static void view() {
        String sqlQuery = "SELECT * FROM tbl_medicalrecord";
        String[] columnHeaders = {"ID","Name","Date","Diagnos", "Treatment",};
        String[] columnNames = {"p_id","p_name","p_date","p_diagnos", "p_treatment",};
        config conf = new config();
        conf.view(sqlQuery, columnHeaders, columnNames);
    
}
    
     public static void update(){
    
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter ID the to update: ");
        int id = sc.nextInt();
        System.out.print("Enter new name: ");
        String Name = sc.next();
        System.out.print("Enter the Date to Update: ");
        int Date = sc.nextInt();
        System.out.print("Enter the Diagnos to Update: ");
        String Diagnos = sc.next();
        System.out.print("Enter the Treatment to Update: ");
        String Treatment = sc.next();
        String qry = "UPDATE tbl_medicalrecord SET p_name = ?,p_date = ?, p_diagnos = ?, p_treatment = ?, WHERE p_id = ?";
        
        config conf = new config();
        conf.update(qry, id, Name, Date, Diagnos, Treatment );
        
    }
     public static void delete(){
     
           Scanner sc = new Scanner (System.in);
           System.out.println("Enter the ID You want to delete");
           int id = sc.nextInt();
           
           String qry = "DELETE FROM tbl_medicalrecord WHERE id = ?";
           
           config conf = new config();
           conf.delete(qry, id);
     
     
     }
}