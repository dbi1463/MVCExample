/* Ball.java created on Dec, 19, 2016
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
package tw.funymph.example.mvc.model;

/**
 * This class represents a rolled out lottery ball.
 * 
 * @author Pin-Ying Tu
 * @version 1.0
 * @since 1.0
 */
public class Ball {

	private int number;
	private boolean special;

	/**
	 * Construct a ball with its number and whether the number
	 * is special or not.
	 * 
	 * @param ballNumber the ball number
	 * @param specialBall true if the number is special
	 */
	Ball(int ballNumber, boolean specialBall) {
		number = ballNumber;
		special = specialBall;
	}

	/**
	 * Get whether the ball number is special or not.
	 * 
	 * @return true if the ball number is special
	 */
	public boolean isSpecial() {
		return special;
	}

	/**
	 * Get the ball number.
	 * 
	 * @return the ball number
	 */
	public int getNumber() {
		return number;
	}
}
