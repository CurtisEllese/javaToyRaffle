public class Toy {
    private int id;
    private String name;
    private int amountInStorage;
    private int toyDropFrequencyPercent;

    public Toy(int id, String name, int amountInStorage, int toyDropFrequencyPercent) {
        this.id = id;
        this.name = name;
        this.amountInStorage = amountInStorage;
        this.toyDropFrequencyPercent = toyDropFrequencyPercent;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("ID: ").append(id);
        res.append(", Название: ").append(name);
        res.append(", Количество на складе: ").append(amountInStorage);
        res.append(", Частота выпадения игрушки: ").append(toyDropFrequencyPercent);
        res.append("\n");
        return res.toString();
    }

    public void changeDropFrequency(int newPercentage) {
        this.toyDropFrequencyPercent = newPercentage;
    }

    public int getAmount() {
        return amountInStorage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getToyDropFrequencyPercent() {
        return toyDropFrequencyPercent;
    }
    
    public void increaseAmount(int numToIncrease) {
        this.amountInStorage += numToIncrease;
    }

    public void decreaseAmount(int numToDecrease) {
        this.amountInStorage -= numToDecrease;
    }  

    public void increaseFrequency(int numToIncrease) {
        this.toyDropFrequencyPercent += numToIncrease;
    }    

    public void decreaseFrequency(int numToDecrease) {
        this.toyDropFrequencyPercent -= numToDecrease;
    }    
}
