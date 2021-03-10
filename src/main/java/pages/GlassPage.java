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
    @FindBy(id = "show-transition-labels")
    private WebElement transitionLabelsCheckBox;
    private By workflowTransitions = By.xpath("//div[@id='glass-workflow-transitions']//td[@class='transition-name']");

    public GlassPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
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

    public List<String> checkWorkflowTransitionData(String transition) {

        try {
            List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//b[contains(text(), '" + transition + "')]//ancestor::tr[@class='transition-row']//td")));
            List<String> actualTransitionNames = new ArrayList<>();
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
            List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(workflowTransitions));
            List<String> actualTransitionNames = new ArrayList<>();
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
            List<String> actualTransitionNames = new ArrayList<>();
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


