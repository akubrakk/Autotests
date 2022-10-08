package ui.element;

import org.openqa.selenium.WebElement;

public class Button {
    private WebElement element;

    public Button(WebElement element){
        this.element = element;
    }

    public String getName(){
        return element.getAttribute("name");
    }
    public void clickButton(){
        element.click();
    }
}
