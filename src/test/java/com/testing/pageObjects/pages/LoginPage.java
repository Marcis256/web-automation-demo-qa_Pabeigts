package com.testing.pageObjects.pages;

import io.cucumber.datatable.DataTable;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import java.util.Map;

@DefaultUrl("/text-box")
public class LoginPage extends BookStoreApplicationPage{
  // Locators ----------------------------------------------------------------------------------------------------------

  // Title of page
  public static By LOGIN_TITLE = css("li[class='btn btn-light active']");

  public static By NEW_USER_BUTTON = id("newUser");

  public static By FIRST_NAME_FIELD =id("firstname");

  // Public methods ----------------------------------------------------------------------------------------------------
  public void waitForPageToLoad() {
    getElement(LOGIN_TITLE).waitUntilPresent();
    logWeAreOnPage();
  }

  public Boolean validateTextBoxResults(DataTable data){
    for (Map<String, String> map : dataToMap(data)) {
      for (String key : map.keySet()) {
        info("The element: " + snakify(key) + " should contain " + map.get(key));

        if(getElement(snakify(key)).getText().contains(map.get(key)) == false) return false;
      }
    }
    return true;
  }
}
