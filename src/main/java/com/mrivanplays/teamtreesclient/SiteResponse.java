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

import java.util.Optional;

/**
 * Represents a response from the #teamtrees site.
 *
 * @param <T> type of the response
 */
public final class SiteResponse<T> {

  private T data;
  private int responseCode;
  private String responseMessage;

  public SiteResponse(T data) {
    this.data = data;
    this.responseCode = 200;
    this.responseMessage = "Successful request";
  }

  public SiteResponse(int responseCode, String responseMessage) {
    this.responseCode = responseCode;
    this.responseMessage = responseMessage;
  }

  /** @return the data (if present) */
  public Optional<T> getData() {
    return Optional.ofNullable(data);
  }

  /** @return response code */
  public int getResponseCode() {
    return responseCode;
  }

  /** @return response message */
  public String getResponseMessage() {
    return responseMessage;
  }

  @Override
  public String toString() {
    return "SiteResponse{" +
        "data=" + data +
        ", responseCode=" + responseCode +
        ", responseMessage='" + responseMessage + '\'' +
        '}';
  }
}
