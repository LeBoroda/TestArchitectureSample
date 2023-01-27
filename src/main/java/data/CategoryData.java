package data;

public enum CategoryData {
    GAMEDEV("GameDev");

    private String name;

    CategoryData(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
