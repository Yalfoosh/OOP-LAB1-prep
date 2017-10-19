package hr.fer.oop.lab1.prob5;

/**
 * @author Ljac
 */
public class Shapes 
{
    public static String[] shape = {"+--------+",   //0
                                    "\\        /",  //1
                                    " \\______/ ",  //2
                                    "  ______  ",   //3
                                    " /      \\ ",  //4
                                    "/        \\",  //5
                                    "           "}; //6
    
    private final static int[] hourglass = {0, 1, 2, 3, 4, 5, 0};
    private final static int[] circle = {3, 4, 5, 1, 2};
    private final static int[] cup = {6, 1, 2, 0};
    private final static int[] hat = {3, 4, 5, 0};
    
    public static void PrintShape(int[] shapeMap)
    {
        for(int i : shapeMap)
            System.out.println(shape[i]);
    }
    
    public static void main(String[] args)
    {
        PrintShape(hourglass);
        PrintShape(circle);
        PrintShape(cup);
        PrintShape(hat);
    }
}