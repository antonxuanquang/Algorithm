package behavioral.interpreter;

public class InterpreterPatternDemo {
	private static Expression getMaleExpression() {
		Expression robert = new TerminalExression("Roboert");
		Expression john = new TerminalExression("John");
		return new OrExpression(robert, john);
	}

	private static Expression getMarriedWomenExpression() {
		Expression julie = new TerminalExression("Julie");
		Expression married = new TerminalExression("Married");
		return new AndExpression(julie, married);
	}

	public static void main(String[] args) {
		Expression isMale = getMaleExpression();
		Expression isMarriedWoman = getMarriedWomenExpression();

		System.out.println("John is male? " + isMale.interpret("John"));
		System.out.println("Julie is a married women? "
				+ isMarriedWoman.interpret("Married Julie"));
	}
}
