package tba2;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author Wata
 */
public class TBA2 {

    public static void main(String[] args) {
        Cek cek = new Cek();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        input = input + " ";
        char[] arrInput = input.toCharArray();
        ArrayList<String> token = new ArrayList();
        Stack<String> stack = new Stack();
        int i = 0;
        int count = 0;
        boolean status = true;
        char node = 'Z';
        while (i < arrInput.length && node != 'X'){
            while (node != 'X'){
                switch(node){
                    case 'Z' :
                        if (i<arrInput.length){
                            if(cek.Kabagikur(arrInput[i])){
                                node = 'G';
                                i++;
                            }else if (cek.Tanda(arrInput[i])){
                                node = 'A';
                                i++;
                            }else if (cek.Num(arrInput[i])){
                                node = 'B';
                                i++;
                            }else if (cek.Spasi(arrInput[i])){
                                node = 'Z';
                                i++;
                            }
                            else{
                                node = 'X';
                                token.add("err");
                                status = false;
                            }
                        }else{
                            node = 'X';
                        }
                        break;
                    case 'A' :
                        if (i<arrInput.length){
                            if (cek.Num(arrInput[i])){
                                node = 'B';
                                i++;
                            }else if(cek.Spasi(arrInput[i])){
                                node = 'Z';
                                token.add("opr");
                                i++;
                            }else{
                                    node = 'X';
                                    token.add("err");
                                    status = false;
                                }
                            break;
                        }else{
                            node = 'X';
                        }
                    case 'B':
                        if (i<arrInput.length){
                            if (cek.Num(arrInput[i])){
                                node = 'B';
                                i++;
                            }else if (cek.Koma(arrInput[i])){
                                node = 'C';
                                i++;
                            }else if (cek.E(arrInput[i])){
                                node = 'D';
                                i++;
                            }else if (cek.Spasi(arrInput[i])){
                                node = 'Z';
                                token.add("num");
                                i++;
                            }else{
                                node = 'X';
                                token.add("err");
                                status = false;
                            }
                        }else{
                            node = 'X';
                            token.add("err");
                        }
                        break;
                    case 'C' :
                        if (i<arrInput.length){
                            if (cek.Num(arrInput[i])){
                                node = 'C';
                                i++;
                            }else if (cek.Spasi(arrInput[i])){
                                node = 'Z';
                                token.add("num");
                                i++;
                            }else{
                                node = 'X';
                                token.add("err");
                                status = false;
                            }
                        }else{
                            node = 'X';
                            token.add("num");
                        }
                        break;    
                    case 'D' :
                        if (i<arrInput.length){
                            if (cek.Num(arrInput[i])){
                                node = 'F';
                                i++;
                            }else if (cek.Tanda(arrInput[i])){
                                node = 'E';
                                i++;
                            }else{
                                token.add("err");
                                node = 'X';
                                status = false;
                            }
                        }else{
                            node = 'X';
                            token.add("num");
                        }
                        break;
                    case 'E' :
                        if (i<arrInput.length){
                            if (cek.Num(arrInput[i])){
                                node = 'F';
                                i++;
                            }else{
                                token.add("err");
                                node = 'X';
                                status = false;
                            }
                        }else{
                                token.add("err");
                                node = 'X';
                                status = false;
                            }
                        break;
                    case 'F' :
                        if (i<arrInput.length){
                            if (cek.Spasi(arrInput[i])){
                                node = 'Z';
                                token.add("num");
                                i++;
                            }else if (cek.Num(arrInput[i])){
                                node = 'F';
                                i++;
                            }else{
                                token.add("err");
                                node = 'X';
                                status = false;
                            }
                        }else{
                                node = 'X';
                                token.add("err");
                                status = false;
                            }
                        break;
                    case 'G' :
                        if (i<arrInput.length){
                            if (cek.Spasi(arrInput[i])){
                                node = 'Z';
                                if (cek.Kaba(arrInput[i-1])){
                                    token.add("opr");
                                }else if (cek.Kurbuk(arrInput[i-1])){
                                    token.add("kurbuk");
                                }else if (cek.Kurtup(arrInput[i-1])){
                                    token.add("kurtup");
                                }
                                i++;
                            }else{
                                node = 'X';
                                token.add("err");
                            }
                        }else{
                                node = 'X';
                                token.add("err");
                                status = false;
                            }
                        break;                                            
                }
            }
        }
        for (int j = 0; j < token.size(); j++) {
            System.out.print(token.get(j)+ " ");
        }
        System.out.println("");        

        i = 0; int x; int y; String r;
        while (i < token.size()){
            if ("num".equals(token.get(i))){
                stack.push("Z");
            }else {
                stack.push(token.get(i));
            }
            i++;
            y = -1;
            while (y < stack.size()){
                y++;
                r = "";
                x = y;
                while (x < stack.size()){
                    r = r + stack.get(x);
                    x++;
                    if (r.equals("ZoprZ")){
                        stack.pop();
                        stack.pop();
                        stack.pop();
                        stack.push("Z");                    
                       y = -1; x = stack.size();
                    }
                    if (r.equals("kurbukZkurtup")){
                        stack.pop();
                        stack.pop();
                        stack.pop();
                        stack.push("Z");                    
                         y = -1; x = stack.size();
                    }
                }

            }
        }
        if (stack.peek()=="Z" && stack.size()==1){
            System.out.println("Valid");
        }else{
            System.out.println("Tidak Valid");
        }      
    }    
}
