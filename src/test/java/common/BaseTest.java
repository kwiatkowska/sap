package common;

import com.microsoft.playwright.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    private static Playwright pw;
    private static Browser browser;
    private static BrowserContext context;
    protected Page page;

    @BeforeAll
    static void beforeAll(){
        pw = Playwright.create();
        browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
    }

    @BeforeEach
    void beforeEac(){
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://www.sapfioneer.com/");
        Assertions.assertThat(page.title()).isEqualTo("SAP Fioneer | World-class software solutions for financial services");
    }

    @AfterEach
    void afterEach(){
        context.close();
    }

    @AfterAll
    static void afterAll(){
        pw.close();
    }
}
