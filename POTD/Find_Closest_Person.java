public class Find_Closest_Person {
    public int findClosest(int x, int y, int z) {
        int p1=Math.abs(x-z);
        int p2=Math.abs(y-z);
         if(p1>p2){
            return 2;
         }
         else if(p1<p2){
            return 1;
         }
         return 0;        
    }
}
