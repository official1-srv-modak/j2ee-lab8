import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class FeedParser {
    public static List<Feed> parseFeeds(String filePath) throws IOException {
        Gson gson = new Gson();
        Type feedListType = new TypeToken<List<Feed>>(){}.getType();
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, feedListType);
        }
    }
}
