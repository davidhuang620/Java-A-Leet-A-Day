public class MiniCassandra {
    
    private HashMap<String, TreeMap<Integer, Column>> cassandra;
    
    public MiniCassandra() {

        cassandra = new HashMap<>();

    }
     
    private void init(String row_key){
        if (!cassandra.containsKey(row_key)){
            cassandra.put(row_key, new TreeMap<Integer, Column>());
        }
    }
     
    public void insert(String row_key, int column_key, String value) {
        init(row_key);
        cassandra.get(row_key).put(column_key, new Column(column_key, value));
    }

    public List<Column> query(String row_key, int column_start, int column_end)
    {
        init(row_key);
        ArrayList<Column> res = new ArrayList<>();
        for (Integer col : cassandra.get(row_key).keySet()){
            if (col >= column_start && col <= column_end){
                res.add(cassandra.get(row_key).get(col));
            }
        }
        return res;
    }
}
