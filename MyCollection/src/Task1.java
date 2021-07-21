import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

public class Task1 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(4,5,-6,4,5,3,4,2,4,5,7));
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(Integer i:arrayList){
            if(hashMap.containsKey(i)){
                Integer oldValue = hashMap.get(i);
                hashMap.put(i,oldValue+1);
            }else{
                hashMap.put(i,1);
            }
        }
        System.out.println(hashMap);
    }
}
