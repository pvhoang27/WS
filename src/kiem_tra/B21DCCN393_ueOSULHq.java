//[Mã câu hỏi (qCode): ueOSULHq].  Một dịch vụ web (hỗ trợ SOAP version 1.1) được định nghĩa và mô tả trong tệp DataService?wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/DataService?wsdl để xử lý các bài toán với dữ liệu nguyên thủy.
//Yêu cầu: Viết chương trình tại máy trạm (WS client) để giao tiếp với DataService thực hiện các công việc sau:
//a. Triệu gọi phương thức getData với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một danh sách số nguyên (List<Integer>) từ server.
//b. Với danh sách số nguyên nhận được, xóa tất cả các phần tử trùng lặp, giữ lại lần xuất hiện đầu tiên của mỗi phần tử. Mảng kết quả sẽ chỉ chứa các phần tử duy nhất theo thứ tự xuất hiện ban đầu.
//c. Triệu gọi phương thức submitDataIntArray(String studentCode, String qCode, List<Integer> data) để gửi mảng kết quả đã loại bỏ các phần tử trùng lặp trở lại server.
//Ví dụ: Nếu mảng số nguyên nhận được từ phương thức getData là [1, 2, 2, 3, 4, 3, 5], mảng kết quả sau khi loại bỏ phần tử trùng lặp là [1, 2, 3, 4, 5]. Mảng này sẽ được gửi lại server qua phương thức submitData.
//d. Kết thúc chương trình client.

package kiem_tra; 

// Các import cần thiết
import vn.medianews.*; 
import java.util.*;     

/**
 *
 * @author hoang
 */
// Tên class phải khớp với tên tệp
public class B21DCCN393_ueOSULHq {
    
    public static void main(String[] args) throws Exception {
        // --- CẤU HÌNH ---
        String msv = "B21DCCN393"; 
        String qCode = "ueOSULHq";   
        
        // Khởi tạo service và port 
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        
        // a. Triệu gọi phương thức getData
        List<Integer> a = port.getData(msv, qCode);
        System.out.println( a);
        
        // b. Xóa tất cả các phần tử trùng lặp, giữ lại lần xuất hiện đầu tiên
        // Sử dụng LinkedHashSet sẽ tự động loại bỏ phần tử trùng
        // và giữ nguyên thứ tự chèn (thứ tự xuất hiện đầu tiên).
        List<Integer> ans = new java.util.ArrayList<>(new java.util.LinkedHashSet<>(a));

        System.out.println(ans);
        
        // c. Triệu gọi phương thức submitDataIntArray
        port.submitDataIntArray(msv, qCode, ans);
        
        
        // d. Kết thúc chương trình client
    }
}