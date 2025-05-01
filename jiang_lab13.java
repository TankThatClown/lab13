package lab13;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class jiang_lab13
{
     ArrayList <Integer> arr;
   public jiang_lab13(){
    arr=new ArrayList<>();
   }
    public  void readData(String fileName){
         try {
                BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
               String line;
                while((line= input.readLine())!=null){
                    StringTokenizer s = new StringTokenizer(line,"\t");
                    while(s.hasMoreTokens()){
                        arr.add(Integer.parseInt(s.nextToken()));
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
                System.exit(0);
            }
    }

    public long getTotalCount(){
        return arr.stream().count();
    }
    public long getOddCount(){
        return arr.stream().filter(n->n%2==1).count();
    }
    public long getEvenCount(){
        return arr.stream().filter(n->n%2==0).count();
    }
    public long getDistinctGreaterThanFiveCount(){
        return arr.stream().filter(n->n>5).distinct().count();
    }
    public Integer[] getResult1(){
        return arr.stream().filter(n->n%2==0&&n>5&&n<50).sorted().toArray(Integer[]::new);
    }

    public Integer[] getResult2(){
        return arr.stream().map(n->n*n*3).limit(50).toArray(Integer[]::new);
    }
    public Integer[] getResult3(){
        return arr.stream().filter(n->n%2==1).map(n->n*2).sorted().skip(20).distinct().toArray(Integer[]::new);
    }
}