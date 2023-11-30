public class 다항식더하기 {
    public String solution(String polynomial) {
        String answer = "";
        String[] arr = polynomial.split(" +");
        int x = 0;
        int num = 0;

        for (String s : arr) {
            if (s.equals("x")) {
                x += 1;
            } else if (s.contains("x")) {
                x += Integer.parseInt(s.substring(0, s.length() - 1));
            } else if (!s.equals("+")) {
                num += Integer.parseInt(s);
            }
        }

        if (x != 0 && num == 0) {
            if (x == 1) {
                answer = "x";
            } else {
                answer = x + "x";
            }
        }

        if (x != 0 && num != 0) {
            if (x == 1) {
                answer = "x" + " + " + num;
            } else {
                answer = x + "x" + " + " + num;
            }
        }

        if (x == 0 && num != 0) {
            answer = String.valueOf(num);
        }

        return answer;
    }

    public static void main(String[] args) {
        다항식더하기 a = new 다항식더하기();
        System.out.println(a.solution("x + x + 1 + x + x + 7"));

    }

}
