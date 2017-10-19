package hr.fer.oop.lab1.prob1;

import java.util.Scanner;   //Treba nam za čitanje

/**
 * @author Ljac
 */
public class Rectangle 
{
    static String[] strColl = new String[] {/*0*/  "The input must not be blank. ",                                     //Definirat ću polje stringova s porukama. 1 alokacija == efikasnije
                                            /*1*/  "Invalid number of arguments was provided. ",
                                            /*2*/  "Please provide width: ",
                                            /*3*/  "The width must not be negative. ",
                                            /*4*/  "Please provide height: ",
                                            /*5*/  "The height must not be negative. ",
                                            /*6*/  "You have specified a rectangle of width %.1f and height %.1f. Its area is %.1f and its perimeter is %.1f."};
    
    /**
     * @param a Width of the rectangle
     * @param b Height of the rectangle
     */
    public static void printRes(float a, float b)   //Printa površinu i opseg pravokutnika.
    {
        System.out.printf(strColl[6] + "\n", a, b, a * b, ((a == 0 || b == 0) ? 1 : 2) * (a + b));   //Ako je jedna od dimenzija 0, onda stranice druge dimenzije postaju jedna stranica, pa je opseg dvostruko manji.
    }
    
    /**
     *
     * @param args
     */
    public static void main(String[] args)
    {
        float a = -1, b = -1;                       //Inicijalno stavljam a i b u -1 jer je to ionako zabranjeno stanje
        Scanner in = new Scanner(System.in);
        
        switch(args.length)
        {
            case 0:
                String sIn;
                
                do
                {
                    System.out.print(strColl[2]);
                    
                    sIn = (in.nextLine()).trim();
                    
                    if(sIn.isEmpty())
                        System.out.println(strColl[0]);
                    else
                    {
                        a = Float.parseFloat(sIn);
                        
                        if(a < 0)
                        System.out.println(strColl[3]);
                    }
                }
                while(a < 0);
                
                do
                {
                    System.out.print(strColl[4]);
                    
                    sIn = (in.nextLine()).trim();
                    
                    if(sIn.isEmpty())
                        System.out.println(strColl[0]);
                    else
                    {
                        b = Float.parseFloat(sIn);
                        
                        if(b < 0)
                        System.out.println(strColl[5]);
                    }
                }
                while(b < 0);
                
                printRes(a, b);
                break;
                
            case 2:
                a = Float.parseFloat(args[0]);
                b = Float.parseFloat(args[1]);
                
                printRes(a, b);
                break;
                
            default:
                System.out.println(strColl[1]);
                break;
        }
    }
}