public class Memcache {
    
    private class Data{
        public int key;
        public int val;
        public int expireTime;
        Data (int key, int val, int expireTime){
            this.key = key;
            this.val = val;
            this.expireTime = expireTime;
        }
    }
    
    private HashMap<Integer, Data> cache;
    
    public Memcache() {
        cache = new HashMap<>();
    }


    public int get(int curtTime, int key) {
        Data data = cache.get(key);
        if (data != null && 
        ( data.expireTime >= curtTime || data.expireTime == -1 )){
            return data.val;
        }
        return 2147483647;
    }

    public void set(int curtTime, int key, int value, int ttl) {
        Data data = ttl != 0 ? 
                    new Data(key, value, curtTime + ttl - 1) :
                    new Data(key, value, -1);
        cache.put(key, data);
    }

    public void delete(int curtTime, int key) {
        cache.remove(key);
    }

    public int incr(int curtTime, int key, int delta) {
        Data data = cache.get(key);
        if (data != null && 
            ( data.expireTime >= curtTime || data.expireTime == -1 )){
            data.val += delta;
            return data.val;
        }
        return 2147483647;

    }

    public int decr(int curtTime, int key, int delta) {
        Data data = cache.get(key);
        if (data != null && 
        ( data.expireTime >= curtTime || data.expireTime == -1 )){
            data.val -= delta;
            return data.val;
        }
        return 2147483647;
    }
}
