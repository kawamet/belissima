package karolina.controller;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public enum LangProvider {
    INSTANCE;
    private ResourceBundle bundle = ResourceBundle
            .getBundle("lang", Locale.getDefault());
    public void setLanguage(Locale locale) {
        this.bundle = ResourceBundle.getBundle("lang", locale);
    }
    public String getMessage(String template, String... params) {
        String value =  MessageFormat.format(bundle.getString(template), params);
        try {
            return new String(value.getBytes("ISO-8859-1"), "UTF-8");
        } catch (Exception e) {
            return "Problem in format to UTF-8";
        }
    }
}
