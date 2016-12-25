/* LotteryConsoleView.java created on Dec, 25, 2016
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

import static java.lang.System.out;

import java.util.List;

import tw.funymph.example.mvc.model.Ball;
import tw.funymph.example.mvc.model.LotteryMachine;
import tw.funymph.example.mvc.model.LotteryResult;
import tw.funymph.example.mvc.model.LotteryResultListener;

/**
 * This view show the lottery resulting balls in the console. In the view,
 * the normal ball is surrounded with <code>()</code> and the special ball
 * is surrounded with <code>[]</code>.
 * 
 * @author Pin-Ying Tu
 * @version 1.0
 * @since 1.0
 */
public class LotteryConsoleView implements LotteryResultListener {

	private LotteryMachine model;

	public static void main(String[] args) {
		LotteryMachine machine = new LotteryMachine(49, 7, 7);
		@SuppressWarnings("unused")
		LotteryConsoleView view = new LotteryConsoleView(machine);
		machine.roll();
	}

	/**
	 * Construct a <code>LotteryConsoleView</code> to the show the results
	 * of the given <code>machine</code>.
	 * 
	 * @param machine the lottery machine
	 */
	public LotteryConsoleView(LotteryMachine machine) {
		if (machine == null) {
			throw new IllegalArgumentException("the machine can not be null");
		}
		model = machine;
		model.addLotteryResultListener(this);
		showResultingBalls();
	}

	/**
	 * Show the resulting balls in the console.
	 */
	public void showResultingBalls() {
		List<Ball> resultingBalls = model.getResultingBalls();
		for (Ball ball : resultingBalls) {
			if (ball.isSpecial()) {
				out.print("[" + ball.getNumber() + "] ");
			}
			else {
				out.print("(" + ball.getNumber() + ") ");
			}
		}
		out.println();
	}

	@Override
	public void resultUpdated(LotteryResult result) {
		showResultingBalls();
	}
}
