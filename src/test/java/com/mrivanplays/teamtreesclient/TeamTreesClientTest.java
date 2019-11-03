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
import org.junit.Test;

public class TeamTreesClientTest {

  @Test
  public void test() {
    TeamTreesClient client = new TeamTreesClient();
    SiteResponse<FullGoalData> siteResponse = client.retrieveFullData().join();
    Optional<FullGoalData> dataOptional = siteResponse.getData();
    if (dataOptional.isPresent()) {
      FullGoalData data = dataOptional.get();
      System.out.println("Days left: " + data.getDaysLeft());
      System.out.println(
          "Recent donation trees: " + data.getMostRecentDonation().getTreesDonated());
      System.out.println(
          "Top donation trees: " + data.getTopDonation().getTreesDonated());
      System.out.println("Trees donated: " + data.getTrees());
      System.out.println("Trees left: " + data.getTreesLeft());
      System.out.println("Percent done: " + data.getPercentDone());
    } else {
      System.out.println("Optional not present");
    }
  }
}
