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
    @FindBy(xpath = "//a[@data-target='permissions']")
    private WebElement permissionTab;
    @FindBy(xpath = "//span[text()='Permission Matrix ']/following-sibling::a")
    private WebElement permissionSettingsQuickLink;
    @FindBy(xpath = "//span[text()='Components ']/following-sibling::a")
    private WebElement componentsSettingsQuickLink;
    @FindBy(xpath = "//span[text()='Schemes ']/following-sibling::a")
    private WebElement schemeSettingsQuickLink;
    @FindBy(xpath = "//span[text()='Workflow ']/following-sibling::a")
    private WebElement workflowSettingsQuickLink;
    @FindBy(xpath = "//td[@class='components-table__name']/following-sibling::td[contains(text(),'Project Lead')]")
    private WebElement assignee;
    @FindBy(id = "show-transition-labels")
    private WebElement transitionLabelsCheckBox;


    private By workflow = By.xpath("//div[@id=\"glass-workflow-transitions\"]/table/tbody/tr/td/span/b[local-name()]");
    private By workflowA = By.xpath("//*[@id='workflow-designer1']//*[local-name()='svg']//*[local-name()='text']");
    private By transitionCounters = By.xpath("//b[contains(text(),'To Do')]/ancestor::tr[@class=\"transition-row expanded\"]/following-sibling::tr[1]/descendant::aui-badge");



    public GlassPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void navigateToComponentsTab(String glassProjectUrl) {
        navigateToUrl(glassProjectUrl);
        componentsTab.click();
    }

    public void navigateToVersionsTab(String glassProjectUrl) {
        navigateToUrl(glassProjectUrl);
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
//        driver.findElement(By.xpath("//b[contains(text(),'" + transition + "')]")).click();
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

    public String getWorkflowValidator(String transition) {
        driver.findElement(By.xpath("//b[contains(text(),'" + transition + "')]")).click();
        driver.findElement(By.xpath("//b[contains(text(),'" + transition + "')]/ancestor::tr[@class='transition-row expanded']/following-sibling::tr[1]/descendant::ul/descendant::a[contains(text(),'Validators')]")).click();
        return driver.findElement(By.xpath("//div[contains(@id,'glass-transitions-validators-panel') and @aria-hidden='false']/descendant::li")).getText();
    }

    public void clickSchemeTab() {
        schemesTab.click();
    }

    public void clickPermissionTab() {
        permissionTab.click();
    }

    public boolean clickPermissionSettingsLink(){
        try{
            permissionSettingsQuickLink.click();
            return true;
        }
        catch (NoSuchElementException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean clickComponentSettingsLink(){
        try{
            componentsSettingsQuickLink.click();
            return true;
        }
        catch (NoSuchElementException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean clickSchemeSettingsLink(){
        try{
            schemeSettingsQuickLink.click();
            return true;
        }
        catch (NoSuchElementException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean clickWorkflowSettingsQuickLink(){
        try{
            workflowSettingsQuickLink.click();
            return true;
        }
        catch (NoSuchElementException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean isChangeButtonPresent(String editPage) {
        try {
            driver.findElement(By.xpath("//a[contains(@href,'" + editPage + "')]\n"));
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }

    public boolean isCheckBoxPresent() {
        try {
            return transitionLabelsCheckBox != null;
        } catch (NoSuchElementException e){
            return false;
        }
    }

    public void clickWorkflowTransitionName(String transition) {
        try {
            driver.findElement(By.xpath(String.format("//tr[descendant::b[contains(text(), '%s')]]/td[1]", transition))).click();
        } catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }

    public void clickTabInWorkflowTransitionTable(String transition, String tabName) {
        driver.findElement(By.xpath("//b[contains(text(),'" + transition + "')]/ancestor::tr[@class='transition-row expanded']/following-sibling::tr[1]/descendant::ul/descendant::a[contains(text(),'" + tabName + "')]")).click();
    }

    public String getPostFunctions(String transition) {
        List<WebElement> postFunctionList = driver.findElements(By.xpath(String.format("//tr[descendant::b[contains(text(), '%s')]]/following-sibling::tr[1]//div[contains(@id, 'glass-transitions-postfunctions-panel')]//li", transition)));
        List<String> functions = new ArrayList<>();

        for (WebElement postFunction : postFunctionList) {
            functions.add(postFunction.getText());
        }

        return String.join(", ", functions);
    }

    public String getConditions(String transition) {
        List<WebElement> conditionList = driver.findElements(By.xpath(String.format("//tr[descendant::b[contains(text(), '%s')]]/following-sibling::tr[1]//div[contains(@id, 'glass-transitions-conditions-panel')]//li", transition)));
        List<String> conditions = new ArrayList<>();

        for (WebElement condition : conditionList) {
            conditions.add(condition.getText());
        }

        return String.join(", ", conditions);
    }

    public String getConditionGroup(String transition) {
        WebElement conditionGroup = driver.findElement(By.xpath(String.format("//tr[descendant::b[contains(text(), '%s')]]/following-sibling::tr[1]//div[contains(@id, 'glass-transitions-conditions-panel')]//div[@class='criteria-item']/span", transition)));

        return conditionGroup.getText();
    }

    public String getWorkflowValidators(String transition) {
        return driver.findElement(By.xpath("//div[contains(@id,'glass-transitions-validators-panel') and @aria-hidden='false']/descendant::li")).getText();
    }
}


