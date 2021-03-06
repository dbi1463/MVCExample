/* JavaFXLotteryView.java created on Dec, 25, 2016
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

import static javafx.scene.layout.HBox.setMargin;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import tw.funymph.example.mvc.model.Ball;
import tw.funymph.example.mvc.model.LotteryModel;
import tw.funymph.example.mvc.model.LotteryResult;
import tw.funymph.example.mvc.model.LotteryResultListener;

/**
 * This class provides a window to display all lottery balls.
 * 
 * @author Pin-Ying Tu
 * @version 1.0
 * @since 1.0
 */
public class JavaFXLotteryView extends Stage implements LotteryResultListener {

	private LotteryModel model;

	private HBox container;
	private BorderPane root;
	private Button rollButton;

	/**
	 * Construct a <code>JavaFXLotteryView</code> view with the lottery model.
	 * 
	 * @param lotteryModel the lottery model
	 */
	public JavaFXLotteryView(LotteryModel lotteryModel) {
		model = lotteryModel;
		model.addLotteryResultListener(this);
		container = new HBox();
		root = new BorderPane();
		rollButton = new Button("Roll");
		root.setCenter(container);
		root.setLeft(rollButton);
		BorderPane.setMargin(rollButton, new Insets(8, 0, 8, 5));
		Scene scence = new Scene(root, 370, 45);
		setScene(scence);
		setTitle("Lottery");
		rollButton.setOnAction(this::roll);
	}

	@Override
	public void resultUpdated(LotteryResult result) {
		displayBalls();
	}

	/**
	 * The simple controller.
	 * 
	 * @param e the action event
	 */
	private void roll(ActionEvent e) {
		model.reset();
		model.roll();
	}

	/**
	 * Display all lottery balls.
	 */
	private void displayBalls() {
		List<Node> children = container.getChildren();
		container.getChildren().removeAll(children);
		for (Ball ball : model.getResultingBalls()) {
			BallView ballView = new BallView(ball);
			container.getChildren().add(new Separator());
			setMargin(ballView, new Insets(6, 3, 6, 3));
			container.getChildren().add(ballView);
		}
	}
}
