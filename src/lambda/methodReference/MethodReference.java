package lambda.methodReference;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReference {
    public static void main(String[] args) {

        ///  Lambda expression of a static function
        Function<Integer, Double> function = (input) -> Math.sqrt(input);
        System.out.println(function.apply(4));

        /// 1  Converting the above expression to method reference of static function
        Function<Integer, Double> functionUsingMethodReference = Math::sqrt;
        System.out.println(functionUsingMethodReference.apply(8));

        ///  Lambda expression of a local function
        BiFunction<Integer, Integer, Integer> adder = ((it1, it2) -> addition(it1, it2));
        System.out.println(adder.apply(2, 4));

        /// 2  Converting the above expression to method reference of local function
        BiFunction<Integer, Integer, Integer> adderViaMethodRef = MethodReference::addition;
        System.out.println(adderViaMethodRef.apply(1, 2));

        ///  Lambda expression of a instance object
        MethodReference methodReference = new MethodReference();
        Printer printer = (it) -> methodReference.display(it);
        printer.print("Hello World");

        /// 3 Converting the above expression to method reference
        Printer printer1 = methodReference::display;
        printer1.print("Good Morning");


        ///  Lambda expression for an argument with method arguments
        Function<String, String> lambdaArgument = (it) -> it.toUpperCase();
        System.out.println(lambdaArgument.apply("divyanshu kumar"));

        /// 4 Converting the above expression to method reference
        Function<String, String> methodArgumentExp = String::toUpperCase;
        System.out.println(methodArgumentExp.apply("This is a string "));

        List<String> fruits = new ArrayList<>();
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Oranges");
        fruits.add("Guava");
        fruits.add("Banana");

        ///  Lambda expression to convert list to set
        Function<List<String>, HashSet<String>> setFunction = (list) -> new HashSet<>(list);
        System.out.println(setFunction.apply(fruits));

        /// 5 Converting above expression as method reference
        Function<List<String>, HashSet<String>> setFunctionMethodExp = HashSet::new;
        System.out.println(setFunctionMethodExp.apply(fruits));


    }

    public static int addition(int a, int b) {
        return a + b;
    }

    public void display(String message) {
        message = message.toUpperCase();
        System.out.println(message);
    }
}

@FunctionalInterface
interface Printer {
    void print(String message);
}


