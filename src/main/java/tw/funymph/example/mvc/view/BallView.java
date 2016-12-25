/* BallView.java created on Dec, 25, 2016
 *
 * Copyright (c) <2016> Pin-Ying Tu <dbi1463@gmail.com>
 * 
 * This file is part of MVCExample under the MIT license.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package tw.funymph.example.mvc.view;

import static java.lang.String.valueOf;
import static javafx.geometry.Insets.EMPTY;
import static javafx.geometry.Pos.CENTER;

import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import tw.funymph.example.mvc.model.Ball;

/**
 * This class display a lottery ball in the JavaFX window.
 * 
 * @author Pin-Ying Tu
 * @version 1.0
 * @since 1.0
 */
public class BallView extends Label {

	private Ball displayingBall;

	/**
	 * Construct a <code>BallView</code> to display the given ball.
	 * 
	 * @param ball the ball to display
	 */
	public BallView(Ball ball) {
		displayingBall = ball;
		setText(valueOf(displayingBall.getNumber()));
		setMinSize(30, 30);
		setMaxSize(30, 30);
		setAlignment(CENTER);
		Color ballColor = displayingBall.isSpecial()? Color.RED : Color.YELLOW;
		setBackground(new Background(new BackgroundFill(ballColor, new CornerRadii(15), EMPTY)));
	}
}
