//[Mã câu hỏi (qCode): NRC4Z4sg].  Một dịch vụ web (hỗ trợ SOAP version 1.1) được định nghĩa và mô tả trong tệp DataService?wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/DataService?wsdl để xử lý các bài toán với dữ liệu nguyên thủy.
//Yêu cầu: Viết chương trình tại máy trạm (WS client) để giao tiếp với DataService thực hiện các công việc sau:
//a. Triệu gọi phương thức getData với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một danh sách số nguyên (List<Integer>) từ server.
//b. Chuyển đổi số nguyên nhận được từ hệ thập phân sang hệ nhị phân và biểu diễn kết quả dưới dạng chuỗi nhị phân.
//c. Triệu gọi phương thức submitDataStringArray(String studentCode, String qCode, List<String> data) để gửi chuỗi nhị phân đã chuyển đổi trở lại server.
//Ví dụ: Nếu mỗi số nguyên nhận được từ phương thức getData, chương trình client sẽ chuyển đổi sang chuỗi nhị phân là "1010", và gửi mảng chuỗi này trở lại server qua phương thức submitData.
//d. Kết thúc chương trình client.
package DataService;
import java.util.*; 
import vn.medianews.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hoang
 */
public class B21DCCN132_NRC4Z4sg_ChuyenHe10sangHe2 {
    public static void main(String[] args) throws Exception {
        String studentCode = "B21DCCN132",qCode = "NRC4Z4sg";
        DataService_Service service = new DataService_Service();
        DataService sv = service.getDataServicePort();
        List<Integer> a = sv.getData(studentCode, qCode);
        System.out.println(a);
        List<String> kq = new java.util.ArrayList<>();
        for(int x : a ){
            String np = Integer.toBinaryString(x);
            kq.add(np);
        }
        System.out.println(kq);
        sv.submitDataStringArray(studentCode, qCode, kq);
        
    }
}
