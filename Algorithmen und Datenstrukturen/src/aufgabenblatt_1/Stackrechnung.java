package aufgabenblatt_1;
/**
 * Die Klasse Stackrechnung 
 * @author wobi2016
 *
 */
public class Stackrechnung {

	Stack<Integer> stack;

	public Stackrechnung(Stack<Integer> s) {
		this.stack = s;
	}

	public int berechnung(String str) {
		for (int i = 0; i < str.length(); i++) {
			int zeichen = (int) str.charAt(i);
			if ((zeichen > 39 && zeichen < 58 && (zeichen != 44 && zeichen != 46))) {
				if (zeichen == 41 && !stack.isEmpty()) {
					int operand1 = getoprand(stack);
					int operation = stack.pop();
					int operand2 = getoprand(stack);
					int dummy = stack.pop();
					switch (operation) {
					case 43:
						stack.push(addition(operand1, operand2) + 48);
						break;
					case 42:
						stack.push(multi(operand1, operand2) + 48);
						break;
					case 45:
						stack.push(sub(operand1, operand2) + 48);
						break;
					case 47:
						stack.push(div(operand1, operand2) + 48);
						break;
					}
				} else {
					stack.push(zeichen);
				}
			} else if (zeichen != 32) {
				throw new IllegalArgumentException("ungülitges Zeichen entdeckt");
			}
		}
		return (stack.pop() - 48);
	}

	public int getoprand(Stack<Integer> s) {
		int operand = s.pop() - 48;
		int multi = 10;
		while (s.top() >= 48 && s.top() <= 57) {
			operand += (s.pop() - 48) * multi;
			multi *= 10;
		}
		return operand;
	}

	public int addition(int a, int b) {
		return a + b;
	}

	public int multi(int a, int b) {
		return a * b;
	}

	public int sub(int a, int b) {
		return b - a;
	}

	public int div(int a, int b) {
		if (a == 0) {
			throw new IllegalArgumentException("durch 0 teilen nicht möglich");
		}
		return b / a;
	}

	public static void main(String[] args) {
		Stack<Integer> stack1 = new Stack<>();
		Stackrechnung stackrechnung = new Stackrechnung(stack1);
		System.out.println(stackrechnung.berechnung("((2*4) + (8-4))"));
		System.out.println(stackrechnung.berechnung("(((3-4) * (2-5)) +  (34 + 70))"));
		System.out.println(stackrechnung.berechnung("(((5+3) / (4-2)) +  (67 - 13))"));
		System.out.println(stackrechnung.berechnung("(((3-4) * (2-5)) +  (34 + 70))"));
		System.out.println(stackrechnung.berechnung("(((12 - 18) * (3 + 7)) -  (3 - 4))"));
	}

}
