/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import vn.medianews.CharacterService;
import vn.medianews.CharacterService_Service;

public class nguyenAm {
    public static int dem (String s ){
        int cnt = 0 ; 
        String nguyenAm = "ueoaiUEOAI";
        for(int i = 0 ; i < s.length(); i++){
            if(nguyenAm.indexOf(s.charAt(i)) != -1) cnt ++;
        }
        return cnt; 
    }
    public static void main(String[] args) throws Exception{
        String studentCode ="B22DCCN702", qCode = "LuOCWibI";
        CharacterService_Service service = new CharacterService_Service();
        CharacterService sv = service.getCharacterServicePort();
        List<String> a = sv.requestStringArray(studentCode, qCode);
        System.out.println(a);
        // sap xep
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(dem(o1) != dem(o2) ) return dem(o1) -dem(o2);
                return o1.compareTo(o2);
            }
        });
        
        List<String> kq = new ArrayList<>();
        String nhom = a.get(0);
        for(int i = 1 ; i < a.size(); i++  ){
            if(dem(a.get(i)) == dem(a.get(i - 1))) nhom +=", "+a.get(i);
            else {
                kq.add(nhom);
                nhom = a.get(i);
            }
        }
        kq.add(nhom);
        System.out.println(kq);
        sv.submitCharacterStringArray(studentCode, qCode, kq);
    }
    
    
}
