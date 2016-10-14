/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dmopc6;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jihua5758
 */
public class DMOPC6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int[]t=new int[n];
        int[][]r=new int[2][m];
        for(int i=0;i<n;i++){
            t[i]=in.nextInt();
        }
        for(int i=0;i<m;i++){
            r[0][i]=in.nextInt()-1;
            r[1][i]=in.nextInt()-1;
        }
        int q=in.nextInt();
        int[][]ck=new int[2][q];
        for(int i=0;i<q;i++){
            ck[0][i]=in.nextInt()-1;
            ck[1][i]=in.nextInt();
        }
        for(int i=0;i<q;i++){
            boolean[]c=new boolean[n];
            for(int j=0;j<n;j++){
                c[j]=true;//could be more efficient
            }
            ArrayList<int[]>st=new ArrayList();
            ArrayList<Integer>kr=new ArrayList();
            while(c[ck[0][i]]){
                boolean f=true;
                int p=ck[0][i];
                st.add(new int[2]);
                st.get(st.size()-1)[0]=0;
                st.get(st.size()-1)[1]=t[p];
                while(f){
                    for(int j=0;j<m;j++){
                        if(st.get(st.size()-1)[0]>=ck[1][i]){
                            f=false;
                            c[p]=false;
                            break;
                            
                        }
                        if(r[0][j]==p&&c[r[1][j]]){
                            p=r[1][j];
                            st.get(st.size()-1)[0]++;
                            if(st.get(st.size()-1)[1]>t[p]){
                                st.get(st.size()-1)[1]=t[p];
                            }
                            if(st.get(st.size()-1)[0]>=ck[1][i]){
                                f=false;
                                c[p]=false;
                            }
                            break;
                        }
                        if(j==m-1){
                            f=false;
                            c[p]=false;
                        }
                    }
                    
                }
                if(st.get(st.size()-1)[0]==ck[1][i]){
                    kr.add(p);
                }
            }
            int cr=st.get(0)[1];
            for(int j=1;j<st.size();j++){//check in while loop would be more efficient for large input data
                if(st.get(j)[1]<cr){
                    cr=st.get(j)[1];
                }
            }
            int mi=0;
            for(int j=0;j<kr.size()-1;j++){
                for(int k=j+1;k<kr.size();k++){
                    if(kr.get(j)==kr.get(k)){
                        mi++;
                    }
                }
            }
            System.out.println(cr+" "+(kr.size()-mi));
        }
    }
    
}
