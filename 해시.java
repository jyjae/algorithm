import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 해시 {

    static List<Node>[] hashTable = new ArrayList[8];

    public 해시() {
        for(int i=0; i<hashTable.length; i++) {
            hashTable[i] = new ArrayList<>();
        }
    }
    public static void main(String[] args) {


        해시 solution = new 해시();
        solution.save("Any", "010-222-2222");
        solution.save("Author", "010-111-2222");
        solution.save("AAAA", "010-777-2222");
        solution.save("David", "010-333-2222");

        System.out.println(solution.getData("Author"));
        System.out.println(solution.getData("Any"));
        System.out.println(solution.getData("David"));


    }


    public int getKey(String data) {
        return data.hashCode();
    }

    public int hashFunction(int key) {
        return key % 8;
    }

    public void save(String key, String value) {
        int getKey = getKey(key);
        int hashAddress = hashFunction(getKey);
        if(hashTable[hashAddress].size()!=0) {
            for(int i=0; i<hashTable[hashAddress].size(); i++) {
                if(hashTable[hashAddress].get(i).getKey() == getKey) {
                    hashTable[hashAddress].get(i).data = value;
                    return;
                }
            }
        }
        hashTable[hashAddress].add(new Node(getKey, value));
    }

    public String getData(String key) {
        int getKey = getKey(key);
        int hashAddress = hashFunction(getKey);

        if(hashTable[hashAddress].size()!=0) {
            for(int i=0; i<hashTable[hashAddress].size(); i++) {
                if(hashTable[hashAddress].get(i).getKey() == getKey) {
                    return hashTable[hashAddress].get(i).getData();
                }
            }
        }
        return null;
    }



    public static class Node {
        int key;
        String data;

        public Node(int key, String data) {
            this.key = key;
            this.data = data;
        }
        public int getKey() {
            return key;
        }

        public String getData() {
            return data;
        }
    }
}
