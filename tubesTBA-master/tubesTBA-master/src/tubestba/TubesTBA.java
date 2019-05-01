/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubestba;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Scanner;

/**
 *
 * @author ibnuzx
 */
public class TubesTBA {
    
    
    //Character.MIN_VALUE means ''
    
    public static StateFA S;
    public static StateFA P;
    public static StateFA O;
    public static StateFA K;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Meminta Inputan User
        System.out.println("Token Recognizer by Ibenn");
        System.out.println("Masukan Sebuah Kalimat");
        Scanner scanner = new Scanner( System.in );
        String kalimat = scanner.nextLine();
        
        // Memecah Kalimat Menjadi Beberapa Kata
        List<String> kata = parseString(kalimat);
        
        // Membuat Push Down Automata
        Stack<Character> stack = new Stack<>();
            
        StatePDA init = new StatePDA("I");
        StatePDA s = new StatePDA("s");
        StatePDA q0 = new StatePDA("q0");
        StatePDA q1 = new StatePDA("q1");
        StatePDA q2 = new StatePDA("q2");
        StatePDA q3 = new StatePDA("q3",true);
        
        init.addTransition(Character.MIN_VALUE, Character.MIN_VALUE, "S#", s);
        
        s.addTransition(Character.MIN_VALUE, 'S', "spX", q0);
        
        q0.addTransition('s', 's', "", q0);
        q0.addTransition('p', 'p', "", q0);
        q0.addTransition('o', 'X', "Y", q1);
        q0.addTransition('k', 'X', "", q2);
        q0.addTransition(Character.MIN_VALUE, 'X', "", q2);
        
        q1.addTransition(Character.MIN_VALUE, 'Y', "", q2);
        q1.addTransition('k', 'Y', "", q2);
        
        q2.addTransition(Character.MIN_VALUE, '#', "", q3);
        
        // Membuat Finite Automata
        CreateSubjek();
        CreatePredikat();
        CreateObjek();
        CreateKeterangan();
        
        // Menjalankan Mesin Automata
        StatePDA current = init;
        current = current.getNext(stack, Character.MIN_VALUE, Character.MIN_VALUE);
        current = current.getNext(stack, Character.MIN_VALUE, stack.pop());
        
        int i = 0;
        while(current!= null && i<kata.size()){
            current = current.getNext(stack, tokenRecognizer(kata.get(i)), stack.pop());
            i++;
        }
        
