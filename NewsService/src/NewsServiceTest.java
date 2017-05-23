import lt.vtvpmc.BaseNewsServiceTest;
import lt.vtvpmc.NewsService;


public class NewsServiceTest extends BaseNewsServiceTest {

    @Override
    protected NewsService getNewsService() {
        return new NewsServiceImplementation();
    }
}
