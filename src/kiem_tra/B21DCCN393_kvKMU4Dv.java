//[Mã câu hỏi (qCode): kvKMU4Dv].  Một dịch vụ web (hỗ trợ SOAP version 1.1) được định nghĩa và mô tả trong tệp DataService?wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/DataService?wsdl để xử lý các bài toán với dữ liệu nguyên thủy.
//Yêu cầu: Viết chương trình tại máy trạm (WS client) để giao tiếp với DataService thực hiện các công việc sau:
//a. Triệu gọi phương thức getData với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một danh sách số nguyên (List<Integer>) từ server. Phần tử đầu tiên của mảng này là giá trị K.
//b. Với danh sách số nguyên nhận được, sử dụng giá trị K (phần tử đầu tiên của của danh sách) để xác định phần tử lớn thứ K và nhỏ thứ K trong các phần tử còn lại (loại bỏ phần tử đầu tiên khi tính toán).
//c. Triệu gọi phương thức submitDataIntArray(String studentCode, String qCode, List<Integer> data) để gửi mảng kết quả chứa: phần tử lớn thứ K, phần tử nhỏ thứ K đã tìm được trở lại server.
//Ví dụ: Nếu mảng số nguyên nhận được từ phương thức getData là [3, 5, 1, 4, 2], giá trị K là 3. Chương trình client sẽ tìm phần tử lớn thứ 3 và nhỏ thứ 3 trong mảng [5, 1, 4, 2], kết quả là mảng [2, 4] và gửi kết quả này trở lại server qua phương thức submitData.
//d. Kết thúc chương trình client.
package kiem_tra; 


// Các import cần thiết
import vn.medianews.*; 
import java.util.*;     


public class B21DCCN393_kvKMU4Dv {
    
    public static void main(String[] args) throws Exception {
        String msv = "B21DCCN393"; 
        String qCode = "kvKMU4Dv";   
        
        // Khởi tạo service và port 
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        
        // a. Triệu gọi phương thức getData
        List<Integer> a = port.getData(msv, qCode);
        System.out.println( a);
        
        // 1. Xác định giá trị K và danh sách còn lại
        if (a == null || a.isEmpty()) {
            System.out.println("Loi: Danh sach rong!");
            return;
        }
        
        int K = a.get(0); // Phần tử đầu tiên là K
        List<Integer> remainingList = new ArrayList<>(a.subList(1, a.size()));
        
        // Kiểm tra điều kiện K
        if (K <= 0 || K > remainingList.size()) {
            System.out.println("Loi: Gia tri K khong hop le!");
            return;
        }
        
        // b. Xử lý: Sắp xếp để tìm phần tử lớn thứ K và nhỏ thứ K
        Collections.sort(remainingList);
        
        // Phần tử nhỏ thứ K: nằm ở vị trí K-1 (do index bắt đầu từ 0)
        int kthSmallest = remainingList.get(K - 1);
        
        // Phần tử lớn thứ K: nằm ở vị trí (size - K)
        int kthLargest = remainingList.get(remainingList.size() - K);
        
        // Mảng kết quả: [phần tử lớn thứ K, phần tử nhỏ thứ K]
        List<Integer> ans = new ArrayList<>();
        ans.add(kthLargest);
        ans.add(kthSmallest);

        System.out.println("K = " + K);
        System.out.println("Danh sach con lai: " + remainingList);
        System.out.println("Phan tu lon thu K (" + K + "): " + kthLargest);
        System.out.println("Phan tu nho thu K (" + K + "): " + kthSmallest);
        System.out.println("Mảng ket qua gui di: " + ans);

        // c. Triệu gọi phương thức submitDataIntArray
        port.submitDataIntArray(msv, qCode, ans);
        

    }
}