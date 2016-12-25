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

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import tw.funymph.example.mvc.model.Ball;
import tw.funymph.example.mvc.model.LotteryMachine;
import tw.funymph.example.mvc.model.LotteryResult;
import tw.funymph.example.mvc.model.LotteryResultListener;

/**
 * This class provides a window to display all lottery balls.
 * 
 * @author Pin-Ying Tu
 * @version 1.0
 * @since 1.0
 */
public class JavaFXLotteryView extends Application implements LotteryResultListener {

	private LotteryMachine model;

	private HBox container;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		model = new LotteryMachine(49, 7, 7);
		model.addLotteryResultListener(this);
		container = new HBox();
		Scene scence = new Scene(container, 325, 45);
		stage.setScene(scence);
		stage.setTitle("Lottery");
		stage.show();
		model.roll();
	}

	@Override
	public void resultUpdated(LotteryResult result) {
		displayBalls();
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
