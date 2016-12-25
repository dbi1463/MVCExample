/* JavaFXLotteryApplication.java created on Dec, 25, 2016
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

import javafx.application.Application;
import javafx.stage.Stage;
import tw.funymph.example.mvc.model.LotteryMachine;
import tw.funymph.example.mvc.model.LotteryModel;

/**
 * The class shows an interactive lottery window and display the
 * result in the console, too.
 * 
 * @author Pin-Ying Tu
 * @version 1.0
 * @since 1.0
 */
public class JavaFXLotteryApplication extends Application {

	static LotteryModel model;
	static LotteryConsoleView consoleview;
	static JavaFXLotteryView fxView;

	public static void main(String[] args) {
		model = new LotteryMachine(49, 7, 7);
		consoleview = new LotteryConsoleView(model);
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		fxView = new JavaFXLotteryView(model);
		fxView.show();
	}
}
