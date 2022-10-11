import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 문자열재정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        List<Character> list = new ArrayList<>();
        String answer = "";
        int sum = 0;

        for(int i=0; i<str.length(); i++) {
            if(!Character.isDigit(str.charAt(i))) {
                list.add(str.charAt(i));
            }else {
                sum += str.charAt(i)-'0';
            }
        }

        Collections.sort(list);
        for(Character character : list) {
            answer+=character;
        }

        System.out.println(answer+sum);
    }
}
