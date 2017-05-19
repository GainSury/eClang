package model;

public class InputInfo {
    private String compiler_version;
    private String language;
    private String code_text;
    private String compiler_option;
    public String getCompiler_version() {
        return compiler_version;
    }
    public void setCompiler_version(String compiler_version) {
        this.compiler_version = compiler_version;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public String getCode_text() {
        return code_text;
    }
    public void setCode_text(String code_text) {
        this.code_text = code_text;
    }
    public String getCompiler_option() {
        return compiler_option;
    }
    public void setCompiler_option(String compiler_option) {
        this.compiler_option = compiler_option;
    }
    
}
