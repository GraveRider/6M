import lt.vtvpmc.Article;

public class ArticleImplementation implements Article {

    private String heading;
    private String brief;

    public ArticleImplementation(String heading, String brief) {
        this.heading = heading;
        this.brief = brief;
    }
    @Override
    public String getHeading() {
        return this.heading;
    }

    @Override
    public String getBrief() {
        return this.brief;
    }
}
