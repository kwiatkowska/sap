package Test3;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import common.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

class InputWrongEmail extends BaseTest {

    @Test
    void check_redirection_and_input_wrong_email(){
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Get in touch")).first().click();
        Assertions.assertThat(page.title()).isEqualTo("SAP Fioneer | Contact | Get in touch!");
        Assertions.assertThat(page.url()).isEqualTo("https://www.sapfioneer.com/contact/");
        Locator email =  page.frameLocator("#hs-form-iframe-0").getByLabel("email");
        email.click();
        email.fill("12345");
        assertThat(page.frameLocator("#hs-form-iframe-0").getByText("Email must be formatted correctly")).isVisible();
    }
}