        while(current != null && !stack.isEmpty()){
            current = current.getNext(stack, Character.MIN_VALUE, stack.pop()); 
        }
        // Mengeluarkan Hasil Apakah Kalimat Diterima Atau Tidak
        System.out.println("Kata Diterima : "+(current != null?current.isFinal():false));
              
    }
    
    
    // Mendeteksi Sebuah Kata Adalah Subjek , Predikat , Objek atau Keterangan
    public static Character tokenRecognizer(String kata){
        if(isAccepted(kata , S)){
            return 's';
        }
        else if(isAccepted(kata , K)){
            return 'k';
        }
        else if(isAccepted(kata , O)){
            return 'o';
        }
        else if(isAccepted(kata , P)){
            return 'p';
        }
        return 'w';
    }
    
    // Memecah Kalimat Mendjadi Beberapa Kata
    public static List<String> parseString(String kalimat){
        kalimat = kalimat.toLowerCase();
        int i=0;
        String temp = "";
        List<String> kata = new ArrayList<>();
        
        while(i < kalimat.length()){
            if(kalimat.charAt(i) != ' '){
               temp += kalimat.charAt(i);
            }else if(kalimat.charAt(i) == ' '&& !temp.equals("di")){
                kata.add(temp);
                temp = "";
            }else if(temp.equals("di")){
                temp+=" ";
            }
            i++;
        }
        kata.add(temp);
        
        return kata;
    }
    
    public static void CreateSubjek(){      //iben ali ulan edo dwi
        StateFA q0 = new StateFA("q0");
        StateFA q1 = new StateFA("q1");
        StateFA q2 = new StateFA("q2");
        StateFA q3 = new StateFA("q3");
        StateFA q4 = new StateFA("q4");//
        StateFA q5 = new StateFA("q5");
        StateFA q6 = new StateFA("q6");
        StateFA q7 = new StateFA("q7");//
        StateFA q8 = new StateFA("q8");
        StateFA q9 = new StateFA("q9");
        StateFA q10 = new StateFA("q10");
        StateFA q11 = new StateFA("q11");//
        StateFA q12 = new StateFA("q12");
        StateFA q13 = new StateFA("q13");
        StateFA q14 = new StateFA("q14");//
        StateFA q15 = new StateFA("q15");
        StateFA q16 = new StateFA("q16");
        StateFA q17 = new StateFA("q17",true);//
        q0.addTransition('i', q1);
        q1.addTransition('b', q2);
        q2.addTransition('e', q3);
        q3.addTransition('n', q17);
        q0.addTransition('a', q5);
        q5.addTransition('l', q6);
        q6.addTransition('i', q17);
        q0.addTransition('u', q8);
        q8.addTransition('l', q9);
        q9.addTransition('a', q3);
        //q10.addTransition('n', q4);
        q0.addTransition('e', q12);
        q12.addTransition('d', q13);
        q13.addTransition('o', q17);
        q0.addTransition('d', q15);
        q15.addTransition('w', q6);
        //q16.addTransition('i', q6);
        S=q0;
    }
    public static void CreatePredikat(){
        StateFA q0= new StateFA("q0");         //beli jual nego buat coba
        StateFA q1 = new StateFA("q1");
        StateFA q2 = new StateFA("q2");
        StateFA q3 = new StateFA("q3");
        StateFA q4 = new StateFA("q4");//
        StateFA q5 = new StateFA("q5");
        StateFA q6 = new StateFA("q6");
        StateFA q7 = new StateFA("q7");
        StateFA q8 = new StateFA("q8");//
        StateFA q9 = new StateFA("q9");
        StateFA q10 = new StateFA("q10");
        StateFA q11 = new StateFA("q11");
        StateFA q12 = new StateFA("q12");//
        StateFA q13 = new StateFA("q13");
        StateFA q14 = new StateFA("q14");
        StateFA q15 = new StateFA("q15");//
        StateFA q16 = new StateFA("q16");
        StateFA q17 = new StateFA("q17");
        StateFA q18 = new StateFA("q18");
        StateFA q19 = new StateFA("q19",true);
        
        
        q0.addTransition('b', q1);
        q1.addTransition('e', q2);
        q2.addTransition('l', q3);
        q3.addTransition('i', q19);//
        q0.addTransition('j', q5);
        q5.addTransition('u', q6);
        q6.addTransition('a', q7);
        q7.addTransition('l', q19);//        
        q0.addTransition('n', q9);        
        q9.addTransition('e', q10);        
        q10.addTransition('g', q11);        
        q11.addTransition('o', q19);        
        q0.addTransition('b', q1);        
        q1.addTransition('u', q13);        
        q13.addTransition('a', q14);        
        q14.addTransition('t', q19);//
        q0.addTransition('c', q16);
        q16.addTransition('o', q17);
        q17.addTransition('b', q18);
        q18.addTransition('a', q19);//
        P = q0;
    }
    public static void CreateObjek(){
        StateFA q0 = new StateFA("q0");
        StateFA q1 = new StateFA("q1");      //baju tas kaos jam jas 
        StateFA q2 = new StateFA("q2");
        StateFA q3 = new StateFA("q3");
        StateFA q4 = new StateFA("q4");//
        StateFA q5 = new StateFA("q5");
        StateFA q6 = new StateFA("q6");
        StateFA q7 = new StateFA("q7");//
        StateFA q8 = new StateFA("q8");
        StateFA q9 = new StateFA("q9");
        StateFA q10 = new StateFA("q10");//
        StateFA q11 = new StateFA("q11");
        StateFA q12 = new StateFA("q12");
        StateFA q13 = new StateFA("q13");
        StateFA q14 = new StateFA("q14");//
        StateFA q15 = new StateFA("q15");
        StateFA q16 = new StateFA("q16");
        StateFA q17 = new StateFA("q17",true);//

        q0.addTransition('b', q1);
        q1.addTransition('a', q2);
        q2.addTransition('j', q3);
        q3.addTransition('u', q17);//
        q0.addTransition('j', q5);
        q5.addTransition('a', q6);
        q6.addTransition('s', q17);//
        q0.addTransition('t', q8);
        q8.addTransition('a', q6);
        //q9.addTransition('s', q7);//
        q0.addTransition('k', q11);
        q11.addTransition('a', q12);
        q12.addTransition('o', q6);
        //q13.addTransition('s', q7);//
        q0.addTransition('j', q5);
        q5.addTransition('a', q16);
        q16.addTransition('m', q17);//
        O = q0;
    }
    public static void CreateKeterangan(){
        
        StateFA q0 = new StateFA("q0");
        StateFA q1a = new StateFA("q1a"); //di mall di kios di pasar sekarang kemarin
        StateFA q1b = new StateFA("q1b");
        StateFA q1c = new StateFA("q1c");
        StateFA q2 = new StateFA("q2");
        StateFA q3 = new StateFA("q3");
        StateFA q4 = new StateFA("q4");
        StateFA q5 = new StateFA("q5");//
        StateFA q6 = new StateFA("q6");
        StateFA q7 = new StateFA("q7");
        StateFA q8 = new StateFA("q8");
        StateFA q9 = new StateFA("q9");//
        StateFA q10= new StateFA("q10"); 
        StateFA q11= new StateFA("q11"); 
        StateFA q12= new StateFA("q12");
        StateFA q13= new StateFA("q13"); 
        StateFA q14 = new StateFA("q14");//
        StateFA q15 = new StateFA("q15");
        StateFA q16 = new StateFA("q16");
        StateFA q17 = new StateFA("q17");
        StateFA q18 = new StateFA("q18");
        StateFA q19 = new StateFA("q19");
        StateFA q20 = new StateFA("q120");
        StateFA q21 = new StateFA("q21");
        StateFA q22 = new StateFA("q22");//
        StateFA q23 = new StateFA("q23");
        StateFA q24 = new StateFA("q24");
        StateFA q25 = new StateFA("q25");
        StateFA q26 = new StateFA("q26");
        StateFA q27 = new StateFA("q27");
        StateFA q28 = new StateFA("q28");
        StateFA q29 = new StateFA("q29",true);//


        q0.addTransition('d', q1a);
        q1a.addTransition('i', q1b);
        q1b.addTransition(' ', q1c);
        q1c.addTransition('m', q2);
        q2.addTransition('a', q3);
        q3.addTransition('l', q4);
        q4.addTransition('l', q29);
        q1c.addTransition('k', q6);
        q6.addTransition('i', q7);
        q7.addTransition('o', q8);
        q8.addTransition('s', q29);   
        q1c.addTransition('p', q10);
        q10.addTransition('a', q11);
        q11.addTransition('s', q12);
        q12.addTransition('a', q13);
        q13.addTransition('r', q29);
        q0.addTransition('s', q15);
        q15.addTransition('e', q16);
        q16.addTransition('k', q17);
        q17.addTransition('a', q18);
        q18.addTransition('r', q19);
        q19.addTransition('a', q20);
        q20.addTransition('n', q21);
        q21.addTransition('g', q29);
        q0.addTransition('k', q23);
        q23.addTransition('e', q24);
        q24.addTransition('m', q25);
        q25.addTransition('a', q26);
        q26.addTransition('r', q27);
        q27.addTransition('i', q28);
        q28.addTransition('n', q29);
        K = q0;
    }
    

 
    public static boolean isAccepted(String kata , StateFA initialState){
            StateFA current = initialState;
            int i=0;
            while(current!=null && i<kata.length()){
                current = current.getNext(kata.charAt(i));
                i++;
            }
            return current !=null ? current.getIsFinal() : false;
    }
    
    //Subjek
    //iben ali ulan dwi edo
    
    //predikat
    //beli jual nego buat coba
    
    //objek
    //baju tas kaos jam jas
    
    //keterangan
    //di mall, di kios, di pasar, sekarang, kemarin   
    
}
