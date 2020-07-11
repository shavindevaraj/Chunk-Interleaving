import java.util.*;
public class chunk1{
    static int p_size;
    static int d_size;
    static int m;
    static int n;
    static int a[][];
    static int b[][];
    static int c[][];
    //Actuall data divided into packets at sender
    static void data_sender(){
        m=d_size/p_size;
        n=1;
        a=new int[m][p_size];

        for(int i=0;i<m;i++){
            for(int j=0;j<p_size;j++){
                a[i][j]=n;
                n++;
            }
        }

        System.out.println();
        System.out.println("Packets creation at sender");
        for(int i=0;i<m;i++){
            System.out.print("Packet"+(i+1)+": ");
            for(int j=0;j<p_size;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    } 
    //Sending data column by column and creating packets
    static void data_sent_medium(){
        b=new int[p_size][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<p_size;j++){
                b[j][i]=a[i][j];
            }
        }

        System.out.println();
        System.out.println("Packets sent through medium");
        for(int i=0;i<p_size;i++){
            System.out.print("Packet"+(i+1)+": ");
            for(int j=0;j<m;j++){
                System.out.print(b[i][j]+" ");
            }
            System.out.println();
        }
    }
    //Data lost while transmission
    static void data_lost(){
        Random random=new Random();
        int k=random.nextInt(p_size);
        System.out.println();
        System.out.println("packet"+(k+1)+" was lost");
        for(int i=0;i<m;i++){
            b[k][i]=0;
        }
    }
    //Reamaining data recived at reciver
    static void data_recived_medium(){
        System.out.println();
        System.out.println("Packets recived from medium");
        for(int i=0;i<p_size;i++){
            System.out.print("Packet"+(i+1)+": ");
            for(int j=0;j<m;j++){
                if(b[i][j]==0){
                    System.out.print("  ");
                }
                else{
                System.out.print(b[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
    //Packets recreation at reciver and final data recived
    static void data_recived(){
        c=new int[m][p_size];
        for(int i=0;i<p_size;i++){
            for(int j=0;j<m;j++){
                c[j][i]=b[i][j];
            }
        }

        System.out.println();
        System.out.println("Packet recreation at reciver");
        for(int i=0;i<m;i++){
            System.out.print("Packet"+(i+1)+": ");
            for(int j=0;j<p_size;j++){
                if(c[i][j]==0){
                    System.out.print("X ");
                }
                else{
                System.out.print(c[i][j]+" ");
                }
            }
            System.out.println();
        }
    } 
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the chunk in each packet");
        p_size=in.nextInt();
        System.out.println("Enter the data size(multiples of "+p_size+")");
        d_size=in.nextInt();
        while(d_size%p_size!=0){
            System.out.println("Please enter the data size(multiples of "+p_size+")");
            d_size=in.nextInt();
        }
 
        data_sender();
        data_sent_medium();
        data_lost();
        data_recived_medium();
        data_recived();
    }
}
