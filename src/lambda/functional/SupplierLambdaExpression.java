package lambda.functional;

import java.time.LocalDateTime;
import java.util.function.Supplier;

public class SupplierLambdaExpression {
    public static void main(String[] args) {
        Supplier<String> lambdaSupplier = () -> "I supply strings ";

        Supplier<LocalDateTime> lambdaDateTimeSupplier = () -> LocalDateTime.now();

        System.out.println(lambdaSupplier.get());
        System.out.println(lambdaDateTimeSupplier.get());
    }
}
