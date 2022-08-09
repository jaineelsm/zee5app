//package com.zee.zee5app;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//
//import javax.naming.InvalidNameException;
//
//import com.zee.zee5app.dto.Movie;
//import com.zee.zee5app.enums.Languages;
//import com.zee.zee5app.exceptions.InvalidIdException;
//
//public class ExceptionMain {
//    
//    public static int methodA() throws FileNotFoundException {
//        throw new FileNotFoundException();
//    }
//    
//    public static int methodB() throws FileNotFoundException {
//         return methodA();
//        
//    }
//    public static void methodC() throws FileNotFoundException {
//        methodB();
//    }
//    
//public static void main(String[] args) {
//        
//        try {
//            methodC();
//        } catch (FileNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        
//    }
//}
//    



package com.zee.zee5app;
import com.zee.zee5app.dto.Movie;
//import java.io.ObjectStreamException;

import java.io.FileNotFoundException;

import javax.management.relation.InvalidRelationIdException;
import javax.naming.InvalidNameException;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.enums.Languages;
import com.zee.zee5app.exceptions.InvalidIdException;

public class ExceptionMain {
	
	 public static int methodA() throws FileNotFoundException {
	        throw new FileNotFoundException();
	    }
	    
	    public static int methodB() throws FileNotFoundException {
	        return methodA();
	        
	    }
	    public static void methodC() throws FileNotFoundException {
	        methodB();
//	    	System.out.println("kuuuu");
	    }
	
	
	public static void main (String[] args) {
		
		
		
		
		
		
		
		
		
		
		
		
//		try {
//            methodC();
//        } catch (FileNotFoundException e) {
//            // TODO Auto-generated catch block
//        	System.out.println(e.getMessage());
////            e.printStackTrace();
//        }
//        System.out.println("jhuj");
//		
//		
//		
//		String[] actors = {"a","b","c"};
//		String[] lan = {"al","bl","cl"};
//		
//		String[] actors = {"a","b","c"};
//        String[] lan ={Languages.KANNADA.name(),
//                Languages.TAMIL.name(),Languages.TELUGU.name(),
//                Languages.HINDI.name()
//                ,"c"};
		
		
//		try {
//			Movie movie = new Movie("kuldeep",actors,"movi","abc","","production",lan,2.2f);
//		} catch (InvalidNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidIdException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

}

//defined catch blocks are not matched then the exceptions will be handles by JVM
