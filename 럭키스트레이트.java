import java.util.Scanner;

public class 럭키스트레이트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        String str = N+"";
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            if (i < str.length() / 2) {
                result += N % 10;
                N = N / 10;
            } else {
                if (i ==str.length() - 1) {
                    result -= N % 10;
                    result -= N / 10;
                } else {
                    result -= N % 10;
                    N = N / 10;
                }
            }
        }

        if (result==0) System.out.println("LUCKY");
        else System.out.println("READY");
    }
}
