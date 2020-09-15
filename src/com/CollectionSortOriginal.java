
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionSortOriginal {

    public static void main(String[] args) {
        String[] array = {"abc", "2", "10", "0"};
        List<String> list = Arrays.asList(array);
        Collections.sort(list);
        System.out.println(list);
        System.out.println(Arrays.toString(array)); //

        boolean isDivisibleBy5 = 0 % 5 == 0;
        System.out.println(isDivisibleBy5);

    }
}
/*
[0, 10, 2, abc]
[0, 10, 2, abc]
true
* */