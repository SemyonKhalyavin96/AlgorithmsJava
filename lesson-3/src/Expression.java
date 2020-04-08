public class Expression {
    private String expression;

    public Expression(String str){
        expression = str;
    }

    public String revert(){
        Stack<Character> stack = new Stack<>(expression.length());
        char[] arr = expression.toCharArray();
        for(char c : arr){
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i ++){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
