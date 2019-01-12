package biconsumerfunctionpredicater;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

/**
 * Consumer   - it accepts one parameter and does not return any value. method = accept(Object)
 * eg. List list = new ArrayList(); list.forEach(x -> System.out.println(x));
 * BiConsumer - it accepts 2 parameter does not return any value. method = accept(Object, Object) 
 * BiFunction - it accepts 2 parameter and return a value. method = apply(T t, U u)
 * BiPredicate - it accepts 2 parameter and return a Boolean value. method = test(Object, Object)
 */

public class BiConsumerFunctionPredicate {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Mintu");
		map.put(2, "Meg");
		map.put(3, "Aims");

		BiConsumer<Integer,String> biconsumer = (key, value) -> System.out.println("value is key=" + key + " value=" + value);
		map.forEach(biconsumer);
	
	   //BiFunction
		BiFunction<Integer,Integer,String> biFunction = (num1, num2) -> "Results: " + (num1 + num2);
	    System.out.println(biFunction.apply(3, 8));
	    
	    //BiPredicate
	    BiPredicate<Integer,String> biPredicate = (num, name) -> num>0 && name.startsWith("M");
	    System.out.println(biPredicate.test(1, "Mintu"));
	    System.out.println(biPredicate.test(1, "Meg"));
	    System.out.println(biPredicate.test(1, "Aims"));
	
	}


/**
 * Output
value is key=1 value=Mintu
value is key=2 value=Meg
value is key=3 value=Aims
Results: 11
true
true
false

 */
}


