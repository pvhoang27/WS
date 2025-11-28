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
package luyentap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vn.medianews.CharacterService;
import vn.medianews.CharacterService_Service;

/**
 *
 * @author hoang
 */
public class B21DCCN132_e36xPXlT_ChiaMangTheoSoNguyenAm {
    public static int countVowels(String s) {
        int cnt = 0;
        String vowels = "ueoaiUEOAI";
        for (char c : s.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws Exception{
        String studentCode = "B21DCCN132", qCode = "e36xPXlT";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService sv = service.getCharacterServicePort();
        
        List<String> a = sv.requestStringArray(studentCode, qCode);
        System.out.println(a);
        
        // xử lý bài toán 
        Map<Integer , List<String>> nhom = new HashMap<>();
        
        for(String word :  a){
            int dem = countVowels(word);
            if(!nhom.containsKey(dem)){
                nhom.put(dem, new ArrayList<>());
            }
            nhom.get(dem).add(word);
        }
        List<String> result = new ArrayList<>();  
        for (List<String> group : nhom.values()) {
            // Sắp xếp các từ theo thứ tự từ điển trong mỗi nhóm
            Collections.sort(group);
            
            // Tạo chuỗi liệt kê cách nhau bởi dấu phẩy
            String joinedString = String.join(", ", group);
            result.add(joinedString);
        }
        sv.submitCharacterStringArray(studentCode, qCode, result);
    }
}
