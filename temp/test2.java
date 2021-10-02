package temp;
//import java.util.Scanner;
public class test2{
    public static void main(String[] args){
        char ch='*';
        for(int i=0;i<5;i++){

            for(int j=0;j<5-i;j++){

                System.out.print(' ');

            }

            for(int j=0;j<i*2+1;j++){

                System.out.print(ch);

            }

            System.out.print('\n');

        }



        for(int i=3;i>=0;i--){

            for(int j=0;j<5-i;j++){

                System.out.print(' ');

            }

            for(int j=0;j<i*2+1;j++){

                System.out.print(ch);

            }

            System.out.print('\n');

        }

    }

}