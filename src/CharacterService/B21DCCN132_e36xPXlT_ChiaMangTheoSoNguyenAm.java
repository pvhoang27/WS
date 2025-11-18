/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//[Mã câu hỏi (qCode): e36xPXlT].  Một dịch vụ web (hỗ trợ SOAP version 1.1) được định nghĩa và mô tả trong tệp CharacterService.wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/CharacterService?wsdl để xử lý các bài toán về chuỗi và ký tự.
//Yêu cầu: Viết chương trình tại máy trạm (WS client) để giao tiếp với CharacterService thực hiện các công việc sau:
//a. Triệu gọi phương thức requestStringArray với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một danh sách chuỗi (List<String>) từ server.
//b. Phân loại các từ trong mảng chuỗi thành các nhóm có cùng số lượng nguyên âm. Tạo một chuỗi cho mỗi nhóm, trong đó liệt kê các từ cách nhau bằng dấu phẩy, và sắp xếp các từ theo thứ tự từ điển trong mỗi nhóm.
//c. Triệu gọi phương thức submitCharacterStringArray(String studentCode, String qCode, List<String> data) để gửi danh sách chuỗi kết quả trở lại server, trong đó mỗi phần tử là một nhóm từ với cùng số lượng nguyên âm.
//Ví dụ: Nếu danh sách chuỗi nhận được từ phương thức requestCharacter là ["apple", "banana", "pear", "grape", "kiwi"], các nhóm có thể là:
//•	Nhóm 2 nguyên âm: "apple, banana"
//•	Nhóm 1 nguyên âm: "grape, kiwi, pear"
//Danh sách kết quả sẽ là ["apple, banana", "grape, kiwi, pear"], và danh sách này sẽ được gửi lại server qua phương thức submitCharacter.
//d. Kết thúc chương trình client.
package CharacterService;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import vn.medianews.CharacterService;
import vn.medianews.CharacterService_Service;

/**
 *
 * @author hoang
 */
public class B21DCCN132_e36xPXlT_ChiaMangTheoSoNguyenAm {
    public static void main(String[] args) throws Exception {
        // Cấu hình thông tin
        String msv = "B21DCCN132", qCode = "e36xPXlT"; 
        // Tạo đối tượng dịch vụ từ web service
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        // a. Triệu gọi phương thức requestStringArray từ server 
        List<String> a = port.requestStringArray(msv, qCode);
        System.out.println(a);
        // b. Sắp xếp các chuỗi theo số lượng nguyên âm
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return dem(s1) - dem(s2);
            }
        });
        // c. Triệu gọi phương thức submitCharacterStringArray để gửi mảng đã sắp xếp
        port.submitCharacterStringArray(msv, qCode, a);
        System.out.println(a);
    }
    // Hàm đếm số nguyên âm trong chuỗi
    private static int dem(String str) {
        int cnt = 0;
        // Các ký tự nguyên âm
        String ngAm = "aeiouAEIOU";
        for (int i = 0; i < str.length(); i++) {
            if (ngAm.indexOf(str.charAt(i)) != -1) cnt++;
        }
        return cnt;
    }
}
