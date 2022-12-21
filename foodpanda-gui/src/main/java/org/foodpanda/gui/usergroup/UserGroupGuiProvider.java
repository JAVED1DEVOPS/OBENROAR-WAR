/*
 * foodpanda generated by tentackle-project-archetype.
 */

package org.foodpanda.gui.usergroup;

import org.foodpanda.gui.foodpandaImageProvider;
import org.foodpanda.pdo.md.User;
import org.foodpanda.pdo.md.UserGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

import org.tentackle.fx.Fx;
import org.tentackle.fx.rdc.DefaultGuiProvider;
import org.tentackle.fx.rdc.GuiProviderService;
import org.tentackle.fx.rdc.PdoFinder;
import org.tentackle.fx.rdc.search.DefaultPdoFinder;
import org.tentackle.misc.IdentifiableKey;
import org.tentackle.pdo.PersistentDomainObject;

import java.util.Collection;

/**
 * GUI provider for UserGroup.
 */
@GuiProviderService(UserGroup.class)
public class UserGroupGuiProvider extends DefaultGuiProvider<UserGroup> {

  /**
   * Creates the provider.
   *
   * @param pdo the pdo
   */
  public UserGroupGuiProvider(UserGroup pdo) {
    super(pdo);
  }

  @Override
  public ImageView createIcon() {
    return Fx.createImageView(foodpandaImageProvider.REALM, "usergroup");
  }

  @Override
  @SuppressWarnings("unchecked")
  public UserGroupEditor createEditor() {
    return Fx.load(UserGroupEditor.class);
  }

  @Override
  public boolean editorExists() {
    return true;
  }

  @Override
  public boolean finderExists() {
    return true;
  }

  @Override
  public PdoFinder<UserGroup> createFinder() {
    @SuppressWarnings("unchecked")
    PdoFinder<UserGroup> finder = Fx.load(DefaultPdoFinder.class);
    finder.setSearchRunningImmediately(true);
    return finder;
  }

  @Override
  public boolean providesTreeChildObjects() {
    return getPdo().isViewAllowed();
  }

  @Override
  public <P extends PersistentDomainObject<P>> Collection<? extends PersistentDomainObject<?>> getTreeChildObjects(P parent) {
    return getPdo().getUsers();
  }

  @Override
  public boolean isDragAccepted(DragEvent event) {
    IdentifiableKey<PersistentDomainObject<?>> key = getPdoKeyFromDragboard(event.getDragboard());
    if (key != null && User.class.equals(key.getIdentifiableClass())) {
      // check if user not already added
      for (User user: getPdo().getUsers()) {
        if (!user.isEditAllowed() || key.getIdentifiableId() == user.getId()) {
          return false;
        }
      }
      event.acceptTransferModes(TransferMode.COPY);
      return true;
    }
    return false;
  }

  @Override
  public void dropPdo(PersistentDomainObject<?> pdoToDrop) {
    if (pdoToDrop instanceof User user) {
      UserGroup group = getPdo().reload();
      if (group.isEditAllowed() && !group.getUsers().contains(user)) {   // check again for sure
        group.getUsers().add(user);
        group.save();
      }
    }
  }

}
