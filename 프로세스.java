public class 프로세스 {

    public int solution(int[] priorities, int location) {
        int answer = 0;
        int index = 0;

        while (true) {
            if(priorities[location]==0) break;

            boolean check = true;
            if(index == priorities.length) index=0;
            for(int j=0; j<priorities.length; j++) {
                if(j==index) continue;
                if(priorities[index] < priorities[j]) {
                    check = false;
                    break;
                }
            }

            if(check) {
                priorities[index] =0;
                answer+=1;
            }

            index+=1;
        }

        return answer;
    }

    public static void main(String[] args) {
        프로세스 solution = new 프로세스();
        System.out.println(solution.solution(new int[]{2,1,3,2},2));
    }

}
