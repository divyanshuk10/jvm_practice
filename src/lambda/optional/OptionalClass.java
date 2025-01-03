package lambda.optional;

import java.util.Optional;

public class OptionalClass {
    public static void main(String[] args) {

        String value = "Some Value";
        String optValue = null;
        Optional<String> emptyOptional = Optional.empty();
        Optional<String> ofOptional = Optional.of(value);
        Optional<String> ofNullableOptional = Optional.ofNullable(optValue);

        System.out.println(emptyOptional);
        System.out.println(ofOptional.get());
        System.out.println(ofNullableOptional.orElse(""));

        String data = " String contains spaces in the end ";

        if (data != null && data.contains("spaces")) {
            System.out.println(data);
        }

        Optional<String> optionalData = Optional.ofNullable(data);

        optionalData.ifPresent((it) -> System.out.println("data is available := " + data));
        optionalData.filter((it) -> it.contains("space")).map(String::trim).ifPresent(System.out::println);
    }
}
