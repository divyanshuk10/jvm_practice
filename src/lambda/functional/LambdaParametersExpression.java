package lambda.functional;

public class LambdaParametersExpression {
    public static void main(String[] args) {
        Addition adderTrad = new AdditionImpl();
        int sum = adderTrad.add(1, 6);
        System.out.println(sum);

        Addition adderLambda = (a, b) -> {
            return a + b;
        };
        System.out.println(adderLambda.add(1, 5));
    }
}

interface Addition {
    int add(int a, int b);
}

class AdditionImpl implements Addition {
    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
