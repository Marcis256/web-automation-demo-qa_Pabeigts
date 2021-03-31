package com.testing.pageObjects.pages;

import org.openqa.selenium.By;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/browser-windows")
public class BrowserWindowsPage extends AlertsFrameAndWindowsPage {
  // Locators ----------------------------------------------------------------------------------------------------------
  public static By BROWSER_WINDOWS_TITLE=css("li[class='btn btn-light active']");
  public static By NEW_TAB_BUTTON=text("New Tab");
  public static By NEW_WINDOW_BUTTON=id("windowButton");
  // When a new tab or window is opened, it contains a heading.
  public static By HEADING;
  // Public methods ----------------------------------------------------------------------------------------------------
  public void waitForPageToLoad() {
    getElement(BROWSER_WINDOWS_TITLE).waitUntilPresent();
    logWeAreOnPage();
  }
}
