package hr.fer.oop.lab1.prob2;

/**
 * @author Ljac
 */
public class Roots 
{
    static class cNum           //Kreiramo klasu kompleksnih brojeva.
    {
        private final double a, b;        //Ona sadrži x, y koordinate,
        private double D, angle;    //ili duljinu + kut
        
        private void Recalculate()  //Ovo izračunava duljinu i kut vektora.
        {
            D = Math.sqrt((a * a) + (b * b));
            angle = Math.atan(b / a);
        }
        
        public cNum[] CalcRoot(int n)       //Vraća sve n-te korijene ovog kompleksnog broja.
        {
            cNum[] toRet = new cNum[n];     //Prvo kreiramo neko polje kompleksnih brojeva veličine n.
            
            double Dn = Math.pow(D, (double)1/n);   //Duljina tih korijena je po Moivreovoj formuli n-ti korijen iz D.
            double angleStart = angle/n;            //Kut prvog korijea je kut originalnog broja / n.
            
            for(int i = 0; i < n; i++)              //Kako postoji n korijena, mi moramo iterirati kroz sve njih.
            {
                double nAngle = (2 * Math.PI) * i/n;    //Defiram kut pomaka ovdje umjesto direktnog računanja jer je brže.
                toRet[i] = new cNum(Dn * Math.cos(angleStart + nAngle), Dn * Math.sin(angleStart + nAngle));    //Na i-ti index polja kompleksnih brojeva instanciram (i+1). n-ti korijen.
            }
            
            return toRet;   //Na kraju vraćam polje kompleksnih brojeva.
        }
        
        public cNum(double a, double b)     //Konstruktor za kompleksni broj.
        {
            this.a = a;
            this.b = b;
            
            Recalculate();      //Nakon inicijalizacije vrijednosti računam kompleksni broj u polarnom obliku.
        }
        
        public double getA()    //getteri za realni i imaginarni dio
        {
            return this.a;
        }
        
        public double getB()
        {
            return this.b;
        }
        
        public double getLength()   //getteri za duljinu i kut
        {
            return D;
        }
        
        public double getAngle()
        {
            return angle;
        }
    }
    
    public static void main(String[] args)
    {
        if(args.length == 3)        //Računam samo ako imam 3 argumenta, u suprotnom je krivi unos.
        {
            cNum a = new cNum(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
            int n = Integer.parseInt(args[2]);
            
            System.out.printf("You requested calculation of %d. roots. Solutions are:\n", n);
            
            cNum[] nthRoot = a.CalcRoot(n);     //Ovdje bi teoretski mogli staviti double ali Moivreova formula radi na cijelim brojevima...
            
            for(int i = 0; i < nthRoot.length; i++)
                System.out.printf("%d) %.3f %.3fi\n", i + 1, nthRoot[i].getA(), nthRoot[i].getB());
        }
    }
}
