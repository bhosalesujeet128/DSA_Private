
public class strings {

    public static boolean Ispalindrome(String example){
        for(int i = 0; i<example.length()/2; i++){
            int n = example.length()-1;
            if (example.charAt(i) != example.charAt(n-i)) {
                return false;
            }
        }
        return true;
    }

    public static void Shortest_path(String sp){
        int x=0, y=0;
        for(int i=0; i<sp.length(); i++){
            if (sp.charAt(i) == 'N') {
                x++;
            }
            else if (sp.charAt(i) == 'S') {
                x--;
            }
            else if (sp.charAt(i) == 'E') {
                y++;
            }else if (sp.charAt(i) == 'W') {
                y--;
            }
        }
        int dist = (int)Math.pow(x, 2) + (int)Math.pow(y, 2);
        System.out.println("shortest path is: " + Math.sqrt(dist));
        
    }
    public static void Largest_String(String fruit[]){
        String largest = fruit[0];
        for(int i=1; i<fruit.length; i++){
            if (largest.compareTo(fruit[i]) < 0 ) {
                largest = fruit[i];
            }
        }
        System.out.println(largest);
    }

    public static String toUpperCase(String str){
        StringBuilder sb = new StringBuilder("");

        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for (int i = 1; i<str.length(); i++){
            if (str.charAt(i) == ' ' && i<str.length()-1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else{{
                sb.append(str.charAt(i));
            }}
        }
        return sb.toString();
    }

    public static String Compress(String str){
        String newStr ="";

        for( int i=0; i<str.length(); i++){
            Integer count = 1 ;
            while (i<str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
                count ++;
                i++;
            }
            newStr += str.charAt(i);
            if (count > 1) {
                newStr += count.toString();
            }
        }
        return newStr;
    }
    public static void main(String[] args) {
        // String example = "racecar";        
        // System.out.println(Ispalindrome(example));

        String sp = "WNEENESENNN";
        Shortest_path(sp);

        // String fruit[]= {"apple","applf" };
        // Largest_String(fruit);
        
        // String str = "hi, i am sujeet";
        // System.out.println(toUpperCase(str));

        // String str = "aaabbcccdd"; // a3b2c3d2
        // System.out.println(Compress(str));

    }
}