
import java.util.ArrayList;
import java.util.List;
import vn.medianews.*;

//[Mã câu hỏi (qCode): 2Ag30nUf].  Một dịch vụ web (hỗ trợ SOAP version 1.1) được định nghĩa và mô tả trong tệp DataService?wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/DataService?wsdl để xử lý các bài toán với dữ liệu nguyên thủy.
//Yêu cầu: Viết chương trình tại máy trạm (WS client) để giao tiếp với DataService thực hiện các công việc sau:
//a. Triệu gọi phương thức getData với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một danh sách số nguyên (List<Integer>) từ server.
//b. Chuyển đổi số nguyên nhận được từ hệ thập phân sang hệ nhị phân và biểu diễn kết quả dưới dạng chuỗi nhị phân.
//c. Triệu gọi phương thức submitDataStringArray(String studentCode, String qCode, List<String> data) để gửi chuỗi nhị phân đã chuyển đổi trở lại server.
//Ví dụ: Nếu mỗi số nguyên nhận được từ phương thức getData, chương trình client sẽ chuyển đổi sang chuỗi nhị phân là "1010", và gửi mảng chuỗi này trở lại server qua phương thức submitData.
//d. Kết thúc chương trình client.
public class He10SangHe2 {
    public static void main(String[] args) throws Exception{
        String studentCode ="B20DCCN097",qCode= "2Ag30nUf";
        DataService_Service  service= new  DataService_Service();
        DataService sv = service.getDataServicePort();
        List<Integer> a = sv.getData(studentCode, qCode);
        List<String> kq  = new ArrayList<>();
        System.out.println(a);
//        for(int i = 0 ; i < a.size(); i++){
//            String bi = Integer.toBinaryString(a.get(i));
//            kq.add(bi);
//        }
        for(int x : a ){
            String bi = Integer.toBinaryString(x);
            kq.add(bi);
        }
        sv.submitDataStringArray(studentCode, qCode, kq);
    }
}
