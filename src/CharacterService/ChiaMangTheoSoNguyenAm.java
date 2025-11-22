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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vn.medianews.CharacterService_Service;
import vn.medianews.CharacterService;

public class ChiaMangTheoSoNguyenAm  {
    private static int NguyenAm(String s){
        int cnt = 0 ;
        String nguyenAm =  "ueoaiUEOAI";
        for(char c : s.toCharArray()){
            if(nguyenAm.indexOf(c) != -1) { // tức là nếu nó nằm trong nguyên âm đó 
                cnt ++;
            }
        }
        return  cnt ;
    }
    public static void main(String[] args) throws Exception {
        String studentCode = "B21DCCN132", qCode = "e36xPXlT";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService sv = service.getCharacterServicePort();
        List<String> a = sv.requestStringArray(studentCode, qCode);
        System.out.println(a);
        
        // --- Xử lý bài toán ---
        
        // 1. Tìm xem có những loại số lượng nguyên âm nào
        List<Integer> listSoLuong = new ArrayList<>();
        
        for (String w : a) {
            int dem = NguyenAm(w);
            if (!listSoLuong.contains(dem)) {
                listSoLuong.add(dem);
            }
        }
        
        
        // Sắp xếp danh sách số lượng để nhóm nhỏ (0 nguyên âm) đứng trước, nhóm lớn đứng sau
        Collections.sort(listSoLuong); 
      
        System.out.println( listSoLuong);
        
        List<String> listKetQua = new ArrayList<>();

        // 2. Duyệt qua từng loại số lượng (lúc này đã theo thứ tự 0, 1, 2...)
        for (int soLuongCanTim : listSoLuong) {
            
            List<String> nhomTam = new ArrayList<>();

            // Quét lại toàn bộ danh sách gốc để nhặt từ
            for (String w : a) {
                if (NguyenAm(w) == soLuongCanTim) {
                    nhomTam.add(w);
                }
            }

            // 3. Sắp xếp các từ trong nhóm theo A-Z
            Collections.sort(nhomTam);

            // Ghép chuỗi thủ công
            String chuoiGhep = "";
            for (int i = 0; i < nhomTam.size(); i++) {
                chuoiGhep += nhomTam.get(i);
                if (i < nhomTam.size() - 1) {
                    chuoiGhep += ", ";
                }
            }
            
            listKetQua.add(chuoiGhep);
        }
        
        System.out.println(listKetQua);
        sv.submitCharacterStringArray(studentCode, qCode, listKetQua);
    }
}
