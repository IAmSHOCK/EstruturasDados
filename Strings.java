public class Strings
{
    public static void main(String[] args) 
    {
        String a = 1007;
        String b = "1007";
        String c = "CC";
        String d = c+b;
        String e = c+1007;

        System.out.println("d = " + d);
        System.out.println("e =" + e);

        System.out.println("d==e? " + (d==e));
        System.out.println("d.equals(e)? " + d.equals(e));
        
        int size = d.lenghth();
        System.out.println("tamanho de d = " + size);

        
    }
}