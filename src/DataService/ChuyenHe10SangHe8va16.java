/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//[Mã câu hỏi (qCode): RsNlugQq].  Một dịch vụ web (hỗ trợ SOAP version 1.1) được định nghĩa và mô tả trong tệp DataService?wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/DataService?wsdl để xử lý các bài toán với dữ liệu nguyên thủy.
//Yêu cầu: Viết chương trình tại máy trạm (WS client) để giao tiếp với DataService thực hiện các công việc sau:
//a. Triệu gọi phương thức getData với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một danh sách số nguyên (List<Integer>) từ server.
//b. Chuyển đổi số nguyên nhận được từ hệ thập phân sang cả hệ cơ số 8 (bát phân) và hệ cơ số 16 (thập lục phân). Biểu diễn kết quả dưới dạng chuỗi cho mỗi hệ cơ số.
//c. Triệu gọi phương thức submitDataStringArray(String studentCode, String qCode, List<String> data) để gửi danh sách chuỗi kết quả. Trong đó: Mỗi phần tử là chuỗi kết hợp giữa kết quả chuyển đổi sang hệ cơ số 8 và chuỗi kết quả chuyển đổi sang hệ cơ số 16.
//Ví dụ: Nếu số nguyên nhận64 thì:
//    Chuyển đổi sang hệ cơ số 8, tạo thành chuỗi "100".
//    Chuyển đổi sang hệ cơ số 16, tạo thành chuỗi "40".
//-> Chuỗi kết quả tương ứng sẽ là "100|40". Chương trình client thực hiện lần lượt và gửi danh sách chuỗi này trở lại server qua phương thức submitDataStringArray.
//d. Kết thúc chương trình client.
import java.util.*;
import vn.medianews.*;
/**
 *
 * @author hoang
 */
public class ChuyenHe10SangHe8va16 {
    public static void main(String[] args) throws Exception{
        String studentCode = "B21DCCN017", qCode= "RsNlugQq";
        DataService_Service service = new DataService_Service();
        DataService sv = service.getDataServicePort();
        
        List<Integer> a = sv.getData(studentCode, qCode);
        System.out.println(a);
        List<String> kq = new ArrayList<>();
        String chuoi = "";
        
        for(int x : a ){
            String oc = Integer.toOctalString(x);
            String hex = Integer.toHexString(x).toUpperCase();
            // đừng có nhầm là += nhé
            chuoi =  oc +"|"+hex;
            kq.add(chuoi);
        }
        System.out.println(kq);
        sv.submitDataStringArray(studentCode, qCode, kq);
        
    }
}
