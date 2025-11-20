package CharacterService;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//[Mã câu hỏi (qCode): pN38aVH0].  Một dịch vụ web (hỗ trợ SOAP version 1.1) được định nghĩa và mô tả trong tệp CharacterService.wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/CharacterService?wsdl để xử lý các bài toán về chuỗi và ký tự.
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
/**
 *
 * @author hoang
 */
import java.util.*;
import vn.medianews.*;

public class ChuyenThanh3Chuoi {
    public static void main(String[] args) throws Exception{
        String studentCode = "B21DCCN017", qCode= "pN38aVH0"; 
        CharacterService_Service service= new CharacterService_Service();
        CharacterService sv = service.getCharacterServicePort();
        String s = sv.requestString(studentCode, qCode).toLowerCase();// chuyển luôn về hết chữ thường để xủ lý 
        System.out.println(s);
        // đề bài nói là sv gửi 1 chuỗi mà cách phần tử cách nhau = dấu cách hoặc dấu _ nên ta chuyển hết sang _ cho dễ
        String [] part = s.replace(" ", "_").split("_");
        String pas = "",camel = "" ,snake = "";
        for(int i = 0  ; i < part.length; i++){
            //đầu tiên chữ hoa kí tự đầu tiên + phần còn lại của part, code hơi khó hiểu tí
            String dauHoa = Character.toUpperCase(part[i].charAt(0)) + part[i].substring(1);
            pas += dauHoa;
            
            if(i == 0) camel += part[i];
            else camel+= dauHoa;     
        }
        snake = s;
        List<String> kq = new ArrayList<String>();
        kq.add(pas);
        kq.add(camel);
        kq.add(snake);
        System.out.println(kq);
        
        sv.submitCharacterStringArray(studentCode, qCode, kq);
        
             
    }
}
