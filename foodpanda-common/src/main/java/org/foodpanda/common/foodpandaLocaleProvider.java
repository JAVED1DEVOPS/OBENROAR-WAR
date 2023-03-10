/*
 * foodpanda generated by tentackle-project-archetype.
 */

package org.foodpanda.common;

import org.tentackle.common.LocaleProvider;
import org.tentackle.common.Service;

import java.util.Locale;

/**
 * Application specific locale provider.
 * <p>
 * The default language is "en".
 * Secondary supported languages: "de" (currently)
 */
@Service(LocaleProvider.class)
public class foodpandaLocaleProvider extends LocaleProvider {

  private static final Locale PRIMARY_LOCALE = Locale.ENGLISH;

  private static final Locale[] SECONDARY_LOCALES = {
    Locale.GERMAN
  };

  @Override
  public Locale getEffectiveLocale(Locale locale) {
    if (locale != null) {
      String localeStr = locale.toString();
      for (Locale secondaryLocale : SECONDARY_LOCALES) {
        if (localeStr.startsWith(secondaryLocale.toString())) {
          return secondaryLocale;
        }
      }
    }
    return PRIMARY_LOCALE;
  }

}
