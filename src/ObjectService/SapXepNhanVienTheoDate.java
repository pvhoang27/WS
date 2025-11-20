package ObjectService;

//[Mã câu hỏi (qCode): XVeetAkn].  Một dịch vụ web (hỗ trợ SOAP version 1.1) được định nghĩa và mô tả trong tệp ObjectService.wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/ObjectService?wsdl để xử lý các bài toán với đối tượng.
//Yêu cầu: Viết chương trình tại máy trạm (WS client) để giao tiếp với ObjectService thực hiện các công việc sau:
//a. Triệu gọi phương thức requestListEmployeeY với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một danh sách đối tượng EmployeeY từ server. Mỗi đối tượng EmployeeY có các thuộc tính:
//•	name: kiểu String, đại diện cho tên của nhân viên.
//•	startDate: kiểu Date, đại diện cho ngày bắt đầu làm việc của nhân viên.
//b. Sắp xếp danh sách EmployeeY theo thứ tự thâm niên từ cao đến thấp (người có ngày bắt đầu làm việc sớm nhất sẽ đứng đầu danh sách).
//    Nếu hai nhân viên có cùng ngày bắt đầu làm việc, giữ nguyên thứ tự ban đầu của họ trong danh sách.
//c. Triệu gọi phương thức submitListEmployeeY(String studentCode, String qCode, List<EmployeeY> data) để gửi danh sách nhân viên đã sắp xếp trở lại server.
//d. Kết thúc chương trình client.
import java.util.*;
import vn.medianews.EmployeeY;
import vn.medianews.ObjectService;
import vn.medianews.ObjectService_Service;
public class SapXepNhanVienTheoDate {
    public static void main(String[] args) throws Exception{
        String studentCode ="B21DCCN017",qCode = "XVeetAkn";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService sv = service.getObjectServicePort();
        List<EmployeeY> a =  sv.requestListEmployeeY(studentCode, qCode);
        Collections.sort(a,new Comparator<EmployeeY>(){
            public int compare(EmployeeY o1, EmployeeY o2){
                return o1.getStartDate().compare(o2.getStartDate());
            }
        });
        sv.submitListEmployeeY(studentCode, qCode, a);
        
    }
}
