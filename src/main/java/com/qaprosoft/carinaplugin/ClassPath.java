package com.qaprosoft.carinaplugin;

public enum ClassPath {

    COMMON_PATH("com.qaprosoft.carinaplugin"),

    ABSTRACT_TEST("com.qaprosoft.carina.core.foundation.AbstractTest"),
    ABSTRACT_PAGE("com.qaprosoft.carina.core.gui.AbstractPage"),
    ABSTRACT_PAGE_UI_OBJECT("com.qaprosoft.carina.core.gui.AbstractUIObject"),

    EXTENDED_WEB_ELEMENT("com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement"),
    WEB_ELEMENT("org.openqa.selenium.WebElement");

    private String className;

    ClassPath(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }
}
