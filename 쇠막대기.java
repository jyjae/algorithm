import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        char preChar='(';
        Stack<Character> stack = new Stack();
        int result = 0;

        for(int i=0; i<str.length(); i++) {
            char target = str.charAt(i);

            if(target=='(') {
                result++;
                preChar='(';
                stack.push('(');
            } else {
                stack.pop();
                if(preChar=='(') {
                    result--;
                    result+=stack.size();
                    preChar=')';
                }
            }
        }

        br.close();
    }
}
