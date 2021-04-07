import java.util.HashMap;
import java.util.Map;

/**
 * 返回[1,2,1,3,4,2],返回重复的数字，重复数字的重复
 */
public class q {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 4, 1, 5, 2};

        Map<Integer,Integer> hashmap =new HashMap<Integer, Integer>();
        for(int i=0;i<arr.length;i++){
            int num=1;
            if(hashmap.containsKey(arr[i])){
                num=hashmap.get(arr[i])+1;
            }
            hashmap.put(arr[i],num);
            System.out.println(hashmap.get(arr[i]));


        }
        for(Integer key:hashmap.keySet()){
//            System.out.println(key+"="+hashmap.get(key));
            if(hashmap.get(key)>1){
                System.out.println(key+"="+hashmap.get(key));
            }
        }
    }
}
