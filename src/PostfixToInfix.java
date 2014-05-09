import java.util.Stack;

public class PostfixToInfix {
    private String expression(String secondArg, String firstArg, String exp) {
        return firstArg + exp + secondArg;
    }

    private String brackets(String arg, Boolean mod) {
        if (mod) {
            return "(" + arg + ")";
        }
        return arg;
    }

    public String toInfix(String polish) {
        String[] split = polish.split("\\s+");
        Stack<String> stack = new Stack<>();
        Stack<Boolean> mod = new Stack<>();

        for (String iter : split) {
            switch (iter) {
                case "+":
                    mod.pop();
                    mod.pop();
                    stack.push(expression(stack.pop(), stack.pop(), iter));
                    mod.push(true);
                    break;
                case "-":
                    stack.push(expression(brackets(stack.pop(), mod.pop()), stack.pop(), iter));
                    mod.pop();
                    mod.push(true);
                    break;
                case "*":
                    stack.push(expression(brackets(stack.pop(), mod.pop()), brackets(stack.pop(), mod.pop()), iter));
                    mod.push(false);
                    break;
                default:
                    stack.push(iter);
                    mod.push(false);
                    break;
            }
        }

        return stack.pop();
    }
}
