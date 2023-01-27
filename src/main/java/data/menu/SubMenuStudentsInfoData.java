package data.menu;

public class SubMenuStudentsInfoData implements ISubMenu{

    private String name;

    SubMenuStudentsInfoData(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
