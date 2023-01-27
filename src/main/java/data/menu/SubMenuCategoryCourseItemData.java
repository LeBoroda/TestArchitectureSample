package data.menu;

public enum SubMenuCategoryCourseItemData implements ISubMenu{
    GAMEDEV("GameDev");

    private String name;
    SubMenuCategoryCourseItemData(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
