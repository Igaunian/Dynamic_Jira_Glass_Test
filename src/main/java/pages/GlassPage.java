package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GlassPage extends MainPage {
    private static final String componentAssignee = System.getenv("COMPONENT_ASSIGNEE");
    @FindBy(xpath = "//li[@id='glass-workflow-nav']/a")
    private WebElement issueTypes;
    @FindBy(xpath = "//*[@data-issue-type='Improvement']/a")
    private WebElement improvementIssueType;
    @FindBy(xpath = "//li[@id='glass-general-nav']/a")
    private WebElement general;
    @FindBy(xpath = "//li[@id='glass-people-nav']/a")
    private WebElement people;
    @FindBy(xpath = "//li[@id='glass-permissions-nav']/a")
    private WebElement permissions;
    @FindBy(xpath = "//li[@id='glass-notifications-nav']/a")
    private WebElement notifications;
    @FindBy(xpath = "//a[text()='Components']")
    private WebElement componentsTab;
    @FindBy(xpath = "//a[text()='Versions']")
    private WebElement versionsTab;
    @FindBy(xpath = "//a[text()='Schemes']")
    private WebElement schemesTab;
    @FindBy(xpath = "//td[@class='components-table__name']/following-sibling::td[contains(text(),'Project Lead')]")
    private WebElement assignee;

    public GlassPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void navigateToComponentsTab() {
        navigateToUrl(System.getenv("GLASS_PROJECTURL"));
        componentsTab.click();
    }

    public void navigateToVersionsTab(){
        navigateToUrl(System.getenv("GLASS_PROJECTURL"));
        versionsTab.click();
    }

    public boolean doesComponentExists(String componentName){
        try {
            driver.findElement(By.xpath("//table[@id=\"components-table\"]//a[contains(text(),'" + componentName + "')]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

//    TODO: Add env to xpath
    public boolean doesComponentAssigneePresent() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@class='components-table__name']"))).isDisplayed();
    }
//TODO: func parameter
    public boolean doesComponentDescriptionPresent(String componentDescription){
        try {
            driver.findElement(By.xpath("//td[@class=\"glass-components-table__description\"]//div[contains(text(),'" + componentDescription + "')]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean doesVersioinExists(String componentVersion){
        try {
            driver.findElement(By.xpath("//td[@class=\"versions-table__name\"]//div//a[contains(text(),'" + componentVersion + "')]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean doesVersionStartDatePresent(String versionStartDate){
        try {
            driver.findElement(By.xpath("//td[@class=\"versions-table__date_start\"]//div[contains(text(),'" + versionStartDate + "')]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean doesVersionReleaseDatePresent(String versionReleaseDate) {
        try {
            driver.findElement(By.xpath("//td[@class=\"versions-table__date_release\"]//div[contains(text(),'" + versionReleaseDate + "')]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean doesVersionDescriptionPresent(String versionDescription) {
        try {
            driver.findElement(By.xpath("//td[@class=\"versions-table__description\"]//div[contains(text(),'" + versionDescription + "')]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
