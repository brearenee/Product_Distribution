import java.io.Serializable;

public class Supplier implements Serializable {
    public int demand() {
        return 5;
    }
    public String name(){
        return "test";
    }
    public int storageCost(){
        return 1;
    }
    public int inventory(){
        return 1;
    }
    public int surplus(){
        return 1;
    }
    public boolean save(String str){
        return false;
    }
    public boolean restore(String str){
        return false;
    }
    //overwrite equal - are these two objects equal, not the same object. so its specific to supplier objects. 
    public boolean equals(Object o){
        return false;
    }
    // and if you overwrite equals, you have to override hash code. 
    public int hashCode(){
        return 1;
    }
}