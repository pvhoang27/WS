//[Mã câu hỏi (qCode): 57lZDeqF].  Một dịch vụ web (hỗ trợ SOAP version 1.1) được định nghĩa và mô tả trong tệp CharacterService.wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/CharacterService?wsdl để xử lý các bài toán về chuỗi và ký tự.
//Yêu cầu: Viết chương trình tại máy trạm (WS client) để giao tiếp với CharacterService thực hiện các công việc sau:
//a. Triệu gọi phương thức requestStringArray với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một danh sách chuỗi (List<String>) từ server.
//b. Sắp xếp các chuỗi trong danh sách theo số lượng nguyên âm tăng dần. Nếu hai chuỗi có cùng số lượng nguyên âm, giữ nguyên thứ tự xuất hiện ban đầu của chúng trong mảng.
//c. Triệu gọi phương thức submitCharacterStringArray(String studentCode, String qCode, List<String> data) để gửi danh sách chuỗi đã sắp xếp trở lại server.
//Ví dụ: Nếu mảng chuỗi nhận được từ phương thức requestCharacter là ["apple", "kiwi", "banana", "pear"], số lượng nguyên âm trong các từ là:
//•	"apple" có 2 nguyên âm
//•	"kiwi" có 2 nguyên âm
//•	"pear" có 2 nguyên âm
//•	"banana" có 3 nguyên âm
//Sau khi sắp xếp theo số lượng nguyên âm tăng dần, kết quả sẽ là ["apple", "kiwi", "pear", , "banana"]. Danh sách này sẽ được gửi lại server qua phương thức submitCharacter.
//d. Kết thúc chương trình client.
package kiem_tra; 

import vn.medianews.*; 
import java.util.*;     

public class B21DCCN393_57lZDeqF {
    
    // Phương thức đếm số nguyên âm trong một chuỗi
    public static int countVowels(String s) {
        if (s == null) return 0;
        // Chuyển về chữ thường để đếm dễ dàng hơn
        String lowerCaseS = s.toLowerCase(); 
        String vowels = "aeiou";
        int count = 0;
        for (int i = 0; i < lowerCaseS.length(); i++) {
            char c = lowerCaseS.charAt(i);
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        // --- CẤU HÌNH ---
        String msv = "B21DCCN393"; 
        String qCode = "57lZDeqF";   
        
        // Khởi tạo service và port (Lưu ý: dùng CharacterService_Service)
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        
        // a. Triệu gọi phương thức requestStringArray
        List<String> a = port.requestStringArray(msv, qCode);
        System.out.println("Du lieu goc nhan duoc: " + a);
        
        // b. Sắp xếp các chuỗi theo số lượng nguyên âm tăng dần
        // Sử dụng Comparator và Collections.sort (hoặc List.sort)
        // để đảm bảo sắp xếp ổn định.
        a.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int count1 = countVowels(s1);
                int count2 = countVowels(s2);
                // Sắp xếp tăng dần: count1 - count2
                return count1 - count2;
            }
        });
        
        // a.sort((s1, s2) -> countVowels(s1) - countVowels(s2));

        System.out.println( a);
        
        // c. Triệu gọi phương thức submitCharacterStringArray
        port.submitCharacterStringArray(msv, qCode, a);

    }
}