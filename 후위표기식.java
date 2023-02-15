import java.io.*;
import java.util.Stack;

public class 후위표기식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int[] arr = new int[num];
        for (int i=0; i<num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stack = new Stack();

        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if('A'<=c && c<='Z') {
                stack.push((double) arr[c-65]);
            } else {
                if(!stack.isEmpty()) {
                    double front = 0.00f;
                    double back = 0.00f;

                switch (c) {
                    case '+': {
                        front = stack.pop();
                        back = stack.pop();
                        stack.push(back + front);
                        continue;
                    }
                    case '-': {
                        front = stack.pop();
                        back = stack.pop();
                        stack.push(back - front);
                        continue;
                    }
                    case '/': {
                        front = stack.pop();
                        back = stack.pop();
                        stack.push(back / front);
                        continue;
                    }
                    case '*': {
                        front = stack.pop();
                        back = stack.pop();
                        stack.push(back * front);
                        continue;
                    }
                }
                }
            }
        }
        System.out.println(String.format("%.2f", stack.pop()));
        //bw.write(String.format("%.2f", stack.pop()));

    }
}
