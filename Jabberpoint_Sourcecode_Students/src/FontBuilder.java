import java.awt.*;

public interface FontBuilder {
    CustomFont createFont(Color color, String fontName, int fontStyle, int fontHeight);
}
