package hr.fer.oop.lab1.prob3;

/**
 * @author Ljac
 */

public class PrimeNumbers 
{
    public static int[] buildPrimes(int n)
    {
        int[] toRet = new int[n];
        toRet[0] = 2;               //Prvi ćemo postaviti u 2.
        
        if(n > 1)                   //Ako imamo više od 1 broja, onda možemo definirati i sljedeći kao 3, radi jednostavnosti (1. -> 2. prosti broj je jedino mjesto gdje je prime gap neparan broj)
            toRet[1] = 3;
        else
            return toRet;           //U suprotnom, mi već imamo naše polje.
        
        for(int i = 2; i < n; i++)  //Krećemo od 2, jer to je prvi indeks koji je moguće nedefiniran.
        {
            for(int j = toRet[i - 1] + 2;; j+=2)    //Znamo da sljedeći prim broj može biti najmanje zadnji izračunati + 2.
            {                                       //Također znamo da će susjedni broj biti nužno kompozitan, pa se pomićemo za 2 ako j nije prim.
                if(isPrime(j))                     //Pozivamo metodu koja provjerava je li j prim broj.
                {
                    toRet[i] = j;
                    break;
                }
            }
        }
        
        return toRet;                               //Valja napomenuti da je ova funckija ranjiva na overflow, ali to ne mogu izbjeći bez malo više prčkanja. Ako je netko paranoičan, neka vraća long longove.
    }
    
    public static boolean isPrime(int x)
    {
        double limit = Math.sqrt(x);        //Trebamo gledati djeljivost do maksimano sqrt(j) - nakon toga nijedan broj ne može biti faktor od j.
                
        for(int k = 2; k < limit; k++)      //Počinjemo od 2, jer su svi brojevi djeljivi s 1.
        {
            if(x % k == 0)                  //Ako je ostatak pri dijeljenju 0, zo znači da je j djeljiv s k, pa j nužno nije prim.
                return false;
        }
        
        return true;                        //Ako dođemo do ovoga, naš broj je nužno prim.
    }
    
    public static void main(String[] arg)
    {
        if(arg.length > 0)
        {
            int n = Integer.parseInt(arg[0]);           //Kako ništa ne piše o prihvaćanju argumenata, pretpostavljam da dok god postoji 1. argument sve štima.
        
            if(n > 0)
            {
                int[] primes = buildPrimes(n);
            
                System.out.printf("You requested calculation of first %d prime numbers. Here they are:\n", n);
            
                for(int i = 0; i < n; i++)
                    System.out.printf("%d. %d\n", i + 1, primes[i]);
            }
        }
    }
}
