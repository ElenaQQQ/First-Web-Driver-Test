package org.example.pageObject.pages;


    public class HomePage extends BasePage {
        @FindBy (xpath = "//summary[@class=\"Header-link\"]/img")
        private WebElement profileDropDownButton;

        public HomePage(WebDriver webDriver) {
            super(webDriver);
        }

        public ProfileDropDownModule openProfileDropDown() {
            profileDropDownButton.click();
            return new ProfileDropDownModule(webDriver);
        }
    }


}
