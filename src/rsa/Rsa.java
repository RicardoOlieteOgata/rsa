/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa;

/**
 *
 * @author Ricardo
 */
public class Rsa {
    

    /**
     * @param args the command line arguments
     */
    public static int part1(int a , int b, int c){
        //System.out.println("a*b = " + a*b);
        //System.out.println("c = " + c);
        //System.out.println("b = " + b);
        
        if (a*b < c)
            return a*b;
        else {
            int temp = a*b/c;
            int temp2 = temp * c;
//            System.out.println("temp = " + temp);
            return a*b - temp2; 
        }   
    }
    
    public static int mdc(int a,int b)
    {
        if(b == 0) 
            return a;
        else
            return mdc(b, a % b);
    }
    
    public static int mod(int a, int b){
        int r = a % b;
        /* Uma correçã é necessária se r e b não forem do mesmo sinal */
        
        /* se r for negativo e b positivo, precisa corrigir */
        if ((r < 0) && (b > 0))
            return (b + r);

        /* Se ra for positivo e b negativo, nova correcao */
        if ((r > 0) && (b < 0))
            return (b + r);

        return (r);
}
 
public static int euclides_ext(int a, int b, int c)
{
    int r;
 
    r = mod(b, a);
 
    if (r == 0) {
        return (mod((c / a), (b / a)));   // retorna (c/a) % (b/a)
    }
 
    return ((euclides_ext(r, a, -c) * b + c) / (mod(a, b)));
}

public static int criptarDescriptar (int mensagem, int expoente, int n){    
    int temp = mensagem;
    for (int i = 1 ; i < expoente ; i++)
        temp = part1(mensagem, temp, n);  
    return temp;
}
    public static void main(String[] args) {
        int p = 107;
        int q = 109;
        int n = p*q;
        int qq = (p-1) * (q-1);
        int e= 2;
        while (mdc(qq,e) != 1 || e < 1009)
            e++;     
       // e = 7;
        int d = euclides_ext(e, qq, 1);
        int original = 1234;   
//        for (original = 0; original <= 9999; original++) {            
            
        System.out.println("p = " + p);
        System.out.println("q = " + q);
        System.out.println("n = " + n);
        System.out.println("qq = " + qq);
        System.out.println("e = " + e);
        System.out.println("d = " + d);        

        System.out.println("original = " + original);
        int cifrada = criptarDescriptar(original, e, n);  
        System.out.println("cifrada = " + cifrada);  

        if (original != criptarDescriptar(cifrada, d, n))
            System.out.println("ERRO = " + original);
        }
//    }
}
