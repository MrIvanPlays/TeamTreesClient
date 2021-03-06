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

/** Represents a donation, whether or not it is being a recent or top donation. */
public final class Donation {

  private String name;
  private long treesDonated;
  private String dateAt;
  private String message;

  public Donation(String name, long treesDonated, String dateAt, String message) {
    this.name = name;
    this.treesDonated = treesDonated;
    this.dateAt = dateAt;
    this.message = message;
  }

  /** @return the (nick)name of the person who donated that amount */
  public String getName() {
    return name;
  }

  /** @return trees donated */
  public long getTreesDonated() {
    return treesDonated;
  }

  /**
   * Returns the date when this donation was made. For top donation this is being in different
   * format.
   *
   * @return date at
   */
  public String getDateAt() {
    return dateAt;
  }

  /** @return message, typed by the donator */
  public String getMessage() {
    return message;
  }

  @Override
  public String toString() {
    return "Donation{" +
        "name='" + name + '\'' +
        ", treesDonated=" + treesDonated +
        ", dateAt='" + dateAt + '\'' +
        ", message='" + message + '\'' +
        '}';
  }
}
