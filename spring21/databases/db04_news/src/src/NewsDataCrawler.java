/*
 * CS3810 - Principles of Database Systems - Spring 2021
 * Instructor: Thyago Mota
 * Description: DB 04 - News Data Crawler
 * Student(s) Name(s): Tj Virbick, Rob Nelson, Letitia Fickling
 */

import com.google.gson.*;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mongodb.client.*;
import org.bson.Document;
import java.io.*;
import java.util.*;

public class NewsDataCrawler {

    private static final int PREEMPTIVE_BACKOFF_TIME = 2; // minutes
    private static final int PAGE_SIZE               = 10;

    private MongoClient   mongoClient;
    private MongoDatabase db;
    private String        newsAPIKey;
    private Gson          gson;

    public NewsDataCrawler() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("config.properties"));
        final String USER        = prop.getProperty("user");
        final String PASSWORD    = prop.getProperty("password");
        final String SERVER      = prop.getProperty("server");
        final String DATABASE    = prop.getProperty("database");
        final String CONNECT_URL = "mongodb+srv://" + USER + ":" + PASSWORD + "@" + SERVER;
        this.mongoClient = MongoClients.create(CONNECT_URL);
        this.db = mongoClient.getDatabase(DATABASE);
        this.newsAPIKey = prop.getProperty("news_api_key");
        this.gson = new GsonBuilder().create();

    }

    // TODO: call the news search API to retrieve news articles of the given topic, using parameters page and pageSize; insert all articles returned into a MongoDB collection named "articles"
    public void searchArticles(final String topic, int pageSize, int page) throws UnirestException {
        //Call API to get json-string of articles
        String json = Unirest.get("https://newsapi.org/v2/everything?apiKey="+newsAPIKey+"&sortBy=publishedAt&q="+
                topic+"&page="+ page +"&pageSize="+ pageSize).asString().getBody();
        //System.out.println("json: "+json);

        //Map json-string to Java-object (using GSON)
        Response response = gson.fromJson(json, Response.class);
        System.out.println("RESPONSE: "+response.toString());

        ArticleSource source = gson.fromJson(json, ArticleSource.class);
        System.out.println("SOURCE: "+source.toString());
        Article article = gson.fromJson(json, Article.class);
        System.out.println("ARTICLE: "+article.toString());


        //Rest the API call for 2 min (or maybe in the for loop in main)


        //Close mongoClient
        done();
    }

    public void done() {
        mongoClient.close();
    }

    // TODO: write an application that asks the user for a topic and retrieves 100 news articles from that topic, saving them in a MongoDB database; make sure to pause for 2m between API calls to avoid having your API key being locked out
    public static void main(String[] args) throws IOException, UnirestException {
        //Get User topic
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the topic of your choice: ");
        String userTopic = input.nextLine().trim();
        System.out.println("Retrieving articles about: "+ userTopic);
        userTopic = userTopic.replaceAll("\\s", "%20");
        System.out.println("userTopic: " + userTopic);
        input.close();

        //Call searchArticles with the user topic
        NewsDataCrawler ndc = new NewsDataCrawler();
        for(int i=1; i<=1; i++){
            ndc.searchArticles(userTopic,PAGE_SIZE,i);

        }



    }

}
