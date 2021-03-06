package engine.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Text extends RenderObject {
	private String text;
	// private BitmapFont bmfont;
	private Color color;
	private float height;
	private boolean visible = true;
	Label label;

	public Text(int height, String text, Color color, float globalScale) {
		this.text = text;
		this.label = new Label(this.text, new Skin(Gdx.files.internal("uiskin.json"))/* , "arial.fnt", Color.WHITE */);
		this.label.setHeight(height);
		// this.bmfont = new BitmapFont(Gdx.files.internal("arial.fnt"));
		// this.height = this.bmfont.getCapHeight();
		// this.height = this.label.getMaxHeight();
		// this.setHeight(height);
		this.text = text;
		this.color = color;

	}

	public void setText(String text) {
		this.text = text;
		this.label.pack();
	}

	@Override
	public void draw(float x, float y, float globalScale, SpriteBatch batch) {
		// this.bmfont.setColor(this.color.r, this.color.g, this.color.b, 1);
		this.label.setColor(this.color.r, this.color.g, this.color.b, 1);
		this.label.setPosition(x, y);
		this.label.setText(this.text);
		// this.bmfont.setColor(1, 1, 1, 1);
		if (this.visible) {
			// this.bmfont.draw(batch, this.text, x, y);

			// for (String line : this.text.split("\n")) {
			// this.bmfont.draw(batch, line, x, y + this.getTextHeight());
			this.label.draw(batch, 1f);
			// y += this.bmfont.getLineHeight();
			// }
		}

	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getWidth() {
		// String[] lines = this.text.split("\n");
		// int maxWidth = 0;
		// for (int i = 0; i < lines.length; ++i) {
		// int currentWidth = this.getWidth(i);
		// if (maxWidth < currentWidth) {
		// maxWidth = currentWidth;
		// }
		// }
		// return maxWidth;
		System.out.println("width: " + this.label.getPrefWidth());
		return (int) this.label.getPrefWidth();

	}

	public int getWidth(int line) {
		String[] lines = this.text.split("\n");
		// return this.bmfont.getWidth(lines[line]);

		// return (int) this.bmfont.getBounds(lines[line]).width;

		return (int) this.label.getPrefWidth();
	}

	public int getTextHeight() {
		// return (int) this.bmfont.getLineHeight();
		// System.out.println(this.bmfont.getBounds(this.text).height);
		// return (int) this.bmfont.getBounds(this.text).height;

		return (int) this.label.getHeight();
	}

	public int getActualHeight() {
		return this.getTextHeight() * this.text.split("\n").length;
		// return this.getTextHeight();
	}

	public void setHeight(int height) {
		// this.bmfont.setScale(height / this.height);

		// this.label.setScale(height / this.height);

		// this.height = height;
		this.label.setHeight(height);
	}

	public void setVisible(boolean visible) {
		this.visible = visible;

	}
}
