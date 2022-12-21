/*
 * foodpanda generated by tentackle-project-archetype.
 */

package org.foodpanda.gui.usergroup;

import org.foodpanda.gui.GuiBundle;
import org.foodpanda.gui.GuiConstants;
import org.foodpanda.pdo.md.User;
import org.foodpanda.pdo.md.UserGroup;
import javafx.collections.ObservableList;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;

import org.tentackle.fx.Fx;
import org.tentackle.fx.rdc.PdoTreeCell;
import org.tentackle.fx.rdc.PdoTreeContextMenuItem;
import org.tentackle.fx.rdc.PdoTreeContextMenuItemService;

/**
 * Menu item to remove a user from a group.
 */
@PdoTreeContextMenuItemService(value = User.class, ordinal = 500, group = GuiConstants.ITEM_GROUP)
public class RemoveUserItem extends MenuItem implements PdoTreeContextMenuItem<User> {

  /**
   * Creates a menu item.
   *
   * @param cell the tree cell
   */
  public RemoveUserItem(PdoTreeCell<User> cell) {
    super(GuiBundle.getString("remove from group"), Fx.createImageView("cut"));
    User user = cell.getItem();
    boolean disabled = true;
    if (user.isEditAllowed()) {
      UserGroup grp = cell.getPdoTreeItem().getParentPdo(UserGroup.class);
      if (grp != null) {
        UserGroup group = grp.reload();
        disabled = false;
        setOnAction(e -> {
          group.getUsers().remove(user);
          group.save();
          @SuppressWarnings({ "unchecked", "rawtypes" })
          ObservableList<TreeItem<User>> items = (ObservableList) cell.getPdoTreeItem().getParentPdoItem().getChildren();
          int i=0;
          for (TreeItem<User> item: items) {
            if (user.equals(item.getValue())) {
              items.remove(i);
              cell.getTreeView().refresh();
              break;
            }
            i++;
          }
        });
      }
    }
    setDisable(disabled);
  }

}
