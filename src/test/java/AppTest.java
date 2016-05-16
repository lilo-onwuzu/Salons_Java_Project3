import org.junit.*;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
// filter Constructor is the fluentinum API class that allows us to use the click "withText" method
import static org.fluentlenium.core.filter.FilterConstructor.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  // webdriver is used for selenium test which automatically navigates the web to simulate a human user
  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  // @After
  // public void tearDown() {
  //   // whenever the testing program executes (even in the integration test), new word objects are being created that gets added to the wordInstances arraylist. @After tells the test program to clear all the word objects used in testingso they are not mixed up with the word objects in the program itself. We also need to clear the word objects so each new test starts on a fresh note and the word ids are not mixed up. To use "@After" rule, we have to call the jUnit class library in the integration test
  //   Word.clear();
  // }

  // to dry up code use a DatabaseRule.jave file instead of the above. This is a rule for this class AppTest
  @Rule
  public DatabaseRule database = new DatabaseRule();

  // ClassRule is a class called within AppTest
  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void homePageTest_homePage() {
    goTo("http://localhost:4567/stylists");
    assertThat(pageSource()).contains("Directory of Stylists and Clients");
  }

  @Test
  public void addsANewStylist() {
    goTo("http://localhost:4567/stylists");
    click("a", withText("Add New Stylist"));
    fill("#inputStylist").with("Jane Doe");
    submit(".btn");
    assertThat(pageSource()).contains("Jane Doe");
  }

  @Test
  public void fullListOfStylist() {
    goTo("http://localhost:4567/stylists");
    click("a", withText("Add New Stylist"));
    fill("#inputStylist").with("Jane Doe");
    submit(".btn");
    assertThat(pageSource()).contains("Jane Doe");
    assertThat(pageSource()).contains("Click on the Stylists below");
  }

  @Test
  public void stylist_showsStylistDetails() {
    goTo("http://localhost:4567/stylists");
    click("a", withText("Add New Stylist"));
    fill("#inputStylist").with("Jane Doe");
    submit(".btn");
    assertThat(pageSource()).contains("Jane Doe");
    click("a", withText("Jane Doe"));
    assertThat(pageSource()).contains("Jane Doe has 0 clients");
    click("a", withText("Add New Client For Jane Doe"));
    fill("#inputClient").with("John Doe");
    submit(".btn");
    assertThat(pageSource()).contains("John Doe");
  }

  @Test
  public void stylist_showsClientDetails() {
    goTo("http://localhost:4567/stylists");
    click("a", withText("Add New Stylist"));
    fill("#inputStylist").with("Jane Doe");
    submit(".btn");
    assertThat(pageSource()).contains("Jane Doe");
    click("a", withText("Jane Doe"));
    assertThat(pageSource()).contains("Jane Doe has 0 clients");
    click("a", withText("Add New Client For Jane Doe"));
    fill("#inputClient").with("John Doe");
    submit(".btn");
    assertThat(pageSource()).contains("John Doe");
    click("a", withText("John Doe"));
    assertThat(pageSource()).contains("Delete this client");
    click("a", withText("Delete this client"));
  }

  @Test
  public void edit_editsClientDetails() {
    goTo("http://localhost:4567/stylists");
    click("a", withText("Add New Stylist"));
    fill("#inputStylist").with("Jane Doe");
    submit(".btn");
    assertThat(pageSource()).contains("Jane Doe");
    click("a", withText("Jane Doe"));
    assertThat(pageSource()).contains("Jane Doe has 0 clients");
    click("a", withText("Add New Client For Jane Doe"));
    fill("#inputClient").with("John Doe");
    submit(".btn");
    assertThat(pageSource()).contains("John Doe");
    click("a", withText("John Doe"));
    assertThat(pageSource()).contains("Delete this client");
    click("a", withText("Delete this client"));
    assertThat(pageSource()).contains("No clients have been added for Jane Doe!");
  }

}
