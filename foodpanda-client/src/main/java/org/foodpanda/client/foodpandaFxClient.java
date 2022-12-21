/*
 * foodpanda generated by tentackle-project-archetype.
 */

package org.foodpanda.client;

import org.foodpanda.common.foodpandaPreferences;
import org.foodpanda.common.Version;
import org.foodpanda.gui.GuiBundle;
import org.foodpanda.gui.main.MainController;
import org.foodpanda.pdo.md.User;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import org.tentackle.fx.FxUtilities;
import org.tentackle.fx.rdc.app.FxApplication;
import org.tentackle.fx.rdc.update.UpdatableDesktopApplication;
import org.tentackle.pdo.DomainContext;
import org.tentackle.pdo.Pdo;
import org.tentackle.prefs.PersistedPreferencesFactory;


/**
 * The FX client application.
 */
@SuppressWarnings("unchecked")    // due to getUser() below
public class foodpandaFxClient extends UpdatableDesktopApplication<MainController> {

  /**
   * Creates the application.
   */
  public foodpandaFxClient() {
    super("FX-Client", Version.RELEASE);
  }

  @Override
  public Class<? extends FxApplication> getApplicationClass() {
    return foodpandaLoginApplication.class;
  }

  @Override
  public Class<MainController> getMainControllerClass() {
    return MainController.class;
  }

  @Override
  public void configureMainStage(Stage mainStage) {
    showApplicationStatus(GuiBundle.getString("initialize GUI..."), 0.9);
    super.configureMainStage(mainStage);
    mainStage.setTitle("foodpanda");
    mainStage.setOnCloseRequest((WindowEvent ev) -> {
      ev.consume();
      getMainController().exit();
    });
  }

  @Override
  protected void configurePreferences() {
    super.configurePreferences();
    User user = getUser(getDomainContext());    // must exist!
    PersistedPreferencesFactory.getInstance().setSystemOnly(user.isSystemPreferencesOnly());
    PersistedPreferencesFactory.getInstance().setReadOnly(!user.isChangingPreferencesAllowed());
    foodpandaPreferences.getInstance().getSystemPrefs().addPreferenceChangeListener(evt -> {
      switch (evt.getKey()) {
        case foodpandaPreferences.HELP_URL:
          configureHelpURL();
          break;
        // other application specific pref changes go here...
      }
    });
    configureHelpURL();
  }

  @Override
  @SuppressWarnings("unchecked")
  public User getUser(DomainContext context, long userId) {
    return Pdo.create(User.class, context).selectCached(userId);
  }


  private void configureHelpURL() {
    FxUtilities.getInstance().setHelpURL(foodpandaPreferences.getInstance().getHelpUrl());
  }

  /**
   * Starts the FX client application.
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    new foodpandaFxClient().start(args);
  }

}
