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

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.CompletableFuture;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public final class TeamTreesClient {

  private OkHttpClient okHttp;
  private volatile Request request;

  public TeamTreesClient() {
    okHttp = new OkHttpClient();
    request =
        new Request.Builder()
            .url("https://teamtrees.org/")
            .header(
                "User-Agent",
                "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:15.0) Gecko/20100101 Firefox/15.0.1")
            .build();
  }

  public CompletableFuture<SiteResponse<Long>> retrieveCurrentTrees() {
    return CompletableFuture.supplyAsync(
        () -> {
          Call call = okHttp.newCall(request);
          try (Response response = call.execute()) {
            if (response.code() == 503) {
              return new SiteResponse<>(503, "teamtrees.org is being overloaded with traffic");
            }
            Document document = Jsoup.parse(response.body().string());
            long count = Long.parseLong(document.selectFirst("div.counter").attr("data-count"));
            return new SiteResponse<>(count);
          } catch (SocketTimeoutException e) {
            return new SiteResponse<>(408, "teamtrees.org timed out");
          } catch (IOException e) {
            return new SiteResponse<>(400, "Internal error occurred while trying to send request");
          }
        });
  }

  public CompletableFuture<SiteResponse<Donation>> retrieveRecentDonation() {
    return CompletableFuture.supplyAsync(
        () -> {
          Call call = okHttp.newCall(request);
          try (Response response = call.execute()) {
            if (response.code() == 503) {
              return new SiteResponse<>(503, "teamtrees.org is being overloaded with traffic");
            }
            Document document = Jsoup.parse(response.body().string());
            Element paragraph = document.selectFirst("p.media-body pb-3 mb-0 border-bottom border-gray");
            String name = paragraph.selectFirst("strong").text();
            Elements spanElements = paragraph.select("span");
            long treesDonated = Long.parseLong(spanElements.get(0).text().split(" ")[0].replace(",", ""));
            String dateAt = spanElements.get(1).text();
            String message = spanElements.get(2).text();
            return new SiteResponse<>(new Donation(name, treesDonated, dateAt, message));
          } catch (SocketTimeoutException e) {
            return new SiteResponse<>(408, "teamtrees.org timed out");
          } catch (IOException e) {
            return new SiteResponse<>(400, "Internal error occurred while trying to send request");
          }
        });
  }

  public CompletableFuture<SiteResponse<Donation>> retrieveTopDonation() {
    return CompletableFuture.supplyAsync(
        () -> {
          Call call = okHttp.newCall(request);
          try (Response response = call.execute()) {
            if (response.code() == 503) {
              return new SiteResponse<>(503, "teamtrees.org is being overloaded with traffic");
            }
            Document document = Jsoup.parse(response.body().string());
            Element topListDiv = document.selectFirst("div.tab-pane fade active show");
            Element mostRecentDiv = topListDiv.selectFirst("div");
            Element paragraph = mostRecentDiv.selectFirst("p");
            String name = paragraph.selectFirst("strong").text();
            Elements spanElements = paragraph.select("span");
            long treesDonated = Long.parseLong(spanElements.get(0).text().split(" ")[0].replace(",", ""));
            String dateAt = spanElements.get(1).text();
            String message = spanElements.get(2).text();
            return new SiteResponse<>(new Donation(name, treesDonated, dateAt, message));
          } catch (SocketTimeoutException e) {
            return new SiteResponse<>(408, "teamtrees.org timed out");
          } catch (IOException e) {
            return new SiteResponse<>(400, "Internal error occurred while trying to send request");
          }
        });
  }

  public CompletableFuture<SiteResponse<FullGoalData>> retrieveFullData() {
    return CompletableFuture.supplyAsync(
        () -> {
          Call call = okHttp.newCall(request);
          try (Response response = call.execute()) {
            if (response.code() == 503) {
              return new SiteResponse<>(503, "teamtrees.org is being overloaded with traffic");
            }
            Document document = Jsoup.parse(response.body().string());
            long trees = Long.parseLong(document.selectFirst("div.counter").attr("data-count"));
            Element paragraphRecent = document.selectFirst("p.media-body pb-3 mb-0 border-bottom border-gray");
            String nameRecent = paragraphRecent.selectFirst("strong").text();
            Elements spanElementsRecent = paragraphRecent.select("span");
            long treesDonatedRecent = Long.parseLong(spanElementsRecent.get(0).text().split(" ")[0].replace(",", ""));
            String dateAtRecent = spanElementsRecent.get(1).text();
            String messageRecent = spanElementsRecent.get(2).text();
            Donation recent = new Donation(nameRecent, treesDonatedRecent, dateAtRecent, messageRecent);
            Element topListDiv = document.selectFirst("div.tab-pane fade active show");
            Element mostRecentTopDiv = topListDiv.selectFirst("div");
            Element paragraphTop = mostRecentTopDiv.selectFirst("p");
            String nameTop = paragraphTop.selectFirst("strong").text();
            Elements spanElementsTop = paragraphTop.select("span");
            long treesDonatedTop = Long.parseLong(spanElementsTop.get(0).text().split(" ")[0].replace(",", ""));
            String dateAtTop = spanElementsTop.get(1).text();
            String messageTop = spanElementsTop.get(2).text();
            Donation top = new Donation(nameTop, treesDonatedTop, dateAtTop, messageTop);
            return new SiteResponse<>(new FullGoalData(trees, recent, top));
          } catch (SocketTimeoutException e) {
            return new SiteResponse<>(408, "teamtrees.org timed out");
          } catch (IOException e) {
            return new SiteResponse<>(400, "Internal error occurred while trying to send request");
          }
        });
  }
}
