public class 옹알이 {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] word = {"aya", "ye", "woo", "ma"};

        for (String s : babbling) {
            int length = s.length();
            for (String value : word) {
                if (s.contains(value)) {
                    length -= value.length();
                }

            }
            if (length == 0) {
                answer++;
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        옹알이 a = new 옹알이();
        String[] aa =   {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};
        System.out.println(a.solution(aa));
    }
}
