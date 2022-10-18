import java.util.Scanner;
import java.util.TreeMap;

public class demo {
    public static void main(String[] args) {
        TreeMap<Integer,String> map=new TreeMap<>();
        Scanner sc=new Scanner(System.in);
        int len= sc.nextInt();
        sc.nextLine();
        String[] s=new String[len];
        for (int i = 0; i < len; i++) {
            s[i]= sc.nextLine();
            char[] ch=s[i].toCharArray();
            int index=0;
            int m=0;
            for (int j = 0; j < ch.length; j++) {
                if(ch[j]=='M'){
                    int val;
                    if(index==j-1){
                        val =ch[index]-'0';
                    }else {
                        val = Integer.parseInt(s[i].substring(index, j));
                    }
                    index=j+1;
                    m+=val;
                }else if(ch[j]=='G'){
                    int val;
                    if(index==j-1){
                        val =(ch[index]-'0') * 1024;
                    }else {
                         val = Integer.parseInt(s[i].substring(index, j)) * 1024;
                    }
                    index=j+1;
                    m+=val;
                }else if(ch[j]=='T'){
                    int val;
                    if(index==j-1){
                        val =(ch[index]-'0') * 1024 * 1024;
                    }else {
                        val = Integer.parseInt(s[i].substring(index, j)) * 1024 * 1024;
                    }
                    index=j+1;
                    m+=val;
                }
            }
            map.put(m+i,s[i]);
        }

        for (Integer i:map.keySet()) {
            System.out.println(i+" "+map.get(i));
        }

    }
}
