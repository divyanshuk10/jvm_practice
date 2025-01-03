package lambda.functional;

import java.util.function.Function;

public class FunctionalLambdaExpression {
    public static void main(String[] args) {
        Function<String, Integer> obj = new FunctionImpl();
        int length = obj.apply("Divyanshu");
        System.out.println(length);

        Function<String, Integer> funLambda = (s) -> s.length();
        System.out.println(funLambda.apply("Divyanshu"));
    }
}

class FunctionImpl implements Function<String, Integer> {

    @Override
    public Integer apply(String s) {
        return s.length();
    }
}



