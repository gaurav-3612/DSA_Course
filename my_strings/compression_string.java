package my_strings;

public class compression_string {
    public static void compression(String str){
        StringBuilder sb=new StringBuilder("");
        sb.append(str.charAt(0));
        int count =1;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==str.charAt(i-1)){
                count=count+1;
            }
            else{
                if(count>1){
                    sb.append(count);
                }
                sb.append(str.charAt(i));
                count=1;
            }
        } 
           // for printing the last count of d
            if(count>1){
                sb.append(count);
            }
            // we can alsso do it by another meathod where we will use two nested loops but still the time complexity will be o(n);


            // for(int i=0;i<str.length();i++){
            //     int count=1;
            //     sb.append(str.charAt(i));
            //     while(i<str.length()-1&&  str.charAt(i)==str.charAt(i+1)){
            //         count+=1;
            //         i++;
            //     }
            //     if(count>1){
            //         sb.append(count);
            //     }
            // }

            
        System.out.print(sb); 

    }
    public static void main (String args[]){
        String str="aaaabbbccdd";
        compression(str);
    }
}
