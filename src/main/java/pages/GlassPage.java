package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

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

    private By workflow = By.xpath("//div[@id=\"glass-workflow-transitions\"]/table/tbody/tr/td/span/b[local-name()]");
    private By workflowA = By.xpath("//*[@id='workflow-designer1']//*[local-name()='svg']//*[local-name()='text']");
    private By transitionCounters = By.xpath("//b[contains(text(),'To Do')]/ancestor::tr[@class=\"transition-row expanded\"]/following-sibling::tr[1]/descendant::aui-badge");

    public GlassPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void navigateToComponentsTab() {
        navigateToUrl(System.getenv("GLASS_PROJECTURL"));
        componentsTab.click();
    }

    public void navigateToVersionsTab() {
        navigateToUrl(System.getenv("GLASS_PROJECTURL"));
        versionsTab.click();
    }

    public boolean doesComponentExist(String componentName) {
        try {
            driver.findElement(By.xpath("//table[@id=\"components-table\"]//a[contains(text(),'" + componentName + "')]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //    TODO: Add env to xpath
    public boolean isComponentAssigneePresent() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@class='components-table__name']"))).isDisplayed();
    }

    //TODO: func parameter
    public boolean isComponentDescriptionPresent(String componentDescription) {
        try {
            driver.findElement(By.xpath("//td[@class=\"glass-components-table__description\"]//div[contains(text(),'" + componentDescription + "')]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean doesVersionExist(String componentVersion) {
        try {
            driver.findElement(By.xpath("//td[@class=\"versions-table__name\"]//div//a[contains(text(),'" + componentVersion + "')]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isVersionStartDatePresent(String versionStartDate) {
        try {
            driver.findElement(By.xpath("//td[@class=\"versions-table__date_start\"]//div[contains(text(),'" + versionStartDate + "')]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isVersionReleaseDatePresent(String versionReleaseDate) {
        try {
            driver.findElement(By.xpath("//td[@class=\"versions-table__date_release\"]//div[contains(text(),'" + versionReleaseDate + "')]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isVersionDescriptionPresent(String versionDescription) {
        try {
            driver.findElement(By.xpath("//td[@class=\"versions-table__description\"]//div[contains(text(),'" + versionDescription + "')]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void selectIssuetype(String issueType) {
        try {
            issueTypes.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        try {
            driver.findElement(By.xpath("//span[contains(text(),'" + issueType + "')]")).click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public boolean checkWorkflowName(String workflowName) {
        try {
            driver.findElement(By.xpath("//div[@id='glass-workflow-panel-title2' and contains(text(),'" + workflowName + "')]"));
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String> checkWorkflowTransitionNames() {
        try {
            List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(workflow));
            List<String> actualTransitionNames = new ArrayList<String>();
            for (WebElement element : elements) {
                element.isDisplayed();
                actualTransitionNames.add(element.getText());
            }
            return (actualTransitionNames);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> checkWorkflowAnalysis() {
        try {
            List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(workflowA));
            List<String> actualTransitionNames = new ArrayList<String>();
            for (WebElement element : elements) {
                element.isDisplayed();
                actualTransitionNames.add(element.getText());
            }
            return (actualTransitionNames);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> checkWorkFlowValidatorCounters(String transition) {
        driver.findElement(By.xpath("//b[contains(text(),'" + transition + "')]")).click();
        try {
            List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//b[contains(text(),'" + transition + "')]/ancestor::tr[@class=\"transition-row expanded\"]/following-sibling::tr[1]/descendant::aui-badge")));
            List<String> actualTransitionNames = new ArrayList<String>();
            for (WebElement element : elements) {
                element.isDisplayed();
                actualTransitionNames.add(element.getText());
            }
            return (actualTransitionNames);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return null;
        }
    }
}


