/* LotteryModel.java created on Dec, 25, 2016
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
 * This interface define the model of a lottery machine.
 * 
 * @author Pin-Ying Tu
 * @version 1.0
 * @since 1.0
 */
public interface LotteryModel extends LotteryResult {

	/**
	 * Roll the balls.
	 */
	public void roll();

	/**
	 * Get the number of the final resulting balls.
	 * 
	 * @return the number of the final resulting balls
	 */
	public int getFinalResultCount();

	/**
	 * Reset the result for restart again.
	 */
	public void reset();

	/**
	 * Add the listener into the notification list.
	 * 
	 * @param listener the listener to add
	 */
	public void addLotteryResultListener(LotteryResultListener listener);

	/**
	 * Remove the listener from the notification list.
	 * 
	 * @param listener the listener to remove
	 */
	public void removeLotteryResultListener(LotteryResultListener listener);
}
