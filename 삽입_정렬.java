import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 삽입_정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int n=0; n<q; n++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        for(int i=1; i<list.size(); i++) {
            boolean available = false;
            int target = i;
            for(int j=i-1; j>=0; j--) {
                target = j;
                if(list.get(i)>=list.get(j)) {
                    target+=1;
                    break;
                } else {
                    available = true;
                }
            }

            if(available) {
                int tmp = list.get(i);
                list.remove(i);
                list.add(target, tmp);
            }
        }

        for (Integer a : list) {
            System.out.println(a);
        }
    }
}
