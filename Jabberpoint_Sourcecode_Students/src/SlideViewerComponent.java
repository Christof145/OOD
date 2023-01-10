import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;


/** <p>SlideViewerComponent is a graphical component that ca display Slides.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class SlideViewerComponent extends JComponent implements FontBuilder{
		
	private Slide slide; //The current slide
	private Presentation presentation = null; //The presentation
	private JFrame frame = null;
	
	private static final long serialVersionUID = 227L;
	
	private static final Color BGCOLOR = Color.white;
	private CustomFont customFont;
	private static final int XPOS = 1100;
	private static final int YPOS = 20;

	public SlideViewerComponent(Presentation pres, JFrame frame) {
		setBackground(BGCOLOR); 
		presentation = pres;
		this.frame = frame;
		createFont(Color.BLACK, "Dialog", Font.BOLD, 10);
	}

	public Dimension getPreferredSize() {
		return new Dimension(Slide.WIDTH, Slide.HEIGHT);
	}

	public void update(Presentation presentation, Slide data) {
		if (data == null) {
			repaint();
			return;
		}
		this.presentation = presentation;
		this.slide = data;
		repaint();
		frame.setTitle(presentation.getTitle());
	}

	public void setSlideNumber(int number) {
		this.presentation.setCurrentSlideNumber(number);
			this.update(presentation, presentation.getCurrentSlide());
	}

	//Navigate to the previous slide unless we are at the first slide
	public void prevSlide() {
		if (presentation.getSlideNumber() > 0) {
			setSlideNumber(presentation.getSlideNumber() - 1);
		}
	}

	//Navigate to the next slide unless we are at the last slide
	public void nextSlide() {
		if (presentation.getSlideNumber() < (presentation.getSize()-1)) {
			setSlideNumber(presentation.getSlideNumber() + 1);
		}
	}

	//Remove the presentation
	void clear() {
		setSlideNumber(-1);
	}

	//Draw the slide
	public void paintComponent(Graphics g) {
		g.setColor(BGCOLOR);
		g.fillRect(0, 0, getSize().width, getSize().height);
		if (presentation.getSlideNumber() < 0 || slide == null) {
			return;
		}
		g.setFont(customFont);
		g.setColor(customFont.getColor());
		g.drawString("Slide " + (1 + presentation.getSlideNumber()) + " of " +
                 presentation.getSize(), XPOS, YPOS);
		Rectangle area = new Rectangle(0, YPOS, getWidth(), (getHeight() - YPOS));
		slide.draw(g, area, this);
	}

	@Override
	public CustomFont createFont(Color color, String fontName, int fontStyle, int fontHeight) {
		return customFont = new CustomFont(color, fontName, fontStyle, fontHeight);
	}

	public Presentation getPresentation() {
		return presentation;
	}
}
