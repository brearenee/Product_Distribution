import java.io.Serializable;
public class Transporter implements Serializable {
    public String name(){
        return "test";
    }
    public int allocation(){
        return 1;
    }
    public boolean setAllocation(int x){
        return false;
        //if allocation is higher than max capacity, it should be false. 
    }
    public int costPerUnit(){
        return 1;
    }
    public int maxCapacity(){
        return 1;
    }
    public Supplier from() {
        Supplier supplier = new Supplier();
        return supplier;
    }
    public Supplier to() {
        Supplier supplier = new Supplier();
        return supplier;
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
