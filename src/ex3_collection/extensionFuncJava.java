package ex3_collection;

import java.util.Arrays;
import java.util.List;

public class extensionFuncJava {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("shin", "kwang", "won");

        // 자바에서 코틀린에서 정의한 확장함수를 가져다 쓸때는 첫번째 인자로 수신객체 전달해야함 (여기서는 list)
        // 그리고 수신함수가 정의된 코틀린 소스파일명(extensionFunc.kt)이 클래스명(ExtensionFuncKt이 된다
        String result = ExtensionFuncKt.joinToString(list, "; ", "", "");
        System.out.println(result);
    }
}
