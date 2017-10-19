package hr.fer.oop.lab1.prob4;

import hr.fer.oop.lab1.prob3.PrimeNumbers;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Ljac
 */

public class PrimeFactorization 
{
    public static void main(String[] args)
    {
        if(args.length > 0 && Integer.parseInt(args[0]) > 1)
        {
            int n = Integer.parseInt(args[0]);  //n će biti naš argument
            
            if(PrimeNumbers.isPrime(n))         //Uzimamo funkciju iz prošlog zadatka, provjeravamo je li n već prim broj.
                System.out.printf("Number %d is already prime.\n", n);
            else                                //Ako nije, onda ćemo ga moći faktorizirati.
            {
                int limit = (int)Math.floor(Math.sqrt(n));  //Moramo castati Math.floor jer on vraća double.
            
                List<Integer> primes = new ArrayList<>();   //Stvaramo praznu listu prim brojeva brojeva.
                primes.add(2); primes.add(3);               //Dodajemo im 2 i 3 kao specijalne slučajeve.
            
                List<Integer> factors = new ArrayList<>();  //Stvaramo drugu listu cijelih brojeva u koju ćemo pospremiti faktore. Mogli smo ovo i sa poljima.
            
                for(int i = 5; i < limit; i += 2)           //Prvo trebamo popisati sve moguće prim faktore broja.
                    if(PrimeNumbers.isPrime(i))
                        primes.add(i);
            
                System.out.printf("You requested decomposition of number %d into prime factors. Here they are:\n", n);
                
                while(n > 1)                    //Prolazeći kroz prim brojeve dijelit ćemo one s kojima je n djeljiv. Na taj način ćemo smanjivati n sve dok ne dođe do 1, koji je trivijalan faktor svakog broja.
                {
                    for(int i : primes)         //Prolazimo kroz sve prim brojeve
                        if(n % i == 0)
                        {
                            n /= i;
                            factors.add(i);     //Dodajemo nađeni prim faktor u listu faktora. Ona uglavnom neće biti sortirana,
                        }
                }
                
                Collections.sort(factors);      //pa ćemo ju na kraju sortirati.
                
                for(int i = 0; i < factors.size(); i++)
                    System.out.printf("%d. %d\n", i + 1, factors.get(i));
            }
        }
    }
}