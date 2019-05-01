package tba2;
public class Cek {
    private final char[] isi = {'0','1','2','3','4','5','6','7','8','9'};
    
    public boolean Num(char a){
        boolean status = false;
        int i = 0;
        while (i < 10 && status==false){
            if (a == isi[i]){   
                status = true;
            }
            i++;
        }
        return status;
    }    

    public boolean Tanda(char a){
        boolean status = false;
        if(a == '+' || a=='-'){
            status = true;
        }
        return status;
    }
    
    public boolean E(char a){
        boolean status = false;
        if (a == 'E'){
            status = true;
        }
        return status;
    }
    
    public boolean Spasi(char a){
        boolean status = false;
        if (a == ' '){
            status = true;
        }
        return status;
    }
    
    public boolean Kurbuk(char a){
        boolean status = false;
        if (a == '('){
            status = true;
        }
        return status;
    }
    
    public boolean Kurtup(char a){
        boolean status = false;
        if (a == ')'){
            status = true;
        }
        return status;
    }
    
    public boolean Koma(char a){
        boolean status = false;
        if (a == ','){
            status = true;
        }
        return status;
    }

    public boolean Kabagikur(char a){
        boolean status = false;
        if(a == 'x' || a==':' || a == '(' || a == ')'){
            status = true;
        }
        return status;
    }
    
    public boolean Kaba(char a){
        boolean status = false;
        if(a == 'x' || a==':'){
            status = true;
        }
        return status;
    }
}
