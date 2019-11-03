/*
    Copyright (c) 2019 Ivan Pekov
    Copyright (c) 2019 Contributors

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
*/
package com.mrivanplays.teamtreesclient;

import java.time.Duration;
import java.time.LocalDate;

/** Represents full data about the goal. */
public final class FullGoalData {

  private long trees;
  private Donation mostRecentDonation;
  private Donation topDonation;

  public FullGoalData(long trees, Donation mostRecentDonation, Donation topDonation) {
    this.trees = trees;
    this.mostRecentDonation = mostRecentDonation;
    this.topDonation = topDonation;
  }

  /**
   * @return the trees, donated right now
   */
  public long getTrees() {
    return trees;
  }

  /**
   * @return the trees left for the goal to finish
   */
  public long getTreesLeft() {
    return 20000000 - trees;
  }

  /**
   * @return the days left for the goal to end no matter finished or not
   */
  public long getDaysLeft() {
    LocalDate january1st2020 = LocalDate.of(2020, 1, 1);
    Duration duration = Duration.between(LocalDate.now().atStartOfDay(), january1st2020.atStartOfDay());
    return duration.toDays();
  }

  /**
   * @return the percentage the goal is done
   */
  public double getPercentDone() {
    return (trees / 20000000D) * 100;
  }

  /**
   * @return most recent donation
   */
  public Donation getMostRecentDonation() {
    return mostRecentDonation;
  }

  /**
   * @return recent top donation
   */
  public Donation getTopDonation() {
    return topDonation;
  }

  @Override
  public String toString() {
    return "FullGoalData{" +
        "trees=" + trees +
        ", mostRecentDonation=" + mostRecentDonation +
        ", topDonation=" + topDonation +
        '}';
  }
}
