package Test1;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import common.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class YellowButton extends BaseTest {

    @Test
    void open_sap_page_and_check_button(){
        Locator button = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Get in touch")).first();
        String backgroundColor = (String) button.evaluate("element => getComputedStyle( element ).backgroundColor");
        Assertions.assertThat(backgroundColor).isEqualTo("rgb(255, 212, 60)");
    }
}
