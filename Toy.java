public class Toy {
    private static int quantity;
    private int id;
    private String nameToy;
    private int chance;
    
    public Toy(String nameToy, int chance){
        this.quantity++;
        this.id = this.quantity;
        this.nameToy = nameToy;
        this.chance = chance;
    }

    public int getChance() {
        return chance;
    }

    public String getNameToy() {
        return nameToy;
    }
    
    @Override
    public String toString() {
        return id + " " + nameToy + " " + chance;
    }
}
