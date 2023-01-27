package components.popups;

import data.menu.HeaderMenuItemData;
import data.menu.ISubMenu;

public interface ISubMenuPopUp {
    public void popUpShouldNotBeVisible(HeaderMenuItemData headerMenuItemData);
    public void popUpShouldBeVisible(HeaderMenuItemData headerMenuItemData);
}
