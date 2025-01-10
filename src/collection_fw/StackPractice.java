package collection_fw;


import java.util.Stack;

public class StackPractice {
    public static void main(String[] args) {
        /// Based on the principle of LIFO
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);

        // Check the top most element
        System.out.println(st.peek());

        // remove the top most element
        System.out.println(st.pop());

        // Check the top most element
        System.out.println(st.peek());

        System.out.println(st);


    }
}
