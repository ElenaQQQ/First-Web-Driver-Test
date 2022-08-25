package org.example.pageObject.pages.modules;

import org.openqa.selenium.WebElement;

public class ProfileDropDownModule {
    private WebElement userInformationProfile;

    protected ProfileDropDownModule(WebDriver webDriver) {
        super(webDriver);
    }

    public String getuserInformationProfile() {
        userInformationProfile = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()=\"juliaHrabovska\"]")));

        return userInformationProfile.getText();
    }
}
