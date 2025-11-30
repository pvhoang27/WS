/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luyentap;
import java.util.ArrayList;
import java.util.List;
import vn.medianews.DataService_Service;
import vn.medianews.DataService;
/**
 *
 * @author hoang
 */
public class tp {
    public static void main(String[] args) throws Exception{
         String studentCode = "B21DCCN414", qCode = "9MSsjxSA";
         DataService_Service service = new DataService_Service();
         DataService sv = service.getDataServicePort();
         List<Integer> a = sv.getData(studentCode, qCode);
         System.out.println(a);
         List<String> kq = new ArrayList<>();
         String bi = "";
         for(int x : a ){
             bi = Integer.toBinaryString(x);
             kq.add(bi);
         }
         sv.submitDataStringArray(studentCode, qCode, kq);
    }
}
