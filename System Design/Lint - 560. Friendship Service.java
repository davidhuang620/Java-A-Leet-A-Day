/*

Use TreeSet to keep order and dedupe at the same time!

Use new ArrayList<Integer>(TreeSetVar) to convert at the end

List.remove((Integer) user_id)
Use (Integer) to cast the integer into an integer object 
otherwise, remove method will take the int as an index

Collections.sort(list);

*/

public class FriendshipService {
    
    private HashMap<Integer, Set<Integer>> followersTable, followingTable; 
    
    public FriendshipService() {
        
        followersTable = new HashMap<>();
        followingTable = new HashMap<>();
        
    }

    /*
     * @param user_id: An integer
     * @return: all followers and sort by user_id
     */
    public List<Integer> getFollowers(int user_id) {
        if (followersTable.containsKey(user_id)){
            return new ArrayList<Integer>(followersTable.get(user_id));
        } else{
            return new ArrayList<Integer>();
        }
    }

    /*
     * @param user_id: An integer
     * @return: all followings and sort by user_id
     */
    public List<Integer> getFollowings(int user_id) {
        if (followingTable.containsKey(user_id)){
            return new ArrayList<Integer>(followingTable.get(user_id));
        } else{
            return new ArrayList<Integer>();
        }
    }

    private void init(int user_id){
        if (!followersTable.containsKey(user_id)){
            followersTable.put(user_id, new TreeSet<Integer>());
        }
        if (!followingTable.containsKey(user_id)){
            followingTable.put(user_id, new TreeSet<Integer>());
        }
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void follow(int to_user_id, int from_user_id) {
        init(to_user_id);
        init(from_user_id);
        followersTable.get(to_user_id).add(from_user_id);
        followingTable.get(from_user_id).add(to_user_id);
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void unfollow(int to_user_id, int from_user_id) {
        init(to_user_id);
        init(from_user_id);
        followersTable.get(to_user_id).remove((Integer)from_user_id);
        followingTable.get(from_user_id).remove((Integer)to_user_id);
    }
}
