import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        PostfixToInfix checking = new PostfixToInfix();

        try {
            BufferedReader in = new BufferedReader(new FileReader("postfix.in"));
            PrintWriter out = new PrintWriter("infix.out");

            for (String expression = in.readLine(); expression != null; expression = in.readLine()) {
                out.println(checking.toInfix(expression));
            }

            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
