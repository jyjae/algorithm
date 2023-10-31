public class 올바른괄호 {

    public static void main(String[] args) {
        올바른괄호 solution = new 올바른괄호();
        System.out.println(solution.solution("(()("));
    }

    boolean solution(String s) {
        boolean answer = true;
        char[] c = s.toCharArray();
        int count = 0;
        for(int i=0; i<c.length; i++) {
            if(c[i]=='(') {
                count+=1;
            }else {
                if(count == 0) return false;
                count-=1;
            }
        }
        if(count!=0) return false;

        return answer;
    }
}
