import lt.vtvpmc.Article;
import lt.vtvpmc.NewsService;
import lt.vtvpmc.NewsServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class NewsServiceImplementation implements NewsService {

    private ArticleImplementation articleImplementation;

    @Override
    public List<Article> getArticles() {
        ArrayList<Article> filteredArticles = new ArrayList<Article>();
        ArrayList<Article> fullyFilteredList = new ArrayList<Article>();

        for (Article article : NewsServiceImpl.articles) {
            if (!article.getHeading().toLowerCase().contains("rupūs miltai")
                    && !article.getHeading().toLowerCase().contains("velniai rautų")
                    && !article.getHeading().toLowerCase().contains("velnias")
                    && !article.getHeading().toLowerCase().contains("velniais")) {
                filteredArticles.add(article);
            }
        }
        for (Article article : filteredArticles) {
            if (article.getBrief().toLowerCase().contains("rupūs miltai")) {
                articleImplementation = new ArticleImplementation(article.getHeading(), article.getBrief().replace("rupūs miltai", "***"));
                fullyFilteredList.add(articleImplementation);
            } else if (article.getBrief().toLowerCase().contains("velniai rautų")) {
                articleImplementation = new ArticleImplementation(article.getHeading(), article.getBrief().replace("velniai rautų", "***"));
                fullyFilteredList.add(articleImplementation);
            } else if (article.getBrief().toLowerCase().contains("velnias")) {
                articleImplementation = new ArticleImplementation(article.getHeading(), article.getBrief().replace("velnias", "***"));
                fullyFilteredList.add(articleImplementation);
            } else if (article.getBrief().toLowerCase().contains("velniais")) {
                articleImplementation = new ArticleImplementation(article.getHeading(), article.getBrief().replace("velniais", "***"));
                fullyFilteredList.add(articleImplementation);
            }
            else {
                fullyFilteredList.add(article);
            }
        }
        return fullyFilteredList;
    }
}
