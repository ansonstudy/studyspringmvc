import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Test {
    
	public int[] intArray = new int[10];
	public List<String> strList = null;
	
	public List<String> query() {
		return strList;
	}
	
	class Try <T> {
		public T method() {
			return (T)null;
		}
	}
	
	public static void main(String[] args) {
		
		String[] array = new String[]{"a","b","c"};
		System.out.println(Arrays.toString(array));
		List<String> array2List = Arrays.asList(array);
		array = (String[])array2List.toArray(new String[10]);
		System.out.println(Arrays.toString(array));
		
		//java.util.TreeMap<K, V>

		//Queue q = new PriorityQueue();
		
//==============================================================================			
//		Test t = new Test();
//		System.out.println(t.intArray[1]);
//		
//		List<String> result = t.query();
//		System.out.println(result);
		
//		Double d = 1.0;
//		Integer i = 1;
//		Byte b = 120;
		
//		class Test2 {
//			int i = 0;
//		}
//		
//		Object t2 = (Object) new Test2();
//		Test2 test2 = (Test2)t2;
//		
//		System.out.println(test2.i);
		
//		int i,j,k;
//		i = 100;
//		while (i > 0) {
//			i = j * 2;
//			
//			i--;
//		}
		
//		String s = new String("hello");
//		String b = new String("hello");
//		System.out.println(s==b);
//		
//		System.out.println(25.0/2);
		
//==============================================================================		
//		Map<Integer, String> map = new HashMap<Integer, String>();
//		
//		for (int i = 0 ; i < 10; i++) {
//			map.put(i, "I'm NO."+i);
//		}
		
//		Iterator<Entry<Integer, String>> it = map.entrySet().iterator();	
//		while (it.hasNext()) {
//			Entry<Integer, String> entry = it.next();
//			
//			System.out.println("NO." + entry.getKey() + "=" + entry.getValue());
//		}
//		Iterator<Integer> it = map.keySet().iterator();
//		while (it.hasNext()) {
//			Integer key = (Integer)it.next();
//			System.out.println("NO."+key+"=" + map.get(key));
//		}

//==============================================================================	
//		int[] arr1 = {8,1,9,5,7,6,3,0,4};
//		
//		boolean isSort = true;
//		
//		for (int i = 0; i < arr1.length-1; i++) {
//			
//			isSort = true;
//			
//			for (int j = 0; j < arr1.length-1-i; j++) {
//				//System.out.print(arr1[j]);
//				if (arr1[j] > arr1[j+1]) {
//					int tmp = arr1[j];
//					arr1[j] = arr1[j+1];
//					arr1[j+1] = tmp;
//					isSort = false;
//				}
//				
//				System.out.println(Arrays.toString(arr1));
//			}
//			
//			if (isSort) {
//				break;
//			}
//		}
	}
}
