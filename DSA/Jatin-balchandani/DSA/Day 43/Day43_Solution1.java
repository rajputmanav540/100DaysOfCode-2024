
    import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

    public class Day43_Solution1 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            for(int c =0; c<t; c++){
                int n = sc.nextInt();
                int m = sc.nextInt();
                List<Integer> a = new ArrayList<>();
                List<Integer> b = new ArrayList<>();
                long sumX = 0;
                long sumY = 0;
                for(int i=0; i<n; i++){
                    int x = sc.nextInt();
                    if(x ==0)
                        continue;
                    a.add(x);
                    sumX += x;
                }
                for(int i=0; i<m; i++){
                    int x = sc.nextInt();
                    if(x ==0)
                        continue;
                    b.add(x) ;
                    sumY += x;
                }
                boolean win = false;
                Collections.sort(a);
                Collections.sort(b);
                if(sumX != 0 && sumX != sumY){
                    win = true;
                } else {
                    while(sumX == sumY && !a.isEmpty() && !b.isEmpty()){
                        int x = a.remove(a.size()-1);
                        sumX -= x;
                        int y = b.remove(b.size() -1);
                        sumY -= y;
                        if(sumX != sumY) {
                            win = true;
                            break;
                        }
                    }
                }
                if(win) {
                    System.out.println("Alice");
                } else {
                    System.out.println("Bob");
                }
            }
        }
    }


