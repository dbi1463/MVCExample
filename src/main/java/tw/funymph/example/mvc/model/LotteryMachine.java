/* LotteryMachine.java created on Dec, 19, 2016
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

import static java.util.Collections.emptyList;
import static java.util.Collections.shuffle;
import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the model of a lottery machine.
 * 
 * @author Pin-Ying Tu
 * @version 1.0
 * @since 1.0
 */
public class LotteryMachine {

	public static int NO_SPECIAL_BALL_INDEX = -1;
	public static int DEFAULT_MIN_BALL_NUMBER = 1;
	public static boolean DEFAULT_UNIQUE_BALL = true;

	private int resultCount;
	private int minBallNumber;
	private int maxBallNumber;
	
	private int specialBallIndex;

	private boolean rolled;
	private boolean uniqueBall;

	private List<Integer> availableBalls;
	private List<Ball> resultingBalls;

	/**
	 * Construct a <code>LotteryMachine</code> in which ball number started from 1 to the
	 * given <code>maxNumber</code> and can roll the specified <code>results</code> of
	 * balls out out without any special ball.
	 * 
	 * @param maxNumber the maximum number
	 * @param results the number of resulting balls
	 */
	public LotteryMachine(int maxNumber, int results) {
		this(maxNumber, results, NO_SPECIAL_BALL_INDEX);
	}

	/**
	 * Construct a <code>LotteryMachine</code> in which ball number started from 1 to the
	 * given <code>maxNumber</code> and can roll the specified <code>results</code> of
	 * balls out. The ball that was roll out at the specified <code>specialIndex</code>
	 * will be the special ball.
	 * 
	 * @param maxNumber the maximum number
	 * @param results the number of resulting balls
	 * @param specialIndex the special ball index
	 */
	public LotteryMachine(int maxNumber, int results, int specialIndex) {
		this(DEFAULT_MIN_BALL_NUMBER, maxNumber, results, specialIndex, DEFAULT_UNIQUE_BALL);
	}

	/**
	 * Construct a <code>LotteryMachine</code> in which ball number started from the given
	 * <code>minNumber</code> to the given <code>maxNumber</code> and can roll the specified
	 * <code>results</code> of balls out. The ball that was roll out at the specified
	 * <code>specialIndex</code> will be the special ball. In addition, the <code>unique</code>
	 * can determine whether the resulting balls can have the same number or not.
	 * 
	 * @param minNumber the minimum number
	 * @param maxNumber the maximum number
	 * @param results the number of resulting balls
	 * @param specialIndex the special ball index
	 * @param unique <code>false</code> to allow the numbers in the resulting balls
	 */
	public LotteryMachine(int minNumber, int maxNumber, int results, int specialIndex, boolean unique) {
		if (results < 1) {
			throw new IllegalArgumentException("the number of the resulting balls must be larger than 0");
		}
		if (minNumber < 1 || maxNumber < minNumber) {
			throw new IllegalArgumentException("these two numbers must be larger than 0 and the max must be larger than min");
		}
		if (!unique && results > (maxBallNumber - minBallNumber + 1)) {
			throw new IllegalArgumentException("the required resulting balls are more than the available balls");
		}
		if (specialIndex > results) {
			throw new IllegalArgumentException("the special index can not be larger than the number of the resulting balls");
		}

		uniqueBall = unique;
		resultCount = results;
		minBallNumber = minNumber;
		maxBallNumber = maxNumber;
		specialBallIndex = specialIndex;
	}

	/**
	 * Roll the balls.
	 */
	public void roll() {
		if (rolled) {
			throw new IllegalArgumentException("can not roll again");
		}
		rolled = true;
		initializeBalls();

		for (int index = 1; index <= resultCount; index++) {
			shuffle(availableBalls);
			resultingBalls.add(new Ball(availableBalls.get(0).intValue(), (index == specialBallIndex)));
			if (uniqueBall) {
				availableBalls.remove(0);
			}
		}
	}

	/**
	 * Get the resulting balls. There is no guarantee of that calling this method once can
	 * get all of the final results. 
	 * 
	 * @return the resulting balls
	 */
	public List<Ball> getResultingBalls() {
		return rolled? unmodifiableList(resultingBalls) : emptyList();
	}

	/**
	 * Initialize the balls.
	 */
	private void initializeBalls() {
		availableBalls = new ArrayList<Integer>();
		resultingBalls = new ArrayList<Ball>();
		for (int ballNumber = minBallNumber; ballNumber <= maxBallNumber; ballNumber++) {
			availableBalls.add(ballNumber);
		}
	}
}
