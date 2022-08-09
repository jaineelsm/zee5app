package com.zee.zee5app;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.zee.zee5app.dto.User;

public class SortingMain {
	public static void main(String[] args) {
		
			
				TreeMap<Integer, String> hashmap = new TreeMap<>();
				hashmap.put(1, null);
				hashmap.put(2, null);
				hashmap.put(3, "raj");
//				hashmap.put(null, "rohlan");
//				hashmap.put(null, "rohlansnb ");
				
				
//				4.	Entryset method transform map to set in entry type
				for (Entry<Integer, String>entry:hashmap.entrySet()) {
					System.out.println(entry.getKey()+" "+entry.getValue());
				}
				
//				for (Map.Entry<keyType, valType> entry : map.entrySet()) {
//					keyType key = entry.getKey();
//					valType val = entry.getValue();
//					
//				}
				System.out.println(hashmap.values());
				
				hashmap.forEach((e1,e2)->{
				System.out.println(e1+" "+e2);
				});
				System.out.println(hashmap.get(1));
			

		
		
		
		
		
		
		
		
//		List<Integer> list = Arrays.asList(10,1,2,3,4,4,5,5,5);
//		list.forEach(e->System.out.println(e));//lambda expression
//		list.forEach(System.out::println);//:: ->reference to static method
//		
//		System.out.println("sorted one");
//		Collections.sort(list);
//		list.forEach(e->System.out.println(e));
//		
//		
//		
//		
////		scope within the block, anonymous class, generating $1 class 
//		Comparator<User> comparator = new Comparator<User>() {
//
//			@Override
//			public int compare(User o1, User o2) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//		};
////		no anonymous class
//		Comparator<User> comparator2 = (e1,e2)->{
//			return e1.getUserId().compareTo(e2.getUserId());
//		};
		
		
		
	}

}
