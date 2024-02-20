package Test2;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import common.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Redirection extends BaseTest {

    @Test
    void check_redirect(){
        page.locator("#menu-item-29979").hover();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("ESG KPI Engine")).click();
        Assertions.assertThat(page.title()).isEqualTo("Stay audit-ready with the ESG KPI Engine | SAP Fioneer");
        Assertions.assertThat(page.url()).contains("https://www.sapfioneer.com/finance-esg/esg-kpi-engine/");
    }
}
