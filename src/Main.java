import java.util.Scanner;
//深度优先搜索，只要符合就一直搜索下去，无解就回溯
public class Main {
    public static boolean left(char[][] ch,int x,int y,char nextchar){
        if (!(x-1>=0))return false;
        if(ch[x-1][y]==nextchar)
            return true;
        else return false;
    }
    public static boolean right(char[][] ch,int x,int y,char nextchar){
        if (!(x+1>=0))return false;
        if(ch[x+1][y]==nextchar)
            return true;
        else return false;
    }
    public static boolean up(char[][] ch,int x,int y,char nextchar){
        if (!(y+1>=0))return false;
        if(ch[x][y+1]==nextchar)
            return true;
        else return false;

    }
    public static boolean down(char[][] ch,int x,int y,char nextchar){
        if (!(y-1>=0))return false;
        if(ch[x][y-1]==nextchar)
            return true;
        else return false;
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int m=sc.nextInt();
        sc.nextLine();
        String str=sc.nextLine();
        String s[]=new String[n];
        char[][] ch=new char[n][m];
        for (int i = 0; i < n; i++) {
            s[i]=sc.nextLine();
            ch[i]=s[i].toCharArray();
        }
        int mx=0;
        int my=0;
        int count=0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if(left(ch,x,y,str.charAt(count))) {
                    mx=x;
                    x--;
                    count++;
                }
                if(right(ch,x,y,str.charAt(count))) {
                    mx=x;
                    x++;
                    count++;
                }
                if(up(ch,x,y,str.charAt(count))) {
                    my=y;
                    y--;
                    count++;
                }
                if(down(ch,x,y,str.charAt(count))) {
                    my=y;
                    y++;
                    count++;
                }
                else if (down(ch,x,y,str.charAt(count))){
                    y++;
                }
                if(s[i].charAt(j)==str.charAt(0)) {
                    System.out.println(i+" "+j);
                    return;
                }

            }
        }
        System.out.println("NO");
    }
}


/*public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        char[] ch=s.toCharArray();
        int count=0;
        int max=0;
        for (int i = 0; i < ch.length; i++) {
            for (int j = i; j < ch.length; j++) {
                if(ch[j]=='o')count++;
                int v=j-i;
                if(count%2==0){
                    if (v>max)
                        max=v;
                }
            }
        }
        System.out.println(max+1);
    }*/

/*public static boolean left(char[][] ch,int x,int y,char nextchar){
        if (!(x-1>=0))return false;
        if(ch[x-1][y]==nextchar)
            return true;
        else return false;
    }
    public static boolean right(char[][] ch,int x,int y,char nextchar){
        if (!(x+1>=0))return false;
        if(ch[x+1][y]==nextchar)
            return true;
        else return false;
    }
    public static boolean up(char[][] ch,int x,int y,char nextchar){
        if (!(y+1>=0))return false;
        if(ch[x][y+1]==nextchar)
            return true;
        else return false;

    }
    public static boolean down(char[][] ch,int x,int y,char nextchar){
        if (!(y-1>=0))return false;
        if(ch[x][y-1]==nextchar)
            return true;
        else return false;
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int m=sc.nextInt();
        sc.nextLine();
        String str=sc.nextLine();
        String s[]=new String[n];
        char[][] ch=new char[n][m];
        for (int i = 0; i < n; i++) {
            s[i]=sc.nextLine();
            ch[i]=s[i].toCharArray();
        }
        int mx=0;
        int my=0;
        int count=0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if(left(ch,x,y,str.charAt(count))) {
                    mx=x;
                    x--;
                    count++;
                }
                if(right(ch,x,y,str.charAt(count))) {
                    mx=x;
                    x++;
                    count++;
                }
                if(up(ch,x,y,str.charAt(count))) {
                    my=y;
                    y--;
                    count++;
                }
                if(down(ch,x,y,str.charAt(count))) {
                    my=y;
                    y++;
                    count++;
                }
                else if (down(ch,x,y,str.charAt(count))){
                    y++;
                }
                if(s[i].charAt(j)==str.charAt(0)) {
                    System.out.println(i+" "+j);
                    return;
                }

            }
        }
        System.out.println("NO");
    }
*/

/*public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        sc.nextLine();
        String str=sc.nextLine();
        String s[]=new String[n];
        char[][] ch=new char[n][m];
        for (int i = 0; i < n; i++) {
            s[i]=sc.nextLine();
            ch[i]=s[i].toCharArray();
        }
        int count=0;
        int flag[][][]=new int[str.length()][n][m];
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if(ch[j][k]==str.charAt(i))
                        flag[i][j][k]=1;
                }
            }
        }
        int beginx=0;
        int beginy=0;
        int i,j,k;
        for (i = 0; i < str.length(); i++) {
            for (j = 0; j < n; j++) {
                for (k = 0; k < m; k++) {
                    if(flag[i][j][k]==1){
                        beginx=j;
                        beginy=k;
                        if(j-1!=0) {
                            if (flag[i + 1][j - 1][k] == 1) {
                                i++;
                            }
                        }
                        if(j+1<n&&flag[i+1][j][k]==1){
                            i++;
                        }
                        if(k-1!=0&&flag[i+1][j][k]==1){
                            i++;
                        }
                        if(k+1<n&&flag[i+1][j][k]==1){
                            i++;
                        }else {
                            i=0;
                        }

                    }

                }
            }
            if(i==str.length()-1){
                System.out.println(beginx+" "+beginy);
                return;
            }
        }
        System.out.println("NO");
    }*/