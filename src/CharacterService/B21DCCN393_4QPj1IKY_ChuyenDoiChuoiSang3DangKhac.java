/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//[Mã câu hỏi (qCode): 4QPj1IKY].  Một dịch vụ web (hỗ trợ SOAP version 1.1) được định nghĩa và mô tả trong tệp CharacterService.wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/CharacterService?wsdl để xử lý các bài toán về chuỗi và ký tự.
//Yêu cầu: Viết chương trình tại máy trạm (WS client) để giao tiếp với CharacterService thực hiện các công việc sau:
//a. Triệu gọi phương thức requestString với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một chuỗi (String) từ server. Chuỗi có thể chứa các từ được phân tách bằng dấu cách hoặc dấu gạch dưới.
//b. Chuyển đổi chuỗi đã nhận được sang ba định dạng khác nhau:
//•	PascalCase: Mỗi từ bắt đầu bằng chữ in hoa, không có khoảng cách giữa các từ.
//•	camelCase: Từ đầu tiên viết thường, các từ tiếp theo viết hoa chữ cái đầu và viết liền nhau.
//•	snake_case: Các từ được viết thường và nối với nhau bằng dấu gạch dưới.
//c. Triệu gọi phương thức submitCharacterStringArray(String studentCode, String qCode, List<String> data) để gửi mảng kết quả chứa ba chuỗi đã định dạng trở lại server, theo thứ tự: PascalCase, camelCase, snake_case.
//Ví dụ: Nếu chuỗi nhận được từ phương thức requestCharacter là "hello world example", các chuỗi kết quả sẽ là:
//•	PascalCase: "HelloWorldExample"
//•	camelCase: "helloWorldExample"
//•	snake_case: "hello_world_example"
//Mảng kết quả sẽ là ["HelloWorldExample", "helloWorldExample", "hello_world_example"], và sẽ được gửi lại server qua phương thức submitCharacter.
//d. Kết thúc chương trình client.
package CharacterService;

import java.util.ArrayList;
import java.util.List;
import vn.medianews.CharacterService;
import vn.medianews.CharacterService_Service;

/**
 *
 * @author hoang
 */
public class B21DCCN393_4QPj1IKY_ChuyenDoiChuoiSang3DangKhac {
    public static void main(String[] args) throws Exception{
        String studentCode = "B21DCCN393", qCode = "4QPj1IKY";
        // khai báo đã
        CharacterService_Service service = new CharacterService_Service();
        // khai báo biến sv 
        CharacterService sv = service.getCharacterServicePort();
        // nhận data về 
        // bài này đầu tiên là nhận về 1 chuỗi String , còn lúc gửi đi thì lại là gửi 1 list, nhớ nhé
        String a = sv.requestString(studentCode, qCode).trim();
        System.out.println(a);
        
        //xử lý bài toán 
        // sv sẽ gửi về cho ta 1 chuỗi mà các phần tử cách nhau = dấu gạch hoặc dấu cách
        // vậy thì ta cứ chuyển tất cả về dấu cách (trong mọi trường hợp) đi rồi tách chúng 
        String[] word = a.replace("_", " ").split("\\s+"); // dùng \\s+ cho chắc
        System.out.println(word[1]);
        
        String PascalCase ="";
        String camelCase ="";
        String snake_case = "";
        
        for(int i = 0 ; i < word.length; i++){
            // đầu tiên cứ chuyển hết về chữ thường đã cho dễ biến đổi về sau
            String w = word[i].toLowerCase();
            // tiếp theo xử lý chữ cái đầu viết hoa 
            String dauHoa = Character.toUpperCase(w.charAt(0)) + w.substring(1);
            PascalCase += dauHoa;
            // xử lý chuỗi camel : từ đầu viết thường hết , còn 2 từ sau là có chữ đầu viết hoa
            if(i ==0) camelCase += w; // ban đầu index i = 0 thì lấy luôn w vì nó đang thường sẵn
            else camelCase += dauHoa; // tận dụng của pascal hahaa
            // xử lý snake : viết thường hết nma mỗi từ cách nhau =_
            snake_case += w; //đầu tiên cứ cộng nhẹ cái w đã
            // sau khi cộng w thì nhớ cộng _ để ngăn cách từ tiếp theo, đến khi i < length thì thôi ko cộng _ nữa
            if(i < word.length -1 ) snake_case+= "_"; 
        }
        // cho vào list để nộp lên sv, list kiểu string
        List<String> ans = new  ArrayList<>();
        //add lần lượt theo đúng thứ tự
        ans.add(PascalCase);
        ans.add(camelCase);
        ans.add(snake_case);
        //submit thôi : nhớ là chọn String array
        sv.submitCharacterStringArray(studentCode, qCode, ans);
    }   
}
