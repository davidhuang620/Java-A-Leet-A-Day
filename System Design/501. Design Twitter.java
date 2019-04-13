/**
 * Definition of Tweet:
 * public class Tweet {
 *     public int id;
 *     public int user_id;
 *     public String text;
 *     public static Tweet create(int user_id, String tweet_text) {
 *         // This will create a new tweet object,
 *         // and auto fill id
 *     }
 * }
 */


public class MiniTwitter {
    
    private ArrayList<Tweet> tweetTable;
    private HashSet<Integer> userTable;
    private HashMap<Integer, List<Integer>> followTable;
    private HashMap<Integer, List<Tweet>> newsTable;
    private HashMap<Integer, List<Tweet>> timeLineTable;
    
    
    public MiniTwitter() {
        // do intialization if necessary
        // if Tweet id is increment, then we can use it as timeStamp
        //     <Tweet, timestamp>
        // HashMap<Tweet, Integer> tweetTable = new HashMap<>();
        // TimeStamp will be the index of the array
        ArrayList<Tweet> tweetTable = new ArrayList<>();
        // User table: check if user exist
        HashSet<Integer> userTable = new HashSet<>();
        //     <Followed_Userid, follower_id> 
        HashMap<Integer, List<Integer>> followTable = new HashMap<>();
        //     <user_id, tweets>
        HashMap<Integer, List<Tweet>> newsTable = new HashMap<>();
        //     <user_id, tweets>
        HashMap<Integer, List<Tweet>> timeLineTable = new HashMap<>();
        // An id table to store the index of the id for each table
        // of course the data id limit is the int limit
        // HashMap<String, Integer> idTable = hashMap<>();
        // idTable.put("tweetTable", 0);
        // idTable.put("followTable", 0);
        // idTable.put("newsTable", 0);
        // idTable.put("timeLineTable", 0);
        
    }
    
    // check if user exist, if not intialize the table for them
    public void userInitialization(int user_id){
        if (!userTable.contains(user_id)){
            userTable.add(user_id);
            followTable.put(user_id, new ArrayList<Integer>());
            newsTable.put(user_id, new ArrayList<Tweet>());
            timeLineTable.put(user_id, new ArrayList<Tweet>());
        }
    }
    
    /*
     * @param user_id: An integer
     * @param tweet_text: a string
     * @return: a tweet
     */
    public Tweet postTweet(int user_id, String tweet_text) {
        // Creat tweet and store into database
        Tweet tweet = Tweet.create(user_id, tweet_text);
        tweetTable.add(tweet);
        
        // intialization
        userInitialization(user_id);
        
        // Push Model
        // Push in new feed
        // Find every follower
        for (int follower : followTable.get(user_id)){
            // push the tweet to their news feed
            newsTable.get(follower).add(tweet);
        }
        
        // push in user own timeline
        timeLineTable.get(user_id).add(tweet);

        return tweet;
    }

    /*
     * @param user_id: An integer
     * @return: a list of 10 new feeds recently and sort by timeline
     */
    public List<Tweet> getNewsFeed(int user_id) {
        userInitialization(user_id);
        List<Tweet> currNewsFeed = new List<Tweet>;
        List<Tweet> allNewsFeed = newsTable.get(user_id);
        for (int i = allNewsFeed.size() - 1, j = 0; j < 10; j++, i--){
            currNewsFeed.add(allNewsFeed.get(i));
        }
        return currNewsFeed;
    }

    /*
     * @param user_id: An integer
     * @return: a list of 10 new posts recently and sort by timeline
     */
    public List<Tweet> getTimeline(int user_id) {
        userInitialization(user_id);
        List<Tweet> currTimeLine = new List<Tweet>;
        List<Tweet> allTimeLine = timeLineTable.get(user_id);
        for (int i = allTimeLine.size() - 1, j = 0; j < 10; j++, i--){
            currTimeLine.add(allTimeLine.get(i));
        }
        return currTimeLine;
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void follow(int from_user_id, int to_user_id) {
        userInitialization(from_user_id);
        userInitialization(to_user_id);
        followTable.get(to_user_id).add(from_user_id);
        // can u async and return ?
        
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void unfollow(int from_user_id, int to_user_id) {
        // write your code here
    }
}
