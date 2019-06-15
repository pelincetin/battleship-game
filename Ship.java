public class Ship {
    private String type;
    private int length;
    private int numHits;
    
    public Ship (String type, int length){
        if (type == null  || type.equals ("")){
            throw new IllegalArgumentException();
        }
        this.type = type;
        if (length <1){
            throw new IllegalArgumentException();
        }
        this.length = length;
        this.numHits = 0;
    }
        
    public String getType (){
        return this.type;
    }
    public int getLength(){
        return this.length;
    }
    public int getNumHits (){
        return this.numHits;
    }
    public char getSymbol (){
        return this.type.charAt (0);
    }
    public void applyHit (){
        this.numHits += 1;
    }
    public boolean isSunk (){
        if (this.length == this.numHits){
            return true;
        }else{
            return false;
        }
    }
    public String toString (){
        String str = this.type + " of length " +this.length;
        return str;
    }
}
    
    