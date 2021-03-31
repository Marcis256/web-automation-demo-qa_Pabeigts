package com.testing.pageObjects.pages;


import java.util.Map;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import io.cucumber.datatable.DataTable;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/slider")
public class SliderPage extends WidgetsPage {
  // Locators ----------------------------------------------------------------------------------------------------------
  public static By SLIDER_TITLE=text("Slider");
  // Slider ball/ or sldier itself
  public static By SLIDER_BALL= css("input[class*='range-slider']");
  public static By SLIDER_VALUE=id("sliderValue");
  // Public methods ----------------------------------------------------------------------------------------------------
  public void waitForPageToLoad() {
    getElement(SLIDER_TITLE).waitUntilPresent();
    logWeAreOnPage();
  }

  public void setElementValueTo(String elementName, String value) {
    switch(elementName){
      case "SLIDER_BALL":
        WebElementFacade e = getElement(elementName);

        // Converting the required value given in parameter to integer

        int difference = Integer.valueOf(value) - Integer.valueOf(getElement(SLIDER_BALL).getValue());

        for (int i = Math.abs(difference); i > 0; i--) {
          if (difference > 0)
            e.sendKeys(Keys.ARROW_RIGHT);
          else
            e.sendKeys(Keys.ARROW_LEFT);
        }

        // TODO: Implement a logic that would move the slider to the left (Keys.LEFT) or right (Keys.RIGHT),
        // based on it's current possition, and the value given in the parameter.
  
        // sliderValue - current value of slider ball


        break;
      default:
        super.setElementValueTo(elementName, value);
    }
  }

  public Boolean validateSliderValue(DataTable data){
    for (Map<String, String> map : dataToMap(data)) {
      for (String key : map.keySet()) {
        if(snakify(key).equals("VALUE") && getElement(SLIDER_VALUE).getValue().equals(map.get(key))) return true;
      } 
    }
    return false;
  }
}
