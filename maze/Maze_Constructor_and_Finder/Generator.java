package Maze_Constructor_and_Finder;


public class Generator {
    public static StringBuffer[] blank_create(int n,int m,char block,char road){ //create blank map
        StringBuffer[] mp = new StringBuffer[n];
        for(int i=0;i<n;i++){
            mp[i] = new StringBuffer();
            for(int j=0;j<m;j++){
                mp[i].append(road);
            }
        }
        return mp;
    }

    public static StringBuffer[] prim_create(int n,int m,char block,char road){ //create blank map
        StringBuffer[] mp = new StringBuffer[n];
        for(int i=0;i<n;i++){
            mp[i] = new StringBuffer();
            for(int j=0;j<m;j++){
                if(i%2==1&&j%2==1){
                    mp[i].append(road);
                }
                else{
                    mp[i].append(block);
                }
            }
        }//首先建出0 1图
        
        return mp;
    }

}
