package bigInt;

import java.io.File;

@SuppressWarnings("unused")
public class TestBigInt {

	public static void main(String[] args) {
		
		//addition test
		
		/*
		BigInt a = new BigInt("-1234567890");
		System.out.println(a);
		System.out.println(a.negative);
		
		
		BigInt b = new BigInt("999");
		BigInt c = new BigInt("99");
		System.out.println(b.add(c));
		
		BigInt d = new BigInt("24");
		BigInt e = new BigInt("22");
		System.out.println(d.add(e));
		
		BigInt f = new BigInt("548");
		BigInt g = new BigInt("-549");
		System.out.println(f.add(g));
		*/
		
		//Greater than test
		
		/*
		System.out.println(a.greaterThan(b));
		System.out.println(b.greaterThan(c));
		System.out.println(d.greaterThan(e));
		System.out.println(f.greaterThan(g));
		System.out.println(f.absValueGreaterThan(g));
		*/
		
		//File test
		
		/*
		File file = new File("E:\\DataStructures\\LinkedList\\src\\bigInt\\number.txt");
		BigInt fromFile = new BigInt(file);
		System.out.println(fromFile);
		
		File file1 = new File("E:\\DataStructures\\LinkedList\\src\\bigInt\\number2.txt");
		BigInt fromFile1 = new BigInt(file1);
		System.out.println(fromFile1);
		
		File file2 = new File("E:\\DataStructures\\LinkedList\\src\\bigInt\\negative.txt");
		BigInt fromFile2 = new BigInt(file2);
		System.out.println(fromFile2);
		
		File file3 = new File("E:\\DataStructures\\LinkedList\\src\\bigInt\\negative2.txt");
		BigInt fromFile3 = new BigInt(file3);
		System.out.println(fromFile3);
		
		*/
		
		//Test subtract
		
		/*
		BigInt h = new BigInt("-1111111");
		BigInt i = new BigInt("222");
		System.out.println(h.subtract(i));
		
		BigInt j = new BigInt("1111111");
		BigInt k = new BigInt("-222");
		System.out.println(j.subtract(k));
		
		BigInt l = new BigInt("-5192");
		BigInt m = new BigInt("2389765");
		System.out.println(l.subtract(m));
		*/
		
		//Test multiply 
		
		/*
		BigInt n = new BigInt("23463");
		BigInt o = new BigInt("563");
		System.out.println(o.multiply(n));
		
		BigInt p = new BigInt("-34535");
		BigInt q = new BigInt("4545563");
		System.out.println(p.multiply(q));
		
		BigInt r = new BigInt("-43623463");
		BigInt s = new BigInt("-543563");
		System.out.println(r.multiply(s));
		
		BigInt x = new BigInt("-43623463");
		BigInt y = new BigInt("0");
		System.out.println("the 0 case");
		System.out.println(x.multiply(y));
		
		BigInt l = new BigInt("34642623");
		BigInt m = new BigInt("2389765");
		System.out.println(l.multiply(m));
		*/
		
		//Test divide
		
		
		BigInt p = new BigInt("-34535");
		BigInt q = new BigInt("4545563");
		System.out.println(p.divide(q));
		
		BigInt n = new BigInt("23463");
		BigInt o = new BigInt("-563");
		System.out.println(n.divide(o));
		
		BigInt r = new BigInt("-43623463");
		BigInt s = new BigInt("-543563");
		System.out.println(r.divide(s));
		
		BigInt x = new BigInt("-43623463");
		BigInt y = new BigInt("0");
		System.out.println(x.divide(y));
		
		
		BigInt a = new BigInt("0");
		BigInt b = new BigInt("0");
		System.out.println(a.add(b));
		
	}
}
