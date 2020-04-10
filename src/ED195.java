class ED195
{
	public static boolean balanced(String s) 
	{
		MyStack<Character> stack = new LinkedListStack<>();
		char ch;
		int curvo1 = 0;
		int curvo2 = 0;
		int reto1  = 0;
		int reto2  = 0;

		for (int i = 0; i < s.length(); i++) 
		{
			ch = s.charAt(i);
			
			switch(ch)
			{
				case '(':
					stack.push(ch);
					curvo1++;
					break;
				case '[':
					reto1++;
					stack.push(ch);
					break;
				case ')':
					curvo2++;
					if(!stack.isEmpty())
					{
						if(stack.top()!='(')
						{
							return false;
						}
						else stack.pop(); 
					}
					break;
					case ']':
					reto2++;
					if(!stack.isEmpty())
					{
						if(stack.top()!='[')
						{
							return false;
						}
						else stack.pop(); 
					}					
					break;
			}
		}
		if(curvo1!=curvo2 || reto1!=reto2 || !stack.isEmpty()) return false;
		return true;
	}

	public static void main(String[] args) 
	{
	
		System.out.println(balanced("([([([([([])])])])])"));
		System.out.println(balanced("([([([([([])])]))]])"));
		System.out.println(balanced(")))))))))"));
		System.out.println(balanced("()[](()]"));
		System.out.println(balanced("]]]]]]]]]"));
		System.out.println(balanced("[]()[][][]()((())[][][][][][][])"));
		System.out.println(balanced("(([][][][][[]])[]"));
		System.out.println(balanced("[]()[][][]()((())[][([([([([([])])])])])][][][][][])"));
	}
}