package com.testing.pageObjects.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("/bookApplications")
public class BookStoreApplicationPage extends HomePage{
  // Locators ----------------------------------------------------------------------------------------------------------
  public static By LOGIN_OPTION = css("div.show #item-0");

  // Public methods ----------------------------------------------------------------------------------------------------
  public void waitForPageToLoad() {
    getElement(BOOK_STORE_APPLICATION).waitUntilPresent();
    logWeAreOnPage();
  }
}
