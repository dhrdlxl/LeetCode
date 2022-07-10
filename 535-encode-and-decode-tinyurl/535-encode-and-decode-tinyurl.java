public class Codec {
    private int id = 1;
    private char[] keyChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    HashMap<String, String> map;
    
    public Codec(){
        map = new HashMap<>();
    }
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        StringBuilder key = new StringBuilder();
        int n = id;
        
        while(n > 0) {
            key.append(keyChar[n%62]);
            n /= 62;
        }
        map.put(key.toString(), longUrl);
        id++;
        
        return "http://tinyurl.com/" + key.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String key = shortUrl.substring(19, shortUrl.length());
        
        return map.get(key);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));