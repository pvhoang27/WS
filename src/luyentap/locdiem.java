/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luyentap;
import java.util.ArrayList;
import java.util.List;
import vn.medianews.ObjectService;
import vn.medianews.ObjectService_Service;
import vn.medianews.Student;
public class locdiem {
    public static void main(String[] args) throws Exception{
        String studentCode = "B22DCCN019",qCode = "rAPverT0";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService sv = service.getObjectServicePort();
        List<Student> a = sv.requestListStudent(studentCode, qCode);
        List<Student> kq = new ArrayList<>();
        System.out.println(a);
        for(Student s : a){
            double score = s.getScore();
            if(score>= 8.0f || score <5.0f) kq.add(s);
        }
        sv.submitListStudent(studentCode, qCode, kq);
    }
}
