package aufgabenblatt_1;

public class Stackrechnung {

	Stack stack;

	public Stackrechnung(Stack s) {
		this.stack = s;
	}

	public void input(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) > 39 && str.charAt(i) < 48 && (str.charAt(i) != 44 || str.charAt(i) != 46)) {
				stack.push(str.charAt(i));
			} else {
				throw new IllegalArgumentException("ungülitges Zeichen entdeckt");
			}
		}
	}

	public void addition() {
		int operand1 = stack.pop();

	}

}
