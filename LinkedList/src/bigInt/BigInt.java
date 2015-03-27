package bigInt;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import linkedList.LinkedList;
import linkedList.Node;

public class BigInt implements Number {
	
	LinkedList number;
	boolean negative;
	File file;
	
	public BigInt(){}
	
	public BigInt(String s){
		number = new LinkedList("Number");
		for(int i = s.length() - 1; i >= 0; i--){
			char c = s.charAt(i);
			number.add("" + c);
			if(c == '-'){
				negative = true;
				number.delete("-");
			}
		}
	}
	
	public BigInt(File file){
		try{
			Scanner input = new Scanner(new FileReader(file)); 
			number = new LinkedList("Number");
			char c = ' ';
			boolean nonInt = false;
			while(input.hasNext()){
				String s = input.nextLine();
				if(s.charAt(0) == '-'){
					this.negative = true;
				}
				for(int i = s.length() - 1; i >= 0; i--){
					c = s.charAt(i);
					if(isInteger("" + c)){
						number.add("" + c);
					}else{
						nonInt = true;
					}
				}
			}
			if(nonInt){
				System.out.println("Your file contained non integer data, the abominations were eliminated and only the integers remain.");
			}
			input.close();
		}catch(java.io.FileNotFoundException e){
			System.out.println(e);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	@Override
	public BigInt add(BigInt b) {
		
		LinkedList t = this.number;
		LinkedList o = b.number;
		Node i = t.root;
		Node j = o.root;
		String result = "";
		int num;
		int carry = 0;
		
		BigInt answer = new BigInt();
		
		if(this.greaterThan(new BigInt("-1")) 
				&& (new BigInt("1")).absValueGreaterThan(this)
				&& b.greaterThan(new BigInt("-1")) 
				&& (new BigInt("1")).absValueGreaterThan(b)){
			return new BigInt("0");
		}
		
		//If the first is negative subtract the first from the second
		if(this.negative == true && b.negative == false){
			this.negative = false;
			BigInt temp = b.sub(this);
			this.negative = true;
			return temp;
		//If the second is negative subtract second from the first
		}else if(b.negative == true && this.negative == false){
			b.negative = false;
			BigInt temp = this.sub(b);
			b.negative = true;
			return temp;
		}else{
		//Otherwise both are same sign so add normally
			while(i != null || j != null){
				if(i != null && j != null){
					num = Integer.valueOf(i.getInfo()) + Integer.valueOf(j.getInfo());
				}else if(i == null){
					num = Integer.valueOf(j.getInfo());
				}else{
					num = Integer.valueOf(i.getInfo());
				}
				if(i != null){
					i = i.getLink();
				}
				if(j != null){
					j = j.getLink();
				}
				if(carry != 0){
					num += carry;
				}
				carry = 0;
				if(num > 9){
					carry = 1;
					num = num % 10;
				}
				result = num + result;
			}
			if(carry != 0){
				result = carry + result;
			}
			answer = new BigInt(result);
			if(this.negative && b.negative){
				answer.negative = true;
			}
			cleanUp(answer);
			return answer;
		}
	}
	
	public BigInt add(int n) {
		
		String s = String.valueOf(n);
		BigInt b = new BigInt(s);
		
		LinkedList t = this.number;
		LinkedList o = b.number;
		Node i = t.root;
		Node j = o.root;
		String result = "";
		int num;
		int carry = 0;
		
		BigInt answer = new BigInt();
		
		if(this.negative == true && b.negative == false){
			this.negative = false;
			BigInt temp = b.sub(this);
			this.negative = true;
			return temp;
		}else if(b.negative == true && this.negative == false){
			b.negative = false;
			BigInt temp = this.sub(b);
			b.negative = true;
			return temp;
		}else{
			
			while(i != null || j != null){
				if(i != null && j != null){
					num = Integer.valueOf(i.getInfo()) + Integer.valueOf(j.getInfo());
				}else if(i == null){
					num = Integer.valueOf(j.getInfo());
				}else{
					num = Integer.valueOf(i.getInfo());
				}
				if(i != null){
					i = i.getLink();
				}
				if(j != null){
					j = j.getLink();
				}
				if(carry != 0){
					num += carry;
				}
				carry = 0;
				if(num > 9){
					carry = 1;
					num = num % 10;
				}
				result = num + result;
			}
			if(carry != 0){
				result = carry + result;
			}
			answer = new BigInt(result);
			if(this.negative && b.negative){
				answer.negative = true;
			}
			
			cleanUp(answer);
			return answer;
		}
	}

	@Override
	public BigInt sub(BigInt b) {
		
		//It the first is positive and second is negative add them as two positive numbers (always will be positive)
		
		if(this.negative == false && b.negative == true){
			b.negative = false;
			BigInt temp = this.add(b);
			b.negative = true;
			return temp;
			
		//It the first is negative and second is positive add them as two negative numbers (always will be negative)
			
		}else if(this.negative == true && b.negative == false){
			b.negative = true;
			BigInt temp = this.add(b);
			b.negative = false;
			return temp;
			
		//If both are positive or negative then subtract normally
			
		}else{
			BigInt answer = new BigInt();
			
			LinkedList t = this.number;
			LinkedList o = b.number;
			
			Node i;
			Node j;
			
		//get the larger absolute value on top (i) and carry the larger number's sign
			boolean isNegative = false;
			if(this.absValueGreaterThan(b)){
				i = t.root;
				j = o.root;
				isNegative = this.negative;
			}else if(b.absValueGreaterThan(this)){
				j = t.root;
				i = o.root;
				isNegative = !b.negative;
				
		//If the absolute value of both numbers is equal just return zero
				
			}else{
				return new BigInt("0");
			}
			
		//The actual subtracting
			
			int num = 0;
			int carry = 0;
			String result = "";
			while(i != null || j != null){	
				
				
				if(i != null && j != null){
			
			//if the top number is bigger, subtract normally and subtract any carry from last subtraction
					if(Integer.valueOf(i.getInfo()) >= Integer.valueOf(j.getInfo())){
						num = Integer.valueOf(i.getInfo()) - Integer.valueOf(j.getInfo()) - carry;
					
						carry = 0;
					
			//if bottom number is bigger, add 10 to the top and add to the carry
					}else{
						int temp = Integer.valueOf(i.getInfo()) + 10;
						num = temp - Integer.valueOf(j.getInfo()) - carry;
				
						carry = 1;
					}
			//when j runs out of digits
				}else if(i != null && carry != 0){
					
					num = Integer.valueOf(i.getInfo()) - carry;
					carry = 0;
					if(num == 0 && i.getLink() == null){
						answer = new BigInt(result);
						
						return answer;
					}
					
				}else{
					num = Integer.valueOf(i.getInfo());
				}
				
				
			//move nodes up
				if(i != null){
					i = i.getLink();
				}
				if(j != null){
					j = j.getLink();
				}
				
				result = num + result;
			}
			answer = new BigInt(result);
			answer.negative = isNegative;
			
			
			cleanUp(answer);
			return answer;
		}
	}

	@Override
	public BigInt multiply(BigInt b) {
		
		LinkedList t = this.number;
		LinkedList o = b.number;
		
		Node i = t.root;
		Node j = o.root;
		
		if((!this.greaterThan(new BigInt("0")) && this.greaterThan(new BigInt("-1"))) 
			|| (!b.greaterThan(new BigInt("0")) && b.greaterThan(new BigInt("-1")))){
			
			return new BigInt("0");
		}
		
		BigInt ans = new BigInt("0");
		BigInt tempAns = new BigInt("0");
		
		int num = 0;
		int carry = 0;
		
		
		int count = 1;
		
		while(i != null){
			while(j != null){
				
				num = Integer.valueOf(j.getInfo()) * Integer.valueOf(i.getInfo());
				
				if(carry > 0){
					num += carry;
					carry = 0;
				}
				
				if(num >= 10){
					carry = num / 10;
					num = num % 10;
				}
				
				
				tempAns.number.add("" + num);
				
				
				j = j.getLink();
			}
			
			if(carry > 0){
				tempAns.number.add("" + carry);
				carry = 0;
			}
			
			tempAns.number.delete();		
			
			ans = tempAns.add(ans);
			
			tempAns = new BigInt("0");
			
			for(int a = count; a > 0; a--){
				tempAns.number.add("0");
			}
			
			count++;
			
					
			i = i.getLink();
			j = o.root;
		}
		
		if(this.negative == true ^ b.negative == true){
			ans.negative = true;
		}
		cleanUp(ans);
		return ans;
	}
/*
	@Override
	public BigInt divide(BigInt b) {
		if(!b.greaterThan(new BigInt("0")) && b.greaterThan(new BigInt("-1"))){
			try{
				int i = 1/0;
				i = i+0;
				return null;
			}catch(ArithmeticException e){
				System.out.println("Can't divide by 0");
				return null;
			}
		}else{
		
			if(!this.greaterThan(new BigInt("0")) && this.greaterThan(new BigInt("-1"))){
					
				return new BigInt("0");
			}
			
			final BigInt ONE = new BigInt("1");
			BigInt ans = new BigInt("0");
			BigInt i = new BigInt("-1");
			
			while(this.absValueGreaterThan(ans)){
				
				i = i.add(ONE);
				ans = b.multiply(i);
				ans.negative = false;
			
			}
			
			i = i.sub(ONE);
			
			if(this.negative == true ^ b.negative == true){
				i.negative = true;
			}
			cleanUp(i);
			return i;
		}
	}
	*/
	public BigInt divide(BigInt b){
		if(!b.greaterThan(new BigInt("0")) && b.greaterThan(new BigInt("-1"))){
			try{
				int i = 1/0;
				i = i+0;
				return null;
			}catch(ArithmeticException e){
				System.out.println("Can't divide by 0");
				return null;
			}
		}else{
			LinkedList t = this.number;
			LinkedList o = b.number;
			
			Node i = t.root;
			Node j = o.root;
			
			BigInt answer = new BigInt();
			
			int count = Integer.valueOf(t.size() - 1);
			int multiplier = 1;
			
			BigInt curInc = new BigInt("1");
			BigInt curNum = new BigInt();
			BigInt remainder = new BigInt();
			
			while(count >= 0){
				count--;
				
				//get the most significant digit
				for(int in = count; in > 0; in--){
					i = i.getLink();
				}
				if(remainder != null && Integer.valueOf(remainder) != 0){
					curNum = curNum.add(remainder);
					
				}
				curNum = new BigInt(i.getInfo());
				
				//multiply by incrementing larger numbers to find highest divisor
				while(curNum.greaterThan(curInc)){
					multiplier++;
					curInc = b.multiply(new BigInt("" + multiplier));
				}
				
				answer.add(new BigInt("" + multiplier));
				
				//subtract the highest multiple from the b number
				remainder = curNum.sub(curInc);
				
				
			}
			return answer;
		}
	}
	
	
	@Override
	public boolean greaterThan(BigInt b){
		
		if((this.number.size() > b.number.size()) || 
				(this.negative == false && b.negative == true)){
			return true;
		}else if(b.number.size() > this.number.size() ||
				(this.negative == true && b.negative == false)){
			return false;
		}else{
			LinkedList t = this.number;
			LinkedList o = b.number;
			Node i = t.root;
			Node j = o.root;
			int count = t.size();
			
			while(count > 0){
				i = t.root;
				j = o.root;
				for(int c = count - 1; c > 0; c--){
					i = i.getLink();
					j = j.getLink();
				}
				if(Integer.valueOf(i.getInfo()) > Integer.valueOf(j.getInfo())){
					return true;
				}else if(Integer.valueOf(i.getInfo()) < Integer.valueOf(j.getInfo())){
					return false;
				}
				count--;
			}
		}
		return false;
	}
	
	public boolean absValueGreaterThan(BigInt b){
		
		if((this.number.size() > b.number.size()) ){
			return true;
		}else if(b.number.size() > this.number.size() ){
			return false;
		}else{
			LinkedList t = this.number;
			LinkedList o = b.number;
			Node i = t.root;
			Node j = o.root;
			int count = t.size();
			
			while(count > 0){
				i = t.root;
				j = o.root;
				for(int c = count - 1; c > 0; c--){
					i = i.getLink();
					j = j.getLink();
				}
				if(Integer.valueOf(i.getInfo()) > Integer.valueOf(j.getInfo())){
					return true;
				}else if(Integer.valueOf(i.getInfo()) < Integer.valueOf(j.getInfo())){
					return false;
				}
				count--;
			}
		}
		return false;
	}
	
	public boolean isInteger( String input ) {
	    try {
	        Integer.parseInt( input );
	        return true;
	    }
	    catch( Exception e ) {
	        return false;
	    }
	}
	
	public void cleanUp(BigInt b){
		LinkedList t = b.number;
		Node pointer = t.root;
		boolean again = true;
		while(again){
			again = false;
			pointer = t.root;
			for(int i = t.size() - 1; i >= 1; i--){
				pointer = pointer.getLink();
			}
			if(pointer.getInfo().equalsIgnoreCase("0")){
				t.delete(t.size() - 1);
				again = true;
			}
			
		}
	}
	
	@Override
	public String toString(){
		Node pointer = number.root;
		String s = "";
		int count = 0;
		while(pointer != null ){
			if(count % 3 == 0
					&& count != 0){
				s = "," + s;
			}
			count++;
			s = pointer.getInfo() + s;
			pointer = pointer.getLink();
		}
		if(this.negative){
			s = "-" + s;
		}
		
		return s;
	}
	
}
