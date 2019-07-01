public class ReverseString {

    public static String reverse(String s){

        if(s.length() == 1)
            return s;
        else
            return reverse(s.substring(1))  + s.charAt(0);
    }



    public static void main(String args[]){

        String revString = reverse("reverse");
        System.out.println(revString);

    }
}
