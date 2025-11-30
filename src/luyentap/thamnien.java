/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luyentap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import vn.medianews.EmployeeY;
import vn.medianews.ObjectService;
import vn.medianews.ObjectService_Service;
public class thamnien {
    public static void main(String[] args) throws Exception{
         String studentCode = "B21DCCN414", qCode = "k33FY3jJ";
         ObjectService_Service service = new ObjectService_Service();
         ObjectService sv = service.getObjectServicePort();
         List<EmployeeY> a = sv.requestListEmployeeY(studentCode, qCode);
         System.out.println(a);
         Collections.sort(a, new Comparator<EmployeeY>(){
             public int compare (EmployeeY o1 , EmployeeY o2 ){
                 return o1.getStartDate().compare(o2.getStartDate());
             }
         });
         sv.submitListEmployeeY(studentCode, qCode, a);
    }
}
