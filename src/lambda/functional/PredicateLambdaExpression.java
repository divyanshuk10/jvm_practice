package lambda.functional;

import java.util.function.Predicate;

public class PredicateLambdaExpression {
    public static void main(String[] args) {

        Predicate<String> stringPredicate = (s) -> s.isEmpty();
        System.out.println(stringPredicate.test("Divyanshu"));
        System.out.println(stringPredicate.test(""));

        Predicate<String> stringPredicateUsingMethodRef = String::isEmpty;
        System.out.println(stringPredicateUsingMethodRef.test("Divyanshu"));
        System.out.println(stringPredicateUsingMethodRef.test(""));
    }
}
