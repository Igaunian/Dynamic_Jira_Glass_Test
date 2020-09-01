package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectPage extends MainPage {

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div[1]/header/div/div[3]/div/a")
    private WebElement boardDropDown;

    @FindBy(xpath = "//section[@id='content']//li[6]//a[1]")
    private WebElement componentsButton;

    @FindBy(xpath = "//input[@placeholder='Component name']")
    private WebElement componentNameInputField;

    @FindBy(xpath = "//input[@placeholder='Description (optional)']")
    private WebElement componentDescriptionInputField;

    @FindBy(xpath = "//input[@id='assigneeType-field']")
    private WebElement componentAssigneeInputField;

    @FindBy(xpath = "//div[@class='components-add__confirm']//button[@class='aui-button aui-button-primary']")
    private WebElement addComponentButton;

    @FindBy(xpath = "//a[@class='component-delete-dialog deletecomponent_link']")
    private WebElement deleteComponentButton;

    @FindBy(xpath = "//input[contains(@class,'aui-button')]")
    private WebElement deleteForSure;

    @FindBy(xpath = "//span[@class='aui-icon aui-icon-small aui-iconfont-more']")
    private WebElement actionButton;

    @FindBy(xpath = "//table[@id=\"components-table\"]//a[contains(text(),'Very Component')]")
    private WebElement expectedComponent;

    @FindBy(xpath = "//a[@class='aui-button aui-button-subtle aui-sidebar-toggle aui-sidebar-footer-tipsy']")
    private WebElement expandSidebarButton;

    @FindBy(xpath = "//input[@placeholder='Version name']")
    private WebElement versionNameInputfield;

    @FindBy(xpath = "//input[@placeholder='Description (optional)']")
    private WebElement versionDescriptionInputField;

    @FindBy(xpath = "//input[@placeholder='Start date (optional)']")
    private WebElement startDateinputField;

    @FindBy(xpath = "//input[@placeholder='Release date (optional)']")
    private WebElement releaseDateInputField;

    @FindBy(xpath = "//button[@class='aui-button aui-button-primary']")
    private WebElement addNewVersionButton;

    public ProjectPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }
//TODO override less parameter
    public void createComponent(String ProjectComponentURL, String componentName, String componentDescription, String componentAssignee){
        navigateToComponentsPage(ProjectComponentURL);
        componentNameInputField.sendKeys(componentName);
        componentDescriptionInputField.sendKeys(componentDescription);
        componentAssigneeInputField.sendKeys(componentAssignee);
        addComponentButton.click();
    }

    public void deleteComponent(String ProjectComponentURL){
        navigateToComponentsPage(ProjectComponentURL);
        actionButton.click();
        deleteComponentButton.click();
        deleteForSure.click();
    }

    public boolean doesComponentExist(){
        try {
//            driver.findElement(By.xpath("//table[@id=\"components-table\"]//a[contains(text(),'Very Component')]"));
            wait.until(ExpectedConditions.visibilityOf(expectedComponent)).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void navigateToComponentsPage(String projectComponentURL) {
        navigateToUrl(projectComponentURL);
    }

    public void navigateToVersionsPage(){
        navigateToUrl(System.getenv("PROJECT_VERSIONS_URL"));
    }

    public void createNewVersion(String versionName, String startDate, String releaseDate, String description){
        navigateToVersionsPage();
        versionNameInputfield.sendKeys(versionName);
        startDateinputField.sendKeys(startDate);
        releaseDateInputField.sendKeys(releaseDate);
        versionDescriptionInputField.sendKeys(description);
        addNewVersionButton.click();
    }

    public void deleteVersion() {
        navigateToVersionsPage();
        actionButton.click();
        deleteComponentButton.click();
        deleteForSure.click();
    }
}
