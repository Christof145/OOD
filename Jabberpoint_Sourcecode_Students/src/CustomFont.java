import java.awt.*;

public class CustomFont  extends Font{
    private Color color;
    private String fontName ;
    private int fontStyle;
    private  int fontHeight;

    public CustomFont(Color color, String fontName, int fontStyle, int fontHeight) {
        super(fontName, fontStyle, fontHeight);
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getFontName() {
        return this.fontName;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    public int getFontStyle() {
        return this.fontStyle;
    }

    public void setFontStyle(int fontStyle) {
        this.fontStyle = fontStyle;
    }

    public int getFontHeight() {
        return this.fontHeight;
    }

    public void setFontHeight(int fontHeight) {
        this.fontHeight = fontHeight;
    }
}
